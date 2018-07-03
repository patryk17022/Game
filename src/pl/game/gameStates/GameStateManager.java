package pl.game.gameStates;

import pl.game.gameObjects.GameObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class GameStateManager {

    public static List<GameObject> gameObjectList = new ArrayList<GameObject>();


    public static void main(String[] a) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(10, 10, 1280,720);
        window.getContentPane().setBackground(Color.black);
        window.setVisible(true);



        while(true) {



            for(GameObject gameObject : gameObjectList){
                gameObject.Update(window);
                gameObject.Draw(window);
            }

            window.repaint();


        }
    }
}
