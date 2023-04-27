package combat;

import graphics.Graphics;

public class Test {

    public static void main(String[] args) throws Exception {

        Graphics.textSpeed = 10;
        FullCombat.enemyGameState("Fenrir", 125, 20, 5, 0, 8, -1, 40);
        FullCombat.fight();

    }
    
}