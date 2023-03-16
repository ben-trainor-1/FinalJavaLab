package audio;
import javax.sound.sampled.Clip;

public class FadeTest {

    public static void main(String[] args) throws Exception {

        Player play = new Player();
        Clip clip = play.playAudio("./src/audio/loop_soft_piano.wav", 0);

        System.out.println("Lowering volume...");
        Player.fadeOutAudio(clip, 4000);
        System.out.println("Volume lowered.");
        
        do {
            // Wait for clip to end
        } while (clip.isActive());
        
    }
    
}
