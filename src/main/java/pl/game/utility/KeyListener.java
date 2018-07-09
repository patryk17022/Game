package pl.game.utility;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {

    private static volatile Character[] pressed = new Character[4];


    public static synchronized boolean isKeyPressed(Character key){
        for(int i = 0 ; i < pressed.length; i++){
            if(key == pressed[i]){
                return true;
            }
        }
        return false;
    }

    public static synchronized Character[] getPressed() {
        return pressed;
    }

    @Override
    public synchronized void keyReleased(KeyEvent event) {
        for(int i = 0 ; i < pressed.length; i++)
        {
            if(pressed[i] == event.getKeyChar())
            {
                pressed[i] = null;
                return;
            }
        }
    }

    @Override
    public synchronized void keyPressed(KeyEvent event){
        for(int i = 0 ; i < pressed.length; i++)
        {
            if(pressed[i] == null || pressed[i] == event.getKeyChar())
            {
                pressed[i] = event.getKeyChar();
                return;
            }
        }
    }

    public synchronized static void clearBuffer(){
        if(pressed[0] != null) {
            for (int i = 0; i < pressed.length; i++) {
                pressed[i] = null;
            }
        }
    }
}
