package combat;
import java.util.Scanner;
import graphics.Colors;
import graphics.Graphics;


public class FullCombat {
        
    public static void fight(String enemy, int enemyHealth) throws Exception {
    
        // Create scanner and variables
        Scanner in = new Scanner(System.in);
        int input;

        // Display enemy
        Graphics.displayCharacter(enemy, enemyHealth);
        Thread.sleep(3000);

        // Combat
        do {

            Graphics.displayCharacter("Reginald", 100);

            Graphics.text(Colors.ANSI_YELLOW + "Enter 1 for Attack - Enter 2 for Defend - Enter 3 for Heal\n1. Attack - \n2. Defend - Blocks all damage except critical hits\n3. Heal - " + Colors.ANSI_RESET);
            input = in.nextInt();

            if (input == 1) {
                Attack.
            }
            else if (input == 2) {
                Defend.
            }
            else if (input == 3) {
                Heal.
            }
            else {
                Graphics.text("Do you not know how to read? You must be a true viking. Try again.");
            }

        } while (true);
    

    }

    
}
