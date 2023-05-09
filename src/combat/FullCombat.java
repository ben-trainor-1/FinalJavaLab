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
    static boolean failsafe = false;
    static int enemyAction = 100;
    static boolean playerCritical = false;
    static boolean enemyCritical = false;
    static boolean parry = false;

    public static void printSpace(int spaceCount) {
        for (int i = 0; i < spaceCount; i++) {
            System.out.println();
        }
    }

    /**
     * Updates enemy stats for combat. Call before calling `fight()`.
     * @param enemy
     * @param enemyHealth
     * @param enemyAttackAvg
     * @param enemyCriticalChance
     * @param eCritical
     * @param attackChance
     * @param defenseChance
     * @param eDefenseBuff
     * @param healChance
     * @param enemyHealAmount
     * @throws Exception
     */
    public static void enemyGameState(String enemy, int enemyHealth, int enemyAttackAvg, int enemyCriticalChance, int eCritical, int attackChance, int defenseChance, int eDefenseBuff, int healChance, int healCount, int enemyHealAmount) throws Exception {
        GameState.enemy = enemy;
        GameState.enemyMaxHealth = enemyHealth;
        GameState.enemyHealth = enemyHealth;
        GameState.enemyAttackAvg = enemyAttackAvg;
        GameState.enemyCriticalChance = enemyCriticalChance;
        GameState.eCritical = eCritical;
        GameState.attackChance = attackChance;
        GameState.defenseChance = defenseChance;
        GameState.eDefenseBuff = eDefenseBuff;
        GameState.healChance = healChance;
        GameState.enemyHealCount = healCount;
        GameState.enemyHealAmount = enemyHealAmount;
    }

    // Fight an enemy
    public static void fight() throws Exception {

        failsafe = false;

        do {
            // Create objects and variables
            Scanner in = new Scanner(System.in);
            Random Rand = new Random();
            int input;
            String stringInput;

            // Reset variables for the fight
            GameState.playerHealth = GameState.playerMaxHealth;
            GameState.enemyHealth = GameState.enemyMaxHealth;
            GameState.pBuffPhase = 0;
            GameState.eBuffPhase = 0;
            GameState.pHealedToMax = false;
            GameState.eHealedToMax = false;
            int playerInitialHealCount = GameState.playerHealCount;
            int enemyInitialHealCount = GameState.enemyHealCount;

            // Display enemy 

            // Opponent introduction thingy
            System.out.println(); 
            Graphics.text("An opponent approaches... its name is " + Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET);
            System.out.println(); 
            Graphics.text("Better to fight and fall than to live without hope. Be BRAVE," + Colors.ANSI_GREEN + " Viking!" + Colors.ANSI_RESET); 
            System.out.println();
            Thread.sleep(1000);

            // Display enemy
            Graphics.displayEnemy(GameState.enemy);
            System.out.println();
            
            // Dramatic pause
            Thread.sleep(1500);

            // Combat
            do {

                // Display the character
                Graphics.displayGormGro();
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
                        if ((GameState.enemyHealCount > 0) && (GameState.enemyHealth < GameState.enemyMaxHealth) && (GameState.healChance != -1)) {
                            
                            enemyAction = Rand.nextInt(GameState.healChance);

                        }
                        else if (GameState.healChance == -1) {
                            enemyAction = -1;
                        }

                        // Enemy heal
                        if (enemyAction == 0) {

                            enemyAction = 10;
                            GameState.enemyHealCount -= 1;

                        }
                        // Enemy attack/defend
                        else {
                            
                            if (GameState.eBuffPhase == 1) {
                                enemyAction = 0;
                            }
                            else {
                                enemyAction = Rand.nextInt(GameState.defenseChance - GameState.attackChance) + GameState.attackChance;
                            }

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

                    // Take in input as a String
                    stringInput = in.nextLine().toLowerCase();

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
                    else if (stringInput.equals("failsafe")) {
                        input = 0;
                        failsafe = true;
                        break;
                    }
                    else {
                        Graphics.text(Colors.ANSI_RESET + "Do you not know how to read? You must be a true viking. Try again.");
                    }

                } while (true);

                if (failsafe == false) {
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
                                if (GameState.weapon.equals("battleaxe")) {
                                    Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " takes advantage of the opening and slices " + Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + " with a vicious " + Colors.ANSI_RED + "critical" + Colors.ANSI_RESET + " slash!");  
                                }
                                else {
                                    Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " takes advantage of the opening and hurls " + GameState.posNoun.toLowerCase() + " spear, plunging deep into " + Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "\'s flesh, causing a " + Colors.ANSI_RED + "critical" + Colors.ANSI_RESET + " wound!");  
                                }
                            }
                            else {
                                if (GameState.weapon.equals("battleaxe")) {
                                    Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " realizes " + GameState.posNoun.toLowerCase() + " opportunity and quickly swings " + GameState.posNoun.toLowerCase() + " axe!");
                                }
                                else {
                                    Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " realizes " + GameState.posNoun.toLowerCase() + " opportunity and quickly jabs at " + Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "!");
                                }
                            }
                        }
                        // normal attack
                        else {
                            if (playerCritical == true) {
                                
                                if (GameState.weapon.equals("battleaxe")) {
                                    Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " musters up extra strength and attempts to slice " + Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + " with a vicious " + Colors.ANSI_RED + "critical" + Colors.ANSI_RESET + " slash!");  
                                }
                                else {
                                    Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " musters up extra strength and hurls " + GameState.posNoun.toLowerCase() + " spear at " + Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "...");  
                                }
                            
                            }
                            else {
                                if (GameState.weapon.equals("battleaxe")) {
                                    Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " swings " + GameState.posNoun.toLowerCase() + " axe!");
                                }
                                else {
                                    Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " thrusts with " + GameState.posNoun.toLowerCase() + " spear!");
                                }
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
                            Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " takes a breather and pops a few dumplings.");
                        }
                        else {
                            Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " quickly scarfs down a dumpling and prepares " + GameState.objpNoun.toLowerCase() + "self!");
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
                            Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + " puts up its guard!");
                        }
                        // Gorm defend
                        else if (input == 2) {
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
                                Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s attack did " + Colors.ANSI_RED + GameState.pDamageDealt + Colors.ANSI_RESET + " damage!");
                            }
                            // Enemy attack
                            else if (enemyAction >= 0 && enemyAction <= 4) {
                                // Enemy critical
                                if (enemyCritical == true) {
                                    Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " and " + Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "\'s attacks collide with a devastating clash!");
                                    Thread.sleep(750);
                                    Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + " emerges from the encounter stunned!");
                                    if (GameState.pBuffPhase == 1) {
                                        Thread.sleep(750);
                                        System.out.println();
                                        Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s defensive buff wears off...");
                                    }
                                    if (GameState.eBuffPhase == 1) {
                                        Thread.sleep(750);
                                        System.out.println();
                                        Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "\'s defensive buff wears off...");
                                    }
                                }
                                // Enemy standard
                                else {
                                    if (GameState.pBuffPhase == 1) {
                                        Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s strong defensive buff leaves " + Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "\'s attack as only a glancing blow, hardly injuring " + Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "!");
                                        System.out.println();
                                    }
                                    else if (GameState.eBuffPhase == 1) {
                                        Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " calls upon the name of " + GameState.posNoun.toLowerCase() + " Ancestors, and " + GameState.pNoun.toLowerCase() + " attack is still able to do some " + Colors.ANSI_RED + "critical" + Colors.ANSI_RESET + " damage!");
                                    }
                                    
                                    Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s attack did " + Colors.ANSI_RED + GameState.pDamageDealt + Colors.ANSI_RESET + " damage!");
                                    Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "\'s attack did " + Colors.ANSI_RED + GameState.eDamageDealt + Colors.ANSI_RESET + " damage!");
                                }
                            }
                            // Enemy defend
                            else if (enemyAction >= 5 && enemyAction <= 9) {
                                if (GameState.eBuffPhase == 1) {
                                    Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " calls upon the name of " + GameState.posNoun.toLowerCase() + " Ancestors, and " + GameState.pNoun.toLowerCase() + " attack is still able to do some " + Colors.ANSI_RED + "critical" + Colors.ANSI_RESET + " damage!");
                                }
                                // TODO: Add other cases for damage dealt
                                Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s " + Colors.ANSI_RED + "critical" + Colors.ANSI_RESET + " hit shatters " + Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "\'s defense and duly whoops them!");
                                System.out.println();
                                Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s attack did " + Colors.ANSI_RED + GameState.pDamageDealt + Colors.ANSI_RESET + " damage!");
                                if (GameState.pBuffPhase == 1) {
                                    Thread.sleep(750);
                                    System.out.println();
                                    Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s defensive buff wears off...");
                                }
                            } 
                            // Enemy heal
                            else if (enemyAction == 10) {
                                if (GameState.eBuffPhase == 1) {
                                    Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " calls upon the name of " + GameState.posNoun.toLowerCase() + " Ancestors, and " + GameState.pNoun.toLowerCase() + " attack is still able to do some " + Colors.ANSI_RED + "critical" + Colors.ANSI_RESET + " damage!");
                                }

                                if (!GameState.eHealedToMax) {
                                    Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + " healed " + Colors.ANSI_GREEN + GameState.eHealthGained + Colors.ANSI_RESET + " health!");
                                }
                                else {
                                    Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + " healed to max health!");
                                }
                                Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s attack did " + Colors.ANSI_RED + GameState.pDamageDealt + Colors.ANSI_RESET + " damage!");
                                if (GameState.pBuffPhase == 1) {
                                    Thread.sleep(750);
                                    System.out.println();
                                    Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s defensive buff wears off...");
                                }
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
                                if (enemyCritical == true) {
                                    if (GameState.pBuffPhase == 1) {
                                        Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + " calls upon the name of SURTUR, and their attack is still able to do some " + Colors.ANSI_RED + "critical" + Colors.ANSI_RESET + " damage!");
                                    }
                                    else if (GameState.eBuffPhase == 1) {
                                        Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "\'s strong defensive buff leaves " + Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s attack as only a glancing blow, hardly injuring " + Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "!");
                                        System.out.println();
                                    }
                                }
                                else {
                                    if (GameState.pBuffPhase == 1) {
                                        Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s strong defensive buff leaves " + Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "\'s attack as only a glancing blow, hardly injuring " + Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "!");
                                    }
                                    else if (GameState.eBuffPhase == 1) {
                                        Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "\'s strong defensive buff leaves " + Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s attack as only a glancing blow, hardly injuring " + Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "!");
                                        System.out.println();
                                    }
                                }
                                System.out.println();
                                Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s attack did " + Colors.ANSI_RED + GameState.pDamageDealt + Colors.ANSI_RESET + " damage!");
                                Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "\'s attack did " + Colors.ANSI_RED + GameState.eDamageDealt + Colors.ANSI_RESET + " damage!");
                            }
                            // Enemy defend
                            else if (enemyAction >= 5 && enemyAction <= 9) {
                                if (GameState.weapon.equals("battleaxe")) {
                                    Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s axe glances harmlessly off " + Colors.ANSI_RED + GameState.enemy  + Colors.ANSI_RESET + "\'s strong defense!");
                                }
                                else {
                                    Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s spear glances harmlessly off " + Colors.ANSI_RED + GameState.enemy  + Colors.ANSI_RESET + "\'s strong defense!");
                                }

                                Thread.sleep(750);
                                System.out.println();
                                Graphics.text("The strong defense prepares " + Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + " for the next attack!");
                                Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + " gains a defensive buff!");

                                if (GameState.pBuffPhase == 1) {
                                    Thread.sleep(750);
                                    System.out.println();
                                    Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s defensive buff wears off...");
                                }
                                if (GameState.eBuffPhase == 1) {
                                    Thread.sleep(750);
                                    System.out.println();
                                    Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "\'s defensive buff wears off...");
                                }
                            }
                            // Enemy heal
                            else if (enemyAction == 10) {
                                if (GameState.eBuffPhase == 1) {
                                    Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "\'s strong defensive buff leaves " + Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s attack as only a glancing blow, hardly injuring " + Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "!");
                                    System.out.println();
                                }

                                if (!GameState.eHealedToMax) {
                                    Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + " healed " + Colors.ANSI_GREEN + GameState.eHealthGained + Colors.ANSI_RESET + " health!");
                                }
                                else {
                                    Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + " healed to max health!");
                                }
                                Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s attack did " + Colors.ANSI_RED + GameState.pDamageDealt + Colors.ANSI_RESET + " damage!");
                                if (GameState.pBuffPhase == 1) {
                                    Thread.sleep(750);
                                    System.out.println();
                                    Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s defensive buff wears off...");
                                }
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
                            if (GameState.eBuffPhase == 1) {
                                Thread.sleep(750);
                                System.out.println();
                                Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "\'s defensive buff wears off...");
                            }
                        }
                        // Enemy attack
                        else if (enemyAction >= 0 && enemyAction <= 4) {
                            // Enemy critical
                            if (enemyCritical == true) {
                                if (GameState.pBuffPhase == 1) {
                                    Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + " calls upon the name of SURTUR, and their attack is still able to do some " + Colors.ANSI_RED + "critical" + Colors.ANSI_RESET + " damage!");
                                }
                                
                                // TODO: Add other cases for damage dealt
                                Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "\'s " + Colors.ANSI_RED + "critical" + Colors.ANSI_RESET + " hit shatters " + Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s defense and duly whoops them!");
                                System.out.println();
                                Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "\'s attack did " + Colors.ANSI_RED + GameState.eDamageDealt + Colors.ANSI_RESET + " damage!");
                                if (GameState.eBuffPhase == 1) {
                                    Thread.sleep(750);
                                    System.out.println();
                                    Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "\'s defensive buff wears off...");
                                }
                            }
                            // Enemy standard
                            else {
                                Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "\'s attack glances harmlessly off " + Colors.ANSI_GREEN + GameState.name  + Colors.ANSI_RESET + "\'s strong defense!");
                                Thread.sleep(750);
                                System.out.println();
                                Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s strong defense emboldens " + GameState.objpNoun.toLowerCase() + "! " + GameState.pNoun + "\'s prepared for the next attack!");
                                Graphics.text(GameState.pNoun + " gains a defensive buff!");
                                if (GameState.eBuffPhase == 1) {
                                    Thread.sleep(750);
                                    System.out.println();
                                    Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "\'s defensive buff wears off...");
                                }
                            }
                        }
                        // Enemy defend
                        else if (enemyAction >= 5 && enemyAction <= 9) {
                            Graphics.text("How ironic...");
                            Thread.sleep(750);
                            Graphics.text("Nothing happens...");
                            if (GameState.pBuffPhase == 1) {
                                Thread.sleep(750);
                                System.out.println();
                                Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s defensive buff wears off...");
                            }
                            if (GameState.eBuffPhase == 1) {
                                Thread.sleep(750);
                                System.out.println();
                                Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "\'s defensive buff wears off...");
                            }
                        }
                        // Enemy heal
                        else if (enemyAction == 10) {
                            if (!GameState.eHealedToMax) {
                                Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + " healed " + Colors.ANSI_GREEN + GameState.eHealthGained + Colors.ANSI_RESET + " health!");
                            }
                            else {
                                Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + " healed to max health!");
                            }
                            if (GameState.pBuffPhase == 1) {
                                Thread.sleep(750);
                                System.out.println();
                                Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s defensive buff wears off...");
                            }
                            if (GameState.eBuffPhase == 1) {
                                Thread.sleep(750);
                                System.out.println();
                                Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "\'s defensive buff wears off...");
                            }
                        }
                    }
                    // Gorm heal
                    else if (input == 3) {
                        // Enemy attack
                        if (enemyAction >= 0 && enemyAction <= 4) {
                            if (enemyCritical == false) {
                                if (GameState.pBuffPhase == 1) {
                                    Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s strong defensive buff leaves " + Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "\'s attack as only a glancing blow, hardly injuring " + Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "!");
                                    System.out.println();
                                }
                            }
                            else {
                                if (GameState.pBuffPhase == 1) {
                                    Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + " calls upon the name of SURTUR, and their attack is still able to do some " + Colors.ANSI_RED + "critical" + Colors.ANSI_RESET + " damage!");
                                }
                            }

                            if (!GameState.pHealedToMax) {
                                Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " healed " + Colors.ANSI_GREEN + GameState.pHealthGained + Colors.ANSI_RESET + " health!");
                            }
                            else {
                                Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " healed to max health!");
                            }

                            Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "\'s attack did " + Colors.ANSI_RED + GameState.eDamageDealt + Colors.ANSI_RESET + " damage!");
                            
                            if (GameState.eBuffPhase == 1) {
                                Thread.sleep(750);
                                System.out.println();
                                Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "\'s defensive buff wears off...");
                            }
                        }
                        // Enemy defense
                        else if (enemyAction >= 5 && enemyAction <= 9) {

                            if (!GameState.pHealedToMax) {
                                Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " healed " + Colors.ANSI_GREEN + GameState.pHealthGained + Colors.ANSI_RESET + " health!");
                            }
                            else {
                                Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " healed to max health!");
                            }

                            if (GameState.pBuffPhase == 1) {
                                Thread.sleep(750);
                                System.out.println();
                                Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s defensive buff wears off...");
                            }
                            if (GameState.eBuffPhase == 1) {
                                Thread.sleep(750);
                                System.out.println();
                                Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "\'s defensive buff wears off...");
                            }
                        }
                        // Enemy heal
                        else if (enemyAction == 10) {

                            if (!GameState.pHealedToMax) {
                                Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " healed " + Colors.ANSI_GREEN + GameState.pHealthGained + Colors.ANSI_RESET + " health!");
                            }
                            else {
                                Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " healed to max health!");
                            }

                            if (!GameState.eHealedToMax) {
                                Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + " healed " + Colors.ANSI_GREEN + GameState.eHealthGained + Colors.ANSI_RESET + " health!");
                            }
                            else {
                                Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + " healed to max health!");
                            }

                            if (GameState.pBuffPhase == 1) {
                                Thread.sleep(750);
                                System.out.println();
                                Graphics.text(Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s defensive buff wears off...");
                            }
                            if (GameState.eBuffPhase == 1) {
                                Thread.sleep(750);
                                System.out.println();
                                Graphics.text(Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "\'s defensive buff wears off...");
                            }
                        }
                    }

                    // Wait
                    Thread.sleep(750);

                    // Print space
                    System.out.print("\n\n");
                
                    // Reset critical chances/iterate buff phases/reset healedToMax
                    playerCritical = false;
                    enemyCritical = false;
                    GameState.pHealedToMax = false;
                    GameState.eHealedToMax = false;

                    if (GameState.pBuffPhase > 0) {
                        GameState.pBuffPhase --;
                    }

                    if (GameState.eBuffPhase > 0) {
                        GameState.eBuffPhase --;
                    }
            

                    // Display enemy
                    Graphics.displayEnemy(GameState.enemy);
                    System.out.println();
                }
                else {
                    break;
                }

            } while (GameState.playerHealth > 0 && GameState.enemyHealth > 0);



            if (failsafe == false) {
                // Display player
                Graphics.displayGormGro();
                System.out.print("\n\n");

                // Calculate what happens
                if (GameState.playerHealth <= 0) {
                    if (GameState.enemy.equals("Reginald")) {
                        Graphics.displayDeath("Tomb", Colors.ANSI_BLACK);
                        Graphics.textInline("\n" + Colors.ANSI_RED + GameState.name + " attempted to fight valiantly, but was absolutely whooped by the almighty " + GameState.enemy + "..." + Colors.ANSI_RESET);
                        Graphics.waitForEnter();

                        // Respawn statement
                        Graphics.textInline("\n\n" + Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s puny soul is dragged down to Niflheim for " + GameState.posNoun.toLowerCase() + " eternal punishment...");
                        Graphics.waitForEnter();
                        Graphics.textInline("\nBut wait!");
                        Graphics.waitForEnter();
                        Graphics.text("\nHela recognizes that " + Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " is a feeble, unworthy opponent for " + Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "...");
                        Graphics.textInline("She grants you another life...");
                        Graphics.waitForEnter();
                        Graphics.textInline("\nDon't make the mistake of fighting the almighty " + Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + " again...");
                        Graphics.waitForEnter();                    }
                    else if (GameState.enemy.equals("Loki")) {
                        Graphics.textInline("\n\nThe fight with " + Colors.ANSI_RED + "Loki" + Colors.ANSI_RESET + " is hard and tedious...");
                        Graphics.waitForEnter();
                        Graphics.textInline("\n" + Colors.ANSI_RED + "Loki" + Colors.ANSI_RESET + " seems to never run out of energy, never ceasing his fast, ferocious attacks.");
                        Graphics.waitForEnter();
                        Graphics.textInline("\nHe finally gets the upperhand as he nimbly swings his scepter to disarm you!");
                        Graphics.textInline("\nYou attempt to retaliate, but he impales you through the chest...");
                        Graphics.waitForEnter();
                        Graphics.textInline("\nThe last thing you see is " + Colors.ANSI_RED + "Loki" + Colors.ANSI_RESET + " laughing...");
                        Graphics.waitForEnter();
                        Graphics.textInline("\n\"You thought you had a chance...\"");
                        Graphics.waitForEnter();
                        Graphics.displayDeath("Tomb", Colors.ANSI_BLACK);
                        Graphics.waitForEnter();

                    }
                    else {
                        GameState.playerHealCount = playerInitialHealCount;
                        GameState.enemyHealCount = enemyInitialHealCount;
                        Graphics.displayDeath("Tomb", Colors.ANSI_BLACK);
                        Graphics.textInline("\n" + Colors.ANSI_RED + GameState.name + " fought honorably, but was slain by " + GameState.enemy + "..." + Colors.ANSI_RESET);
                        Graphics.waitForEnter();

                        // Respawn statement
                        Graphics.textInline("\n\n" + Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + "\'s brave soul is taken up to Valhalla for " + GameState.posNoun.toLowerCase() + "eternal reward...");
                        Graphics.waitForEnter();
                        Graphics.textInline("\nBut wait!");
                        Graphics.waitForEnter();
                        Graphics.textInline("\nSince " + Colors.ANSI_GREEN + GameState.name + Colors.ANSI_RESET + " died valiantly in combat, the gods have granted " + GameState.objpNoun.toLowerCase() + " another chance to defeat " + GameState.posNoun.toLowerCase() + " foe...");
                        Graphics.waitForEnter();
                        Graphics.text("\nDon't let them regret their choice...");
                        Graphics.waitForEnter();
                    }
                }
                else {
                    Graphics.displayWin("Trophy", Colors.ANSI_YELLOW);
                    Graphics.textInline("\n" + Colors.ANSI_GREEN + GameState.name + " fought courageously and defeated " + Colors.ANSI_RED + GameState.enemy + Colors.ANSI_RESET + "!");
                    Graphics.waitForEnter();
                    Graphics.textInline("\nSafe travels on the rest of your journey, " + Colors.ANSI_GREEN + "Viking" + Colors.ANSI_RESET + "...");
                    Graphics.waitForEnter();
                }

                printSpace(100);
                Thread.sleep(750);
            }
            else {
                break;
            }
    
        } while (GameState.playerHealth < 1 && !GameState.enemy.equals("Loki") && !GameState.enemy.equals("Reginald"));

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
                GameState.pDamageDealt = (GameState.playerAttack + (Rand.nextInt(11) - 5) + GameState.pCritical);
                if (GameState.eBuffPhase == 1) {
                    GameState.pDamageDealt -= GameState.eDefenseBuff;
                }
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
                if (GameState.eBuffPhase == 1) {
                    GameState.pDamageDealt -= GameState.eDefenseBuff;
                }
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
            if (Rand.nextInt(GameState.enemyCriticalChance) == 0 && (GameState.enemyCriticalChance != -1)) {
                
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
                if (GameState.pBuffPhase == 1) {
                    GameState.eDamageDealt -= GameState.pDefenseBuff;
                }
                GameState.playerHealth -= GameState.eDamageDealt;



                // Don't go below 0
                if (GameState.playerHealth < 0) {
                    GameState.playerHealth = 0;
                }

                // ENEMY DAMAGED
                GameState.pDamageDealt = (GameState.playerAttack + (Rand.nextInt(11) - 5) + GameState.pCritical);
                if (GameState.eBuffPhase == 1) {
                    GameState.pDamageDealt -= GameState.eDefenseBuff;
                }
                GameState.enemyHealth -= GameState.pDamageDealt;

                // Don't go below 0
                if (GameState.enemyHealth < 0) {
                    GameState.enemyHealth = 0;
                }

            }
            // Player standard hit; Enemy critical hit
            else if (enemyCritical == true) {

                // PLAYER DAMAGED
                GameState.eDamageDealt = ((GameState.enemyAttackAvg + (Rand.nextInt(11) - 5)) + GameState.eCritical);
                if (GameState.pBuffPhase == 1) {
                    GameState.eDamageDealt -= GameState.pDefenseBuff;
                }
                GameState.playerHealth -= GameState.eDamageDealt;

                // Don't go below 0
                if (GameState.playerHealth < 0) {
                    GameState.playerHealth = 0;
                }

                // ENEMY DAMAGED
                GameState.pDamageDealt = (GameState.playerAttack + (Rand.nextInt(11) - 5));
                if (GameState.eBuffPhase == 1) {
                    GameState.pDamageDealt -= GameState.eDefenseBuff;
                }
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
                if (GameState.pBuffPhase == 1) {
                    GameState.eDamageDealt -= GameState.pDefenseBuff;
                }
                GameState.playerHealth -= GameState.eDamageDealt;

                // Don't go below 0
                if (GameState.playerHealth < 0) {
                    GameState.playerHealth = 0;
                }
                
                // ENEMY DAMAGED
                GameState.pDamageDealt = (GameState.playerAttack + (Rand.nextInt(11) - 5));
                if (GameState.eBuffPhase == 1) {
                    GameState.pDamageDealt -= GameState.eDefenseBuff;
                }
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
                GameState.pDamageDealt = (GameState.playerAttack + (Rand.nextInt(11) - 5) + GameState.pCritical);
                if (GameState.eBuffPhase == 1) {
                    GameState.pDamageDealt -= GameState.eDefenseBuff;
                }
                GameState.enemyHealth -= GameState.pDamageDealt;
                
                // Don't go below 0
                if (GameState.enemyHealth < 0) {
                    GameState.enemyHealth = 0;
                }

            }
            else {
                GameState.eBuffPhase = 2;
            }

        }
        // Enemy heal
        else if (enemyAction == 10) {

            // Heal enemy
            GameState.eHealthGained = ((GameState.enemyHealAmount + (Rand.nextInt(11) - 5)));
            GameState.enemyHealth += GameState.eHealthGained;

            // Don't go over enemy max health
            if (GameState.enemyHealth >= GameState.enemyMaxHealth) {

                GameState.eHealedToMax = true;
                GameState.enemyHealth = GameState.enemyMaxHealth;

            }

            // Player critical hit
            if (playerCritical == true) {

                // ENEMY DAMAGED
                GameState.pDamageDealt = (GameState.playerAttack + (Rand.nextInt(11) - 5) + GameState.pCritical);
                if (GameState.eBuffPhase == 1) {
                    GameState.pDamageDealt -= GameState.eDefenseBuff;
                }
                GameState.enemyHealth -= GameState.pDamageDealt;

            }
            // Player standard hit
            else {

                // ENEMY DAMAGED
                GameState.pDamageDealt = (GameState.playerAttack + (Rand.nextInt(11) - 5));
                if (GameState.eBuffPhase == 1) {
                    GameState.pDamageDealt -= GameState.eDefenseBuff;
                }
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
            if (Rand.nextInt(GameState.enemyCriticalChance) == 0 && (GameState.enemyCriticalChance != -1)) {
                
                enemyCritical = true;

            }
            // Enemy standard hit
            else {

                enemyCritical = false;

                GameState.pBuffPhase = 2;
    
            }

            // Calculate outcomes
            // Player defense; Enemy critical hit
            if (enemyCritical == true) {

                /// PLAYER DAMAGED
                GameState.eDamageDealt = (GameState.enemyAttackAvg + (Rand.nextInt(11) - 5) + GameState.eCritical);
                if (GameState.pBuffPhase == 1) {
                    GameState.eDamageDealt -= GameState.pDefenseBuff;
                }
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
            if (GameState.enemyHealth >= GameState.enemyMaxHealth) {

                GameState.eHealedToMax = true;
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
        if (GameState.playerHealth >= GameState.playerMaxHealth) {

            GameState.pHealedToMax = true;
            GameState.playerHealth = GameState.playerMaxHealth;

        }

        // No need for Stunned enemy case
        // Enemy attack
        if ((enemyAction >= 0 && enemyAction <= 4)) {
                
            // Enemy critical hit
            if (Rand.nextInt(GameState.enemyCriticalChance) == 0 && (GameState.enemyCriticalChance != -1)) {
                
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
                GameState.eDamageDealt = (GameState.enemyAttackAvg + (Rand.nextInt(11) - 5) + GameState.eCritical);
                if (GameState.pBuffPhase == 1) {
                    GameState.eDamageDealt -= GameState.pDefenseBuff;
                }
                GameState.playerHealth -= GameState.eDamageDealt;

            }
            // Player heal; Enemy standard hit
            else {

                // PLAYER DAMAGED
                GameState.eDamageDealt = (GameState.enemyAttackAvg + (Rand.nextInt(11) - 5));
                if (GameState.pBuffPhase == 1) {
                    GameState.eDamageDealt -= GameState.pDefenseBuff;
                }
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
            if (GameState.enemyHealth >= GameState.enemyMaxHealth) {

                GameState.eHealedToMax = true;
                GameState.enemyHealth = GameState.enemyMaxHealth;

            }

        }

    }

}