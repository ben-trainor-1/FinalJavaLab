package combat;

import graphics.Graphics;
import state.GameState;

public class Test {

    public static void main(String[] args) throws Exception {

        GameState.name = "Gorm";
        
        Graphics.textSpeed = 10;

        FullCombat.enemyGameState("DireWolf",110,1000,5,25,2,10,10,7,2,35);
        FullCombat.fight();

    }
    
}