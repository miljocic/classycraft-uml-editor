package raf.dsw.classycraft.app.gui.swing.controller;

import lombok.Getter;
import lombok.Setter;
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
    private DeleteStateAction deleteStateAction;
    private MoveStateAction moveStateAction;
    private SelectStateAction selectStateAction;
    private ZoomStateAction zoomStateAction;


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
        deleteStateAction = new DeleteStateAction();
        moveStateAction = new MoveStateAction();
        selectStateAction = new SelectStateAction();
        zoomStateAction = new ZoomStateAction();


    }

}



