package story;

import java.util.Scanner;

import javax.swing.colorchooser.ColorSelectionModel;

import java.awt.Color;
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
            Graphics.displayBackground("Mountains");
            Graphics.textInline(Colors.ANSI_BLUE +  "temp studio name" + Colors.ANSI_RESET + " presents temp game name");
            Graphics.waitForEnter();
            Graphics.text("\n" + "please choose a character...");
            
            //Call scanner
            Scanner in = new Scanner(System.in); 
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
                Graphics.text("You  have chosen a greatspear");
                break;
            }
            else if(input == 2){
                //Choosing Battleaxe
                Graphics.text("You have chosen battleaxe");
                break;
            }
            else{
                //input error
                failedInput();
            }
        }while(true);

        //Setting 
        Graphics.textInline(Colors.ANSI_PURPLE + "Your story starts in the misty mountains of Iceland in a town called Asbjorn \n" + 
                            "It is a small town sparsely populated. While the inhabitants are kind and welcoming, you are a warrior who wishes to fight.\n");
        Graphics.waitForEnter();
        Graphics.textInline("Lucky for you, a cave leading straight to Hel is nearby, and since your chances of fighting in Ragnarok are slim, this is your best shot for action.\n" +
                            Colors.ANSI_YELLOW + "You can 1) leave the village now, or 2) stay a give a brief goodbye to your acquaintences"
                            + Colors.ANSI_RESET);
                       
        
        //Option for leaving or staying
        do{

            input = in.nextInt();
            if(input == 1){
                Graphics.text("You have chosen to leave the village straightaway. It will be easier this for them this way.");
                break;
            }
            else if(input == 2
            ){
                Graphics.displayCharacter("Viggo", 1);
                Graphics.text("You decided to stay and say goodbye.\n" + Colors.ANSI_PURPLE + "In Asbjorn you approach Viggo, the blacksmith. Once he was a great warrior like you, but he now he has settled down.\n He accepted his fate here...\n"
                                + Colors.ANSI_GREEN +  "\"Viggo, I'm leaving this town. I'm going to Hel. You can join me if you wish\"\n\"Alas, young (...) I do not display your energetic talent any more.\n I will stay here, accepting my banishment\"\n"
                                + "\"Well, I'll miss you then. You were the closest one of this lot to me.\"\n"
                                + "\"We understand that you have not lost your fervor for fighting like we have. We all wish you luck from the bottom of our hearts.\"\n"
                                + Colors.ANSI_PURPLE + "With that you leave the town filled with Thrill and anticipation for your upcoming battles.\n" + Colors.ANSI_RESET);
                break;
            }
            else{
                failedInput();
            }
        }while(true);

         //Leave Village; go to cave
        Graphics.waitForEnter();
        Graphics.displayBackground("Trees");
        Graphics.text(Colors.ANSI_PURPLE + "You walk down the path leading to the cave. Nothing eventful so far..." + Colors.ANSI_RESET);
        Thread.sleep(1000);
        Graphics.text(Colors.ANSI_PURPLE + "But wait..." + Colors.ANSI_RESET);
        Thread.sleep(1000);
        Graphics.text(Colors.ANSI_PURPLE + "There's something there! Behind that tree!" + Colors.ANSI_RESET);
        Thread.sleep(1000);
        Graphics.text(Colors.ANSI_PURPLE + "You are filled with determination as a dire wolf leaps, and blocks your path." + Colors.ANSI_RESET);
        

         //First fight(required): Dire wolf
        //Insert Battle with dire wolf here

        //Enter cave, but run into dead end. Odin comes, scorns you, but then feels guilty and moves boulder allowing you to move on.
        Graphics.textInline(Colors.ANSI_PURPLE + "After a rather bloody battle, you reach the mouth of the cave you seek.\n"
                        + "You have known of this cave for a while now, but you soon realize there is a dead end.\n"
                        + "You are overcome with confusion. Your sources are reliable how could they get this wrong?\n"
                        + "Then the answer comes to you as a figure steps out of the shadows.\n");
        Graphics.waitForEnter();
        Graphics.textInline(Colors.BLUE_BOLD_BRIGHT + "\"You should not have come here, World-Traitor.\"\n" + Colors.ANSI_RESET
                        + Colors.ANSI_GREEN + "\"That was not my fault. I was baited into it. You know this since you are soooooo great and wise, Odin\"\n"
                        + Colors.BLUE_BOLD_BRIGHT + "\"DO NOT SASS ME YOUNG [...]! YOU HAVE BROUGHT RUIN TO US ALL. you do not deserve to have fought even that dire wolf, worthless wretch...\"\n" + Colors.ANSI_RESET
                        + Colors.ANSI_PURPLE + "As quickly as it came, Odin's sudden outbust turns somber. Pain contorts his face\n"
                        + Colors.BLUE_BOLD_BRIGHT + "Well... none of us deserve to live anymore. That's why Ragnarok is here.\n I will remove this boulder here. Continue to Hel if you wish. If you can board Naglfar, you can fight in Ragnarok.\n" + Colors.ANSI_RESET);  

        do{
            //Choice of how to respond to the offer
            Graphics.textInline(Colors.ANSI_YELLOW + "What luck! A chance like this has never arisen before. How do you repsond?\n"
                            + "1) \"Thank you, father Odin, for this chance at glory.\"\n"
                            + "2) \"Haha! you suck. I'll do this only to prove that you are weak.\"" );  
            input =in.nextInt();

            //Odin's responses
            if(input == 1){
                Graphics.textInline(Colors.ANSI_PURPLE + "Odin looks solemnly at you, as if peering into your mind.\n"
                                + Colors.BLUE_BOLD_BRIGHT + "You have courage. I only hope it will stay with to the end." + Colors.ANSI_RESET); 
                break; 
            }
            else if(input == 2){
                Graphics.textInline(Colors.ANSI_PURPLE + "\"Odin flares in rage, judging you with his eye.\"\n"
                                + Colors.BLUE_BOLD_BRIGHT + "\"You have courage and wit. That will take you far\"" + Colors.ANSI_RESET); 
                break; 
            }
            else{
                failedInput();
            }
        }while(true);  
        
        //Odin leaves
        Graphics.textInline(Colors.ANSI_PURPLE + "With that Odin steps away, and the way foward reveals itself to you.");
        Graphics.waitForEnter();
        Thread.sleep(1000);

        //Choice: left of right
        Graphics.textInline(Colors.ANSI_PURPLE + "You walk through the cave. It is quiet and dark. You have a torch, though, so that helps.\n"
                        + Colors.ANSI_YELLOW + "You come upon an intersection. Which way do you choose?\n"
                        + "1) Left\n"
                        + "2) Right");
        input = in.nextInt();
            //left: Loki room
        if(input == 1){
            Graphics.textInline("You chose to the passage to the left");

            //Play cavern sounds

            //Begin encounter with Loki
            Graphics.waitForEnter();
            Graphics.textInline(Colors.ANSI_PURPLE + "The carvern is narrow and musty. Silence permeates through the air.\n"
                                    + "As you round a corner, however, you spot torchlight ahead." + Colors.ANSI_RESET); 
            Graphics.waitForEnter();
            Graphics.textInline(Colors.BLACK_BRIGHT + "A figure stands in a small room." + Colors.ANSI_RESET);   
            Graphics.displayCharacter("Loki", 500);  
            Graphics.waitForEnter(); 

            Graphics.textInline(Colors.BLACK_BACKGROUND + "\"Well, well, well, what do we have here?\n" + Colors.ANSI_RESET
                                + Colors.ANSI_PURPLE + "You stand speechless before the infamous god of deceit. Words with him are dangerous... He molds them as if they are clay.\n"
                                + Colors.BLACK_BACKGROUND + "I feel obliged to thank you. You have done so much for me! I must ask, how did Odin handle it? Was he mad?\"\n" + Colors.ANSI_RESET);
            Graphics.waitForEnter();
            
            //Options to respond to Loki
            Graphics.textInline(Colors.ANSI_YELLOW + "How do you respond?\n"
                                + "1) \"THERE AIN'T NO WAY I'M TELLING YOU BOY!\"\n"
                                + "2) \"Yeah, he was mad, but that doesn't matter. You tricked me.\"\n"
                                + "3) \"I hate you! You got me banished!\"\n"
                                + "4) (remain silent)\n");
            input = in.nextInt();
            //If player says something
            if(input == 1 || input == 2 || input == 3){
                Graphics.textInline(Colors.ANSI_PURPLE + "A thin smile dominates Loki's face.\n"
                                    + Colors.BLACK_BACKGROUND + "\"Don't be so dramatic! I won't stop you from... whatever it is you're doing.\n"
                                    + "Actually I have a gift for you!");  
            }
            //If player chooses to remain silent?
            else if(input == 4){
                Graphics.textInline(Colors.BLACK_BACKGROUND + "What? Cat got your tongue? You're so boring? I can't stand boring people...\n"
                );          
            }
            else{
                //User error
                failedInput();
            }
        }
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