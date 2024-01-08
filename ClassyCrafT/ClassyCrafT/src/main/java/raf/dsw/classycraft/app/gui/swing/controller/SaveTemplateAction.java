package raf.dsw.classycraft.app.gui.swing.controller;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import raf.dsw.classycraft.app.logg.messages.ErrorType;
import raf.dsw.classycraft.app.repository.implementation.Diagram;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class SaveTemplateAction extends AbstractClassyAction {

    public SaveTemplateAction() {

        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/saveTemplate.png"));
        putValue(Action.NAME, "Save template");
        putValue(Action.SHORT_DESCRIPTION, "Save selected Diagram as template");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();
        if ((MainFrame.getInstance().getTree().getSelectedNode() == null) || !(MainFrame.getInstance().getTree().getSelectedNode().getClassyNode() instanceof Diagram)) {
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(ErrorType.SAVE_DIAGRAM_AS_TEMPLATE);
            return;
        }

        Diagram diagram = (Diagram) MainFrame.getInstance().getTree().getSelectedNode().getClassyNode();
        diagram.setTemplate(true);
        ApplicationFramework.getInstance().getSerializer().saveTemplate(diagram);
    }
}
