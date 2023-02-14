package combat;
import java.util.Scanner;
import java.util.Random;
import graphics.*;
import state.*;


public class FullCombat {
        
    // Create variables for methods
    static int enemyAction;

    public void fight(String enemy, int enemyHealth, int attackChance, int defenseChance, int healChance) throws Exception {
    
        // Create objects and variables
        Scanner in = new Scanner(System.in);
        Random Rand = new Random();
        int input;

        // Display enemy
        Graphics.displayCharacter(enemy, enemyHealth);
        Thread.sleep(3000);

        // Combat
        do {

            // Display the character
            Graphics.displayCharacter("Reginald", 100);

            // Randomly select enemy action
            enemyAction = Rand.nextInt(healChance);
            if (enemyAction == 0) {
                enemyAction = 10;
            }
            else {
                enemyAction = Rand.nextInt(defenseChance - attackChance) + attackChance;
            }

            // Choose action
            Graphics.text(Colors.ANSI_YELLOW + "Enter 1 for Attack - Enter 2 for Defend - Enter 3 for Heal\n1. Attack - \n2. Defend - Blocks all damage except critical hits\n3. Heal - " + Colors.ANSI_RESET);
            input = in.nextInt();

            // Calculate 
            if (input == 1) {
                attack();
            }
            else if (input == 2) {
                
            }
            else if (input == 3) {
                
            }
            else {
                Graphics.text("Do you not know how to read? You must be a true viking. Try again.");
            }

        } while (true);
    

    }

    public static void attack() throws Exception {

        if (enemyAction == 0) {

        }
        else if (enemyAction == 1) {

        }
        else {

        }

    }
 
    
}
