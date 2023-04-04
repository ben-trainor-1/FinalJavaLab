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

    public static void fadeOutAudio(Clip clip, long fadeSpeed) throws InterruptedException {

        FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        
        do {
            volume.setValue(volume.getValue() - 0.05F);
            Thread.sleep(fadeSpeed);
        } while (volume.getValue() > -80.0F);

        clip.stop();
        
    }
    
}
