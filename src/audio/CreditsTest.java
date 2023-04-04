package audio;
import java.io.File;
import java.util.Scanner;
import javax.sound.sampled.Clip;

public class CreditsTest {

    public static void main(String[] args) throws Exception {

        Player play = new Player();
        
        Clip clip = play.playAudio("./src/audio/loop_soft_piano.wav", 0);

        File credits = new File("./src/audio/Credits.txt");
        Scanner creditsScanner = new Scanner(credits);

        String currentLine = "";

        do {

            currentLine = creditsScanner.nextLine();
            System.out.println(currentLine);
            Thread.sleep(150);

        } while (creditsScanner.hasNext());
        

        do {
            // Wait for clip to end
        } while (clip.isActive());

        
        creditsScanner.close();
        
    }
    
}
