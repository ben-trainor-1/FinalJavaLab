package audio;
import javax.sound.sampled.Clip;

public class FadeTest {

    public static void main(String[] args) throws Exception {

        Player play = new Player();
        Clip clip = play.playAudio("./src/audio/loop_soft_piano.wav", 0, -80.0f);

        // System.out.println("Lowering volume...");
        // Player.fadeOutAudio(clip, 4000);
        // System.out.println("Volume lowered.");
        
        Player.fadeInAudio(clip, 4000);
        
        do {
            // Wait for clip to end
        } while (clip.isActive());
        
    }
    
}
