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
        //TODO 1: zmienne x oraz y znajdują się w zmiennej position w CompGraphics ktory bedzie na pewno dołączony do gracza
        //TODO 1: aby się odwołać to trzeba zrobic tak gameObject.<CompGraphics>GetComponent() to nam zwroci CompGraphics w ktorym sa wektory
        //TODO 1: i do nich dodajemy te wartosci o ile chcemy sie przesunac plus warto pomnozyc predkosc przed deltaTime (poczytaj co to jest jak nie to ci powiem
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
