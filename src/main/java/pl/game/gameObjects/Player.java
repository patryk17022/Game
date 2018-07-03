package pl.game.gameObjects;

import pl.game.component.CompGraphics;
import pl.game.component.CompMovement;

import javax.swing.*;
import java.awt.*;

public class Player extends GameObject{
    @Override
    public void Update(JFrame window) {

    }

    @Override
    public void Draw(JFrame window) {

    }

    public Player(Image img, int x, int y, int sizeX, int sizeY, int speed){
        AddComponent(new CompGraphics(img,x,y,sizeX,sizeY));
        AddComponent(new CompMovement(speed));
    }

}
