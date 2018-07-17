package pl.game.utility;

import java.util.Vector;

public class Vector2D {

    private int x = 0;
    private int y = 0;

    public Vector2D() {
    }

    public Vector2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Vector2D addX(int valueX){
        x+=valueX;

        return this;
    }

    public Vector2D addY(int valueY){
        y+=valueY;

        return this;
    }
    public Vector2D add(int valueX, int valueY){
        x+=valueX;
        y+=valueY;

        return this;
    }
    public Vector2D add(Vector2D a){
        
        this.x+=a.getX();
        this.y+=a.getY();

        return this;
    }

}
