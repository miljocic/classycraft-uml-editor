package raf.dsw.classycraft.app.gui.swing.controller;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import raf.dsw.classycraft.app.logg.messages.ErrorType;
import raf.dsw.classycraft.app.repository.implementation.Diagram;
import raf.dsw.classycraft.app.repository.implementation.Package;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URL;
import java.util.Objects;

public class LoadTemplateAction extends AbstractClassyAction{

    public LoadTemplateAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/loadTemplate.png"));
        putValue(Action.NAME, "Load template");
        putValue(Action.SHORT_DESCRIPTION, "Load template from template Galery");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        URL templateURL = getClass().getResource(Diagram.getTemplatePath());
        if (templateURL != null) {
            JFileChooser jfc = new JFileChooser(templateURL.getPath());
            if (!(MainFrame.getInstance().getTree().getSelectedNode().getClassyNode() instanceof Package)) {
                ApplicationFramework.getInstance().getMessageGenerator().generateMessage(ErrorType.NO_PACKAGE_SELECTED);
            }
            Package aPackage = (Package) MainFrame.getInstance().getTree().getSelectedNode().getClassyNode();
            if (jfc.showOpenDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
                try {
                    File file = jfc.getSelectedFile();
                    if (file.getParent().equals(Objects.requireNonNull(getClass().getResource(Diagram.getTemplatePath())).getPath())) {
                        Diagram diagram = ApplicationFramework.getInstance().getSerializer().loadTemplate(file);
                        MainFrame.getInstance().getTree().loadTemplate(diagram);
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
    }
}
