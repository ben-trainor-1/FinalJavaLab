package graphics;
import java.io.File;
import java.util.Scanner;
import java.io.Console;

public class Graphics {

    // Text speed variable

    static int textSpeed = 50;

    // Method for printing text

    public static void text(String text) throws Exception {

        for (int i = 0; i < text.length(); i++) {

            System.out.print(text.charAt(i));
            Thread.sleep(textSpeed);

        }
        System.out.println();

    }

    public static void textInline(String text) throws Exception {

        for (int i = 0; i < text.length(); i++) {

            System.out.print(text.charAt(i));
            Thread.sleep(textSpeed);

        }

    }

    // Method for printing out enemies

    public static void displayCharacter(String characterName, int characterHealth) throws Exception {
         
        String filePath = "./src/graphics/Characters/" + characterName + ".txt";
        File characterFile = new File(filePath);
        Scanner characterScanner = new Scanner(characterFile);

        // Character name
        text(characterScanner.nextLine());

        // Stats
        textInline(characterScanner.nextLine());
        text(characterHealth + ";");

        // Character sprite
        while (characterScanner.hasNext()) {
            System.out.println(characterScanner.nextLine());
            Thread.sleep(textSpeed);
        }

    }

    // Method for printing out background

    public static void displayBackground(String backgroundName) throws Exception {
         
        String filePath = "./src/graphics/Background/" + backgroundName + ".txt";
        File backgroundFile = new File(filePath);
        Scanner backgroundScanner = new Scanner(backgroundFile);
    
        // Background name
        text(backgroundScanner.nextLine());
    
    
        // Background sprite
        while (backgroundScanner.hasNext()) {
            System.out.println(backgroundScanner.nextLine());
            Thread.sleep(textSpeed);
        }
    
    }
    
    // Method for printing out death

    public static void displayDeath(String deathName) throws Exception {
         
        String filePath = "./src/graphics/Death/" + deathName + ".txt";
        File deathFile = new File(filePath);
        Scanner deathScanner = new Scanner(deathFile);
    
        // Death name
        text(deathScanner.nextLine());
    
    
        // Death sprite
        while (deathScanner.hasNext()) {
            System.out.println(deathScanner.nextLine());
            Thread.sleep(textSpeed);
        }
    }

    // Method for printing out weapons

    public static void displayWeapons(String weaponsName) throws Exception {
         
        String filePath = "./src/graphics/Weapons/" + weaponsName + ".txt";
        File weaponsFile = new File(filePath);
        Scanner weaponsScanner = new Scanner(weaponsFile);
        
        // Weapons name
        text(weaponsScanner.nextLine());
        
        
        // Weapons sprite
        while (weaponsScanner.hasNext()) {
            System.out.println(weaponsScanner.nextLine());
            Thread.sleep(textSpeed);

        }
    }

    // Method for printing out win

    public static void displayWin(String winName) throws Exception {
         
        String filePath = "./src/graphics/Win/" + winName + ".txt";
        File winFile = new File(filePath);
        Scanner winScanner = new Scanner(winFile);
            
        // Win name
        text(winScanner.nextLine());
            
            
        // Win sprite
        while (winScanner.hasNext()) {
            System.out.println(winScanner.nextLine());
            Thread.sleep(textSpeed);
    
        }
    }

    // Wait for user to press enter

    public static void waitForEnter() {
        Console c = System.console();
        System.out.print(" \u2023");
        if (c != null) {
            c.readLine();
        }
    }

}

