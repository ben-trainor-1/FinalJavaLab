package graphics;
public class GraphicsTest {
    public static void main(String[] args) throws Exception {
        // Graphics.displayHealing("Key");
        // Graphics.displayCharacter("Reginald", 100);
        // Graphics.displayCharacter("Loki", 100);
        // Graphics.displayCharacter("Viggo", 100);
        // Graphics.displayDeath("Dead");
        
        Graphics.textSpeed = 30;

        testAllGraphicsMethods();
        
    }
    
    // Method for running every graphics method
    public static void testAllGraphicsMethods() throws Exception {
        
        Graphics.displayEnemy("Skeleton1");
        Graphics.displayEnemy("Skeleton2");
        Graphics.displayHealing("MagicalNecklace", Colors.ANSI_WHITE);
        Graphics.displayWeapons("Axe", Colors.ANSI_WHITE);
       


    }

}
