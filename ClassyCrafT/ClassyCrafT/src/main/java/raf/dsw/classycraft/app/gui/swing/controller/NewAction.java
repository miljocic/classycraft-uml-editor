package raf.dsw.classycraft.app.gui.swing.controller;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.tree.ClassyTreeImplementation;
import raf.dsw.classycraft.app.gui.swing.tree.model.ClassyTreeItem;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import raf.dsw.classycraft.app.logg.messages.ErrorType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

@Getter
@Setter
public class NewAction extends AbstractClassyAction{

    public NewAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/plus.png"));
        putValue(NAME, "New Project");
        putValue(SHORT_DESCRIPTION, "New Project");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if((((ClassyTreeImplementation)MainFrame.getInstance().getTree()).getTreeView().getSelectionPath()== null)){
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage( ErrorType.NO_PROJECT_SELECTED);
            return;
        }
        ClassyTreeItem selected = (ClassyTreeItem) MainFrame.getInstance().getTree().getSelectedNode();
        MainFrame.getInstance().getTree().addChild(selected);


    }
}
