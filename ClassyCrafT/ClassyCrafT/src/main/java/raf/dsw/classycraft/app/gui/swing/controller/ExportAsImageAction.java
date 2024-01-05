package raf.dsw.classycraft.app.gui.swing.controller;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import raf.dsw.classycraft.app.gui.swing.view.PackageView;
import raf.dsw.classycraft.app.logg.messages.ErrorType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class ExportAsImageAction extends AbstractClassyAction {

    public ExportAsImageAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/export.png"));
        putValue(Action.NAME, "Export as image");
        putValue(Action.SHORT_DESCRIPTION, "Export project as image");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (MainFrame.getInstance().getSplitPane().getRightComponent() instanceof PackageView) {
            PackageView packageView = (PackageView) MainFrame.getInstance().getSplitPane().getRightComponent();
            if (packageView.getMtp().getSelectedComponent() instanceof DiagramView) {
                DiagramView diagramView = (DiagramView) packageView.getMtp().getSelectedComponent();
                JFileChooser jfc = new JFileChooser();
                if (jfc.showSaveDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
                    File imageFile = jfc.getSelectedFile();
                    try {
                        diagramView.exportImage(imageFile);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        } else {
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(ErrorType.NO_DIAGRAM_TO_EXPORT_1);
        }
    }
}
