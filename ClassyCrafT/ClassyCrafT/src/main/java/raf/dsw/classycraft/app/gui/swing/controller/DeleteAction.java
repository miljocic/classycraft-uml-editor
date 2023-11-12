package raf.dsw.classycraft.app.gui.swing.controller;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.tree.model.ClassyTreeItem;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import raf.dsw.classycraft.app.gui.swing.view.PackageView;
import raf.dsw.classycraft.app.logg.messages.ErrorType;

import raf.dsw.classycraft.app.repository.implementation.Package;
import raf.dsw.classycraft.app.repository.implementation.ProjectExplorer;

import javax.swing.*;
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

        ClassyTreeItem selected = MainFrame.getInstance().getTree().getSelectedNode();

        if (selected == null) {
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(ErrorType.NODE_NOT_SELECTED);
            return;
        }

        if (selected.getClassyNode() instanceof ProjectExplorer) {
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(ErrorType.CANNOT_DELETE_PROJECT_EXPLORER);
            return;
        }

        if (!(selected.getClassyNode() instanceof ProjectExplorer)) {
            if (selected.getClassyNode() instanceof Package) {
                Package paket = (Package) selected.getClassyNode();
                PackageView packageView = null;
                for (PackageView pv : MainFrame.getInstance().getPackageViews()) {
                    if (pv.getPaket().equals(paket)) {
                        packageView = pv;
                        break;
                    }
                }
                MainFrame.getInstance().getPackageViews().remove(packageView);
                MainFrame.getInstance().getSplitPane().setRightComponent(new JPanel());
            }

            // Remove the selected node from the tree
            MainFrame.getInstance().getTree().delete(selected);
        }
    }
}
