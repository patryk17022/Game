package pl.game.component;

import pl.game.GameEngine;
import pl.game.gameObjects.GameObject;
import pl.game.utility.KeyListener;
import pl.game.utility.Vector2D;

import javax.swing.*;
import java.util.Vector;

public class CompMovement implements Component{

    private GameObject gameObject = null;


    Vector2D velocity=new Vector2D();
    private int speed;
    private int maxSpeed;

    public void constSpeed(){

        double delta=0;
        delta=GameEngine.deltaTime;

        velocity.setX((int) Math.round(speed * delta));
        velocity.setY((int) Math.round(speed * delta));
    }

    public void accelerationSpeed(){
        double delta=0;
        delta=GameEngine.deltaTime;

        velocity.setX((int) Math.round(speed * delta + velocity.getX()));
        velocity.setY((int) Math.round(speed * delta + velocity.getY()));
    }

    public void accelerationSlow(){
        double delta=0;
        delta=GameEngine.deltaTime;

        velocity.setX((int) Math.round(speed * delta - velocity.getX()));
        velocity.setY((int) Math.round(speed * delta - velocity.getY()));
    }

    public void slowChange(){
        constSpeed();

        int movement = (int)(speed*GameEngine.deltaTime);

        if(KeyListener.isKeyPressed('w')){
            velocity.setY(-movement);
        }

        if(KeyListener.isKeyPressed('s')){
            velocity.setY(movement);
        }

        if(KeyListener.isKeyPressed('a')){
            velocity.setX(-movement);
        }

        if(KeyListener.isKeyPressed('d')){
            velocity.setX(movement);
        }

        gameObject.<CompGraphics>GetComponent().getObjectPosition().add(velocity.getX(),velocity.getY());
    }

    public void fastChange(){

           accelerationSpeed();
        int movement = (int)(speed*GameEngine.deltaTime);

        if(KeyListener.isKeyPressed('w')){
            velocity.setY(-movement);
        }

        if(KeyListener.isKeyPressed('s')){
            velocity.setY(movement);
        }

        if(KeyListener.isKeyPressed('a')){
            velocity.setX(-movement);
        }

        if(KeyListener.isKeyPressed('d')){
            velocity.setX(movement);
        }

        /*
        * zwolnienie

        if(KeyListener.isKeyPressed('w')){
            velocity.setY(-movement+2);
        }

        if(KeyListener.isKeyPressed('s')){
            velocity.setY(movement-2);
        }

        if(KeyListener.isKeyPressed('a')){
            velocity.setX(-movement+2);
        }

        if(KeyListener.isKeyPressed('d')){
            velocity.setX(movement-2);
        }

        * */
        gameObject.<CompGraphics>GetComponent().getObjectPosition().add(velocity.getX(),velocity.getY());

    }

    public void Update(JFrame window) {

       // slowChange();
        fastChange();

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
