package raf.dsw.classycraft.app.gui.swing.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ActionManager {

    private ExitAction exitAction;

    public ActionManager() {
        initialiseActions();
    }

    private void initialiseActions(){
    exitAction = new ExitAction();

    }

}



