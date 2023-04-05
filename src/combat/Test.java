package combat;

import graphics.Graphics;

public class Test {

    public static void main(String[] args) throws Exception {

        Graphics.textSpeed = 10;
        FullCombat.enemyGameState("Gullinkambi", 150, 15, 3, 0, 7, 5, 30);
        FullCombat.fight();

    }
    
}