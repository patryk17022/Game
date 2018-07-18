package pl.game.gameStates;

import pl.game.utility.KeyListener;

import javax.swing.*;

public class StateMenu implements  StateComponent {

    private GameStateManager gameStateManager;

    public StateMenu(GameStateManager gsm){
        gameStateManager = gsm;
    }

    public void Update(JFrame window) throws Exception {

        if(KeyListener.isMousePressed(KeyListener.MOUSE_BUTTON.LEFT)){
            gameStateManager.setActualState(ActualState.GAME_STATE);
        }
    }
}
