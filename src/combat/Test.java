package combat;

import graphics.Graphics;
import state.GameState;

public class Test {

    public static void main(String[] args) throws Exception {

        GameState.name = "Gorm";
        
        Graphics.textSpeed = 10;
        FullCombat.enemyGameState("Reginald", 30,150,1,50,0,5,0,1,0);
        FullCombat.fight();

    }
    
}