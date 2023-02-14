package story;
import java.io.File;
import java.util.Scanner;

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
         
        String filePath = "./src/graphics/" + characterName + ".txt";
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
    
}
