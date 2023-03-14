import java.util.ArrayList;
import java.util.Scanner;

public class MazeProto {

    public static String[][] maze = {
        {"DE","UDB","RP","LD","DP"},
        {"UR","ULRD","LRD","LRD","URD"},
        {"DPE","UR","ULRD","UL","UD"},
        {"UR","LR","URL","LR","LU"},
    };

    public static void main(String[] args) {

        // Set current position
        int[] currentPosition = {3,2};
        // Display position
        System.out.println("[" + currentPosition[0] + ", " + currentPosition[1] + "]" );

        while (true) {
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
