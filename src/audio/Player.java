package audio;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.*;

public class Player {

    void playAudio(String audioFilePath) throws Exception {

        File audioFile = new File(audioFilePath);

        if (audioFile.exists()) {
            
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(audioFile);

            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.loop(3);
        }

    }
    
}
