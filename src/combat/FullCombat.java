package combat;
import java.util.Scanner;
import java.util.Random;
import graphics.*;
import state.*;


public class FullCombat {
        
    // Create variables for methods
    static int enemyAction;
    static boolean playerCritical = false;
    static boolean enemyCritical = false;
    static int parry = 0;
    static int critical = 20;

    // Update enemy GameState stats (before a fight)
    public static void enemyGameState(String enemy, int enemyHealth, int enemyAttackAvg, int attackChance, int defenseChance, int healChance) throws Exception {
        GameState.enemy = enemy;
        GameState.enemyHealth = enemyHealth;
        GameState.enemyAttackAvg = enemyAttackAvg;
        GameState.attackChance = attackChance;
        GameState.defenseChance = defenseChance;
        GameState.healChance = healChance;
    }

    // Fight an enemy
    public static void fight() throws Exception {
    
        // Create objects and variables
        Scanner in = new Scanner(System.in);
        Random Rand = new Random();
        int input;

        // Display enemy
        Graphics.displayCharacter(GameState.enemy, GameState.enemyHealth);
        Thread.sleep(1500);

        // Combat
        do {

            // Display the character
            Graphics.displayCharacter("Reginald", GameState.playerHealth);

            // Randomly select enemy action
            // enemyAction = Rand.nextInt(healChance);
            // if (enemyAction == 0) {
            //     enemyAction = 10;
            // }
            // else {
            //     enemyAction = Rand.nextInt(defenseChance - attackChance) + attackChance;
            // }

            // TESTING ENEMY ATTACK
            enemyAction = 0;
            
            // TESTING
            Graphics.text("Enemy did: " + enemyAction);

            // Choose action
            Graphics.text(Colors.ANSI_RESET + "Enter " + Colors.ANSI_YELLOW + "1" + Colors.ANSI_RESET + " for Attack - Enter " + Colors.ANSI_YELLOW + "2" + Colors.ANSI_RESET + " for Defend - Enter " + Colors.ANSI_YELLOW + "3" + Colors.ANSI_RESET + " for Heal\n" + Colors.ANSI_YELLOW + "1. Attack" + Colors.ANSI_RESET + " - \n" + Colors.ANSI_YELLOW + "2. Defend " + Colors.ANSI_RESET + "- Blocks all damage except critical hits\n" + Colors.ANSI_YELLOW + "3. Heal " + Colors.ANSI_RESET + "- " + Colors.ANSI_RESET);
            input = in.nextInt();

            // Calculate 
            if (input == 1) {
                attack();
                // enemyHealth -= GameState.attack;
                // System.out.println("You attacked...\nAnd dealt 50 damage to " + Colors.ANSI_RED + enemy + Colors.ANSI_RESET + "!");
                // Graphics.displayCharacter(enemy, enemyHealth);
            }
            else if (input == 2) {
                
            }
            else if (input == 3) {
                
            }
            else {
                Graphics.text(Colors.ANSI_RESET + "Do you not know how to read? You must be a true viking. Try again.");
            }

            // Reset critical chances
            playerCritical = false;
            enemyCritical = false;

            Graphics.displayCharacter(GameState.enemy, GameState.enemyHealth);

        } while (true);
    

    }

    public static void attack() throws Exception {

        // New Random object
        Random Rand = new Random();

        // Player critical hit
        if (Rand.nextInt(10) == 0) {
            playerCritical = true;
            
            // TESTING
            Graphics.text("Player critical");
        }

        // Enemy attack
        if (enemyAction >= 0 && enemyAction <= 4) {

            // Enemy critical hit
            if (Rand.nextInt(10) == 0) {
                enemyCritical = true;

                // TESTING
                Graphics.text("Enemy critical");
                GameState.playerHealth -= (GameState.enemyAttackAvg + critical);
                GameState.enemyHealth -= (GameState.playerAttack + critical);
            }
            // Enemy standard hit
            else {
                GameState.playerHealth -= GameState.enemyAttackAvg;
                GameState.enemyHealth -= GameState.playerAttack;
            }
            
            // Calculate outcome
            // if (playerCritical == 1 && enemyCritical == 1) {

            // }
        }
        else if (enemyAction >= 5 && enemyAction <= 9) {
        
        }
        else {

        }

    }
 
    
}
