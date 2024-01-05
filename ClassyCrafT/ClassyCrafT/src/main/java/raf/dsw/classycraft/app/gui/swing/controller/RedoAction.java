package raf.dsw.classycraft.app.gui.swing.controller;

import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class RedoAction extends AbstractClassyAction {

    public RedoAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/redo.png"));
        putValue(Action.NAME, "Redo Action");
        putValue(Action.SHORT_DESCRIPTION, "Redo the last action");
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        DiagramView dV = (DiagramView) MainFrame.getInstance().getWorkspace().getPackageView().
                getMtp().getSelectedComponent();
        dV.getDiagram().getCommandManager().doCommand();
        System.out.println("Redo activated");

    }
}
