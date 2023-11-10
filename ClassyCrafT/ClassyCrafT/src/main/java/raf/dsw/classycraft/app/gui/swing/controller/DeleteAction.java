package raf.dsw.classycraft.app.gui.swing.controller;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.tree.ClassyTreeImplementation;
import raf.dsw.classycraft.app.gui.swing.tree.model.ClassyTreeItem;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import raf.dsw.classycraft.app.logg.messages.ErrorType;
import raf.dsw.classycraft.app.repository.implementation.ProjectExplorer;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class DeleteAction extends AbstractClassyAction{

    public DeleteAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/delete.png"));
        putValue(NAME, "Delete");
        putValue(SHORT_DESCRIPTION, "Delete");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        if((((ClassyTreeImplementation)MainFrame.getInstance().getTree()).getTreeView().getSelectionPath()== null)){
//            ApplicationFramework.getInstance().getMessageGenerator().generateMessage( ErrorType.COMPONENT_NOT_SELECTED);
//            return;
//        }
//
//        DefaultMutableTreeNode selectedNode= (DefaultMutableTreeNode) MainFrame.getInstance().getProjectExplorer().getSelectionPath().getLastPathComponent();
//        DefaultTreeModel model = ( DefaultTreeModel) MainFrame.getInstance().getProjectExplorer().getModel();
//        model.removeNodeFromParent(selectedNode);
        ClassyTreeItem selected = MainFrame.getInstance().getTree().getSelectedNode();

        if (selected == null){
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(ErrorType.COMPONENT_NOT_SELECTED);
            return;
        }

        if (selected.getClassyNode() instanceof ProjectExplorer) {

            ApplicationFramework.getInstance().
                    getMessageGenerator().generateMessage(ErrorType.CANNOT_DELETE_PROJECT_EXPLORER);
            return;
        }
        MainFrame.getInstance().getTree().delete(selected);
    }
}
