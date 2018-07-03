package pl.game.gameStates;

import pl.game.gameObjects.Box;
import pl.game.gameObjects.GameObject;
import pl.game.utility.KeyListerner;
import pl.game.gameObjects.Player;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class GameStateManager {

    public static List<GameObject> gameObjectList = new ArrayList<GameObject>();

    public static void main(String[] a) {
        try {
            JFrame window = new JFrame("Game");
            window.addKeyListener(new KeyListerner());
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setSize( 1280, 720);
            //  window.getContentPane().setBackground(Color.black);
            window.setVisible(true);

            Image image =null;
            File file;
            ClassLoader classLoader = new GameStateManager().getClass().getClassLoader();
            file = new File(classLoader.getResource("Textures/Crate.png").getFile());
            image = ImageIO.read(file);

            int size = 100;
            for(int i = 0 ; i < 10 ; i++)
            {
                gameObjectList.add(new Box(image,i*size + size, 500, size, size));
            }

            gameObjectList.add(new Player(image,250, 300, 25, 25, 10)); //dodany obiekt gracza

            while (true) {

                KeyListerner.clearBuffer();
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
