package graphics;
import java.io.File;
import java.util.Scanner;

import state.GameState;

import java.io.Console;

public class Graphics {

    // Text speed variable

    public static int textSpeed = 50;

    // Space method
    public static void space(int numOfSpaces) {
        for (int i = 0; i < numOfSpaces; i++) {
            System.out.println();
        }
    }

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

    // Display main character
    public static void displayGormGro() throws Exception {

        String filePath = "./src/graphics/Characters/" + GameState.name + ".txt";
        File characterFile = new File(filePath);
        Scanner characterScanner = new Scanner(characterFile);
        String currentLine;

        // Print name
        text(Colors.GREEN_BACKGROUND + characterScanner.nextLine() + Colors.ANSI_RESET);

        // Print attack
        currentLine = characterScanner.nextLine();
        textInline(currentLine);
        text(Colors.RED_BOLD + GameState.playerAttack + Colors.ANSI_RESET);

        // Print health
        currentLine = characterScanner.nextLine();
        textInline(currentLine);
        text(Colors.GREEN_BOLD + GameState.playerHealth + Colors.ANSI_RESET);

        // Print sprite
        while (characterScanner.hasNext()) {
            System.out.println(characterScanner.nextLine());
            Thread.sleep(textSpeed);
        }

    }

    // Display enemies
    public static void displayEnemy(String enemyName) throws Exception {
         
        String filePath = "./src/graphics/Characters/Enemies/" + enemyName + ".txt";
        File enemyFile = new File(filePath);
        Scanner enemyScanner = new Scanner(enemyFile);
        String currentLine;

        // Print name
        text(Colors.RED_BACKGROUND + enemyScanner.nextLine() + Colors.ANSI_RESET);

        // Print attack
        currentLine = enemyScanner.nextLine();
        textInline(currentLine.substring(0, 8));
        text(Colors.RED_BOLD + GameState.enemyAttackAvg + Colors.ANSI_RESET);

        // Print health
        currentLine = enemyScanner.nextLine();
        textInline(currentLine.substring(0, 8));
        text(Colors.GREEN_BOLD + GameState.enemyHealth + Colors.ANSI_RESET);

        // Print sprite
        while (enemyScanner.hasNext()) {
            System.out.println(enemyScanner.nextLine());
            Thread.sleep(textSpeed);
        }

    }
    
    // Method for printing out background

    public static void displayBackground(String backgroundName, String color) throws Exception {
         
        String filePath = "./src/graphics/Background/" + backgroundName + ".txt";
        File backgroundFile = new File(filePath);
        Scanner backgroundScanner = new Scanner(backgroundFile);

        
        // Background name
        text(backgroundScanner.nextLine());
        System.out.print(color);
    
        // Background sprite
        while (backgroundScanner.hasNext()) {
            System.out.println(backgroundScanner.nextLine());
            Thread.sleep(textSpeed);
        }

        System.out.println(Colors.ANSI_RESET);

        
    
    }
    
    // Method for printing out death

    public static void displayDeath(String deathName, String color) throws Exception {
         
        String filePath = "./src/graphics/Death/" + deathName + ".txt";
        File deathFile = new File(filePath);
        Scanner deathScanner = new Scanner(deathFile);
    
        // Death name
        text(deathScanner.nextLine());
        System.out.print(color);
    
    
        // Death sprite
        while (deathScanner.hasNext()) {
            System.out.println(deathScanner.nextLine());
            Thread.sleep(textSpeed);
        }

        System.out.println(Colors.ANSI_RESET);
    }

    // Method for printing out weapons

    public static void displayWeapons(String weaponsName, String color) throws Exception {
         
        String filePath = "./src/graphics/Weapons/" + weaponsName + ".txt";
        File weaponsFile = new File(filePath);
        Scanner weaponsScanner = new Scanner(weaponsFile);
        
        // Weapons name
        text(weaponsScanner.nextLine());
        System.out.print(color);
        
        
        // Weapons sprite
        while (weaponsScanner.hasNext()) {
            System.out.println(weaponsScanner.nextLine());
            Thread.sleep(textSpeed);

        }

        System.out.println(Colors.ANSI_RESET);
    }

    // Method for printing out win

    public static void displayWin(String winName, String color) throws Exception {
         
        String filePath = "./src/graphics/Win/" + winName + ".txt";
        File winFile = new File(filePath);
        Scanner winScanner = new Scanner(winFile);
            
        // Win name
        text(winScanner.nextLine());
        System.out.print(color);
            
            
        // Win sprite
        while (winScanner.hasNext()) {
            System.out.println(winScanner.nextLine());
            Thread.sleep(textSpeed);
    
        }

        System.out.println(Colors.ANSI_RESET);
    }

    // Method for printing out healing
    public static void displayHealing(String healingName, String color) throws Exception {

        String filePath = "./src/graphics/Healing/" + healingName + ".txt";
        File healingFile = new File(filePath);
        Scanner healingScanner = new Scanner(healingFile);

        // Healing name
        text(healingScanner.nextLine());
        System.out.print(color);

        // Healing sprite
        while (healingScanner.hasNext()) {
            System.out.println(healingScanner.nextLine());
            Thread.sleep(textSpeed);
            
        }

        System.out.println(Colors.ANSI_RESET);
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

