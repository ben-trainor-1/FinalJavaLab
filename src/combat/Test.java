package combat;

public class Test {

    public static void main(String[] args) throws Exception {

        // Graphics.displayCharacter("Gullinkambi", 500);

        // FullCombat.fight("Gullinkambi", 500, 30, 0, 10, 3);

        FullCombat.enemyGameState("Gullinkambi", 300, 30, 4, 0, 10, 4, 30);
        FullCombat.fight();

    }
    
}