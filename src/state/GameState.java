package state;

public class GameState {

    // Player stats
    public static String name = "Gorm";
    public static String pNoun = "";
    public static String objpNoun = "";
    public static String weapon = "";
    public static int level = 1;
    public static int playerHealth = 100;
    public static int playerAttack = 15;
    public static int playerHealCount = 2;
    public static int playerHealAmount;
    public static int playerCriticalChance = 4;

    // Enemy stats
    public static String enemy = "";
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
    public static boolean firstNorth = true;
    public static boolean firstEast = true;
    public static boolean firstWest = true;
    public static boolean winFlyting = false;
    public static boolean helPermission = false;
    
}
