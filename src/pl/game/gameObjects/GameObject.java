package pl.game.gameObjects;

import pl.game.component.Component;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public abstract class GameObject {

    public abstract void Update(JFrame window);

    public abstract void Draw(JFrame window);

    private List<Component> components = new ArrayList<Component>();

    protected void UpdateGameObject(JFrame window){
        Update(window);

        for(Component comp : components){
            comp.Update(window);
        }
    }

    protected void DrawGameObject(JFrame window){
        Draw(window);

        for(Component comp : components){
            comp.Draw(window);
        }
    }

    public List<Component> getComponents() {
        return components;
    }

    public void AddComponent(Component comp){
        comp.SetGameObject(this);
        components.add(comp);
    }

    public <T> T GetComponent(){
        for(Component comp : components){
            if (((T)comp) != null){
                return (T)comp;
            }
        }
        return null;
    }
}
