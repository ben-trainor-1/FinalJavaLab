package graphics;
import java.io.File;
import java.util.Scanner;

public class Graphics {

    static int textSpeed = 50;

    public static void text(String text) throws Exception {

        for (int i = 0; i < text.length(); i++) {

            System.out.print(text.charAt(i));
            Thread.sleep(textSpeed);

        }
        System.out.println();

    }

    public static void textEnemy(String filePath) throws Exception{
        File enemyFile = new File(filePath);
        Scanner enemyScanner = new Scanner(enemyFile);

        text(enemyScanner.nextLine());
        text(enemyScanner.nextLine());

    }
    
}
