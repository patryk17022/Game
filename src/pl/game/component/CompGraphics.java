package pl.game.component;

import pl.game.gameObjects.GameObject;
import pl.game.utility.Vector2D;

import javax.swing.*;
import java.awt.*;

public class CompGraphics implements Component {

    GameObject gameObject = null;


    private Vector2D position= new Vector2D();
    private Vector2D size = new Vector2D();


    public CompGraphics(int x, int y, int sizeX, int sizeY){
        position = new Vector2D(x,y);
        size = new Vector2D(sizeX,sizeY);
    }

    public CompGraphics(){

    }

    public Vector2D getPosition() {
        return position;
    }

    public void setPosition(Vector2D position) {
        this.position = position;
    }

    public Vector2D getSize() {
        return size;
    }

    public void setSize(Vector2D size) {
        this.size = size;
    }

    public Vector2D getObjectPosition() {

        return position;
    }

    public void setObjectPosition(Vector2D position) {
        this.position = position;
    }

    public Vector2D getObjectSize() {
        return size;
    }

    public void setObjectSize(Vector2D size) {
        this.size = size;
    }

    @Override
    public void Update(JFrame window) {

    }

    @Override
    public void Draw(JFrame window) {

        Graphics2D g2d = (Graphics2D) window.getBufferStrategy().getDrawGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLUE);
        g2d.fillRect(position.getX(), position.getY(), size.getX(), size.getY());
    }


    @Override
    public GameObject GetGameObject() {
        return gameObject;
    }

    @Override
    public void SetGameObject(GameObject gameObject) {
        this.gameObject = gameObject;
    }
}
