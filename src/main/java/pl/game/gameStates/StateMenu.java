package pl.game.gameStates;

import pl.game.utility.KeyListener;

import javax.swing.*;
import java.awt.*;

public class StateMenu implements  StateComponent {

    private GameStateManager gameStateManager;

    public StateMenu(GameStateManager gsm){
        gameStateManager = gsm;
    }

    public void Update(JFrame window) throws Exception {

        Graphics2D g2d = (Graphics2D) window.getBufferStrategy().getDrawGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLUE);
        g2d.fillRect(100,100,100,100);

        if(KeyListener.isMousePressed(KeyListener.MOUSE_BUTTON.LEFT) && KeyListener.getMousePosiiton().isInRectangle(100,100,100,100)){
            gameStateManager.setActualState(ActualState.GAME_STATE);
        }
    }
}
