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

    public ActionManager() {
        initialiseActions();
    }

    private void initialiseActions(){

        exitAction = new ExitAction();
        newAction = new NewAction();
        aboutUsAction = new AboutUsAction();
        deleteAction = new DeleteAction();


    }

}



