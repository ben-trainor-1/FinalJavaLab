package audio;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.*;
import javax.sound.sampled.FloatControl;

/**
 * Usage
 * 0. Import the Clip class to your file that wll use audio
 * 1. Create a new Player object in your file
 * 2. Call playAudio and give it two arguments
 *    a. The file path for the audio file
 *    b. How many times it should loop (-1 for continuous)
 * 3. playAudio will return a Clip object
 *    Use this object to keep track of playback
 */
public class Player {

    Clip playAudio(String audioFilePath, int loopCount) throws Exception {

        File audioFile = new File(audioFilePath);

        // File exists
        if (audioFile.exists()) {
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.loop(loopCount);
            return clip;
        }
        // File does not exist
        else {
            System.out.println("Audio file does not exist.");
            return null;
        }


    }

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
    
}
