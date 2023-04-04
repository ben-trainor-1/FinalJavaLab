package audio;
import java.io.File;
import java.util.Scanner;
import javax.sound.sampled.Clip;

public class AudioTest {

    public static void main(String[] args) throws Exception {

        Player play = new Player();
        
        Clip clip = play.playAudio("./src/audio/loop_soft_piano.wav", 0);

        File credits = new File("./src/audio/Credits.txt");
        Scanner creditsScanner = new Scanner(credits);

        String currentLine = "";

        do {

            currentLine = creditsScanner.nextLine();
            for (int i = 0; i < currentLine.length(); i++) {
                System.out.print(currentLine.charAt(i));
                Thread.sleep(30);
            }
            System.out.println();

        } while (creditsScanner.hasNext());


        System.out.println("Lowering volume...");
        Player.fadeOutAudio(clip, 15);
        System.out.println("Volume lowered.");
        

        do {
            // Wait for clip to end
        } while (clip.isActive());

        
        creditsScanner.close();
        
    }
    
}
