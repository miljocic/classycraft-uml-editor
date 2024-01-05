package raf.dsw.classycraft.app.gui.swing.controller;

import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class UndoAction extends AbstractClassyAction {

    public UndoAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/undo.png"));
        putValue(Action.NAME, "Undo Action");
        putValue(Action.SHORT_DESCRIPTION, "Undo the last action");
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        DiagramView dV = (DiagramView) MainFrame.getInstance().getWorkspace().
                getPackageView().getMtp().getSelectedComponent();
        dV.getDiagram().getCommandManager().undoCommand();
        System.out.println("Undo activated");

    }
}
