package pl.game.component;

import pl.game.gameObjects.GameObject;
import pl.game.utility.Vector2D;

import javax.swing.*;
import java.awt.*;



public class CompGraphics extends JComponent implements Component {

    GameObject gameObject = null;

    Vector2D position= new Vector2D();
    Vector2D size = new Vector2D();

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
        window.getContentPane().add(this);
    }

    public void paint(Graphics g) {
        g.drawRect (position.getX(), position.getY(), size.getX(), size.getY());
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
