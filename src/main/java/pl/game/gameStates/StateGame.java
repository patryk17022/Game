package pl.game.gameStates;

import pl.game.GameEngine;
import pl.game.gameObjects.Box;
import pl.game.gameObjects.GameObject;
import pl.game.gameObjects.Player;
import pl.game.utility.ResourceManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class StateGame implements StateComponent{

    public List<GameObject> gameObjectList = new ArrayList<GameObject>();

    private GameStateManager gameStateManager;


    public StateGame(GameStateManager gsm) throws Exception{
        gameStateManager = gsm;

        int size = 100;
        for(int i = 0 ; i < 10 ; i++)
        {
            gameObjectList.add(new Box(ResourceManager.getTexture("Crate"),i*size + size, 500, size, size));
        }


        gameObjectList.add(new Player(ResourceManager.getTexture("Player"),250, 300, 100, 100, 100)); //dodany obiekt gracza
    }

    public void Update(JFrame window) throws Exception{

        Graphics graph = window.getBufferStrategy().getDrawGraphics();
        graph.setColor(Color.black);
        graph.fillRect(0, 0, GameEngine.getWidth(), GameEngine.getHeight());

        for (GameObject gameObject : gameObjectList) {
            gameObject.UpdateGameObject(window);
            gameObject.DrawGameObject(window);
        }

        Thread.sleep(16);

    }
}
