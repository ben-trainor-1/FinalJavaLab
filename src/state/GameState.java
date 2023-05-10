package state;

public class GameState {

    // Player stats
    public static String nicco = "Nicco";
    public static String name = "Gorm";
    public static String pNoun = "He";
    public static String objpNoun = "Him";
    public static String posNoun = "His";
    public static String genderNoun = "Lad";
    public static String newName = "";
    public static String lostLove = "";
    public static String weapon = "";
    public static int playerHealth;
    public static int playerMaxHealth = 15000;
    public static int playerAttack = 10000;
    public static int pDefenseBuff = 100;
    public static int pBuffPhase = 0;
    public static int playerHealCount = 10;
    public static int playerHealAmount = 400;
    public static int playerCriticalChance = 10;
    public static int pCritical = 3000;

    // Enemy stats
    public static String enemy = "";
    public static int enemyMaxHealth;
    public static int enemyHealth = 0;
    public static int enemyAttackAvg = 0;
    public static int attackChance = 0;
    public static int defenseChance = 0;
    public static int eDefenseBuff = 5;
    public static int eBuffPhase = 0;
    public static int healChance = 0;
    public static int enemyHealCount = 1;
    public static int enemyHealAmount;
    public static int enemyCriticalChance;
    public static int eCritical;
    public static boolean reginald = false;


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
    public static boolean pHealedToMax = false;
    public static int eDamageDealt;
    public static int eHealthGained;
    public static boolean eHealedToMax = false;

}
