package raf.dsw.classycraft.app.state.controller;

import raf.dsw.classycraft.app.gui.swing.controller.AbstractClassyAction;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class DeleteStateAction extends AbstractClassyAction {

    public DeleteStateAction() {

        putValue(NAME, "Delete element");
        putValue(SMALL_ICON, loadIcon("/images/deletestate.png"));
        putValue(SHORT_DESCRIPTION, "Delete Element");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        MainFrame.getInstance().getWorkspace().getPackageView().startDeleteState();

    }

}
