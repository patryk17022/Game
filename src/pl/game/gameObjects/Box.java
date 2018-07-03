package pl.game.gameObjects;

import pl.game.component.CompGraphics;

import javax.swing.*;

public class Box extends GameObject{

    public Box(int x, int y, int sizeX, int sizeY){
        AddComponent(new CompGraphics(x,y,sizeX,sizeY));
    }

    @Override
    public void Update(JFrame window) {

    }

    @Override
    public void Draw(JFrame window) {

    }
}
