package raf.dsw.classycraft.app.state;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.state.model.*;
@Getter
@Setter
public class StateManager {

    private State current;
    private AddState addState;
    private DeleteState deleteState;
    private SelectState selectState;
    private MoveState moveState;
    private ZoomState zoomState;


    public StateManager() {

        addState = new AddState();
        deleteState = new DeleteState();
        moveState = new MoveState();
        zoomState = new ZoomState();

    }

}
