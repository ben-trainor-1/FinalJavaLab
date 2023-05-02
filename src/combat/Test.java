package combat;

import graphics.Graphics;
import state.GameState;

public class Test {

    public static void main(String[] args) throws Exception {

        GameState.name = "Gorm";
        
        Graphics.textSpeed = 10;
        FullCombat.enemyGameState("Reginald", 999, 100, 1, 0, 5, 100, 0);
        FullCombat.fight();

    }
    
}