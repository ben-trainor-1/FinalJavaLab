package story;

import java.util.Scanner;
import java.io.File;
import java.nio.file.attribute.GroupPrincipal;
import java.util.ArrayList;
import graphics.Graphics;
import graphics.Colors;
import story.Gorm;
import story.Gro;




public class Story {

    public static void failedInput(){
        System.out.println(Colors.ANSI_RED + "Please input a better number." + Colors.ANSI_RESET);
    }

    public static void main(String[] args) throws Exception {

        ////NOTE: Storing character data is yet to be implemented!
        //String [] info = {" "," "," "," "," "," "};
            //Intro:
            Graphics.text(Colors.ANSI_BLUE +  "temp studio name" + Colors.ANSI_RESET + " presents temp game name" + "\n" + "please choose a character...");
        
            Scanner in = new Scanner(System.in);
            
            //Call scanner
            //Use integers
            int input;
            
            do{
            //Fancy Welcome
            Graphics.text(Colors.ANSI_YELLOW + "Enter 1 to choose Gorm (male) or 2 to choose Gro (Female)" + Colors.ANSI_RESET);
            
            //remember character- unimplemented
            //ArrayList<String> gormOrGroArray = new ArrayList<>();
            
            //Choose character
            input = in.nextInt();
            if(input == 1){
                
                //NOTE: Storing character data is yet to be implemented!
                // info[0] = Gorm.name;
                // info[1] = Gorm.pNoun;
                // info[2] = Gorm.objectPNoun;
                
                //Choosing Gorm
                Graphics.text("You have chosen Gorm! Gorm is a muscular bald man with one long red braid");
                break;
                
                
            }
            else if(input == 2){
                
                //NOTE: Storing character data is yet to be implemented!
                // info[0] = Gro.name;
                // info[1] = Gro.pNoun;
                // info[2] = Gro.objectPNoun;
                
                //Choosing Gro 
                Graphics.text("You have chosen Gro! Gro is a graceful woman with Blonde braids and one bald spot");
                break;
            }
            else{
                //input error
                failedInput();
            }
        }while(true);
        
        //Choose Weapon 
        do{
            
            //prompt user
            Graphics.text(Colors.ANSI_YELLOW + "Enter 1 for a greatspear or 2 for a battleaxe" + Colors.ANSI_RESET);
            input = in.nextInt();

            if(input == 1){
                //Choosing Greatspear
                Graphics.text("You  have chosen spear");
                break;
            }
            else if(input == 2){
                //Choosing Battleaxe
                Graphics.text("You have chosen axe");
                break;
            }
            else{
                //input error
                failedInput();
            }
        }while(true);

        //Setting 
        Graphics.text(Colors.ANSI_PURPLE + "Your story starts in the misty mountains of Iceland in a town called Asbjorn \n" + 
                        "It is a small town sparsely populated. While the inhabitants are kind and welcoming, you are a warrior who wishes to fight.\n" +
                        "Lucky for you, a cave leading straight to Hel is nearby, and since your chances of fighting in Ragnarok are slim, this is your best shot for action.\n" +
                        Colors.ANSI_YELLOW + "You can 1) leave the village now, or 2) stay a give a brief goodbye to your acquaintences"
                        + Colors.ANSI_RESET);
        
        //Option for leaving or staying
        input = in.nextInt();
            if(input == 1){
                Graphics.text("You have chosen to leave the village straightaway. It will be easier this for them this way.");
            }
            else if(input == 2){
                Graphics.text("You decided to stay and say goodbye.");
            }
            else{
                Graphics.text("Please inout a valid option");
            }

        //Leave Village; go to cave
        //First fight(required): Dire wolf
        //Enter cave, but run into dead end. Odin comes, scorns you, but then feels guilty and moves boulder allowing you to move on.
        //Choice: left of right
            //left: Loki room
            //right: locked door
        //Meet with Loki. He thanks you for freeing him, then taunts you. He figures out your plans and laughs at them
            //Many dialouge choices, but they all end in embaressment 
        //Fight undead skeleton for key
            //another optional US for ???
        //Head back to right 
        //Some sort of stronghold...
        //Maze:
            //Riddles to help you thru (perhaps some allude to the good ending)
            //You can do a "Theseus and the Minotaur" kinda thing
            //Few suprise battles; (avoidable but mandatory if you find them)
            //At the end: Gullinkambi: the Golden Comb (boss fight)
                //After the fight: Loki mocks you again
                //Weapon upgrade!
            //Discover large cavern
        //Abyss
            //The only way is an elevator, but it is broken
            //Go to path on right
                //Easier enemy (required)
                //One room contains a blacksmith puzzle 
                //You find a spare gear lying around
            //or return to village
                //On your way out you notice a hidden crevice - it contains Weapon upgrade  
                //Chance to fight hard enemy
                //Blacksmith gives a gear
            //Epic art as descend in the elevator 
            //At the bottom is the gates of Hel
                //The Fenris Wolf (Boss fight) guards it
                    //weapon upgrade!
                    //defeat the wolf but don't kill it
                    //Get absolutely mocked by Loki again
        //Greater Hel Area
            //Outside the gates: Nothing of note, but a trickling stream of dirty water
            //Eastern Hel: Docks
                //Naglfar, the ship made of fingernails and toenails resides here.
                    //Loki fight is on this ship
                    //Must find way on ship
            //Western Hel: Tavern 
                //Lots of dead people drinking here
                //Flyting happens here
                    //Flyting: A poetic constest of insults
                        //Allusions to this thru out game. remember old insults and what peeps are sensitive to.
                        //Winning allowd good ending
                //find rumors about ship
            //Southern Hel: Gates to Hel; 
                //Entrance
            //Northern Hel: Hela's palace
                //permission from Hel to get on ship 
                //Must find/fight way into palace
        //bIG BOTE
            //Loki bossfight
                //If you win Loki runs away
                //If you lose, you get thrown into water (die)
                //If you win against loki and in the flyting, then Loki drops weapon, which you then use in Ragnorak


    }
}