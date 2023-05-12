package story;

import java.util.ArrayList;
import java.util.Scanner;
import combat.FullCombat;
import graphics.*;
import audio.*;
import javax.sound.sampled.Clip;

public class RoosterMaze {

    public static String[][] maze = {
        //Key: L = left, R = right, U = up, D = down, B = bossfight(exit)
        //     E = enemy, 1 = riddle #1, 2 = riddle #2, 3 = riddle #3
        {"DE","DB","R1","LD","D2"},
        {"UR","ULRD","LRD","LRDU","ULD"},
        {"D3E","UR","ULRD","UL","UD"},
        {"UR","LR","URL","LR","LU"},
    };

    public static void main(String[] args) throws Exception  {

        Graphics.textSpeed = 15;
        
        // Start music
        Player play = new Player();
        Clip mazeMusic = play.playAudio("./src/audio/music/ambient_beat_loop.wav", -1, 0.0F, 0);
        
        // Set current position
        int[] currentPosition = {3,2};
        // Display position
        System.out.println("[" + currentPosition[0] + ", " + currentPosition[1] + "]" );

        while (currentPosition[0] != -1 && currentPosition[1] != -1) {
            // Print out the map
            printMap(maze, currentPosition);
            // Update position with movement method
            currentPosition =  movement(currentPosition[0], currentPosition[1], mazeMusic);
            // Display position
            if (!(currentPosition[0] == -1)) System.out.println("[" + currentPosition[0] + ", " + currentPosition[1] + "]" );
            
        }


    }

    /**
     * Movement method for traversing a maze. Takes in two integers for the
     * current position of the player. Prevents illegal moves. Accepted inputs:
     * {@code LEFT, L, RIGHT, R, UP, U, DOWN, D } 
     * @param row
     * @param col
     * @return mazePosition
     */
    public static int[] movement(int row, int col, Clip clip) throws Exception {

        int[] exitMaze = {-1,-1};
        String mazeInfo = maze[row][col]; // Keep track of movement options and item info in cell
        int[] mazePosition = {row, col}; // Keep track of position to return later
        ArrayList<String> movementOptions = new ArrayList<String>();

        // Store movement options
        if (mazeInfo.contains("L")) {
            movementOptions.add("LEFT");
            movementOptions.add("L");
        }
        if (mazeInfo.contains("R")) {
            movementOptions.add("RIGHT");
            movementOptions.add("R");
        }
        if (mazeInfo.contains("U")) {
            movementOptions.add("UP");
            movementOptions.add("U");
        }
        if (mazeInfo.contains("D")) {
            movementOptions.add("DOWN");
            movementOptions.add("D");
        }

        //Check for Enemies
        if(mazeInfo.contains("E")){
            Player.fadeOutAudio(clip, 1500);
            Graphics.text(Colors.RED_BOLD + "Uh-oh! A mysterious figure stands menacingly" + Colors.ANSI_RESET);
            Thread.sleep(50);
            
            FullCombat.enemyGameState("Skeleton2",85,15,5,10,4,7,5,4,1,20);
            FullCombat.fight();
            Player.fadeInAudio(clip, 1500, -1, 0.0F);
        }

        //Check for Riddles
        if(mazeInfo.contains("1")){
            Graphics.text(Colors.ANSI_PURPLE + "You approach a dead end.\nThere is writing on the wall\n" + Colors.ANSI_RESET
                                + Colors.ANSI_RED + "Some play with us, most confuse us.\nWe are not approaching,\nNor do we mean as well.\nWhat are we?" + Colors.ANSI_RESET);  
        }
        if(mazeInfo.contains("2")){
            Graphics.text(Colors.ANSI_PURPLE + "You approach a dead end.\nThere is writing on the wall\n" + Colors.ANSI_RESET
                                + Colors.ANSI_RED + "Though many try, you can't bring me down. What am I?" + Colors.ANSI_RESET);
            
        }
        if(mazeInfo.contains("3")){
            Graphics.text("You approach a dead end.\nThere is writing on the wall\n" + Colors.ANSI_RESET
                                + Colors.BLACK_BOLD_BRIGHT + "A Flyting is a poem\nof insults cut like a gem\nBeware of the tongue\nlest you get stung\nLest you get carried away.\n"
                                + Colors.ANSI_PURPLE + "Below is the single word, " + Colors.RED_BOLD_BRIGHT + "\"Cur\"" + Colors.ANSI_PURPLE + "." + Colors.ANSI_RESET);
        }

        //Check for Bossfight
        if(mazeInfo.contains("B")){
            Player.fadeOutAudio(clip, 2000);
            // FullCombat.enemyGameState("Gullinkambi",100,15,5,20,0,10,10,6,2,30);
            // FullCombat.fight();
            return exitMaze;
        }

        // Print movement options
        System.out.println("Movement options: " + movementOptions.toString());

        // Scanner and user movement choice
        Scanner in = new Scanner(System.in);
        String movementChoice;
        System.out.println("Where would you like to go?");

        // Prevent illegal moves
        do {
            movementChoice = in.nextLine().toUpperCase();
            if (movementOptions.contains(movementChoice)) {
                break;
            }
            else {
                System.out.println("Please enter a valid direction.");
            }
        } while (true);

        // Update position
        if (movementChoice.equals("L") || movementChoice.equals("LEFT")) {
            mazePosition[1] -= 1;
        }
        else if (movementChoice.equals("R") || movementChoice.equals("RIGHT")) {
            mazePosition[1] += 1;
        }
        else if (movementChoice.equals("U") || movementChoice.equals("UP")) {
            mazePosition[0] -= 1;
        }
        else if (movementChoice.equals("D") || movementChoice.equals("DOWN")) {
            mazePosition[0] += 1;
        }
        return mazePosition;

    }

    public static void printMap(String[][] mazeInstance, int[] playerLocation) throws Exception {
        
        for (int i = 0; i < mazeInstance.length; i++) {
            
            for (int j = 0; j < mazeInstance[0].length; j++) {

                System.out.print("| ");

                if (playerLocation[0] == i && playerLocation[1] == j) {
                    System.out.print("O");
                }
                else {
                    System.out.print(" ");
                }

                System.out.print(" ");

            }
            System.out.println("|");
            Thread.sleep(50);

        }
    } 
}
