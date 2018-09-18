package pl.game.gameStates;

import pl.game.GameEngine;
import pl.game.component.CompPhysics;
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
      /*  for(int i = 0 ; i < 10 ; i++)
        {
            gameObjectList.add(new Box(ResourceManager.getTexture("Crate"),i*size + size, 500, size, size));
        }*/

       // gameObjectList.add(new Box(ResourceManager.getTexture("Crate"),0*size + size, 250, size, size));

       // gameObjectList.get(gameObjectList.size()-1).GetComponent(CompPhysics.class).addVelocity(5,0);

        gameObjectList.add(new Box(ResourceManager.getTexture("Crate"),10*size + size, 250, size, size));

        gameObjectList.get(gameObjectList.size()-1).GetComponent(CompPhysics.class).addVelocity(-10,0);

        gameObjectList.add(new Box(ResourceManager.getTexture("Crate"),13*size + size, 250, size, size));

        gameObjectList.add(new Box(ResourceManager.getTexture("Crate"),4*size + size, 0, size, size));
        gameObjectList.add(new Box(ResourceManager.getTexture("Crate"),4*size + size, size, size, size));
        gameObjectList.add(new Box(ResourceManager.getTexture("Crate"),4*size + size, 2*size, size, size));

  //      gameObjectList.add(new Player(ResourceManager.getTexture("Player"),250, 300, 100, 100, 100)); //dodany obiekt gracza
    }

    public void CheckCollisions(){

        for(GameObject ga1 : gameObjectList){
            CompPhysics ph1 = ga1.GetComponent(CompPhysics.class);
            ph1.clearCollision();
            for(GameObject ga2 : gameObjectList){
                if(ga1 != ga2) {
                    CompPhysics ph2 = ga2.GetComponent(CompPhysics.class);
                    if(ph1.isCollision(ph2))
                        ph1.collisionList.add(ga2);
                }
            }
        }
    }

    public void Update(JFrame window) throws Exception{

        Graphics graph = window.getBufferStrategy().getDrawGraphics();
        graph.setColor(Color.black);
        graph.fillRect(0, 0, GameEngine.getWidth(), GameEngine.getHeight());


        for (GameObject gameObject : gameObjectList) {
            gameObject.UpdateGameObject(window);
            gameObject.DrawGameObject(window);
        }

        CheckCollisions();

        Thread.sleep(16);

    }
}
