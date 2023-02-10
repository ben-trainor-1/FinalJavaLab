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
    }
    
    
}
