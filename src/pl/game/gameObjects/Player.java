package pl.game.gameObjects;

import pl.game.component.CompGraphics;
import pl.game.component.CompMovement;

import javax.swing.*;

public class Player extends GameObject{
    @Override
    public void Update(JFrame window) {

    }

    @Override
    public void Draw(JFrame window) {

    }

    //TODO 2: konstrukotr w kotrym dodajemy componenty (podpatrz jak w klasie Box jest dodawany CompGraphics
    public Player(int x, int y, int sizeX, int sizeY, int speed){
        AddComponent(new CompGraphics(x,y,sizeX,sizeY));
        AddComponent(new CompMovement(speed));
    }

}
