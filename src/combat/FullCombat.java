package combat;
import java.util.Scanner;
import java.util.Random;
import graphics.*;
import state.*;


/* ENEMY COMBAT CHOICE VALUES
 * 0-4: Attack
 * 5-9: Defense
 * 10: Heal
 * -1: Stun
 */

public class FullCombat {
        
    // Create variables for methods
    static int enemyAction;
    static boolean playerCritical = false;
    static boolean enemyCritical = false;
    static boolean parry = false;
    static int critical = 20;

    // Update enemy GameState stats (before a fight)
    public static void enemyGameState(String enemy, int enemyHealth, int enemyAttackAvg, int enemyCriticalChance, int attackChance, int defenseChance, int healChance, int enemyHealAmount) throws Exception {
        GameState.enemy = enemy;
        GameState.enemyHealth = enemyHealth;
        GameState.enemyAttackAvg = enemyAttackAvg;
        GameState.enemyCriticalChance = enemyCriticalChance;
        GameState.attackChance = attackChance;
        GameState.defenseChance = defenseChance;
        GameState.healChance = healChance;
        GameState.enemyHealAmount = enemyHealAmount;
    }

    // Fight an enemy
    public static void fight() throws Exception {
    
        // Create objects and variables
        Scanner in = new Scanner(System.in);
        Random Rand = new Random();
        int input;
        GameState.playerHealCount = 2;

        // Reset player stats for the fight (Health 100 + 25 for each level)
        GameState.playerHealth = 100 + (GameState.level * 25) - 25;

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
                
                do {
                    // Randomly select enemy action
                    if (GameState.enemyHealCount > 0) {
                        
                        enemyAction = Rand.nextInt(GameState.healChance);

                    }
                
                    if (enemyAction == 0) {

                        enemyAction = 10;
                        GameState.enemyHealCount -= 1;

                    }
                    else {
                        
                        enemyAction = Rand.nextInt(GameState.defenseChance - GameState.attackChance) + GameState.attackChance;

                        // enemyAction = 0;

                    }

                } while (enemyAction == 10 && GameState.enemyHealCount < 0);

            }

            // Choose action
            if (GameState.playerHealCount > 1) {
                Graphics.text(Colors.ANSI_RESET + "Enter " + Colors.ANSI_YELLOW + "1" + Colors.ANSI_RESET + " for Attack - Enter " + Colors.ANSI_YELLOW + "2" + Colors.ANSI_RESET + " for Defend - Enter " + Colors.ANSI_YELLOW + "3" + Colors.ANSI_RESET + " for Heal\n" + Colors.ANSI_YELLOW + "1. Attack" + Colors.ANSI_RESET + " - Attacks opponent with a small chance for a" + Colors.ANSI_RED + " critical" + Colors.ANSI_RESET + " hit\n" + Colors.ANSI_YELLOW + "2. Defend" + Colors.ANSI_RESET + " - Blocks all damage except" + Colors.ANSI_RED + " critical" + Colors.ANSI_RESET + " hits\n" + Colors.ANSI_YELLOW + "3. Heal " + Colors.ANSI_RESET + "- Heals a fraction of " + Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s health. " + Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " has " + GameState.playerHealCount + " heals left");
            }
            else if (GameState.playerHealCount == 1) {
                Graphics.text(Colors.ANSI_RESET + "Enter " + Colors.ANSI_YELLOW + "1" + Colors.ANSI_RESET + " for Attack - Enter " + Colors.ANSI_YELLOW + "2" + Colors.ANSI_RESET + " for Defend - Enter " + Colors.ANSI_YELLOW + "3" + Colors.ANSI_RESET + " for Heal\n" + Colors.ANSI_YELLOW + "1. Attack" + Colors.ANSI_RESET + " - Attacks opponent with a small chance for a" + Colors.ANSI_RED + " critical" + Colors.ANSI_RESET + " hit\n" + Colors.ANSI_YELLOW + "2. Defend" + Colors.ANSI_RESET + " - Blocks all damage except" + Colors.ANSI_RED + " critical" + Colors.ANSI_RESET + " hits\n" + Colors.ANSI_YELLOW + "3. Heal " + Colors.ANSI_RESET + "- Heals a fraction of " + Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s health. " + Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " has 1 heal left");
            }
            else {
                Graphics.text(Colors.ANSI_RESET + "Enter " + Colors.ANSI_YELLOW + "1" + Colors.ANSI_RESET + " for Attack - Enter " + Colors.ANSI_YELLOW + "2" + Colors.ANSI_RESET + " for Defend - Enter " + Colors.ANSI_YELLOW + "3" + Colors.ANSI_RESET + " for Heal\n" + Colors.ANSI_YELLOW + "1. Attack" + Colors.ANSI_RESET + " - Attacks opponent with a small chance for a" + Colors.ANSI_RED + " critical" + Colors.ANSI_RESET + " hit\n" + Colors.ANSI_YELLOW + "2. Defend" + Colors.ANSI_RESET + " - Blocks all damage except" + Colors.ANSI_RED + " critical" + Colors.ANSI_RESET + " hits\n" + Colors.ANSI_YELLOW + "3. Heal " + Colors.ANSI_RESET + "- Heals a fraction of " + Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s health. " + Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " has 0 heals left");
            }

            do {

                input = in.nextInt();

                // Calculate 
                if (input == 1) {

                    attack();
                    
                }
                else if (input == 2) {
                    
                    defend();

                }
                else if (input == 3) {
                    
                    // If you still have heals left
                    if (GameState.playerHealCount > 0) {
                        heal();
                        GameState.playerHealCount -= 1;
                    }
                    else {
                        Graphics.text("\n" + Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " has no heals left! You're doooomed...\nChoose to attack or defend.");
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
            // If the player attacked, then...
            if (input == 1) {

                if (playerCritical == true) {

                    Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " attacks " + Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + " with a" + Colors.ANSI_RED + " critical" + Colors.ANSI_RESET + " hit!");

                }
                else {

                    Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " attacks " + Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "!");

                }

            }
            // If the player defended, then...
            else if (input == 2) {
                
                Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " braces for impact...");

            }
            // If the player healed, then...
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

                // If the player is defending
                if (input == 2) {

                    // Critical attack
                    if (enemyCritical == true) {

                        Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "\'s " + Colors.ANSI_RED + "critical" + Colors.ANSI_RESET + " hit shatters " + Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s defense and duly whoops them!");

                    }
                    // Standard attack
                    else {

                        Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "\'s attack glances harmlessly off " + Colors.ANSI_GREEN + GameState.name  + Colors.ANSI_RESET + "\'s strong defense!");

                    }

                }

            }
            else if ((enemyAction >= 5 && enemyAction <= 9)) {

                Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + " braces for impact...");

                // If the player is attacking
                if (input == 1) {

                    // Critical attack
                    if (playerCritical == true) {

                        Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s " + Colors.ANSI_RED + "critical" + Colors.ANSI_RESET + " hit shatters " + Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "\'s defense and duly whoops them!");

                    }
                    // Standard attack
                    else {

                        Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s attack glances harmlessly off " + Colors.ANSI_RED + GameState.enemy  + Colors.ANSI_RESET + "\'s strong defense!");

                    }

                }
                // If the player is defending
                else if (input == 2) {

                    Graphics.text(Colors.ANSI_RESET + ". . . \nNothing happens...");

                }

            }
            else if (enemyAction == 10) {

                Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + " healed " + Colors.ANSI_GREEN + GameState.enemyHealAmount + Colors.ANSI_RESET + " health!");

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
        if (Rand.nextInt(GameState.playerCriticalChance) == 0) {
            
            playerCritical = true;
            
        }

        // Stunned enemy
        if (enemyAction == -1) {

            // Player critical hit
            if (playerCritical == true) {
                GameState.enemyHealth -= ((GameState.playerAttack + (Rand.nextInt(11) - 5)) + critical);

            }
            // Player standard hit
            else {
                GameState.enemyHealth -= (GameState.playerAttack + (Rand.nextInt(11) - 5));
            }

        }
        // Enemy attack
        else if ((enemyAction >= 0 && enemyAction <= 4)) {
                
            // Enemy critical hit
            if (Rand.nextInt(GameState.enemyCriticalChance) == 0) {
                
                enemyCritical = true;

            }
            // Enemy standard hit
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
                GameState.enemyHealth -= ((GameState.playerAttack + (Rand.nextInt(11) - 5)) + critical);

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
                GameState.enemyHealth -= (GameState.playerAttack + (Rand.nextInt(11) - 5));

            }
            
        }
        // Enemy defense
        else if (enemyAction >= 5 && enemyAction <= 9) {
        
            // Deal damage if it's a critical hit
            if (playerCritical == true) {

                GameState.enemyHealth -= ((GameState.playerAttack + (Rand.nextInt(11) - 5)) + critical);

            }

        }
        // Enemy heal
        else if (enemyAction == 10) {

            // Set enemyHealAmount
            GameState.enemyHealAmount = (Rand.nextInt(10) + 26);

            // Heal enemy
            GameState.enemyHealth += GameState.enemyHealAmount;

            // Player critical hit
            if (playerCritical == true) {
                GameState.enemyHealth -= ((GameState.playerAttack + (Rand.nextInt(11) - 5)) + critical);

            }
            // Player standard hit
            else {
                GameState.enemyHealth -= (GameState.playerAttack + (Rand.nextInt(11) - 5));
            }

        }

    }

    // Defend method
    public static void defend() throws Exception {

        Random Rand = new Random();

        // Enemy attack
        if ((enemyAction >= 0 && enemyAction <= 4)) {
                
            // Enemy critical hit
            if (Rand.nextInt(GameState.enemyCriticalChance) == 0) {
                
                enemyCritical = true;

            }
            // Enemy standard hit
            else {

                enemyCritical = false;
    
            }

            // Calculate outcomes
            // Player defense; Enemy critical hit
            if (enemyCritical == true) {

                // Deal damage
                GameState.playerHealth -= (GameState.enemyAttackAvg + critical);

            }
            
        }
        // NO NEED FOR ENEMY DEFENSE (nothing happens)
        // Enemy heal
        else if (enemyAction == 10) {

            // Set enemyHealAmount
            GameState.enemyHealAmount = (Rand.nextInt(10) + 36);

            // Heal enemy
            GameState.enemyHealth += GameState.enemyHealAmount;

        }

    }


    // Heal method
    public static void heal() throws Exception {

        // New Random object
        Random Rand = new Random();
        GameState.playerHealAmount = (Rand.nextInt(10) + 36);

        // Stunned enemy
        if (enemyAction == -1) {

            GameState.playerHealth += GameState.playerHealAmount;

        }
        // Enemy attack
        else if ((enemyAction >= 0 && enemyAction <= 4)) {
                
            // Enemy critical hit
            if (Rand.nextInt(GameState.enemyCriticalChance) == 0) {
                
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

            // Set playerHealAmount
            GameState.playerHealAmount = (Rand.nextInt(10) + 26);

            // Heal player
            GameState.playerHealth += GameState.playerHealAmount;

            // Set enemyHealAmount
            GameState.enemyHealAmount = (Rand.nextInt(10) + 26);

            // Heal enemy
            GameState.enemyHealth += GameState.enemyHealAmount;

        }

    }

 
    
}
