package pl.game.gameStates;


import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

enum ActualState {

    EXIT(-1),
    GAME_STATE(0);

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
        states.add(new StateGame());
        actualState = ActualState.GAME_STATE;
    }

    public boolean Update(JFrame window) throws Exception
    {

        states.get(actualState.getId()).Update(window);

        if(actualState == ActualState.EXIT){
            return false;
        }
        return true;
    }

    public void setActualState(ActualState newState){
        actualState = newState;
    }

    public ActualState getActualState(){
        return actualState;
    }

}
