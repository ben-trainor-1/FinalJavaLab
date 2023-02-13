package story;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import graphics.Graphics;
import graphics.Colors;
import story.Gorm;
import story.Gro;




public class Story {

    public static void main(String[] args) throws Exception {

        ////NOTE: Storing character data is yet to be implemented!
        //String [] info = {" "," "," "," "," "," "};
            //Intro:
        
            
        //Fancy Welcome
        Graphics.text(Colors.ANSI_BLUE +  "temp studio name" + Colors.ANSI_RESET + " presents temp game name" + "\n" + "please choose a character..." 
                        + "\n" + Colors.ANSI_YELLOW + "Enter 1 to choose Gorm (male) or 2 to choose Gro (Female)" + Colors.ANSI_RESET);

        //Choose Character

        //remember character
        //ArrayList<String> gormOrGroArray = new ArrayList<>();
        
        //Call scanner
        //Use integers
        Scanner in = new Scanner(System.in);
        int input;
        input = in.nextInt();

        if(input == 1){

            //NOTE: Storing character data is yet to be implemented!
            // info[0] = Gorm.name;
            // info[1] = Gorm.pNoun;
            // info[2] = Gorm.objectPNoun;

            //Choosing Gorm
            Graphics.text("You have chosen Gorm! Gorm is a muscular bald man with one long red braid");
            

        }
        else if(input == 2){

            //NOTE: Storing character data is yet to be implemented!
            // info[0] = Gro.name;
            // info[1] = Gro.pNoun;
            // info[2] = Gro.objectPNoun;
            
            //Choosing Gro 
            Graphics.text("You have chosen Gro! Gro is a graceful woman with Blonde braids and one bald spot");
            //gormOrGroArray.add("Gro");
        }
        else{
            //input error
            Graphics.text("Please choose Gorm or Gro");
        }


        //Choose Weapon 

        //prompt user
        Graphics.text(Colors.ANSI_YELLOW + "Enter 1 for a greatspear or 2 for a battleaxe" + Colors.ANSI_RESET);

        //Reset input
        input = 0;
        input = in.nextInt();

        if(input == 1){
            //Choosing Greatspear
            Graphics.text("You  have chosen spear");
        }
        else if(input == 2){
            //Choosing Battleaxe
            Graphics.text("You have chosen axe");
        }
        else{
            //input error
            Graphics.text("Please choose spear or axe");
        }

        //Setting 
        Graphics.text(Colors.ANSI_PURPLE + "Your story starts in the misty mountains of Iceland in a town called Asbjorn \n" + 
                        "It is a small town sparsely populated. While the inhabitants are kind an welcoming, You are a warrior who wishes to fight." + Colors.ANSI_RESET);
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
            //You can do an "Theseus and the Minotaur" kinda thing
            //Few suprise battles; (avoidable but mandatory if you find them)
            //At the end: Gullinkambi: the Golden Comb (boss fight)
                //After the fight: Loki mocks you again
                //Weapon upgrade!
            //
        //Flyting: A poetic constest of insults
            //Allusions to this thru out game. remember old insults and what peeps are sensitive to.
            //Winning allowd good ending
    }
    
    
}
