package audio;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.*;

public class Player {

    Clip playAudio(String audioFilePath, int loopCount) throws Exception {

        File audioFile = new File(audioFilePath);

        if (audioFile.exists()) {
            
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(audioFile);

            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.loop(loopCount);
            return clip;
        }
        else {
            System.out.println("Audio file does not exist.");
            return null;
        }


    }
    
}
