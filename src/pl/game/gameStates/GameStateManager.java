package pl.game.gameStates;

import pl.game.gameObjects.Box;
import pl.game.gameObjects.GameObject;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class GameStateManager {

    public static List<GameObject> gameObjectList = new ArrayList<GameObject>();


    public static void main(String[] a) {
        try {
            JFrame window = new JFrame("Game");
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setSize( 1280, 720);
            //  window.getContentPane().setBackground(Color.black);
            window.setVisible(true);

            //TODO 3: dodaj obiekt gracza w sposob podony do tego nizej
            gameObjectList.add(new Box(10, 10, 200, 200));
            gameObjectList.add(new Box(400, 400, 100, 200));
            gameObjectList.add(new Box(600, 200, 100, 50));

            while (true) {

                window.createBufferStrategy(2);

                for (GameObject gameObject : gameObjectList) {
                    gameObject.UpdateGameObject(window);
                    gameObject.DrawGameObject(window);
                }

                window.getBufferStrategy().show();
                Thread.sleep(10);


            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
