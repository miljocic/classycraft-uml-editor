package raf.dsw.classycraft.app.gui.swing.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ActionManager {

    private ExitAction exitAction;
    private NewAction newAction;
    private AboutUsAction aboutUsAction;
    private DeleteAction deleteAction;
    private AuthorAction authorAction;
    private MyMouseListener myMouseListener;

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


    }

}



