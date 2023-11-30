package raf.dsw.classycraft.app.state.controller;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.controller.AbstractClassyAction;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import raf.dsw.classycraft.app.gui.swing.view.PackageView;
import raf.dsw.classycraft.app.logg.messages.ErrorType;

import java.awt.event.ActionEvent;

public class MoveStateAction extends AbstractClassyAction {

    public MoveStateAction() {

        putValue(NAME, "Move element");
        putValue(SMALL_ICON, loadIcon("/images/movestate.png"));
        putValue(SHORT_DESCRIPTION, "Move Element");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (MainFrame.getInstance().getSplitPane().getRightComponent() instanceof PackageView){
            MainFrame.getInstance().getWorkspace().getPackageView().startMoveState();
        }else {
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(ErrorType.NO_DIAGRAM_VIEW_SELECTED);
        }


    }

}
