package combat;

import graphics.Graphics;
import state.GameState;

public class Test {

    public static void main(String[] args) throws Exception {

        GameState.name = "Gorm";
        
        Graphics.textSpeed = 10;

        FullCombat.enemyGameState("Dwarf",10,0,4,20,2,6,25,4,2,50);
        FullCombat.fight();

    }
    
}