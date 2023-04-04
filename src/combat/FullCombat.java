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
    static int enemyAction = 100;
    static boolean playerCritical = false;
    static boolean enemyCritical = false;
    static boolean parry = false;
    static int critical = 20;

    public static void printSpace(int spaceCount) {
        for (int i = 0; i < spaceCount; i++) {
            System.out.println();
        }
    }

    // Update enemy GameState stats (before a fight)
    public static void enemyGameState(String enemy, int enemyHealth, int enemyAttackAvg, int enemyCriticalChance, int attackChance, int defenseChance, int healChance, int enemyHealAmount) throws Exception {
        GameState.enemy = enemy;
        GameState.enemyMaxHealth = enemyHealth;
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

        do {
            // Create objects and variables
            Scanner in = new Scanner(System.in);
            Random Rand = new Random();
            int input;
            String stringInput;
            GameState.playerHealCount = 2;

            // Reset health for the fight
            GameState.playerHealth = GameState.playerMaxHealth;
            GameState.enemyHealth = GameState.enemyMaxHealth;

            // Display enemy 

            // Opponent introduction thingy
            System.out.println(); 
            Graphics.text("An opponent approaches... its name is " + Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET);
            System.out.println(); 
            Graphics.text("Better to fight and fall than to live without hope. Be BRAVE," + Colors.ANSI_GREEN + " Viking!" + Colors.ANSI_RESET); 
            System.out.println();
            Thread.sleep(1000);

            // Display enemy
            Graphics.displayCharacter(GameState.enemy, GameState.enemyHealth);
            System.out.println();
            
            // Dramatic pause
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
                        if ((GameState.enemyHealCount > 0) && (GameState.enemyHealth < GameState.enemyMaxHealth)) {
                            
                            enemyAction = Rand.nextInt(GameState.healChance);

                        }

                        // Enemy heal
                        if (enemyAction == 0) {

                            enemyAction = 10;
                            GameState.enemyHealCount -= 1;

                        }
                        // Enemy attack/defend
                        else {
                            
                            enemyAction = Rand.nextInt(GameState.defenseChance - GameState.attackChance) + GameState.attackChance;

                        }

                    } while (enemyAction == 10 && (GameState.enemyHealCount < 0 || GameState.enemyHealth == GameState.enemyMaxHealth));

                }
                
                // Colors.ANSI_RESET + "Enter " + Colors.ANSI_YELLOW + "1" + Colors.ANSI_RESET + " for Attack - Enter " + Colors.ANSI_YELLOW + "2" + Colors.ANSI_RESET + " for Defend - Enter " + Colors.ANSI_YELLOW + "3" + Colors.ANSI_RESET + " for Heal\n"
           
                // Choose action
                if (GameState.playerHealCount > 1) {
                    Graphics.text(Colors.ANSI_RESET + "Enter \'" + Colors.ANSI_YELLOW + "Attack" + Colors.ANSI_RESET + "\', \'" + Colors.ANSI_YELLOW + "Defend" + Colors.ANSI_RESET + "\', or \'" + Colors.ANSI_YELLOW + "Heal" + Colors.ANSI_RESET + "\'\n" + Colors.ANSI_YELLOW + "1. Attack" + Colors.ANSI_RESET + " - Attacks opponent with a small chance for a" + Colors.ANSI_RED + " critical" + Colors.ANSI_RESET + " hit\n" + Colors.ANSI_YELLOW + "2. Defend" + Colors.ANSI_RESET + " - Blocks all damage except" + Colors.ANSI_RED + " critical" + Colors.ANSI_RESET + " hits\n" + Colors.ANSI_YELLOW + "3. Heal " + Colors.ANSI_RESET + "- Heals a fraction of " + Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s health. " + Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " has " + GameState.playerHealCount + " heals left");
                }
                else if (GameState.playerHealCount == 1) {
                    Graphics.text(Colors.ANSI_RESET + "Enter \'" + Colors.ANSI_YELLOW + "Attack" + Colors.ANSI_RESET + "\', \'" + Colors.ANSI_YELLOW + "Defend" + Colors.ANSI_RESET + "\', or \'" + Colors.ANSI_YELLOW + "Heal" + Colors.ANSI_RESET + "\'\n" + Colors.ANSI_YELLOW + "1. Attack" + Colors.ANSI_RESET + " - Attacks opponent with a small chance for a" + Colors.ANSI_RED + " critical" + Colors.ANSI_RESET + " hit\n" + Colors.ANSI_YELLOW + "2. Defend" + Colors.ANSI_RESET + " - Blocks all damage except" + Colors.ANSI_RED + " critical" + Colors.ANSI_RESET + " hits\n" + Colors.ANSI_YELLOW + "3. Heal " + Colors.ANSI_RESET + "- Heals a fraction of " + Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s health. " + Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " has 1 heal left");
                }
                else {
                    Graphics.text(Colors.ANSI_RESET + "Enter \'" + Colors.ANSI_YELLOW + "Attack" + Colors.ANSI_RESET + "\', \'" + Colors.ANSI_YELLOW + "Defend" + Colors.ANSI_RESET + "\', or \'" + Colors.ANSI_YELLOW + "Heal" + Colors.ANSI_RESET + "\'\n" + Colors.ANSI_YELLOW + "1. Attack" + Colors.ANSI_RESET + " - Attacks opponent with a small chance for a" + Colors.ANSI_RED + " critical" + Colors.ANSI_RESET + " hit\n" + Colors.ANSI_YELLOW + "2. Defend" + Colors.ANSI_RESET + " - Blocks all damage except" + Colors.ANSI_RED + " critical" + Colors.ANSI_RESET + " hits\n" + Colors.ANSI_YELLOW + "3. Heal " + Colors.ANSI_RESET + "- Heals a fraction of " + Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s health. " + Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " has 0 heals left");
                }

                do {

                    // TODO: take in string for attack, defend, heal -> convert to integer
                    stringInput = in.nextLine().toLowerCase();

                    // input = in.nextInt();

                    // Calculate 
                    if (stringInput.equals("attack")) {

                        input = 1;
                        attack();
                        break;
                        
                    }
                    else if (stringInput.equals("defend")) {
                        
                        input = 2;
                        defend();
                        break;

                    }
                    else if (stringInput.equals("heal")) {
                        
                        // If you still have heals left
                        if (GameState.playerHealCount > 0) {
                            
                            if (GameState.playerHealth != 100) {

                                input = 3;
                                heal();
                                GameState.playerHealCount -= 1;
                                break;

                            }
                            else {
                                // TODO: Touch up on print statement 
                                Graphics.text("\n" + Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " is at full health! Save those for when you're weak, Viking! \nChoose to attack or defend.");
                            }

                        }
                        // If you have no heals left
                        else {
                            Graphics.text("\n" + Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " has no heals left! You're doooomed...\nChoose to attack or defend.");
                            GameState.playerHealCount -= 1;
                        }

                    }
                    else {
                        Graphics.text(Colors.ANSI_RESET + "Do you not know how to read? You must be a true viking. Try again.");
                    }

                } while (true);

                // Print space
                System.out.print("\n\n");





                // Enemy stunned print statement
                if (enemyAction == -1) {
                    Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + " sways where they are, stunned.");
                }

                // GORM ACTION
                // Gorm attack
                if (input == 1) {
            
                    // enemy stunned
                    if (enemyAction == -1) {
                        if (playerCritical == true) {
                            // TODO: Pronouns
                            Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " takes advantage of his opening and deals a crushing " + Colors.ANSI_RED + "critical" + Colors.ANSI_RESET + " blow!");
                        }
                        else {
                            // TODO: Pronouns
                            Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " takes advantage of his opening and attacks!");
                        }
                    }
                    // normal attack
                    else {
                        if (playerCritical == true) {
                            Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " musters up extra strength and deals a crushing " + Colors.ANSI_RED + "critical" + Colors.ANSI_RESET + " blow!");
                        }
                        else {
                            Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " lunges to attack!");
                        }
                    }
        
                }
                // Gorm defends
                else if (input == 2) {

                    // enemy stunned
                    if (enemyAction == -1) {
                        Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " defends despite having an opening...");
                    }
                    // normal
                    else {
                        Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " braces for impact!");
                    }

                }
                // player heals
                else if (input == 3) {
                    
                    // enemy stunned
                    if (enemyAction == -1) {
                        Graphics.text("Gorm takes a breather and pops a few dumplings.");
                    }
                    else {
                        Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " quickly scarfs down a dumpling and prepares himself!");
                    }
                    // TODO: Low health heal
                    // else if (playerLowHealth == true) {
                    //     print("Gorm nervously gulps down a dumpling!");
                    // }
                    // // normal
                    // else {
                    //     print("Gorm quickly scarfs down a dumpling and prepares himself!");
                    // }

                }

                // Wait
                Thread.sleep(750);

                // ENEMY ACTION
                // Enemy attack
                if (enemyAction >= 0 && enemyAction <= 4) {
                    // critical
                    if (enemyCritical == true) {
                        Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + " delivers a crushing" + Colors.ANSI_RED + " critical" + Colors.ANSI_RESET + " blow!"); 
                    }
                    // normal
                    else {
                        Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + " lunges to attack!");
                    }
                }
                // Enemy defense
                else if (enemyAction >= 5 && enemyAction <= 9) {
                    // Gorm crit
                    if (input == 1 && playerCritical == true) {
                        Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + " nervously braces for impact!");
                    }
                    // Gorm normal
                    else if (input == 1 && playerCritical == false) {
                        // TODO: Add pronouns
                        Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + " puts up its guard!");
                    }
                    // Gorm defend
                    else if (input == 2) {
                        // TODO: Add pronouns
                        Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + " also puts up its guard...");
                    }
                    // Gorm heal
                    else if (input == 3) {
                        Graphics.text("Luckily, " + Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + " decided to defend.");
                    }
                }
                // enemy heals
                else if (enemyAction == 10) {
                
                    // // TODO: heal at low health
                    // if (enemyLowHealth == true) {
                    //     print("Enemy nervously heals some health!");
                    // }
                    // Gorm crit
                    if (input == 1 && playerCritical == true) {
                        Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + " quickly heals and prepares for impact!");
                    }
                    // Gorm normal
                    else if (input == 1 && playerCritical == false) {
                        // TODO: Add pronouns
                        Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + " heals and readies itself!");
                    }
                    // Gorm defend
                    else if (input == 2) {
                        Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + " takes advantage of the opening and heals!");
                    }
                    // Gorm heal
                    else if (input == 3) {
                        Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + " also chooses to heal!");
                    }
                }

                Thread.sleep(750);
                System.out.println();

                // RESULTS
                // Gorm attack
                if (input == 1) {
                    // Gorm critical
                    if (playerCritical == true) {
                        // Enemy stun
                        if (enemyAction == -1) {
                            Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s  attack did " + Colors.ANSI_RED + GameState.pDamageDealt + Colors.ANSI_RESET + " damage!");
                        }
                        // Enemy attack
                        else if (enemyAction >= 0 && enemyAction <= 4) {
                            // Enemy critical
                            if (enemyCritical == true) {
                                Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " and " + Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "\'s attacks collide with a devastating clash!");
                                Thread.sleep(750);
                                Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + " emerges from the encounter stunned!");
                            }
                            // Enemy standard
                            else {
                                Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s  attack did " + Colors.ANSI_RED + GameState.pDamageDealt + Colors.ANSI_RESET + " damage!");
                                Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "\'s attack did " + Colors.ANSI_RED + GameState.eDamageDealt + Colors.ANSI_RESET + " damage!");
                            }
                        }
                        // Enemy defend
                        else if (enemyAction >= 5 && enemyAction <= 9) {
                            // TODO: Add other cases for damage dealt
                            Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s " + Colors.ANSI_RED + "critical" + Colors.ANSI_RESET + " hit shatters " + Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "\'s defense and duly whoops them!");
                            System.out.println();
                            Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s  attack did " + Colors.ANSI_RED + GameState.pDamageDealt + Colors.ANSI_RESET + " damage!");
                        } 
                        // Enemy heal
                        else if (enemyAction == 10) {
                            Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + " healed " + Colors.ANSI_GREEN + GameState.eHealthGained + Colors.ANSI_RESET + " health!");
                            Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s  attack did " + Colors.ANSI_RED + GameState.pDamageDealt + Colors.ANSI_RESET + " damage!");
                        }
                    }
                    // Gorm standard
                    else {
                        // Enemy stun
                        if (enemyAction == -1) {
                            Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s attack did " + Colors.ANSI_RED + GameState.pDamageDealt + Colors.ANSI_RESET + " damage!");
                        }
                        // Enemy attack
                        else if (enemyAction >= 0 && enemyAction <= 4) {
                            Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s  attack did " + Colors.ANSI_RED + GameState.pDamageDealt + Colors.ANSI_RESET + " damage!");
                            Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "\'s attack did " + Colors.ANSI_RED + GameState.eDamageDealt + Colors.ANSI_RESET + " damage!");
                        }
                        // Enemy defend
                        else if (enemyAction >= 5 && enemyAction <= 9) {
                            Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s attack glances harmlessly off " + Colors.ANSI_RED + GameState.enemy  + Colors.ANSI_RESET + "\'s strong defense!");
                        }
                        // Enemy heal
                        else if (enemyAction == 10) {
                            Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + " healed " + Colors.ANSI_GREEN + GameState.eHealthGained + Colors.ANSI_RESET + " health!");
                            Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s  attack did " + Colors.ANSI_RED + GameState.pDamageDealt + Colors.ANSI_RESET + " damage!");
                        }
                    }
                }
                // Gorm defend
                else if (input == 2) {
                    // Enemy stun
                    if (enemyAction == -1) {
                        Graphics.text(". . .");
                        Thread.sleep(750);
                        Graphics.text("Nothing happens...");
                    }
                    // Enemy attack
                    else if (enemyAction >= 0 && enemyAction <= 4) {
                        // Enemy critical
                        if (enemyCritical == true) {
                            // TODO: Add other cases for damage dealt
                            Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "\'s " + Colors.ANSI_RED + "critical" + Colors.ANSI_RESET + " hit shatters " + Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s defense and duly whoops them!");
                            System.out.println();
                            Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "\'s attack did " + Colors.ANSI_RED + GameState.eDamageDealt + Colors.ANSI_RESET + " damage!");
                        }
                        // Enemy standard
                        else {
                            Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "\'s attack glances harmlessly off " + Colors.ANSI_GREEN + GameState.name  + Colors.ANSI_RESET + "\'s strong defense!");
                        }
                    }
                    // Enemy defend
                    else if (enemyAction >= 5 && enemyAction <= 9) {
                        Graphics.text("How ironic...");
                        Thread.sleep(750);
                        Graphics.text("Nothing happens...");
                    }
                    // Enemy heal
                    else if (enemyAction == 10) {
                        Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + " healed " + Colors.ANSI_GREEN + GameState.eHealthGained + Colors.ANSI_RESET + " health!");
                    }
                }
                // Gorm heal
                else if (input == 3) {
                    Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " healed " + Colors.ANSI_GREEN + GameState.pHealthGained + Colors.ANSI_RESET + " health!");
                    // Enemy attack
                    if (enemyAction >= 0 && enemyAction <= 4) {
                        Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "\'s attack did " + Colors.ANSI_RED + GameState.eDamageDealt + Colors.ANSI_RESET + " damage!");
                    }
                    // Enemy heal
                    else if (enemyAction == 10) {
                        Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + " healed " + Colors.ANSI_GREEN + GameState.eHealthGained + Colors.ANSI_RESET + " health!");
                    }
                }

                // Wait
                Thread.sleep(750);

                // Print space
                System.out.print("\n\n");
            
                // Reset critical chances
                playerCritical = false;
                enemyCritical = false;

                // Display enemy
                Graphics.displayCharacter(GameState.enemy, GameState.enemyHealth);
                System.out.println();

            } while (GameState.playerHealth > 0 && GameState.enemyHealth > 0);




            // Display player
            Graphics.displayCharacter(GameState.name, GameState.playerHealth);
            System.out.print("\n\n");

            // Calculate what happens
            if (GameState.playerHealth <= 0) {
                Graphics.displayDeath("Tomb");
                Graphics.text("\n" + Colors.ANSI_RED + GameState.name + " fought honorably, but was slain by " + GameState.enemy + "..." + Colors.ANSI_RESET + "\n\n");

                // Respawn statement
                Thread.sleep(3000);
                Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s brave soul is taken up to Valhalla for his eternal reward...\n");
                Thread.sleep(1500);
                Graphics.text("But wait!\n");
                Thread.sleep(1000);
                Graphics.text("Since " + Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " died valiently in combat, the gods have granted him another chance to defeat his foe...\n");
                Thread.sleep(1500);
                Graphics.text("Don't let them regret their choice...");
                Thread.sleep(3000);
                
            }
            else {
                Graphics.displayWin("Trophy");
                Graphics.text("\n" + Colors.ANSI_GREEN + GameState.name + " fought courageously and defeated " + Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "!\n");
                Thread.sleep(1500);
                Graphics.text("Safe travels on the rest of your journey, " + Colors.ANSI_GREEN + "Viking" + Colors.ANSI_RESET + "...");
                Thread.sleep(3000);
            }

            printSpace(100);
            Thread.sleep(750);
    
        } while (GameState.playerHealth < 1);

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

                // ENEMY DAMAGED
                GameState.pDamageDealt = ((GameState.playerAttack + (Rand.nextInt(11) - 5)) + critical);
                GameState.enemyHealth -= GameState.pDamageDealt;

                // Don't go below 0
                if (GameState.enemyHealth < 0) {
                    GameState.enemyHealth = 0;
                }

            }
            // Player standard hit
            else {

                // ENEMY DAMAGED
                GameState.pDamageDealt = (GameState.playerAttack + (Rand.nextInt(11) - 5));
                GameState.enemyHealth -= GameState.pDamageDealt;

                // Don't go below 0
                if (GameState.enemyHealth < 0) {
                    GameState.enemyHealth = 0;
                }

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

                // PLAYER DAMAGED
                GameState.eDamageDealt = (GameState.enemyAttackAvg + (Rand.nextInt(11) - 5));
                GameState.playerHealth -= GameState.eDamageDealt;

                // Don't go below 0
                if (GameState.playerHealth < 0) {
                    GameState.playerHealth = 0;
                }
                
                // ENEMY DAMAGED
                GameState.pDamageDealt = ((GameState.playerAttack + (Rand.nextInt(11) - 5)) + critical);
                GameState.enemyHealth -= GameState.pDamageDealt;

                // Don't go below 0
                if (GameState.enemyHealth < 0) {
                    GameState.enemyHealth = 0;
                }

            }
            // Player standard hit; Enemy critical hit
            else if (enemyCritical == true) {

                // PLAYER DAMAGED
                GameState.eDamageDealt = ((GameState.enemyAttackAvg + (Rand.nextInt(11) - 5)) + critical);
                GameState.playerHealth -= GameState.eDamageDealt;

                // Don't go below 0
                if (GameState.playerHealth < 0) {
                    GameState.playerHealth = 0;
                }

                // ENEMY DAMAGED
                GameState.pDamageDealt = (GameState.playerAttack + (Rand.nextInt(11) - 5));
                GameState.enemyHealth -= GameState.pDamageDealt;

                // Don't go below 0
                if (GameState.enemyHealth < 0) {
                    GameState.enemyHealth = 0;
                }

            }
            // Player standard hit; Enemy standard hit
            else {
                
                // PLAYER DAMAGED
                GameState.eDamageDealt = (GameState.enemyAttackAvg + (Rand.nextInt(11) - 5));
                GameState.playerHealth -= GameState.eDamageDealt;

                // Don't go below 0
                if (GameState.playerHealth < 0) {
                    GameState.playerHealth = 0;
                }
                
                // ENEMY DAMAGED
                GameState.pDamageDealt = (GameState.playerAttack + (Rand.nextInt(11) - 5));
                GameState.enemyHealth -= GameState.pDamageDealt;

                // Don't go below 0
                if (GameState.enemyHealth < 0) {
                    GameState.enemyHealth = 0;
                }

            }
            
        }
        // Enemy defense
        else if (enemyAction >= 5 && enemyAction <= 9) {
        
            // Deal damage if it's a critical hit
            if (playerCritical == true) {

                // ENEMY DAMAGED
                GameState.pDamageDealt = ((GameState.playerAttack + (Rand.nextInt(11) - 5)) + critical);
                GameState.enemyHealth -= GameState.pDamageDealt;
                
                // Don't go below 0
                if (GameState.enemyHealth < 0) {
                    GameState.enemyHealth = 0;
                }

            }

        }
        // Enemy heal
        else if (enemyAction == 10) {

            // Heal enemy
            GameState.eHealthGained = ((GameState.enemyHealAmount + (Rand.nextInt(11) - 5)));
            GameState.enemyHealth += GameState.eHealthGained;

            // Don't go over enemy max health
            if (GameState.enemyHealth > GameState.enemyMaxHealth) {

                GameState.enemyHealth = GameState.enemyMaxHealth;

            }

            // Player critical hit
            if (playerCritical == true) {

                // ENEMY DAMAGED
                GameState.pDamageDealt = ((GameState.playerAttack + (Rand.nextInt(11) - 5)) + critical);
                GameState.enemyHealth -= GameState.pDamageDealt;

            }
            // Player standard hit
            else {

                // ENEMY DAMAGED
                GameState.pDamageDealt = (GameState.playerAttack + (Rand.nextInt(11) - 5));
                GameState.enemyHealth -= GameState.pDamageDealt;
                
            }

            // Don't go below 0
            if (GameState.enemyHealth < 0) {
                GameState.enemyHealth = 0;
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

                /// PLAYER DAMAGED
                GameState.eDamageDealt = (GameState.enemyAttackAvg + (Rand.nextInt(11) - 5) + critical);
                GameState.playerHealth -= GameState.eDamageDealt;

                // Don't go below 0
                if (GameState.playerHealth < 0) {
                    GameState.playerHealth = 0;
                }

            }
            
        }
        // NO NEED FOR ENEMY DEFENSE (nothing happens)
        // Enemy heal
        else if (enemyAction == 10) {

            // Heal enemy
            GameState.eHealthGained = ((GameState.enemyHealAmount + (Rand.nextInt(11) - 5)));
            GameState.enemyHealth += GameState.eHealthGained;

            // Don't go over enemy max health
            if (GameState.enemyHealth > GameState.enemyMaxHealth) {

                GameState.enemyHealth = GameState.enemyMaxHealth;

            }

        }

    }


    // Heal method
    public static void heal() throws Exception {

        // New Random object
        Random Rand = new Random();

        // Heal player
        GameState.pHealthGained = ((GameState.playerHealAmount + (Rand.nextInt(11) - 5)));
        GameState.playerHealth += GameState.pHealthGained;

        // Don't go over max player health
        if (GameState.playerHealth > 100) {

            GameState.playerHealth = 100;
        }

        // No need for Stunned enemy case
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
            // Player heal; Enemy critical hit
            if (enemyCritical == true) {
                    
                // PLAYER DAMAGED
                GameState.eDamageDealt = (GameState.enemyAttackAvg + (Rand.nextInt(11) - 5) + critical);
                GameState.playerHealth -= GameState.eDamageDealt;

            }
            // Player heal; Enemy standard hit
            else {

                // PLAYER DAMAGED
                GameState.eDamageDealt = (GameState.enemyAttackAvg + (Rand.nextInt(11) - 5));
                GameState.playerHealth -= GameState.eDamageDealt;

            }

            // Don't go below 0
            if (GameState.playerHealth < 0) {
                GameState.playerHealth = 0;
            }
            
        }
        // No need for Enemy defense case
        // Enemy heal
        else if (enemyAction == 10) {

            // Heal enemy
            GameState.eHealthGained = ((GameState.enemyHealAmount + (Rand.nextInt(11) - 5)));
            GameState.enemyHealth += GameState.eHealthGained;

            // Don't go over enemy max health
            if (GameState.enemyHealth > GameState.enemyMaxHealth) {

                GameState.enemyHealth = GameState.enemyMaxHealth;

            }

        }

    }

}