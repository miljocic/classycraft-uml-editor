package raf.dsw.classycraft.app.state.controller;

import raf.dsw.classycraft.app.gui.swing.controller.AbstractClassyAction;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class SelectStateAction extends AbstractClassyAction {

    public SelectStateAction() {

        putValue(NAME, "Select element");
        putValue(SMALL_ICON, loadIcon("/images/selectstate.png"));
        putValue(SHORT_DESCRIPTION, "Select Element");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        MainFrame.getInstance().getWorkspace().getPackageView().startSelectState();

    }

}
