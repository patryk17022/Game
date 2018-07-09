package pl.game.utility;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class KeyListener extends KeyAdapter {

    private static volatile List<Character> pressed = new ArrayList<Character>();

    public static synchronized boolean isKeyPressed(Character key){
        for(Character elem : pressed){
            if(key == elem){
                return true;
            }
        }
        return false;
    }

    public static synchronized List<Character> getPressed() {
        return pressed;
    }

    @Override
    public synchronized void keyReleased(KeyEvent event) {

        int index = pressed.indexOf(event.getKeyChar());
        if(index >= 0)
            pressed.remove(index);

    }

    @Override
    public synchronized void keyPressed(KeyEvent event){
        for(Character elem : pressed){
            if(event.getKeyChar() == elem){
                return;
            }
        }
        pressed.add(event.getKeyChar());
    }

    public synchronized static void clearBuffer(){
        pressed.clear();
    }
}
