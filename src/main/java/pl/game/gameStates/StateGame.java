package pl.game.gameStates;

import pl.game.gameObjects.Box;
import pl.game.gameObjects.GameObject;
import pl.game.gameObjects.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class StateGame {

    public List<GameObject> gameObjectList = new ArrayList<GameObject>();

    public StateGame() throws Exception{

        Image image = null;
        File file;
        ClassLoader classLoader = new GameStateManager().getClass().getClassLoader();
        file = new File(classLoader.getResource("Textures/Crate.png").getFile());
        image = ImageIO.read(file);

        int size = 100;
        for(int i = 0 ; i < 10 ; i++)
        {
            gameObjectList.add(new Box(image,i*size + size, 500, size, size));
        }

        gameObjectList.add(new Player(image,250, 300, 25, 25, 100)); //dodany obiekt gracza
    }

    public void Update(JFrame window) throws Exception{

        for (GameObject gameObject : gameObjectList) {
            gameObject.UpdateGameObject(window);
            gameObject.DrawGameObject(window);
        }

        Thread.sleep(16);

    }
}
