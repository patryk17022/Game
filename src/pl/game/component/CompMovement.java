package pl.game.component;


import pl.game.gameObjects.GameObject;
import pl.game.utility.Vector2D;

import javax.swing.*;

public class CompMovement implements Component{

    private GameObject gameObject = null;
    private Vector2D vector=new Vector2D();
    private int speed;
    @Override
    public void Update(JFrame window) {
        //poruszanie się postaci
        int i=0;
        vector.addX(i++);
    }

    @Override
    public void Draw(JFrame window) {

    }

    @Override
    public GameObject GetGameObject() {
        return gameObject;
    }

    @Override
    public void SetGameObject(GameObject gameObject) {
        this.gameObject=gameObject;
    }

    public CompMovement(int speed){
        this.speed=speed;
    }

    //TODO 1: w klasie to do robimy poruszanie się postaci
    //TODO 1: zmienne x oraz y znajdują się w zmiennej position w CompGraphics ktory bedzie na pewno dołączony do gracza
    //TODO 1: aby się odwołać to trzeba zrobic tak gameObject.<CompGraphics>GetComponent() to nam zwroci CompGraphics w ktorym sa wektory
}
