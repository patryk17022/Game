package pl.game.component;

import pl.game.gameObjects.GameObject;
import pl.game.utility.Vector2D;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class CompGraphics implements Component {

    private GameObject gameObject = null;

    private Vector2D position= new Vector2D();
    private Vector2D size = new Vector2D();

    private Image image;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public CompGraphics(Image image, int x, int y, int sizeX, int sizeY){
        position = new Vector2D(x,y);
        size = new Vector2D(sizeX,sizeY);
        this.image = image;
    }

    public CompGraphics(){

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

    public void Update(JFrame window) {

    }

    public void Draw(JFrame window) {

        Graphics2D g2d = (Graphics2D) window.getBufferStrategy().getDrawGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLUE);
        g2d.drawImage(image,position.getX(),position.getY(),size.getX(),size.getY(),null);
       // position.addX((int)(new Random().nextGaussian() * new Random().nextInt(5)));
    }

    public GameObject GetGameObject() {
        return gameObject;
    }

    public void SetGameObject(GameObject gameObject) {
        this.gameObject = gameObject;
    }
}
