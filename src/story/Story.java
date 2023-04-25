package story;

import java.util.Scanner;
import graphics.Graphics;
import state.GameState;
import graphics.Colors;
import java.util.Random;



public class Story {

    //Method for user error
    //TODO: Add dumpling box
    //TODO: Add enemy Blurbs
    public static void failedInput(){
        System.out.println(Colors.ANSI_RED + "Please input a better number." + Colors.ANSI_RESET);
    }

    //Method for maze
    public static String[][] maze = {
        //Key: L = left, R = right, U = up, D = down, B = bossfight(exit)
        //     E = enemy, 1 = riddle #1, 2 = riddle #2, 3 = riddle #3
        {"DE","DB","R1","LD","D2"},
        {"UR","ULRD","LRD","LRDU","ULD"},
        {"D3E","UR","ULRD","UL","UD"},
        {"UR","LR","URL","LR","LU"},
    };
    //Method for maze #2!
    //Random
    static Random rand = new Random();
    public static boolean berserkerFight(){
        if(rand.nextInt(2) == 1)
        return true;
        else{
            return false;
        }
    }
    

    public static void main(String[] args) throws Exception {

        Graphics.textSpeed = 0;

        ////NOTE: Storing character data is yet to be implemented!
        //String [] info = {" "," "," "," "," "," "};   
         //Intro:
            Graphics.displayBackground("Mountains", Colors.ANSI_BLUE);
            Graphics.textInline(Colors.ANSI_BLUE +  "temp studio name" + Colors.ANSI_RESET + " presents temp game name.");

            Graphics.waitForEnter();
            Graphics.text("\n" + "please choose a character...");
            
            //Call scanner
            Scanner in = new Scanner(System.in); 
            int input;

            //File Scanner
            // File fileActivate = new File("./src/MazeProto.java");
            // Scanner runFile = new Scanner(fileActivate)
            
            do{
            //Fancy Welcome
            Graphics.text(Colors.ANSI_YELLOW + "Enter 1 to choose Gorm (male) or 2 to choose Gro (female)." + Colors.ANSI_RESET);
            
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
                Graphics.text("You have chosen Gorm! Gorm is a muscular, bald man with one long red braid.");
                break;
                
                
            }
            else if(input == 2){
                
                //NOTE: Storing character data is yet to be implemented!
                // info[0] = Gro.name;
                // info[1] = Gro.pNoun;
                // info[2] = Gro.objectPNoun;
                
                //Choosing Gro 
                Graphics.text("You have chosen Gro! Gro is a graceful woman with blonde braids and one bald spot.");
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
            Graphics.text(Colors.ANSI_YELLOW + "Enter 1 for a greatspear or 2 for a battleaxe." + Colors.ANSI_RESET);
            input = in.nextInt();

            if(input == 1){
                //Choosing Greatspear
                Graphics.text("You have chosen a greatspear.");
                break;
            }
            else if(input == 2){
                //Choosing Battleaxe
                Graphics.text("You have chosen a battleaxe.");
                break;
            }
            else{
                //input error
                failedInput();
            }
        }while(true);

        //Setting 
        Graphics.textInline(Colors.ANSI_PURPLE + "Your story starts in the misty mountains of Iceland inside of a small, sparsely populated town called Asbjorn. \nWhile its inhabitants are kind and welcoming, you are a warrior who wishes to fight.");
        Graphics.waitForEnter();
        Graphics.textInline("Lucky for you, a cave leading straight to Hel is nearby.\nSince your chances of fighting in Ragnarok are slim, this is your best shot for action.\n" 
                            + "You sift through your belongings and discover your trusty dumpling box. It is a gift from a long-lost loved one.\nIt periodically fills up with revitalizing dumplings, so you may never go hungry.\nYou leave the rest behind.\n");
        Graphics.textInline(Colors.ANSI_YELLOW + "Now you have a choice.\nYou can \n1) leave the village now or \n2) stay a give a brief goodbye to your acquaintances.\n" + Colors.ANSI_RESET);
                       
        
        //Option for leaving or staying
        do{

            input = in.nextInt();
            if(input == 1){
                Graphics.textInline(Colors.ANSI_PURPLE + "You have chosen to leave the village straightaway. It will be easier this for them this way." + Colors.ANSI_RESET);
                break;
            }
            else if(input == 2){
                Graphics.displayEnemy("Skeleton1");
                Graphics.textInline("You decided to stay and say goodbye.\n" + Colors.ANSI_PURPLE + "In Asbjorn you approach Viggo, the blacksmith. Once he was a great warrior like you, but he now he has settled down.\nHe accepted his fate here...\n"
                                + Colors.ANSI_GREEN +  "\"Viggo, I'm leaving this town. I'm going to Hel. You can join me if you wish\"\n\"Alas, young (...) I do not display your energetic talent any more.\n I will stay here, accepting my banishment\"\n"
                                + "\"Well, I'll miss you then. You were the closest one of this lot to me.\"\n"
                                + "\"We understand that you have not lost your fervor for fighting like we have. We all wish you luck from the bottom of our hearts.\"\n"
                                + Colors.ANSI_PURPLE + "With that you leave the town filled with thrill and anticipation for your upcoming battles.");
                break;
            }
            else{
                failedInput();
            }
        }while(true);

         //Leave Village; go to cave
        Graphics.waitForEnter();
        Graphics.displayBackground("Trees", Colors.GREEN_UNDERLINED);
        Graphics.text(Colors.ANSI_PURPLE + "You walk down the path leading to the cave. Nothing eventful so far..." + Colors.ANSI_RESET);
        Thread.sleep(1000);
        Graphics.text(Colors.ANSI_PURPLE + "But wait..." + Colors.ANSI_RESET);
        Thread.sleep(1000);
        Graphics.text(Colors.ANSI_PURPLE + "There's something there! Behind that tree!" + Colors.ANSI_RESET);
        Thread.sleep(1000);
        Graphics.text(Colors.ANSI_PURPLE + "You are fueled with determination as a dire wolf leaps and blocks your path." + Colors.ANSI_RESET);
        

         //First fight(required): Dire wolf
        //Insert Battle with dire wolf here

        //Enter cave, but run into dead end. Odin comes, scorns you, but then feels guilty and moves boulder allowing you to move on.

        Graphics.textInline(Colors.ANSI_PURPLE + "After a rather bloody battle, you reach the mouth of the cave.\n"
                        + "You have known of this cave for a while now, but you soon realize it is a dead end.\n"
                        + "You are filled with confusion. Your sources are reliable; how could they get this wrong?\n"
                        + "Then the answer comes to you as a figure steps out of the shadows.");
        Graphics.waitForEnter();
        Graphics.textInline(Colors.BLUE_BOLD_BRIGHT + "\"You should not have come here, World-Traitor.\"\n" + Colors.ANSI_RESET
                        + Colors.ANSI_GREEN + "\"That was not my fault. I was baited into it. You know this since you are soooooo great and wise, Odin.\"\n"
                        + Colors.BLUE_BOLD_BRIGHT + "\"DO NOT SASS ME YOUNG [...]! YOU HAVE BROUGHT RUIN TO US ALL.\nYou did not deserve to have fought even that dire wolf, worthless wretch...\"\n" + Colors.ANSI_RESET
                        + Colors.ANSI_PURPLE + "As quickly as it came, Odin's sudden outburst turns somber. Pain contorts his face.\n"
                        + Colors.BLUE_BOLD_BRIGHT + "\"Well... none of us deserve to live anymore. That's why Ragnarok is here.\nI will remove this boulder here. Continue to Hel if you wish. \nIf you can board Naglfar, you can fight in Ragnarok.\"\n" + Colors.ANSI_RESET);  

        do{
            //Choice of how to respond to the offer
            Graphics.textInline(Colors.ANSI_YELLOW + "What luck! A chance like this has never arisen before. How do you respond?\n"
                            + "1) \"Thank you, father Odin, for this chance at glory.\"\n"
                            + "2) \"Haha! you suck. I'll do this only to prove that you are weak.\"\n" + Colors.ANSI_RESET );  
            input =in.nextInt();

            //Odin's responses
            if(input == 1){
                Graphics.textInline(Colors.ANSI_PURPLE + "Odin looks solemnly at you, as if peering into your mind.\n"

                                + Colors.BLUE_BOLD_BRIGHT + "\"You have courage. I only hope it will stay with to the end.\"\n"
                                + Colors.ANSI_RESET); 
                break; 
            }
            else if(input == 2){
                Graphics.textInline(Colors.ANSI_PURPLE + "\"Odin flares in rage, judging you with his eye.\"\n"
                                + Colors.BLUE_BOLD_BRIGHT + "\"You have courage and wit. That will take you far\"\n" + Colors.ANSI_RESET); 

                break; 
            }
            else{
                failedInput();
            }
        }while(true);  
        
        //Odin leaves
        Graphics.textInline(Colors.ANSI_PURPLE + "With that Odin steps away, and the way forward reveals itself to you.");

        Graphics.waitForEnter();
        Thread.sleep(1000);

        //Choice: left of right
        Graphics.textInline(Colors.ANSI_PURPLE + "You walk through the cave. It is quiet and dark. You have a torch, though, so that helps.\n"
                        + Colors.ANSI_YELLOW + "You come upon an intersection. Which way do you choose?");
        Graphics.waitForEnter();
        do{
            Graphics.textInline(Colors.ANSI_YELLOW + "1) Left\n"
            + "2) Right\n" + Colors.ANSI_RESET);
            input = in.nextInt();
            //Loki room
            if(input == 1 && GameState.firstLeft == false){
                Graphics.textInline(Colors.ANSI_PURPLE + "You chose to go through the passage on the left.");

                //Play cavern sounds

                //Begin encounter with Loki
                        //Meet with Loki. He thanks you for freeing him, then taunts you. He figures out your plans and laughs at them
                //Many dialogue choices, but they all end in embarrassment
                Graphics.waitForEnter();
                Graphics.textInline(Colors.ANSI_PURPLE + "The cavern is narrow and musty. Silence permeates through the air.\n"
                                        + "As you round a corner, however, you spot torchlight ahead."); 
                Graphics.waitForEnter();
                Graphics.textInline(Colors.BLACK_BRIGHT + "A figure stands in a small room.\n" + Colors.ANSI_RESET);   
                Graphics.displayEnemy("Loki");  
                Graphics.waitForEnter(); 

                Graphics.textInline(Colors.BLACK_BRIGHT + "\"Well, well, well, what do we have here?\"\n" + Colors.ANSI_RESET
                                    + Colors.ANSI_PURPLE + "You stand speechless before the infamous god of deceit. Words with him are dangerous... He molds them as if they are clay.\n"
                                    + Colors.BLACK_BRIGHT + "\"I feel obliged to thank you. You have done so much for me! I must ask, how did Odin handle it? Was he mad?\"");
                Graphics.waitForEnter();
                
                //Options to respond to Loki
                Graphics.textInline(Colors.ANSI_YELLOW + "How do you respond?\n"
                                    + "1) \"THERE AIN'T NO WAY I'M TELLING YOU BOY!\"\n"
                                    + "2) \"Yeah, he was mad, but that doesn't matter. You tricked me.\"\n"
                                    + "3) \"I hate you! You got me banished!\"\n"
                                    + "4) (remain silent)\n" + Colors.ANSI_RESET);
                input = in.nextInt();
                //If player says something
                if(input == 1 || input == 2 || input == 3){
                    Graphics.textInline(Colors.ANSI_PURPLE + "A thin smile dominates Loki's face.\n"
                                        + Colors.BLACK_BRIGHT + "\"Don't be so dramatic! I won't stop you from... whatever it is you're doing.\n"
                                        + "Actually I have a gift for you!");  
                    Graphics.waitForEnter();
                    Graphics.textInline(Colors.RED_BOLD + "Just kidding! I don't!\n" + Colors.BLACK_BRIGHT +  "Anyway, toodles! \nI would wish you luck on your endeavors, but we all know you can't have any luck!\"" + Colors.ANSI_RESET);
                }
                //If player chooses to remain silent?
                else if(input == 4){
                    Graphics.textInline(Colors.BLACK_BRIGHT + "\"What? Cat got your tongue? You're so boring! I can't stand boring people...\"");
                    Graphics.waitForEnter();
                    Graphics.textInline(Colors.ANSI_PURPLE + "Loki looks incredibly bored."
                                        + Colors.BLACK_BRIGHT + "\n\"Why did I choose you to free me again? You lack any sort of emotion that I find so very entertaining.\n"
                                        + "Well, toodles!\"" + Colors.ANSI_RESET);
                }
                else{
                    //User error
                    failedInput();
                }
                //TODO: Fix do loop. Color background handling. Fix second Skelly fight
                //Fight undead skeleton for key
                //Enter Undead skeleton fight
                Graphics.textInline(Colors.ANSI_PURPLE + "\nYou are left standing in the happy flickering torchlight coming from a nearby sconce.\n"
                                    + "A gaping doorway stands ahead and you can see two skeletons. " 
                                    + "There is one on the ground... the other looming, staring right at you.");
                Graphics.waitForEnter();
                Graphics.textInline("You notice a key attached to its femur... It's fighting time!!!" + Colors.ANSI_RESET);
                //insert undead skeleton fight #1 here
                GameState.key = true;

                //Head back to right 
                Graphics.textInline(Colors.ANSI_PURPLE + "\nWith the skeleton now at rest, you remove the iron key from its femur." + Colors.ANSI_RESET);
                Graphics.textInline(Colors.BLUE_BACKGROUND_BRIGHT + "\nYou received \'Special Key!\'" + Colors.ANSI_RESET + Colors.ANSI_YELLOW + "                                                                                                                            ");

                //Optional skeleton fight
                Graphics.textInline(Colors.ANSI_YELLOW + "\nYou notice that you are now presented with yet another choice:\n"
                                    + "1) Enter the room with the other skeleton, for it appears to be holding something...\n"
                                    + "2) Go back to the intersection and head to the right.\n" + Colors.ANSI_RESET);
                
                //Options
                do{
                    input = in.nextInt();
                    if(input == 1){
                        //if the player chooses to enter the room
                        Graphics.textInline(Colors.ANSI_PURPLE + "You burst into the room.");
                        Thread.sleep(1000);
                        Graphics.textInline("The prone skeleton nimbly rises to its boney feet. It's fighting time again!!!" + Colors.ANSI_RESET);
                        //TODO: Insert Undead skeleton fight #2
                        Graphics.textInline(Colors.ANSI_PURPLE + "\nThe skeleton lies defeated, and you find that it was holding a necklace... magical no doubt.\n" + Colors.ANSI_RESET
                                            + Colors.BLUE_BACKGROUND_BRIGHT + "You received \'Magical Necklace!\'" + Colors.ANSI_RESET + Colors.ANSI_PURPLE +  "\ndeal more damage in battle!");
                        Graphics.waitForEnter();
                        Graphics.textInline(Colors.ANSI_PURPLE + "You return to the intersection, seeking Hel more than anything. Ragnarok won't wait for anyone now!\n" + Colors.ANSI_RESET);
                        break;
                    }
                    else if (input == 2){
                        //if the player chooses to return to intersection
                        Graphics.textInline(Colors.ANSI_PURPLE + "You return to the intersection, seeking Hel more than anything. Ragnarok won't wait for anyone now!\n" + Colors.ANSI_RESET);
                        break;
                    }
                    else{
                        //User error
                        failedInput();
                    }
                }while(true);
                GameState.firstLeft = true;
            }
            else if(input == 1 && GameState.firstLeft == true){
                Graphics.textInline(Colors.ANSI_PURPLE + "There is nothing LEFT to do there.\n" + Colors.ANSI_RESET);
            }
            //right: locked door
            else if(input == 2){
                Graphics.textInline(Colors.ANSI_PURPLE + "You chose the path on the right.");
                Graphics.waitForEnter();
                //Some sort of stronghold...
                if(GameState.key == true){
                    Graphics.textInline(Colors.ANSI_PURPLE + "You come upon a door. It is locked, but you have a key!\nIt fits in snugly, and the door swings open.");
                    Graphics.waitForEnter();
                    Graphics.textInline(Colors.ANSI_PURPLE + "Before the walls are smooth, cool stone. You appear to be in a winding fortress.\n You continue along but quickly realize that you are in a maze!" + Colors.ANSI_RESET);
                    
                    //Maze
                    RoosterMaze.main(args);

                    //At the end: Gullinkambi: the Golden Comb (boss fight)
                    Graphics.textInline(Colors.ANSI_PURPLE + "You found the end of the maze!\nYou enter a large circular and (oddly enough) well-lit room.");
                    Graphics.waitForEnter();
                    Graphics.textInline("You stride triumphantly through the room. Suddenly, you hear a loud" + Colors.PURPLE_BACKGROUND + "\"cuckaw!\"" + Colors.ANSI_RESET);
                    //TODO: Add rooster crow

                    Graphics.waitForEnter();
                    Graphics.textInline(Colors.RED_BACKGROUND + "A large rooster falls down and glares menacingly at you.\nIt's Gullinkambi, the Golden Comb." + Colors.ANSI_RESET);
                    //TODO: Add Gullinkambi boss fight

                    //After the fight: Loki mocks you again
                    Graphics.textInline(Colors.ANSI_PURPLE + "The giant rooster twitches dead on the ground. You are left breathless and traumatized.\n"
                                        + Colors.RED_BOLD_BRIGHT + "You will never look at roosters the same way again...\n" + Colors.ANSI_RESET
                                        + Colors.ANSI_PURPLE + "Speaking of roosters, Loki enters the room!");
                    Graphics.waitForEnter(); 
                    Graphics.textInline(Colors.BLACK_BRIGHT + "\"Well, there goes Gullinkambi. Such a tragedy. I had plans with him.\"\n");
                    Graphics.textInline(Colors.ANSI_YELLOW + "What do you say?\n"
                                        + "1) \"Well, I\'m just that good!\"\n"
                                        + "2) \"Sorry to burst your bubble pal :)\"\n"
                                        + "3) \"And i\'m coming for you next.\"\n"
                                        + "4) Remain silent\n" + Colors.ANSI_RESET);
                    do{
                        input = in.nextInt();
                        if(input == 1 || input == 3){
                            Graphics.textInline(Colors.BLACK_BRIGHT + "\"Likely story, buddy.\nBe honest for once in your life, you just get lucky.\nanyway, I have places to be. Toodles!\"");
                            Graphics.waitForEnter();
                            break;
                        }
                        else if (input == 2){
                            Graphics.textInline(Colors.BLACK_BRIGHT + "\"Don\'t be sorry my little Munchkin! Papa Loki\'s big plans aren\'t ruined!\nBut he still some things to do... Toodles!\"");
                            Graphics.waitForEnter();
                            break;
                        }
                        else if(input == 4){
                            Graphics.textInline(Colors.BLACK_BRIGHT + "\"Still silent I see? Your loss...\n Toodles!");
                            Graphics.waitForEnter();
                            break;
                        }
                        else{
                            failedInput();
                        }
                    }while(true);
                    break;

                    //Weapon upgrade!
                    //Discover large cavern
                }
                else{
                    Graphics.textInline(Colors.ANSI_PURPLE + "You come upon a door. It is locked. You try to force it open, but it remains steadfast.\nperhaps something in the left passage will help.\n");
                }
            }
        }while(true);

        Graphics.textInline(Colors.ANSI_PURPLE + "Loki suddenly vanishes and you walk out of the room to go look for something that will lead to the bottom of Hel.\n"
        + "You spot a cliff that will lead to an open cave with an elevator.\nAfter getting past the cliff and going into the open cave, you soon discover the elevator is broken. You have a few options.\n");

        //TODO: ADD KATE'S STORY 
        do {
            Graphics.text(Colors.ANSI_YELLOW + "You can 1) go to the path on your right, or 2) return to the village to get help." + Colors.ANSI_RESET);
            input = in.nextInt();

                if(input == 1){ 
                    Graphics.textInline(Colors.ANSI_PURPLE+ "You have chosen to to take the path on the right." 
                                    + "Suddenly, an angry dwarf comes out of the shadows\n"
                                    + "He jumps you immediately and while you think he doesn't have a lot of strength, he continues to surprise you.");
                    Graphics.waitForEnter();
                    //TODO: Add dwarf fight
                    Graphics.textInline(Colors.ANSI_PURPLE + "After a rather long battle, you defeat the little, yet mighty dwarf and walk towards the room on your left\n"
                                        + "When you enter, your eyes immediately fall onto the blacksmith puzzle\n" + "It reminds you of your friend, Viggo and while exploring the rest of the room, you discover a spare gear lying around."
                                        + Colors.ANSI_RESET);
                    break;
                }
                if (input == 2) {
                    Graphics.text(Colors.ANSI_PURPLE + "You have decided to return to the village\n"
                                + "You remember your friend, Viggo the blacksmith. He would probably help you fix the elevator so you can get to the bottom of Hel!\n" 
                                + "On your way out, you notice something shining from a hidden crevice.\n"
                                + "You walk towards it and find that it's a weapon upgrade. Score! It can help you fight bigger battles!\n");
                    //Chance for berserker fight
                    if(berserkerFight() == true){
                        Graphics.textInline(Colors.ANSI_PURPLE + "Suddenly, out of nowhere, a berserker charges at you in fury. You fight him until he is no more.\n");
                        Graphics.waitForEnter();
                        //TODO: Add berserker fight
                        Graphics.textInline("After the long battle, you defeat him and go on your way. The show must go on!" + Colors.ANSI_RESET);
                    }
                    else{
                        Graphics.textInline(Colors.ANSI_PURPLE + "You return the surface without any disturbance.");
                    }
                    Graphics.waitForEnter();
                    Graphics.textInline("When you are finally in Asbjorn, you find Viggo working.\n"
                                        + Colors.ANSI_GREEN + "\"Can you come help me fix the elevator? I need the elevator fixed so I can get to the bottom of Hel and finish my journey.\"\n" + Colors.ANSI_RESET);
                    Graphics.waitForEnter();
                    Graphics.textInline(Colors.ANSI_PURPLE + "Viggo agrees but tells you he doesn't want to fight at all. And then, he gives you a gear that looks helpful.\n"+  Colors.ANSI_RESET);
                    break;
                }
            } while(true);

    //descending at the bottom of Hel and fight with wolf (Fenrir)
            Graphics.textInline(Colors.ANSI_PURPLE + "You take a good long look at the broken elevator. You conveniently figure out that the you possess is exactly what you need to get it running!\n" 
                                + "you finally descend to the bottom of Hel.\n"
                                + "You soon discover that Fenrir the wolf is guarding the gate. You must defeat him.\n" 
                                + "Without throwing caution to the wind, you approach him slowly. But Fenrir doesn't hesitate to rush at you.\n");
            Graphics.waitForEnter();
            //TODO: Add Fenrir fight
            Graphics.textInline("You and Fenrir fight hard and the battle gets a bit bloody. You feel empowered.\n"
                                + "You finally defeat Fenrir, but you don't kill him. Fewer the casualties the better, right? More to kill in Ragnorak ;)\n");
    //Loki's mocking 
           Graphics.textInline(Colors.ANSI_PURPLE + "After standing there for a few moments, you hear sarcastic clapping and a small chuckle.\n"
                    + "You spin around quickly and try and find where that sound is coming from. Suddenly Loki appears out of the shadows.\n"
                    + Colors.ANSI_RESET
                    + Colors.BLACK_BRIGHT + "\"Well done. You managed to fight without killing. How kind of you.\"\n" 
                    + Colors.ANSI_RESET
                    + Colors.ANSI_GREEN + "\"Loki? You were here the whole time? How did I not see you? Why are you here?\"\n"
                    + Colors.ANSI_RESET
                    + Colors.BLACK_BRIGHT + "\"So many questions but so little time. All you need to know, young lad, is that you really need to work on your fighting skills.\"");
            Graphics.waitForEnter();
            Graphics.textInline(Colors.ANSI_YELLOW + "What do you say?\n"
                                + "1) \"Well, if you are soooooo good, why don\'t you fight me!\"\n"
                                + "2) \"I\'m gonna bring you down!\" (draw weapon)\n"
                                + "3) \"Out of my way!\"\n"
                                + "4) (Remain silent)\n" + Colors.ANSI_RESET); 
            input =in.nextInt();
            do{
                if(input == 1 || input == 2){
                    Graphics.textInline(Colors.BLACK_BRIGHT + "\"Alas, young cur, I must get going now! Toodles!\"\n"
                                        + Colors.ANSI_PURPLE + "With that Loki disappears, leaving you quivering in rage." + Colors.ANSI_RESET);
                    break;
                }
                else if(input == 3 || input == 4){
                    Graphics.textInline(Colors.BLACK_BRIGHT + "\"Must you be such a bore?\nToodles for now, then.\"\n"
                                        + Colors.ANSI_PURPLE + "With that Loki disappears, leaving you in a cloud of dust." + Colors.ANSI_RESET);  
                    break;
                }
                else{
                    failedInput();
                }
            }while(true);

            //Segue into next part
            Graphics.waitForEnter();
            Graphics.textInline(Colors.ANSI_PURPLE + "The Gates of Hel stand before you. They are certainly a sight to behold. They are gilded in gold and decorated with gemstones.\n"
                                + "They open before you, and you are filled with wonder. Though miniscule compared to Valhalla, Hel is still quite the sight.\n"
                                + "You take it all in, but you know that you must continue on. End times don\'t wait for wonders.");
            Graphics.waitForEnter();

            Graphics.textInline(Colors.ANSI_PURPLE + "After your fun little banter with Loki, you walk to the entrance of the gates.\n"
                                + "There is nothing but a dirty stream but you're excited to find out what lies beyond the gates.\n"
                                + "You push them open and discover the bottom of Hel was so much more than what you expected." );
            Graphics.waitForEnter();

    //Greater Hel Area
        do { 
            Graphics.text(Colors.ANSI_YELLOW + "You can either go to 1) Eastern region (docks), 2) Western region (tavern)\n" 
                                            + "3) Southern region (gates of Hel), or 4) Northern region where you can visit Hela's palace."+ Colors.ANSI_RESET );
            input = in.nextInt();
            //Eastern Hel: Docks
            //Naglfar, the ship made of fingernails and toenails resides here.
            //Loki fight is on this ship
            //Must find way on ship 

            if(input == 1){    
                if(GameState.helPermission == false){Graphics.textInline(Colors.ANSI_PURPLE + "In the eastern region of the bottom of Hel, you find Naglfar, the famous ship made of finger and toe nails.\n"
                                    + "Odin told you that this is the requisite ship to prove your worth.\n"
                                    + "The only problem is that trying to get aboard is harder than expected, and you have to travel to the Northern region to Hela's palace and get permission.\n");
                }
                else{
                    Graphics.textInline(Colors.ANSI_PURPLE + "You show the guard of Naglfar the letter of permission from Hela.\n"
                                        + "You board the ship. Loki is standing in the center of dock with his arms crossed and a smirk on his face.\n" + Colors.ANSI_RESET
                                        + Colors.BLACK_BRIGHT + "\"You really don't know when to give up, do you? Well, it doesn't matter because I've been expecting you.\"\n" + Colors.ANSI_RESET
                                        + Colors.ANSI_PURPLE + "You boldly stride up to him. Now y'all are standing head to head, glaring at each other with arms crossed.\n"
                                        + Colors.ANSI_GREEN + "\"Loki, fancy seeing you here. You're right. I don't know when to give up but know is not the time. I'm fighting whether you like it or not.\"\n" + Colors.ANSI_RESET
                                        + Colors.BLACK_BRIGHT + "\"Ah, young lad. I was hoping you'd say that. But don't think I'm going to make it easy for you. I am the god of mischief after all.\"\n" + Colors.ANSI_RESET
                                        + Colors.ANSI_GREEN + "\"Ha, why am I not surprised? Going easy on anyone would be the very last thing I'd except from you.\"\n" + Colors.ANSI_RESET);
                    //TODO: Add final boss
                    Graphics.textInline(Colors.PURPLE_BRIGHT + "After a long, exhausting battle, Loki seems completely unfazed. He suddenly stops.\n"
                                        + Colors.BLACK_BRIGHT+  "\"Alas! I must be off! I\'m sincerely sorry we cannot finish. Perhaps I will visit you during Ragnorak!\nYou have my full assurances that this is fate\'s will, not mine!\nToddles!\"\n" + Colors.ANSI_RESET
                                        + Colors.PURPLE_BRIGHT + "With that he jumps off the boat. As for you...");
                    Graphics.waitForEnter();
                    Thread.sleep(1000);
                    Graphics.textInline(Colors.GREEN_BRIGHT + "You are no longer on the boat. Odin is next to you, and before you, a large army stands. You came in the nick of time!\nOdin smiles at you nods at the shiny armor at your feet.\nYou hastily put it on and join the army." + Colors.ANSI_RESET
                                        + Colors.ANSI_WHITE + "\nYou run off to battle, destined to die forever...");
                    Graphics.waitForEnter();
                    Graphics.textInline("The end! (Ending #1 of 3)");
                    //TODO: Add best and worst ending!
                    //TODO: Add credits and exit system
                }
            }      
    //Western Hel: Tavern 
            else if (input == 2) {
                if(GameState.firstWest == false){
                    //Lots of dead people drinking here
                    //Flyting happens here
                    //Flyting: A poetic constest of insults
                    //Winning allows good ending
                    //find rumors about ship
                    Graphics.textInline(Colors.ANSI_PURPLE + "You enter the tavern. Lots of the deceased are mingling in here. It seems like a lively place.\n"
                                + "You look around overwhelmed."); 
                    Graphics.waitForEnter();
                    Graphics.textInline("Do you recognize that man?");
                    Graphics.waitForEnter();
                    Graphics.textInline("You do! It's your old friend Fell! Memory floods your mind, as you recall the lead up to your banishment");
                    Graphics.waitForEnter();
                    Graphics.textInline("Fell, although reluctant to help, aided you in freeing Loki. However, Loki betrayed you and killed him, leaving you \'mercifully\' alive.");
                    Graphics.waitForEnter();
                    Graphics.textInline("Fell notices you, and a big grin invades his face.\n"
                        + Colors.CYAN_BRIGHT + "\"[...] you old chap! You've finally come to dine with the dead? But wait. You have a spry look about you...\nYou're alive aren't you?\"\n"
                        + Colors.ANSI_GREEN + "\"Good to see you too, Fell. Still the one with all the questions I see. Yes, I am alive. Odin promised redemption if I boarded Naglfar.\"\n"
                        + Colors.CYAN_BRIGHT + "\"Ohh, that ship. A few of Loki's gurus came in and offered anyone to join him on the boat. Some of us went, but most of us... we don't want to fight the gods we once worshiped.\"");
                    Graphics.waitForEnter();
                    Graphics.textInline("Fell regards you for a long moment. Finally he pipes up,\n"
                        + Colors.CYAN_BRIGHT + "\"Let's do one last flyting. I know its been a while, but for wit and old times sake. Let's have some fun.\"\n"
                        + Colors.ANSI_GREEN + "\"Of course we can, but you know we can, but you know I only like to play with stakes.\"\n"
                        + Colors.CYAN_BRIGHT + "\"I have here this bottle full of \'Godmead\'. Don't ask how I got it, and I don't know what it does. I think it has magical properties, and I was promised that is the best mead ever.\n"
                        + Colors.ANSI_GREEN + "So, what do you say?\"\n"    
                        + Colors.ANSI_PURPLE + "Godmead, huh. A mysterious alcoholic beverage doesn't sound like much of a stake, but Fell seems so eager to flyt with you.\n"
                        + Colors.ANSI_YELLOW + "1) \"Let's do it!\"\n2) \"No, I can't do this right now.\"\n" + Colors.ANSI_RESET);
                    input = in.nextInt();
                    if(input == 1){
                        //Run flyting 
                        Tavern.main(args);
                        GameState.winFlyting = true;
                    }
                    else if(input == 2){
                        Graphics.textInline(Colors.ANSI_GREEN + "\"Not today, Fell. I have better things to do\"\n");
                    }
                    else{
                        failedInput();
                    }
                    GameState.firstWest = true;
                }
                else{
                    Graphics.textInline(Colors.ANSI_PURPLE + "You do not feel like entering the tavern again.\n");
                }
            }
    //Southern Hel: Gates to Hel; 
            else if (input == 3) {
            //Entrance
            //Coming here a second time rewards you with a hidden dumpling recipe; add dialogue 
                if(GameState.firstSouth != 1){
                    Graphics.textInline(Colors.ANSI_PURPLE + "You travel to the Southern region of Hel. You walk to the entrance at the gates.\n"
                    + "There is nothing but a dirty stream\n");
                    GameState.firstSouth++;
                    } 
                else{
                    Graphics.textInline(Colors.ANSI_PURPLE + "You decide to investigate the stream a bit more..." + Colors.ANSI_RESET);
                    Graphics.waitForEnter();
                    Graphics.textInline(Colors.ANSI_BLUE + "You found a Dumpling recipe! It\'s mystical!\n" + Colors.ANSI_RESET);
                    //TODO: Add healing upgrade
                }
            }
                
    //Northern Hel: Hela's palace
            else if (input == 4) {
                    if(GameState.firstNorth == false){
                        //permission from Hel to get on ship 
                        //Must find your way thru the palace (it's a maze ;)
                        Graphics.textInline(Colors.ANSI_PURPLE + "After traveling around for a bit, you walk to the Northern part of Hel.\n"
                                            + "You approach the sinister looking palace. Hela resides in the palace somewhere, and you must get permission from her board Naglfar.");
                        Graphics.waitForEnter();

                        HelMaze.main(args);
                        // Approach palace after maze 
                        Graphics.text(Colors.ANSI_PURPLE + "When you finally get through and defeat the maze, you reach the throne room.\n"
                        + "There are guards at the door but you have to get in to get permission to fight aboard Naglfar.\n"
                        + "You approach the guards and try to make up a silly story but they don't buy it.\n"
                        + "You finally give up and tell them the truth but they still don't care. Your only option is to fight your way in.\n"
                        + "After a long fight between the two of them, you are a little injured but you manage to get past the doors.\n" + Colors.ANSI_RESET
                        + Colors.RED_BRIGHT + "\"Who are you and how did you get in here?\"\n" + Colors.ANSI_RESET
                        + Colors.ANSI_GREEN + "\"My name is [...]. I was told I had to come here to get permission from you, great Hela.\"\n" + Colors.ANSI_RESET
                        + Colors. ANSI_PURPLE + "You approach her at her throne and kneel on one knee.\n" + Colors.ANSI_RESET
                        + Colors.RED_BRIGHT + "\"You are correct. But don't think you'll get my consent so easily. I have a riddle for you.\"\n"
                        + "\"What does man love more than life,\nhate more than death or mortal strife;\nthat which contented men desire;\nthe poor have,\nthe rich require;\nthe miser spends,\nthe spendthrift saves,\nand all men carry to their graves?\"\n"
                        + "You have three options for the answer." + Colors.ANSI_RESET);
                        do {
                           
                            Graphics.text(Colors.ANSI_YELLOW + "There are three options. Only one is the correct answer.\n"
                                                    + "option 1: Nothing.\n"
                                                    + "option 2: Money.\n"
                                                    + "option 3: A moral life.\n" + Colors.ANSI_RESET);
                            input = in.nextInt();
                            if (input == 1) {
                                Graphics.textInline(Colors.ANSI_PURPLE + "Hela slowly starts to nod her head.\n"
                                                                    + Colors.RED_BRIGHT + "\"You are very smart. You have my permission to aboard the Naglfar.\"\n" + Colors.ANSI_RESET
                                                                    + Colors.ANSI_PURPLE + "She hands you a letter and let you go on your way.\n");
                                Graphics.displayWin("yay", Colors.YELLOW_BRIGHT);
                                GameState.helPermission = true;
                                break;
                            }

                            else if (input == 2 || input == 3) {
                                Graphics.textInline("Hela shakes her head and says that you will not be able to board Naglfar and fight");
                                Graphics.displayDeath("Dead", Colors.RED_BOLD);
                                Graphics.textInline(Colors.RED_BRIGHT + "\"Because you got the riddle wrong, you must the fight my meanest elf.\"");
                                Graphics.waitForEnter();
                                Graphics.textInline(Colors.ANSI_PURPLE + "Hela summons her biggest, meanest elf and he comes stomping in.\n"
                                + "Oh great. He looks so angry and irritated. This is going to be loads of fun, you think to yourself.\n"
                                + "He immediately knows its you he has to fight and charges at you. You bring out your [...] while he pulls out an axe.\n"
                                + "You finally defeat him, leaving the mean elf dirty, bloody, and in pain. You look at Hela who has been watching the whole time.\n"
                                + Colors.RED_BRIGHT + "\"Good job young lad. You have defeated my undefeatable elf. You have my permission to aboard the Naglfar\"\n" + Colors.ANSI_RESET
                                + Colors.ANSI_PURPLE + "She hands you a letter and lets you go on your way. You thank her and head out the door.\n");
                                GameState.helPermission = true;
                                break;
                            }
                            else{
                                failedInput();
                            }
                        } while(true);
                        GameState.firstNorth = true;
                    }
                else{
                    Graphics.textInline(Colors.ANSI_PURPLE + "There is nothing else to do here.\n");
                }
            }                                   
            //Failed input
            else{
                failedInput();
            }  
        } while(true);
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
                //The Fenrir Wolf (Boss fight) guards it
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
                    //Flyting: A poetic contest of insults
                        //Allusions to this thru out game. remember old insults and what peeps are sensitive to.
                        //Winning allows good ending
                //find rumors about ship


            //Southern Hel: Gates to Hel; 
                //Entrance
            //Northern Hel: Hela's palace
                //permission from Hel to get on ship - prove your worth; fight an enemy
                //Must find/fight way into palace
        //bIG BOTE
            //Loki 
                //If you win Loki runs away
                //If you lose, you get thrown into water (die)
                //If you win against loki and in the flyting, then Loki drops weapon, which you then use in Ragnorak
}