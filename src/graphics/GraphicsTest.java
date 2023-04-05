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
        
        Graphics.displayBackground("Mountains", Colors.ANSI_BLUE);
        Graphics.displayDeath("Tomb", Colors.ANSI_BLACK);
        Graphics.displayEnemy("Gullinkambi");
        Graphics.displayGormGro();
        Graphics.displayHealing("Dumpling", Colors.ANSI_WHITE);
        Graphics.displayWeapons("Axe", Colors.ANSI_WHITE);
        Graphics.displayWin("Trophy", Colors.ANSI_YELLOW);
        Graphics.space(5);
        Graphics.text("Hello, world!");
        Graphics.textInline("Hello, world! Inline text!");
        Graphics.waitForEnter();


    }

}
