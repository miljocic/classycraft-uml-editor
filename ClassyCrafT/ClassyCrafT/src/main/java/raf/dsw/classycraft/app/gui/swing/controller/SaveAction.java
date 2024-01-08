package raf.dsw.classycraft.app.gui.swing.controller;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import raf.dsw.classycraft.app.logg.messages.ErrorType;
import raf.dsw.classycraft.app.repository.implementation.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

public class SaveAction extends AbstractClassyAction {

    public SaveAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/save.png"));
        putValue(Action.NAME, "Save");
        putValue(Action.SHORT_DESCRIPTION, "Save");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JFileChooser jfc = new JFileChooser();

        if ((MainFrame.getInstance().getTree().getSelectedNode() == null) || !(MainFrame.getInstance().getTree().getSelectedNode().getClassyNode() instanceof Project)) {
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(ErrorType.ONLY_PROJECT_SERIALIZABLE);
            return;
        }

        Project project = (Project) MainFrame.getInstance().getTree().getSelectedNode().getClassyNode();
        File projectFile = null;

        if (!project.isChanged()) {
            return;
        }

        if (project.getDirectory() == null || project.getDirectory().isEmpty()) {
            if (jfc.showSaveDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
                projectFile = jfc.getSelectedFile();
                project.setDirectory(projectFile.getPath());
            } else {
                return;
            }
        }
        project.setChanged(false);
        ApplicationFramework.getInstance().getSerializer().saveProject(project);
    }

}
