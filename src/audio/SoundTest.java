package audio;
import javax.sound.sampled.Clip;
import java.util.Scanner;

public class SoundTest {

    public static void main(String[] args) throws Exception {

        Player play = new Player();
        Clip clip = play.playAudio("./src/audio/animalsAndCharacters/wolf.wav", 0, 0.0F, 0);
        
        Scanner in = new Scanner(System.in);
        in.nextLine();
        
        Player.fadeOutAudio(clip, 1); 

        while (true);

    }
    
}
