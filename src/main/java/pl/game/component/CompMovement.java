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

        if(KeyListener.isKeyPressed('w')) {
            gameObject.<CompGraphics>GetComponent().getObjectPosition().addY(-y);
        }
        if(KeyListener.isKeyPressed('s')){
            gameObject.<CompGraphics>GetComponent().getObjectPosition().addY(y);
        }
        if(KeyListener.isKeyPressed('a')){
            gameObject.<CompGraphics>GetComponent().getObjectPosition().addX(-x);
        }
        if(KeyListener.isKeyPressed('d')){
            gameObject.<CompGraphics>GetComponent().getObjectPosition().addX(x);
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
