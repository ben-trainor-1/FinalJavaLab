package state;

public class GameState {

    // Player stats
    public static String name = "Gro";
    public static String pNoun = "";
    public static String objpNoun = "";
    public static String posNoun = "";
    public static String genderNoun = "";
    public static String newName = "";
    public static String lostLove = "";
    public static String weapon = "";
    public static int playerHealth;
    public static int playerMaxHealth = 100;
    public static int playerAttack = 15;
    public static int playerHealCount = 2;
    public static int playerHealAmount = 30;
    public static int playerCriticalChance = 3;

    // Enemy stats
    public static String enemy = "";
    public static int enemyMaxHealth;
    public static int enemyHealth = 0;
    public static int enemyAttackAvg = 0;
    public static int attackChance = 0;
    public static int defenseChance = 0;
    public static int healChance = 0;
    public static int enemyHealCount = 1;
    public static int enemyHealAmount;
    public static int enemyCriticalChance;


    //Booleans for checking
    public static boolean key = false;
    public static int firstSouth = 0;
    public static boolean firstNorth = false;
    public static boolean firstEast = true;
    public static boolean firstWest = false;
    public static boolean winFlyting = false;
    public static boolean helPermission = false;
    public static boolean firstLeft = false;
        

    // Display stats
    public static int pDamageDealt;
    public static int pHealthGained;
    public static int eDamageDealt;
    public static int eHealthGained;
    
}
