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
    static boolean parry = false;
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
        GameState.playerHealCount = 2;

        // Display enemy
        Graphics.displayCharacter(GameState.enemy, GameState.enemyHealth);
        System.out.println();
        Thread.sleep(1500);

        // Combat
        do {

            // Display the character
            Graphics.displayCharacter(GameState.name, GameState.playerHealth);
            System.out.print("\n\n");


            // Enemy does not act if there is a parry
            if (parry == true) {
                parry = false;
                enemyAction = -1;
            }
            // Enemy action
            else {
                
                // Randomly select enemy action
                enemyAction = Rand.nextInt(GameState.healChance);
                if (enemyAction == 0) {
                    enemyAction = 10;
                }
                else {
                    
                    // enemyAction = Rand.nextInt(GameState.defenseChance - GameState.attackChance) + GameState.attackChance;

                    enemyAction = 0;

                }

            }
            

            // Choose action
            Graphics.text(Colors.ANSI_RESET + "Enter " + Colors.ANSI_YELLOW + "1" + Colors.ANSI_RESET + " for Attack - Enter " + Colors.ANSI_YELLOW + "2" + Colors.ANSI_RESET + " for Defend - Enter " + Colors.ANSI_YELLOW + "3" + Colors.ANSI_RESET + " for Heal\n" + Colors.ANSI_YELLOW + "1. Attack" + Colors.ANSI_RESET + " - Attacks opponent with a small chance for a" + Colors.ANSI_RED + " critical" + Colors.ANSI_RESET + " hit\n" + Colors.ANSI_YELLOW + "2. Defend" + Colors.ANSI_RESET + " - Blocks all damage except critical hits\n" + Colors.ANSI_YELLOW + "3. Heal " + Colors.ANSI_RESET + "- Heals a fraction of " + GameState.name + "\'s health" + Colors.ANSI_RESET);

            do {

                input = in.nextInt();

                // Calculate 
                if (input == 1) {

                    attack();
                    
                }
                else if (input == 2) {
                    
                    // defend();

                }
                else if (input == 3) {
                    
                    // If you still have heals left
                    if (GameState.playerHealCount > 0) {
                        heal();
                        GameState.playerHealCount -= 1;
                    }
                    else {
                        Graphics.text("\n" + Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " has no heals left! You're doooomed...");
                        GameState.playerHealCount -= 1;
                    }

                }
                else {
                    Graphics.text(Colors.ANSI_RESET + "Do you not know how to read? You must be a true viking. Try again.");
                }
            } while ((input != 1 && input != 2 && input != 3) || (input == 3 && GameState.playerHealCount < 0) );

            // Print space
            System.out.print("\n\n");

            // Display what player did
            if (input == 1) {

                if (playerCritical == true) {

                    Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " attacks " + Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + " with a" + Colors.ANSI_RED + " critical" + Colors.ANSI_RESET + " hit!");

                }
                else {

                    Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " attacks " + Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "!");

                }

            }
            else if (input == 2) {
                
            }
            else if (input == 3) {
                Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " healed " + Colors.ANSI_GREEN + GameState.playerHealAmount + Colors.ANSI_RESET + " health!" );
            }

            // Display what enemy did
            if (enemyAction == -1) {

                Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + " stays where they are, stunned.");

            }
            else if ((enemyAction >= 0 && enemyAction <= 4)) {

                if (enemyCritical == true) {

                    Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + " delivers a crushing" + Colors.ANSI_RED + " critical" + Colors.ANSI_RESET + " blow!");

                    if (playerCritical == true) {

                        Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " and " + Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "\'s attacks collide with a devastating clash!\n" + Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + " emerges from the encounter stunned!");

                    }

                }
                else {

                    Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + " lunges to attack!");

                }
            }
            else if ((enemyAction >= 5 && enemyAction <= 9)) {

            }
            else if (enemyAction == 10) {

            }

            // Print space
            System.out.print("\n\n");

            // Reset critical chances
            playerCritical = false;
            enemyCritical = false;

            Graphics.displayCharacter(GameState.enemy, GameState.enemyHealth);
            System.out.println();

        } while (true);
    

    }

    public static void attack() throws Exception {

        // New Random object
        Random Rand = new Random();

        // Player critical hit
        if (Rand.nextInt(10) == 0) {
            
            playerCritical = true;
            
        }

        // Stunned enemy
        if (enemyAction == -1) {

            // Player critical hit
            if (playerCritical == true) {
                GameState.enemyHealth -= (GameState.playerAttack + critical);

            }
            // Player standard hit
            else {
                GameState.enemyHealth -= GameState.playerAttack;
            }

        }
        // Enemy attack
        else if ((enemyAction >= 0 && enemyAction <= 4)) {

            // If the enemy isn't stunned, then...
            if (enemyAction != -1) {
                
                // Enemy critical hit
                if (Rand.nextInt(10) == 0) {
                    
                    enemyCritical = true;

                }
                // Enemy standard hit
                else {

                    enemyCritical = false;
        
                }

            }
            else {

                enemyCritical = false;

            }

            // Calculate outcomes
            // Player critical hit; Enemy critical hit: Parry
            if (playerCritical == true && enemyCritical == true) {
                    
                // Parry
                parry = true;

            }
            // Player critical hit; Enemy standard hit
            else if (playerCritical == true) {

                // Deal damage
                if (enemyAction != -1) {
                    GameState.playerHealth -= GameState.enemyAttackAvg;
                }
                GameState.enemyHealth -= (GameState.playerAttack + critical);

            }
            // Player standard hit; Enemy critical hit
            else if (enemyCritical == true) {

                // Deal damage
                GameState.playerHealth -= (GameState.enemyAttackAvg + critical);
                GameState.enemyHealth -= GameState.playerAttack;

            }
            // Player standard hit; Enemy standard hit
            else {
                
                // Deal damage
                if (enemyAction != -1) {
                    GameState.playerHealth -= GameState.enemyAttackAvg;
                }
                GameState.enemyHealth -= GameState.playerAttack;

            }
            
        }
        // Enemy defense
        else if (enemyAction >= 5 && enemyAction <= 9) {
        


        }
        // Enemy heal
        else if (enemyAction == 10) {



        }

    }

    // Heal method
    public static void heal() throws Exception {

        // New Random object
        Random Rand = new Random();
        GameState.playerHealAmount = (Rand.nextInt(10) + 26);

        // Stunned enemy
        if (enemyAction == -1) {

            GameState.playerHealth += GameState.playerHealAmount;

        }
        // Enemy attack
        else if ((enemyAction >= 0 && enemyAction <= 4)) {
                
            // Enemy critical hit
            if (Rand.nextInt(10) == 0) {
                
                enemyCritical = true;

            }
            // Enemy standard hit
            else {

                enemyCritical = false;

            }

            // Heal player
            GameState.playerHealth += GameState.playerHealAmount;

            // Calculate outcomes
            // Player heal; Enemy critical hit
            if (enemyCritical == true) {
                    
                // Enemy critical hit
                GameState.playerHealth -= (GameState.enemyAttackAvg + critical);

            }
            // Player heal; Enemy standard hit
            else {

                // Enemy standard hit
                GameState.playerHealth -= GameState.enemyAttackAvg;

            }
            
        }
        // Enemy defense
        else if (enemyAction >= 5 && enemyAction <= 9) {



        }
        // Enemy heal
        else if (enemyAction == 10) {



        }

    }

 
    
}
