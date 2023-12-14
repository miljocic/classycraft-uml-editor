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
    private ConnectState connectState;
    private EditState editState;

    private MoveDiagramState moveDiagramState;

    public StateManager() {

        addState = new AddState();
        deleteState = new DeleteState();
        moveState = new MoveState();
        selectState = new SelectState();
        connectState = new ConnectState();
        editState = new EditState();
        moveDiagramState = new MoveDiagramState();
        current = addState;


    }

    public void setAddState() {
        current = this.addState;
        System.out.println("Current State: AddState");
    }
    public void setEditState(){current = this.editState;}
    public void setDeleteState() {
        current = this.deleteState;
    }
    public void setSelectState() {
        current = this.selectState;
    }

    public void setMoveState() {
        current = this.moveState;
    }

    public void setConnectState(){current = this.connectState;}
    public void setMoveDiagramState(){current = this.moveDiagramState;}

    public void setCurrent(State current) {
        this.current = current;
    }

}
