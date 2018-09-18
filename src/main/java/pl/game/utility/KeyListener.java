package pl.game.utility;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.sun.scenario.effect.impl.sw.sse.SSEBrightpassPeer;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyListener extends KeyAdapter implements MouseListener, MouseMotionListener {

    private static volatile List<Character> pressed = new ArrayList<Character>();

    private static volatile Map<MOUSE_BUTTON,Boolean> mousePressed = new HashMap<MOUSE_BUTTON, Boolean>();

    private static volatile  Vector2D mousePosiiton = new Vector2D();

    public void mouseDragged(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {

        mousePosiiton = new Vector2D(e.getX(),e.getY());
    }

    public enum MOUSE_BUTTON{
        LEFT,
        RIGHT
    }

    public enum KEYBOARD_SPECIAL{
        ESCAPE(27);

        private int value;
        KEYBOARD_SPECIAL(int val){
            value = val;
        }

        public int get(){
            return value;
        }
    }

    public static synchronized boolean isKeyPressed(Character key){
        for(Character elem : pressed){
            if(key == elem){
                return true;
            }
        }
        return false;
    }

    public static synchronized boolean isKeyPressed(KEYBOARD_SPECIAL key){
        return isKeyPressed((char)key.get());
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

    public static Boolean isMousePressed(MOUSE_BUTTON btn){
        if(mousePressed.containsKey(btn))
            return mousePressed.get(btn);
        else
            return false;
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        if(e.getButton()== MouseEvent.BUTTON1)
        {
            mousePressed.put(MOUSE_BUTTON.LEFT,true);
        }else  if(e.getButton()== MouseEvent.BUTTON2) {
            mousePressed.put(MOUSE_BUTTON.RIGHT, true);
        }

    }

    public static Vector2D getMousePosiiton(){
        return  mousePosiiton;
    }

    public void mouseReleased(MouseEvent e) {
        if(e.getButton()== MouseEvent.BUTTON1)
        {
            mousePressed.put(MOUSE_BUTTON.LEFT,false);
        }else  if(e.getButton()== MouseEvent.BUTTON2) {
            mousePressed.put(MOUSE_BUTTON.RIGHT, false);
        }
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}
