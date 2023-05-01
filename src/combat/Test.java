package combat;

import graphics.Graphics;

public class Test {

    public static void main(String[] args) throws Exception {

        Graphics.textSpeed = 10;
        FullCombat.enemyGameState("Reginald", 999, 100, 1, 0, 5, 100, 0);
        FullCombat.fight();

    }
    
}