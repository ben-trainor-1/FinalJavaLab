package story;
import graphics.Colors;
import graphics.Graphics;
import java.util.Scanner;


public class Tavern {

    //Method for failed inputs
    public static void failedInput(){

        System.out.println(Colors.ANSI_RED + "Please input a better number." + Colors.ANSI_RESET);

    }
    public static void main(String[] args) throws Exception {

        //integers and scanner
        Scanner in = new Scanner(System.in); 
        int input;
        int counter = 0;

        //Begin flyting 
        Graphics.textInline(Colors.ANSI_PURPLE + "Fell gives a sly look. The battle begins");
        Graphics.waitForEnter();
        Graphics.textInline(Colors.RED_BOLD_BRIGHT + "\"Well, then let's begin, I may have died, but you're a cur.\"\n" + Colors.ANSI_RESET);

        //Round I
        Graphics.textInline(Colors.ANSI_YELLOW + "1) \"I may be a cur, but you're dead.\"\n"
                                                + "2) \"Dead people are all idiots. I'm not a cur. I am a connoisseur. Get it right, dude.\"\n" 
                                                + "3) \"GIT GUD\"\n"
                                                + "4) \"Insult me all you like, but you're my little fir.\"\n" + Colors.ANSI_RESET);
        input = in.nextInt();
        do{

            if(input == 1){

                Graphics.textInline(Colors.ANSI_PURPLE + "He looks at you and shakes his head. Your response wasn't very creative.\nA crowd starts to gather." + Colors.ANSI_RESET);
                Graphics.displayDeath("Dead", Colors.BLACK_BRIGHT);
                break;      

            }
            else if(input == 3 || input == 4){

                Graphics.textInline(Colors.ANSI_PURPLE + "Your cheeks grow hot. You answer wasn't very good.\nA crowd starts to gather." + Colors.ANSI_RESET);
                Graphics.displayDeath("Dead", Colors.BLACK_BRIGHT);
                break;

            }
            else if(input == 2){

                Graphics.textInline(Colors.ANSI_PURPLE + "The look on his face tells you that you dunked on him.\nA crowd starts to gather." + Colors.ANSI_RESET);
                Graphics.displayWin("Yay", Colors.ANSI_YELLOW);
                counter ++;
                break;

            }
            else{

                failedInput();

            }
            Graphics.waitForEnter();

        }while(true);

        //Round II
        Graphics.textInline(Colors.RED_BOLD_BRIGHT + "\"Níðingr, vile person. Headstrong boy, you can be manipulated to do anything.\"\n" + Colors.ANSI_RESET);
        Graphics.textInline(Colors.ANSI_YELLOW + "1) \"Pussy, you have cat eyes.\"\n"
                                                + "2) \"You can't even think straight.\"\n"
                                                + "3) \"GIT GUD\"\n"
                                                + "4) \"Headstrong? You are correct. Things work out for me, but they obviously didn't work out for you.\"\n" + Colors.ANSI_RESET);
        input = in.nextInt();
        do{

            if(input == 1 || input == 2 || input == 3){

                Graphics.textInline(Colors.ANSI_PURPLE + "\'Your just shy of being insulting,\' you think to yourself as the crowd thickens. You need step up your game.");
                Graphics.displayDeath("Dead", Colors.BLACK_BRIGHT);
                break;

            }
            else if(input == 4){

                Graphics.textInline(Colors.ANSI_PURPLE + "You are triumphant again, but now things are truly heating up now. The crowd thickens.");
                Graphics.displayWin("Yay", Colors.ANSI_YELLOW);
                counter ++;
                break;

            }
            else{

                failedInput();

            }
            Graphics.waitForEnter();
            
        }while(true);

        //Round III
        Graphics.textInline(Colors.RED_BOLD_BRIGHT + "\"It's impossible to underestimate you. You bring everyone so much joy! You know, when you leave the room.\"\n" + Colors.ANSI_RESET);
        Graphics.textInline(Colors.ANSI_YELLOW + "1) \"You are my favorite person… besides every other person I have ever met.\"\n"
                                                + "2) \"I merely mirror you.\"\n"
                                                + "3) \"GIT GUD\"\n"
                                                + "4) \"I brought a date to your funeral.\"\n" + Colors.ANSI_RESET); 
        input = in.nextInt();
        do{

            if(input == 2 || input == 3 || input == 4){

                Graphics.textInline(Colors.ANSI_PURPLE + "You are red in the face. The now large crowd just stares at you.");
                Graphics.displayDeath("Dead", Colors.BLACK_BRIGHT);
                break;

            } 
            else if(input == 1){

                Graphics.textInline(Colors.ANSI_PURPLE + "The now large crowd roars with laughter.");
                Graphics.displayWin("Yay", Colors.ANSI_YELLOW);
                counter ++;
                break;

            }
            else{

                failedInput();

            }
            Graphics.waitForEnter();

        }while(true);

        //Round IV
        Graphics.textInline(Colors.RED_BOLD_BRIGHT + "\"People clap when they see you. They clap their hands over their eyes.\"\n" + Colors.ANSI_RESET);
        Graphics.textInline(Colors.ANSI_YELLOW + "1) \"You suck\"\n"
                                                + "2) \"I like the way you try.\"\n"
                                                + "3) \"GIT GUD\"\n"
                                                + "4) \"I bet your parents change the subject when their friends ask about you... And at least they're still alive.\"\n" + Colors.ANSI_RESET);
        input = in.nextInt();
        do{

            if(input == 1 || input == 2 || input == 3){

                Graphics.textInline(Colors.ANSI_PURPLE + "The rambunctious mob laughs at Fell\'s comment.");
                Graphics.displayDeath("Dead", Colors.BLACK_BRIGHT);
                break;

            }
            else if(input == 4){

                Graphics.textInline(Colors.ANSI_PURPLE + "The crowd wails with laughter.");
                Graphics.displayWin("Yay", Colors.ANSI_YELLOW);
                counter ++;
                break;

            }
            else{

                failedInput();

            }
            Graphics.waitForEnter();

        }while(true);

        //Round V
        Graphics.textInline(Colors.ANSI_PURPLE + "\"Fell smirks.\n" + Colors.RED_BOLD_BRIGHT + "\"Remember when you bragged and bragged about being the wisest? That was before you betrayed Odin.\"\n" + Colors.ANSI_RESET
                            + "The crowd gasps. You struggle to keep your embarrassment down, but he's not done,\n"
                            + Colors.RED_BOLD_BRIGHT + "\"Indeed it\'s both surprising and disappointing that you are still alive.\"\n" + Colors.ANSI_RESET);  
        Graphics.textInline(Colors.ANSI_YELLOW + "1) \"Jealousy is a disease. Get well soon.\"\n"
                                                + "2) \"I get so emotional when you're not around. That emotion is happiness.\"\n"
                                                + "3) \"GIT GUD\"\n"
                                                + "4) \"At least I survived his wrath, unlike someone else I know..." + Colors.ANSI_RESET);
        input = in.nextInt();
        do{

            if(input == 1 || input == 2 || input == 4){
                Graphics.textInline(Colors.ANSI_PURPLE + "The crowd is unimpressed.");
                Graphics.displayDeath("Dead", Colors.BLACK_BRIGHT);
                break;

            }
            else if(input == 3){

                Graphics.textInline(Colors.ANSI_PURPLE + "The crowd roars with laughter.");
                Graphics.displayWin("Yay", Colors.ANSI_YELLOW);
                counter ++;
                break;

            }
            else{
                failedInput();
            }

        }while(true);

        //If you lose
        if(counter < 3){

            Graphics.textInline(Colors.ANSI_PURPLE + "The crowd starts cheering for Fell. Clearly you lost this match.\n Fell pulls the Godmead\n \"Get absolutely stuffed!\"\n He takes a deep swig, and the crowd bunches around him cheering. You are left behind.\n");
            Graphics.displayDeath("Dead", Colors.BLACK_BRIGHT);
            Graphics.waitForEnter();

        }
        //If you win!
        else{

            Graphics.textInline(Colors.ANSI_PURPLE + "The crowd is enthusiastic over you. Fell sighs and pulls out the Godmead,\n" 
            + Colors.CYAN_BRIGHT + "\"This is for you buddy.\"\n" + Colors.ANSI_RESET
            + Colors.ANSI_GREEN + "Get absolutely stuffed!\n");
            Graphics.displayWin("Trophy", Colors.ANSI_YELLOW);
            Graphics.waitForEnter();
            Graphics.textInline(Colors.ANSI_PURPLE + "You a deep swig, and the crowd swells over you. It goes down smoothly, but you do not feel a bit intoxicated. How odd.\nYou say your farewells to Fell and continue forward.\n" + Colors.ANSI_RESET);

        }
    
    }

}
