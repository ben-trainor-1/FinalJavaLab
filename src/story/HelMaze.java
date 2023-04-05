package story;
import java.util.ArrayList;
import java.util.Scanner;
import graphics.Colors;

public class HelMaze {
    public static String[][] maze = {
        //Key: L = left, R = right, U = up, D = down, B = bossfight(exit)
        //     E = enemy, 1 = riddle #1, 2 = riddle #2, 3 = riddle #3
        {"DR","LDR","LR","L7","R8","LDR","LD"},
        {"U6","RDU","LRD","LR","LR","LUD","H"},
        {"R","LDU","RU","LR","L3","DE4","D5"},
        {"D2E","UR","LDR","LR","LDR","LUR","DLU"},
        {"DUR","LD","U","D1","U","D","LDU"},
        {"UR","ULR","LR","ULR","LR","ULR","UL"},
    };

    public static void main(String[] args) {

        // Set current position
        int[] currentPosition = {5,3};
        // Display position
        System.out.println("[" + currentPosition[0] + ", " + currentPosition[1] + "]" );

        while (currentPosition[0] != -1 && currentPosition[1] != -1) {
            // Print out the map
            printMap(maze, currentPosition);
            // Update position with movement method
            currentPosition =  movement(currentPosition[0], currentPosition[1]);
            // Display position
            System.out.println("[" + currentPosition[0] + ", " + currentPosition[1] + "]" );
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
    public static int[] movement(int row, int col) {

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
            System.out.println(Colors.RED_BOLD + "Uh-oh! A mysterious figure stands menacingly" + Colors.ANSI_RESET);
            //TODO: Add an enemy encounter
        }

        //Check for Riddles
        if(mazeInfo.contains("1")){
            System.out.println(Colors.PURPLE_BOLD_BRIGHT + "A faint sound bonetrousles you." + Colors.ANSI_RESET);
            
        }
        if(mazeInfo.contains("2")){
            System.out.println(Colors.PURPLE_BOLD_BRIGHT + "You find a discarded sign that says,\n\"Abandon all hope, those who enter\"\n" + Colors.ANSI_RESET);
            
        }
        if(mazeInfo.contains("3")){
            System.out.println(Colors.PURPLE_BOLD_BRIGHT + "You see a cake! But it is a lie :(" + Colors.ANSI_RESET);
        }
        if(mazeInfo.contains("4")){
            System.out.println(Colors.PURPLE_BOLD_BRIGHT + "You come upon a mosaic depiction a small girl and a large man with a hook on a ship together.\nIt seems out of place" + Colors.ANSI_RESET);
        }
        if(mazeInfo.contains("5")){
            System.out.println(Colors.PURPLE_BOLD_BRIGHT + "Nicco wuz here" + Colors.ANSI_RESET);
        }
        if(mazeInfo.contains("6")){
            System.out.println(Colors.PURPLE_BOLD_BRIGHT + "You come upon upon a raving madman. He looks straight at you and says,\n" + Colors.ANSI_RESET
                                + Colors.RED_BOLD + "\"You know, I was there for that whole sordid affair. Marvelous times! Butterflies, blood, a Fox and severed head... Oh, and the cheese! To die for.\"\n" + Colors.ANSI_RESET
                                + Colors.PURPLE_BOLD_BRIGHT + "You back away slowly..." + Colors.ANSI_RESET);
        }
        if(mazeInfo.contains("7")){
            System.out.println(Colors.PURPLE_BOLD_BRIGHT + "You find a boring and plain dead end." + Colors.ANSI_RESET);
        }
        if(mazeInfo.contains("8")){
            System.out.println(Colors.PURPLE_BOLD_BRIGHT + "Hi there! this is a message from the lovely devs! We sincerely hope you are doing well!" + Colors.ANSI_RESET);
        }

        //Check for Bossfight
        if(mazeInfo.contains("H")){
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

    public static void printMap(String[][] mazeInstance, int[] playerLocation) {
        
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

        }
    } 
}
