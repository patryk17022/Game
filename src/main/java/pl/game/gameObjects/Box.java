package pl.game.gameObjects;

import pl.game.component.CompGraphics;

import javax.swing.*;
import java.awt.*;

public class Box extends GameObject{

    public Box(Image image, int x, int y, int sizeX, int sizeY){
        AddComponent(new CompGraphics(image,x,y,sizeX,sizeY));
    }

    @Override
    public void Update(JFrame window) {

    }

    @Override
    public void Draw(JFrame window) {

    }
}
