package pl.game.component;

import pl.game.gameObjects.GameObject;

import javax.swing.*;

public interface Component{

    void Update(JFrame window);
    void Draw(JFrame window);
    GameObject GetGameObject();
    void SetGameObject(GameObject gameObject);
}
