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
    private ZoomInState zoomInState;
    private ConnectState connectState;
    private EditState editState;


    public StateManager() {

        addState = new AddState();
        deleteState = new DeleteState();
        moveState = new MoveState();
        selectState = new SelectState();
        connectState = new ConnectState();
        editState = new EditState();
        current = addState;


    }

    public void setAddState() {
        current = this.addState;
    }
    public void setEditState(){current = this.editState;}
    public void setDeleteState() {
        current = this.deleteState;
    }
    public void setSelectState() {
        current = this.selectState;
    }
    public void setZoomInState(){
        current = this.zoomInState;
    }
    public void setMoveState() {
        current = this.moveState;
    }

    public void setConnectState(){current = this.connectState;}

}
