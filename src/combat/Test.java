package combat;

import graphics.Graphics;

public class Test {

    public static void main(String[] args) throws Exception {

        Graphics.textSpeed = 10;
        FullCombat.enemyGameState("Fenrir", 75, 10, 5, 0, 8, -1, 30);
        FullCombat.fight();

    }
    
}