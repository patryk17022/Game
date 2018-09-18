package pl.game.gameObjects;

import pl.game.component.CompGraphics;
import pl.game.component.CompPhysics;

import javax.swing.*;
import java.awt.*;

public class Box extends GameObject{

    public Box(Image image, int x, int y, int sizeX, int sizeY){
        AddComponent(new CompGraphics(image,x,y,sizeX,sizeY));
        AddComponent(new CompPhysics(this));
    }

    @Override
    public void Update(JFrame window) {

    }

    @Override
    public void Draw(JFrame window) {

    }
}
