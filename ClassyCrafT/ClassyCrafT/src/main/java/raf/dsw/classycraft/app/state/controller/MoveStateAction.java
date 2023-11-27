package raf.dsw.classycraft.app.state.controller;

import raf.dsw.classycraft.app.gui.swing.controller.AbstractClassyAction;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class MoveStateAction extends AbstractClassyAction {

    public MoveStateAction() {

        putValue(NAME, "Move element");
        putValue(SMALL_ICON, loadIcon("/images/movestate.png"));
        putValue(SHORT_DESCRIPTION, "Move Element");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        MainFrame.getInstance().getWorkspace().getPackageView().startMoveState();

    }

}
