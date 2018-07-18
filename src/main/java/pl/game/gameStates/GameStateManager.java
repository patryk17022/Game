package pl.game.gameStates;


import pl.game.utility.KeyListener;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

enum ActualState {

    EXIT(-1),
    MENU(0),
    GAME_STATE(1);

    private int id;

    ActualState(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }
}

public class GameStateManager{

    private List<StateComponent> states = new ArrayList<StateComponent>();
    private ActualState actualState;

    public GameStateManager() throws Exception{
        states.add(new StateMenu(this));
        states.add(new StateGame(this));

        actualState = ActualState.MENU;
    }

    public boolean Update(JFrame window) throws Exception
    {

        if(KeyListener.isKeyPressed(KeyListener.KEYBOARD_SPECIAL.ESCAPE)){
            actualState = (ActualState.EXIT);
        }

        if(actualState == ActualState.EXIT){
            return false;
        }

        states.get(actualState.getId()).Update(window);

        return true;
    }

    public void setActualState(ActualState newState){
        actualState = newState;
    }

    public ActualState getActualState(){
        return actualState;
    }

}
