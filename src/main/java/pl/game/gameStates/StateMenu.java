package pl.game.gameStates;

import pl.game.GameEngine;
import pl.game.utility.KeyListener;
import pl.game.utility.Vector2D;

import javax.swing.*;
import java.awt.*;

public class StateMenu implements  StateComponent {

    private GameStateManager gameStateManager;

    public StateMenu(GameStateManager gsm){
        gameStateManager = gsm;
    }


    int x = 100;
    int y = 100;
    Vector2D vect;
    public int sigm(float val){
        if(val < 0)
            return -1;
        if (val > 0)
            return 1;
        return 0;
    }


    public void Update(JFrame window) throws Exception {

        Graphics2D g2d = (Graphics2D) window.getBufferStrategy().getDrawGraphics();
        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, GameEngine.getWidth(), GameEngine.getHeight());
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLUE);
        g2d.fillRect(x,y,100,100);

        if(vect == null){
            vect = KeyListener.getMousePosiiton();
        }
        if(KeyListener.getMousePosiiton().isInRectangle(x,y,100,100)){
            x-=sigm(vect.getX() - KeyListener.getMousePosiiton().getX());
            y-=sigm(vect.getY() - KeyListener.getMousePosiiton().getY());

        }else{
            vect = KeyListener.getMousePosiiton();
        }

        if(KeyListener.isMousePressed(KeyListener.MOUSE_BUTTON.LEFT) && KeyListener.getMousePosiiton().isInRectangle(x,y,100,100)){
            gameStateManager.setActualState(ActualState.GAME_STATE);
        }
    }
}
