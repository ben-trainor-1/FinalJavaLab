package audio;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.*;
import java.io.*;
import javax.sound.sampled.FloatControl;

/**
 * <b>Usage</b>
 * <ol>
 *  <li>Import the Clip class to your file that wll use audio</li>
 *  <li>Create a new Player object in your file</li>
 *  <li>Call playAudio and give it two arguments
 *      <p>1) The file path for the audio file</p>
 *      <p>2) How many times it should loop (-1 for continuous)</p>
 *  <li>playAudio will return a Clip object</li>
 * </ol> 
 * Use this object to keep track of playback.
 */
public class Player {

    /**
     * Use this for initializing an audio file. Requires a path, loop count, and start volume. 
     * Use <code>-80.0f</code> when wanting to fade in a file so that it starts silent and fades in.
     * Call this method with that level and then call <code>fadeInAudio()</code> with fade length.
     * Otherwise, use <code>0.0f</code> for the start volume or whatever sounds right.
     * @param audioFilePath
     * @param loopCount
     * @param startVolume
     * @return void
     * @throws Exception
     */
    public Clip playAudio(String audioFilePath, int loopCount, float startVolume) throws Exception {

        File audioFile = new File(audioFilePath);

        // File exists
        if (audioFile.exists()) {
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            volume.setValue(startVolume);
            clip.loop(loopCount);
            return clip;
        }
        // File does not exist
        else {
            System.out.println("Audio file does not exist.");
            return null;
        }


    }

    /**
     * Handles fading audio clips out. Use the original clip that is playing the audio file and the duration of the fade in milliseconds.
     * @param clip
     * @param fadeDuration
     * @throws InterruptedException
     */
    public static void fadeOutAudio(Clip clip, float fadeDuration) throws InterruptedException {

        FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        
        float floor = -80.0f; // Lowest valid decibel level
        float fadeGap = 1.0f; // Gap between fade moments
        long sleepDuration = (long) fadeGap;
        float q = floor;
        float s = fadeDuration / 1000.0f; // Convert fade duration to seconds
        float x = 0;
        float newVolume;

        // Set volume according to the function
        // y = sqrt{q^{2} * s} * 1/s * sqrt{(-x/1000) + s} + q
        
        do {
            
            // Calculate new volume level
            newVolume = (float) (Math.sqrt(q * q * s) * (1/s) * Math.sqrt((-x/1000)+s) + q);
            // Set new volume level
            volume.setValue(newVolume);

            // Note time elapsed
            x += fadeGap;
            Thread.sleep(sleepDuration);

            
        } while (x < fadeDuration); // volume.getValue() > -80.0F

        clip.stop();
        
    }

    /**
     * Handles fading audio clips in. Use the original clip that is playing the audio file and the duration of the fade in milliseconds.
     * @param clip
     * @param fadeDuration
     * @throws InterruptedException
     */
    public static void fadeInAudio(Clip clip, float fadeDuration, float targetVolume) throws InterruptedException {

        FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        
        float floor = -80.0f; // Lowest valid decibel level
        float fadeGap = 1.0f; // Gap between fade moments
        long sleepDuration = (long) fadeGap;
        float q = floor;
        float s = fadeDuration / 1000.0f; // Convert fade duration to seconds
        float x = 0;
        float newVolume;

        volume.setValue(-80.0f);
        clip.start();

        // Set volume according to the function
        // y = sqrt{q^{2} * s} * 1/s * sqrt{(-x/1000) + s} + q
        
        do {
            
            // Calculate new volume level
            newVolume = (float) (Math.sqrt(q * q * s) * (1/s) * Math.sqrt((x/1000)) + q);
            // Set new volume level
            volume.setValue(newVolume);

            // Note time elapsed
            x += fadeGap;
            Thread.sleep(sleepDuration);

            
        } while (volume.getValue() < targetVolume); // volume.getValue() > -80.0F
        
    }
    
}
