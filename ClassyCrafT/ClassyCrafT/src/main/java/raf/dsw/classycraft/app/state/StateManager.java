package raf.dsw.classycraft.app.state;

import lombok.Getter;

import raf.dsw.classycraft.app.state.model.*;
@Getter

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
        selectState = new SelectState();
        zoomState = new ZoomState();
        current = addState;

    }

    /*
    ne rade setteri nzm zasto?
     */
    public void setAddState() {
        current = this.addState;
    }
    public void setDeleteState() {
        current = this.deleteState;
    }
    public void setSelectState() {
        current = this.selectState;
    }
    public void setMoveState() {
        current = this.moveState;
    }
    public void setZoomState() {
        current = this.zoomState;
    }

}
