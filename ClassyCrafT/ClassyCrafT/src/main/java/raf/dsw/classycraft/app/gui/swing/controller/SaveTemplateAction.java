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

public class SaveTemplateAction extends AbstractClassyAction{

    public SaveTemplateAction() {

        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/saveTemplate.png"));
        putValue(Action.NAME, "Save template");
        putValue(Action.SHORT_DESCRIPTION, "Save selected Diagram as template");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        Diagram diagram = (Diagram) MainFrame.getInstance().getTree().getSelectedNode().getClassyNode();
//        diagram.setTemplate(true);
//        ApplicationFramework.getInstance().getSerializer().saveTemplate(diagram);
        if (MainFrame.getInstance().getSplitPane().getRightComponent() instanceof PackageView){
            PackageView packageView = (PackageView) MainFrame.getInstance().getSplitPane().getRightComponent();
            if(packageView.getMtp().getSelectedComponent() instanceof DiagramView) {
                DiagramView diagramView = (DiagramView) packageView.getMtp().getSelectedComponent();
                JFileChooser jfc = new JFileChooser();
                if(jfc.showSaveDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
                    File imageFile = jfc.getSelectedFile();
                    diagramView.exportImage(imageFile);
                }
            }
        }else {
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(ErrorType.SAVE_DIAGRAM_AS_TEMPLATE);
        }
    }
}
