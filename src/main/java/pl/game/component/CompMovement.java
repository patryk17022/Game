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

        if(KeyListener.isKeyPressed('w')) {
            gameObject.<CompGraphics>GetComponent().getObjectPosition().addY(-velocity.getY());
        }
        if(KeyListener.isKeyPressed('s')){
            gameObject.<CompGraphics>GetComponent().getObjectPosition().addY(velocity.getY());
        }
        if(KeyListener.isKeyPressed('a')){
            gameObject.<CompGraphics>GetComponent().getObjectPosition().addX(-velocity.getX());
        }
        if(KeyListener.isKeyPressed('d')){
            gameObject.<CompGraphics>GetComponent().getObjectPosition().addX(velocity.getX());
        }
    }

    public void fastChange(){

        int i=0;
        if(i<2){
           accelerationSpeed();
           i++;
        } else {
            accelerationSlow();
        }

        if(KeyListener.isKeyPressed('w')) {
            gameObject.<CompGraphics>GetComponent().getObjectPosition().addY(-velocity.getY());
        }
        if(KeyListener.isKeyPressed('s')){
            gameObject.<CompGraphics>GetComponent().getObjectPosition().addY(velocity.getY());
        }
        if(KeyListener.isKeyPressed('a')){
            gameObject.<CompGraphics>GetComponent().getObjectPosition().addX(-velocity.getX());
        }
        if(KeyListener.isKeyPressed('d')){
            gameObject.<CompGraphics>GetComponent().getObjectPosition().addX(velocity.getX());
        }
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
