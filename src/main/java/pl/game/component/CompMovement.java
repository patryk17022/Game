package pl.game.component;

import pl.game.GameEngine;
import pl.game.gameObjects.GameObject;
import pl.game.utility.KeyListener;
import pl.game.utility.Vector2D;

import javax.swing.*;

public class CompMovement implements Component{

    private GameObject gameObject = null;


    private int speed;

    public void Update(JFrame window) {

        int x=0;
        int y=0;
        double delta=0;
        delta=GameEngine.deltaTime;

        x = (int) Math.round(speed * delta);
        y = (int) Math.round(speed * delta);

        CompGraphics graph = gameObject.GetComponent(CompGraphics.class);

        if(KeyListener.isKeyPressed('w')) {
            graph.getObjectPosition().addY(-y);
        }
        if(KeyListener.isKeyPressed('s')){
            graph.getObjectPosition().addY(y);
        }
        if(KeyListener.isKeyPressed('a')){
            graph.getObjectPosition().addX(-x);
        }
        if(KeyListener.isKeyPressed('d')){
            graph.getObjectPosition().addX(x);
        }



    }

    public void Draw(JFrame window) {

    }

    public GameObject GetGameObject() {
        return gameObject;
    }

    public void SetGameObject(GameObject gameObject) {
        this.gameObject=gameObject;
    }

    public CompMovement(int speed){
        this.speed=speed;
    }


}
