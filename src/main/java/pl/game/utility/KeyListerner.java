package pl.game.utility;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class KeyListerner extends KeyAdapter {

    private static List<Character> pressed = new ArrayList<Character>();

    public static boolean isKeyPressed(char key){
        for(char pres : pressed){
            if(key == pres){
                return true;
            }
        }
        return false;
    }

    public static List<Character> getPressed() {
        return pressed;
    }

    @Override
    public void keyPressed(KeyEvent event){
        pressed.add(event.getKeyChar());
    }

    public static void clearBuffer(){
        pressed.clear();
    }
}
