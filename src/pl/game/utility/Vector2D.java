package pl.game.utility;

public class Vector2D {

    int x = 0;
    int y = 0;

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


    //TODO: Metoda dodawania do wektora liczby oraz wektora
    //TODO: czli metody addX, addY, add

    public Vector2D addX(int valueX){
        x+=valueX;

        return this;
    }

    public Vector2D addY(int valueY){
        y+=valueY;

        return this;
    }
    public Vector2D addX_Y(int valueX, int valueY){
        x+=valueX;
        y+=valueY;

        return this;
    }



}
