package story;

import java.util.Scanner;
import graphics.Graphics;
import graphics.Colors;



public class Story {

    //Method for user error
    //TODO: Add dumpling box
    //TODO: Add enemy Blurbs
    public static void failedInput(){
        System.out.println(Colors.ANSI_RED + "Please input a better number." + Colors.ANSI_RESET);
    }

    public static String[][] maze = {
        //Key: L = left, R = right, U = up, D = down, B = bossfight(exit)
        //     E = enemy, 1 = riddle #1, 2 = riddle #2, 3 = riddle #3
        {"DE","DB","R1","LD","D2"},
        {"UR","ULRD","LRD","LRDU","ULD"},
        {"D3E","UR","ULRD","UL","UD"},
        {"UR","LR","URL","LR","LU"},
    };
    

    public static void main(String[] args) throws Exception {

        ////NOTE: Storing character data is yet to be implemented!
        //String [] info = {" "," "," "," "," "," "};
            //Intro:
            Graphics.displayBackground("Mountains", Colors.BLACK_BRIGHT);
            Graphics.textInline(Colors.ANSI_BLUE +  "temp studio name" + Colors.ANSI_RESET + " presents temp game name");
            Graphics.waitForEnter();
            Graphics.text("\n" + "please choose a character...");
            
            //Call scanner
            Scanner in = new Scanner(System.in); 
            int input;

            //File Scanner
            // File fileActivate = new File("./src/MazeProto.java");
            // Scanner runFile = new Scanner(fileActivate);
          
            
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
                            "It is a small town sparsely populated. While the inhabitants are kind and welcoming, you are a warrior who wishes to fight.");
        Graphics.waitForEnter();
        Graphics.textInline("Lucky for you, a cave leading straight to Hel is nearby, and since your chances of fighting in Ragnarok are slim, this is your best shot for action.\n" +
                            Colors.ANSI_YELLOW + "You can 1) leave the village now, or 2) stay a give a brief goodbye to your acquaintences\n"
                            + Colors.ANSI_RESET);
                       
        
        //Option for leaving or staying
        do{

            input = in.nextInt();
            if(input == 1){
                Graphics.textInline("You have chosen to leave the village straightaway. It will be easier this for them this way.");
                break;
            }
            else if(input == 2
            ){
                Graphics.displayCharacter("Viggo", 1);
                Graphics.textInline("You decided to stay and say goodbye.\n" + Colors.ANSI_PURPLE + "In Asbjorn you approach Viggo, the blacksmith. Once he was a great warrior like you, but he now he has settled down.\n He accepted his fate here...\n"
                                + Colors.ANSI_GREEN +  "\"Viggo, I'm leaving this town. I'm going to Hel. You can join me if you wish\"\n\"Alas, young (...) I do not display your energetic talent any more.\n I will stay here, accepting my banishment\"\n"
                                + "\"Well, I'll miss you then. You were the closest one of this lot to me.\"\n"
                                + "\"We understand that you have not lost your fervor for fighting like we have. We all wish you luck from the bottom of our hearts.\"\n"
                                + Colors.ANSI_PURPLE + "With that you leave the town filled with Thrill and anticipation for your upcoming battles." + Colors.ANSI_RESET);
                break;
            }
            else{
                failedInput();
            }
        }while(true);

         //Leave Village; go to cave
        Graphics.waitForEnter();
        Graphics.displayBackground("Trees", Colors.WHITE_BACKGROUND);
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
                        + "Then the answer comes to you as a figure steps out of the shadows.");
        Graphics.waitForEnter();
        Graphics.textInline(Colors.BLUE_BOLD_BRIGHT + "\"You should not have come here, World-Traitor.\"\n" + Colors.ANSI_RESET
                        + Colors.ANSI_GREEN + "\"That was not my fault. I was baited into it. You know this since you are soooooo great and wise, Odin\"\n"
                        + Colors.BLUE_BOLD_BRIGHT + "\"DO NOT SASS ME YOUNG [...]! YOU HAVE BROUGHT RUIN TO US ALL. you do not deserve to have fought even that dire wolf, worthless wretch...\"\n" + Colors.ANSI_RESET
                        + Colors.ANSI_PURPLE + "As quickly as it came, Odin's sudden outbust turns somber. Pain contorts his face\n"
                        + Colors.BLUE_BOLD_BRIGHT + "Well... none of us deserve to live anymore. That's why Ragnarok is here.\nI will remove this boulder here. Continue to Hel if you wish. If you can board Naglfar, you can fight in Ragnarok.\n" + Colors.ANSI_RESET);  

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
        //TODO: Script may need to be revised into a method, so it can be called in different areas depending on your choice. A loop could also potentially work?
        Graphics.textInline(Colors.ANSI_PURPLE + "You walk through the cave. It is quiet and dark. You have a torch, though, so that helps.\n"
                        + Colors.ANSI_YELLOW + "You come upon an intersection. Which way do you choose?\n"
                        + "1) Left\n"
                        + "2) Right");
        do{
            input = in.nextInt();
                //left: Loki room
            if(input == 1){
                Graphics.textInline("You chose to the passage to the left");

                //Play cavern sounds

                //Begin encounter with Loki
                        //Meet with Loki. He thanks you for freeing him, then taunts you. He figures out your plans and laughs at them
                //Many dialouge choices, but they all end in embaressment
                Graphics.waitForEnter();
                Graphics.textInline(Colors.ANSI_PURPLE + "The carvern is narrow and musty. Silence permeates through the air.\n"
                                        + "As you round a corner, however, you spot torchlight ahead." + Colors.ANSI_RESET); 
                Graphics.waitForEnter();
                Graphics.textInline(Colors.BLACK_BRIGHT + "A figure stands in a small room." + Colors.ANSI_RESET);   
                Graphics.displayCharacter("Loki", 500);  
                Graphics.waitForEnter(); 

                Graphics.textInline(Colors.BLACK_BRIGHT + "\"Well, well, well, what do we have here?\n" + Colors.ANSI_RESET
                                    + Colors.ANSI_PURPLE + "You stand speechless before the infamous god of deceit. Words with him are dangerous... He molds them as if they are clay.\n"
                                    + Colors.BLACK_BRIGHT + "I feel obliged to thank you. You have done so much for me! I must ask, how did Odin handle it? Was he mad?\"\n" + Colors.ANSI_RESET);
                Graphics.waitForEnter();
                
                //Options to respond to Loki
                Graphics.textInline(Colors.ANSI_YELLOW + "How do you respond?\n"
                                    + "1) \"THERE AIN'T NO WAY I'M TELLING YOU BOY!\"\n"
                                    + "2) \"Yeah, he was mad, but that doesn't matter. You tricked me.\"\n"
                                    + "3) \"I hate you! You got me banished!\"\n"
                                    + "4) (remain silent)\n");
                do{
                    input = in.nextInt();
                    //If player says something
                    if(input == 1 || input == 2 || input == 3){
                        Graphics.textInline(Colors.ANSI_PURPLE + "A thin smile dominates Loki's face.\n"
                                            + Colors.BLACK_BRIGHT + "\"Don't be so dramatic! I won't stop you from... whatever it is you're doing.\n"
                                            + "Actually I have a gift for you!");  
                        Graphics.waitForEnter();
                        Graphics.textInline(Colors.RED_BOLD + "\"Just kidding! I don't!\n" + Colors.BLACK_BRIGHT +  "Anyway, toodles! I would wish you luck on you endeavours, but we all know you can't have any!\"" + Colors.ANSI_RESET);
                        break;
                    }
                    //If player chooses to remain silent?
                    else if(input == 4){
                        Graphics.textInline(Colors.BLACK_BRIGHT + "What? Cat got your tongue? You're so boring? I can't stand boring people...");
                        Graphics.waitForEnter();
                        Graphics.textInline(Colors.ANSI_PURPLE + "Loki looks incredibly bored."
                                            + Colors.BLACK_BRIGHT + "Why did I choose you to free me again? You lack any sort of emotion that I find so very entertaining.\n"
                                            + "Well, toodles!\"" + Colors.ANSI_RESET);
                        break;
                    }
                    else{
                        //User error
                        failedInput();
                    }
                }while(true);
                //Fight undead skeleton for key
                //Enter Undead skeleton fight
                Graphics.textInline(Colors.ANSI_PURPLE + "You are left standing in the happy flickering torchlight coming from a nearby sconce.\n"
                                    + "A gaping doorway stands before, you can see two skeletons one on the ground... the other looming, staring right at you.");
                Graphics.waitForEnter();
                Graphics.textInline("You notice a key attached to its femur... It's fighting time!!!" + Colors.ANSI_RESET);
                //insert undead skeleton fight #1 here

                //Head back to right 
                Graphics.textInline(Colors.ANSI_PURPLE + "With the skeleton now at rest. you remove the iron key from its femur." + Colors.ANSI_RESET);
                Graphics.textInline(Colors.BLUE_BACKGROUND_BRIGHT + "You revieced \'Special Key\'");
                Graphics.waitForEnter();

                //Optional skeleton fight
                Graphics.textInline(Colors.ANSI_YELLOW + "You notice that you are now presented with yet another choice:\n"
                                    + "1) Enter the room with the other skeleton, for it appears to be holding something...\n"
                                    + "2) Go back to the the intersection and head to the right." + Colors.ANSI_RESET);
                
                    //Options
                do{
                    input = in.nextInt();
                    if(input == 1){
                        //if the player chooses to enter the room
                        Graphics.textInline(Colors.ANSI_PURPLE + "You burst into the room.");
                        Thread.sleep(1000);
                        Graphics.textInline("The prone skeleton numbly rises to its boney feet. It's fighting time again!!!" + Colors.ANSI_RESET);
                        //Insert Undead skeleton fight #2
                        Graphics.textInline(Colors.ANSI_PURPLE + "The skeleton lies defeated, and you find that it was holding a recipe... magical no doubt.\n" + Colors.ANSI_RESET
                                            + Colors.BLUE_BACKGROUND_BRIGHT + "You recieved \'Magical Dumpling!\' deal more damage in battle!" + Colors.ANSI_RESET);
                        break;
                    }
                    else if (input == 2){
                        //if the player chooses to return to intersection
                        Graphics.textInline(Colors.ANSI_PURPLE + "You return to the intersection, seeking Hel more than anything. Ragnarok won't wait for anyone now!" + Colors.ANSI_RESET);
                         break;
                    }
                    else{
                        //User error
                        failedInput();
                    }
                }while(true);
            }
                //right: locked door
            else if(input == 2){
                Graphics.textInline("You chose the path on the right");
                Graphics.waitForEnter();

                //TODO: Add a key check to see if character has key in invetory or not.
                
                //Some sort of stronghold...
                //Maze:
                //Riddles to help you thru (perhaps some allude to the good ending)
                //Few suprise battles; (avoidable but mandatory if you find them)
                MazeProto.main(args);


                //At the end: Gullinkambi: the Golden Comb (boss fight)
                Graphics.textInline(Colors.ANSI_PURPLE + "You found the end of the maze!\nYou enter a large circular and (oddly enough) well-lit room\n");
                Graphics.waitForEnter();
                Graphics.textInline("You stride triumphantly through the room. Suddenly! YOu hear a loud \"cuckaw\"" + Colors.ANSI_RESET);
                //TODO: Add rooster crow

                Graphics.waitForEnter();
                Graphics.textInline(Colors.RED_BACKGROUND + "A large rooster falls down and glares menacingly at you\nIt's Gullinkambi, the Golden Comb." + Colors.ANSI_RESET);
                //TODO: Add Gullinkambi boss fight

                //After the fight: Loki mocks you again
                Graphics.textInline(Colors.ANSI_PURPLE + "The giant rooster twitches dead on the ground. You are left breathless and traumatized\n"
                                    + Colors.RED_BOLD_BRIGHT + "You will never look at roosters the same way again...\n" + Colors.ANSI_RESET
                                    + Colors.BLACK_BRIGHT + "Speaking of roosters, Loki enters the room!" + Colors.ANSI_RESET);
                Graphics.waitForEnter(); 
                Graphics.textInline(Colors.BLACK_BRIGHT + "\"Well, there goes Gullinkambi. Such a tragedy. I had plans with him.");
                break;

                //Weapon upgrade!
                //Discover large cavern
            }
            else{
                failedInput();
            }
        }while(true);





        //TODO: ADD KATE'S STORY 
        do {
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

        //TODO: Implement tavern into correct area.
        Graphics.textInline("You enter the tavern. Lots of the deceased are mingling in here. It seems like a lively place.\n"
                                    + "You look around overwhelmed.\n"); 
        Graphics.waitForEnter();
        Graphics.textInline("Do you recognize that man?");
        Graphics.waitForEnter();
        Graphics.textInline("You do! It's your old friend Fell! Memory floods your mind, as you recall the lead up to your banishment");
        Graphics.waitForEnter();
        Graphics.textInline("Fell, although reluctant to help, aided you in freeing Loki. However, Loki betrayed you and killed him, leaving you \'mercifully\' alive.");
        Graphics.waitForEnter();
        Graphics.textInline("Fell notices you, and a big grin invades his face.\n"
                            + "\"[...] you old chap! You've finally come to dine with the dead? But wait. You have a spry look about you...\nYou're alive aren't you?\"\n"
                            + "\"Good to see you too, Fell. Still the one with all the questions I see. Yes, I am alive. Odin promised redemption if I boarded Naglfar.\"\n"
                            + "\"Ohh, that ship. A few of Loki's gurus came in and offered anyone to join him on the boat. Some of us went, but most of us... we don't want to fight the gods we once worshiped.\"");
        Graphics.waitForEnter();
        Graphics.textInline("Fell regards you for a long moment. Finally he pipes up,\n"
                            + "\"Let's do one last flyting. I know its been a while, but for wit and old times sake. Let's have some fun.\"\n"
                            + "\"Of course we can, but you know we can, but you know I only like to play with stakes.\"\n"
                            + "\"I have here this bottle full of \'Godmead\'. Don't ask how I got it, and I don't know what it does. I think it has magical properties, and I was promised that is the best mead ever.\n"
                            + "So, what do you say?\"\n"    
                            + "Godmead, huh. A mysterious alcoholic beverage doesn't sound like much of a stake, but Fell seems so eager to flyt with you.\n"
                            + "1) \"Let's do it!\"\n2) \"No, I can't do this right now.\"");
        input = in.nextInt();
        if(input == 1){
            //TODO: Make a file for the flyting and run it
        }
        else if(input == 2){
            Graphics.textInline("No!");
        }
        else{
            failedInput();
        }

    } 
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
                //permission from Hel to get on ship - prove your worth; fight an enemy
                //Must find/fight way into palace
        //bIG BOTE
            //Loki bossfight
                //If you win Loki runs away
                //If you lose, you get thrown into water (die)
                //If you win against loki and in the flyting, then Loki drops weapon, which you then use in Ragnorak
}