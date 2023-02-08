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
            //Intro:
        
            
            //Fancy Welcome
            Graphics.text(Colors.ANSI_BLUE +  "temp studio name" + Colors.ANSI_RESET + " presents temp game name" + "\n" + "please choose a character..." 
                            + "\n" + Colors.ANSI_YELLOW + "Enter 1 to choose Gorm (male) or 2 to choose Gro (Female)" + Colors.ANSI_RESET);

            //Choose Character
            
            //Call scanner
            //Use integers
            Scanner in = new Scanner(System.in);
            int input;
            input = in.nextInt();

            if(input == 1){
                //Choosing Gorm
                Graphics.text("You have chosen " + Gorm.name);
            }
            else if(input == 2){
                //Choosing Gro 
                Graphics.text("You have chosen " + Gro.name);
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
        }
        
        
}
