package raf.dsw.classycraft.app.gui.swing.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ActionManager {

    private ExitAction exitAction;
    private NewProjectAction newProjectAction;
    private AboutUsAction aboutUsAction;

    public ActionManager() {
        initialiseActions();
    }

    private void initialiseActions(){

        exitAction = new ExitAction();
        newProjectAction = new NewProjectAction();
        aboutUsAction = new AboutUsAction();



    }

}



