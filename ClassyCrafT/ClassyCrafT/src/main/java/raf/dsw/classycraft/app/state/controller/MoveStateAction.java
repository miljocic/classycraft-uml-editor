package raf.dsw.classycraft.app.state.controller;

import raf.dsw.classycraft.app.gui.swing.controller.AbstractClassyAction;

import java.awt.event.ActionEvent;

public class MoveStateAction extends AbstractClassyAction {

    public MoveStateAction() {

        putValue(NAME, "Move element");
        putValue(SMALL_ICON, loadIcon("/images/movestate.png"));
        putValue(SHORT_DESCRIPTION, "Move Element");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
