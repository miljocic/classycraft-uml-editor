package raf.dsw.classycraft.app.gui.swing.controller;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.tree.model.ClassyTreeItem;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import raf.dsw.classycraft.app.logg.messages.ErrorType;
import raf.dsw.classycraft.app.repository.composite.ClassyNodeComposite;
import raf.dsw.classycraft.app.repository.implementation.Diagram;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

@Getter
@Setter
public class NewAction extends AbstractClassyAction{

    public NewAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/addproject.png"));
        putValue(NAME, "New Action");
        putValue(SHORT_DESCRIPTION, "New Project/Package/Diagram/DiagramElement");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(MainFrame.getInstance().getTree().getSelectedNode() == null ) {
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(ErrorType.NODE_NOT_SELECTED);
        }
        else if(MainFrame.getInstance().getTree().getSelectedNode().getClassyNode() instanceof ClassyNodeComposite) {
            if(MainFrame.getInstance().getTree().getSelectedNode().getClassyNode() instanceof Diagram) {
                ApplicationFramework.getInstance().getMessageGenerator().generateMessage(ErrorType.CANNOT_ADD_HERE);
                return;
            }
            MainFrame.getInstance().getTree().addChild(MainFrame.getInstance().getTree().getSelectedNode());
        }
        else {
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(ErrorType.NODE_NOT_COMPOSITE);
        }


    }
}
