package raf.dsw.classycraft.app.state.controller;

import raf.dsw.classycraft.app.gui.swing.controller.AbstractClassyAction;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class AddStateAction extends AbstractClassyAction {

    public AddStateAction() {

        putValue(NAME, "Add element");
        putValue(SMALL_ICON, loadIcon("/images/addstate.png"));
        putValue(SHORT_DESCRIPTION, "Add Element");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        MainFrame.getInstance().getWorkspace().getPackageView().startAddState();

    }

}
