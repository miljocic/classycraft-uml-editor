package raf.dsw.classycraft.app.gui.swing.controller;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.state.StateMouseManager;
import raf.dsw.classycraft.app.state.controller.*;

@Getter
@Setter

public class ActionManager {

    private ExitAction exitAction;
    private NewAction newAction;
    private AboutUsAction aboutUsAction;
    private DeleteAction deleteAction;
    private AuthorAction authorAction;
    private MyMouseListener myMouseListener;
    private AddStateAction addStateAction;
    private EditStateAction editStateAction;
    private DeleteStateAction deleteStateAction;
    private MoveStateAction moveStateAction;
    private SelectStateAction selectStateAction;

    private StateMouseManager stateMouseManager;
    private ConnectStateAction connectStateAction;

    private ZoomIn zoomInAction;
    private ZoomOut zoomOutAction;


    public ActionManager() {
        initialiseActions();
    }

    private void initialiseActions(){

        exitAction = new ExitAction();
        newAction = new NewAction();
        aboutUsAction = new AboutUsAction();
        deleteAction = new DeleteAction();
        authorAction = new AuthorAction();
        myMouseListener = new MyMouseListener();

        addStateAction = new AddStateAction();
        editStateAction = new EditStateAction();
        deleteStateAction = new DeleteStateAction();
        moveStateAction = new MoveStateAction();
        selectStateAction = new SelectStateAction();
        stateMouseManager = new StateMouseManager();
        connectStateAction = new ConnectStateAction();

        zoomInAction = new ZoomIn();
        zoomOutAction = new ZoomOut();


    }

}



