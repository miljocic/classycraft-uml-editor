package raf.dsw.classycraft.app.gui.swing.controller;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.tree.model.ClassyTreeItem;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import raf.dsw.classycraft.app.logg.messages.ErrorType;
import raf.dsw.classycraft.app.repository.implementation.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AuthorAction extends AbstractClassyAction{

    public AuthorAction() {
        putValue(NAME, "Author");
        putValue(SMALL_ICON, loadIcon("/pencil.png"));
        putValue(SHORT_DESCRIPTION, "Change project author");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ClassyTreeItem selected = MainFrame.getInstance().getTree().getSelectedNode();
        if(selected == null) {
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(ErrorType.NODE_NOT_SELECTED);
            return;
        }

        if(selected.getClassyNode() instanceof Project){
            String newAuthor = JOptionPane.showInputDialog("Enter author name:");
            ((Project)selected.getClassyNode()).setAuthor(newAuthor);
        }

    }




}
