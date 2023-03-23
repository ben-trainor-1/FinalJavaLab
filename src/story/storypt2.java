package story;

import java.util.Scanner;
import graphics.Colors;
import graphics.Graphics;
import java.util.ArrayList;

public class storypt2 {
    public static void main(String[] args) throws Exception {

    


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
    //The Fenrir Wolf (Boss fight) guards it
   //weapon upgrade!
  //defeat the wolf but don't kill it
 //Get absolutely mocked by Loki again

//Option to go on the right path or return to villiage (fight)
        do { 
            Scanner in = new Scanner (System.in);
            int input;
            Graphics.text(Colors.ANSI_YELLOW +"You can 1) go to the path on your right, or 2) return to the village" + Colors.ANSI_RESET);
            input = in.nextInt();

                if(input == 1){ 
                    Graphics.text(Colors.ANSI_YELLOW + "You have chosen to to take the path on the right." 
                    + " Suddenly, an angry dwarf comes out of the shadows\n"
                    + "He jumps you immediately and while you think he doesn't have a lot of strenghth, he continues to suprise you.\n" 
                    + "After a rather long battle, you defeat the little, yet mighty dwarf and walk towards the room on your left\n"
                    + "When you enter, your eyes immediately fall onto the blacksmith puzzle\n" + "It reminds you of your friend, Viggo and while exploring the rest of the room, you discover a spare gear lying around.\n "
                     + Colors.ANSI_RESET);
                    break;
                }
                if (input == 2) {
                    Graphics.text(Colors.ANSI_YELLOW + "You have decided to return to the village\n" + Colors.ANSI_YELLOW + 
                    "You remember your friend, Viggo the blacksmith. He would probably help you fix the elevator so you can get to the bottom of Hel!\n" 
                    + "On your way out, you notice something shining from a hidden crevice.\n"
                   + "You walk towards it and find that it's a weapon upgrade. Score! It can help you fight bigger battles!\n"
                    + "Suddenly, out of nowhere, a berserker charges at you in fury. You fight him until he is no more.\n"
                   + "After the long battle, you defeat him and go on your way. The show/journey must go on!");
                    Graphics.waitForEnter();
                    Graphics.textInline("When you are finally in Asbjorn, you find Viggo working.\n"
                   + Colors.ANSI_GREEN + "\"Can you come help me fix the elevator? I need the elevator fixed so I can get to the bottom of Hel and finish my journey\"\n");
                     Graphics.waitForEnter();
                   Graphics.textInline(Colors.ANSI_YELLOW + "Viggo agrees but tells you he doesn't want to fight at all. And then, he gives you a gear that looks helpful.\n"
                   // + "After this, both of you start your journey back to the elevator"
                    +  Colors.ANSI_RESET);
                    break;

                }
            } while(true);

    //descending at the bottom of Hel and fight with wolf (Fenrir)
            Graphics.textInline(Colors.ANSI_PURPLE + "After Viggo fixes the elevator, you finally descend to the bottom of Hel.\n"
                     + "You soon discover that Fenrir the wolf is gurading the gate. You must defeat him.\n" 
                     + "Without throwing caution to the wind, you approach him slowly. But Fenrir doesn't hesitate to rush at you.\n"
                     + "You and Fenrir fight hard and the battle gets a bit bloody. You get a weapon upgrade!\n"
                     + "You finally defeat Fenrir, but you don't kill him. Fewer the casualties the better, right?\n");
            
    //Loki's mocking 
           Graphics.textInline(Colors.ANSI_PURPLE + "After standing there for a few moments, you hear sarcastic clapping and a small chuckle.\n"
                    + "You spin around quickly and try and find where that sound is coming from. Suddenly Loki appears out of the shadows.\n"
                    + Colors.ANSI_RESET
                    + Colors.BLACK_BRIGHT + "\"Well done. You managed to fight without killing. How kind of you.\"\n" 
                    + Colors.ANSI_RESET
                    + Colors.ANSI_GREEN + "\"Loki? You were here the whole time? How did I not see you? Why are you here?\"\n"
                    + Colors.ANSI_RESET
                    + Colors.BLACK_BRIGHT + "\"So many questions but so little time. All you need to know, young lad, is that you really need to work on your fighting skills.\"\n"
                    + Colors.ANSI_RESET); 

         
    
   
    //Greater Hel Area
        do { 
            Scanner in = new Scanner (System.in);
            int input;
            Graphics.text(Colors.ANSI_YELLOW + "You can either go to 1) Eastern region (docks), 2) Western region (tavern) where there is a flyting\n" 
                                            + "3) Southern region (gates of Hel), or 4) Northern region where you can find Hela's palace.\n");
            input = in.nextInt();
        //Outside the gates: Nothing of note, but a trickling stream of dirty water
                
            Graphics.textInline(Colors.ANSI_PURPLE + " After your fun little banter with Loki, you walk to the entrance of the gates.\n"
                                + "There is nothing but a dirty stream but you're excited to find out what lies beyonf the gates.\n"
                                + "You push them open and discover the bottom of Hel was so much more than what you expected.\n" );
     //Eastern Hel: Docks
             //Naglfar, the ship made of fingernails and toenails resides here.
             //Loki fight is on this ship
             //Must find way on ship 

             if(input == 1){    
            Graphics.textInline(Colors.ANSI_PURPLE + "In the eastern region of the bottom of Hel, you find Naglfar, the famous ship made of finger and toe nails.\n"
                                 + "Loki had told you before you left that this is the ship that you must fight him on.\n"
                                 + "The only problem is that trying to get aboard is harder than expected and you have to travel to the Northern region to Hela's palace and get permission.\n");
                                break;
             }
                                
                

                
    //Western Hel: Tavern 
            if (input == 2) {
            //Lots of dead people drinking here
             //Flyting happens here
              //Flyting: A poetic constest of insults
             //Allusions to this thru out game. remember old insults and what peeps are sensitive to.
            //Winning allows good ending
            //find rumors about ship
    }
    //Southern Hel: Gates to Hel; 
            if (input == 3) {
            //Entrance
            Graphics.textInline(Colors.ANSI_PURPLE + "You travel to the Southern region of Hel but there is nothing particularly exciting here so you head to the North region.\n");
            break;
            } 
                
    //Northern Hel: Hela's palace
           if (input == 4) {
            //permission from Hel to get on ship 
            //Must find/fight way into palace
            Graphics.textInline(Colors.ANSI_PURPLE + "After travelling around for a bit, you walk to the Northern part of Hel.\n"
                                + "You must fight or find your way into the palace. Once you are in the palace, you must get permission to come aboard Naglfar.\n" );
                                break;
           }                      
        } while(true);
    }
}
    

