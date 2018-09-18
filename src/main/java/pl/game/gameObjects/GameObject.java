package pl.game.gameObjects;

import pl.game.component.Component;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public abstract class GameObject {

    public abstract void Update(JFrame window);

    public abstract void Draw(JFrame window);

    private List<Component> components = new ArrayList<Component>();

    public void UpdateGameObject(JFrame window){
        Update(window);

        for(Component comp : components){
            comp.Update(window);
        }
    }

    public void DrawGameObject(JFrame window){
        Draw(window);

        for(Component comp : components){
            comp.Draw(window);
        }
    }



    public void AddComponent(Component comp){
        comp.SetGameObject(this);
        components.add(comp);
    }

    public <T extends Component> T GetComponent( Class<T> type){
        for(Component comp : components){

            if (type.isInstance(comp)){
                return type.cast(comp);
            }
        }
        return null;
    }

}
