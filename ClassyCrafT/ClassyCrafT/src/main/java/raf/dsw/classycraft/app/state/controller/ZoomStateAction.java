package raf.dsw.classycraft.app.state.controller;

import raf.dsw.classycraft.app.gui.swing.controller.AbstractClassyAction;

import java.awt.event.ActionEvent;

public class ZoomStateAction extends AbstractClassyAction {

    public ZoomStateAction() {

        putValue(NAME, "Zoom element");
        putValue(SMALL_ICON, loadIcon("/images/zoomstate.png"));
        putValue(SHORT_DESCRIPTION, "Zoom Element");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
