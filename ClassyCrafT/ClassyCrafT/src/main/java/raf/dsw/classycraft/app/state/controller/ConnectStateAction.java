package raf.dsw.classycraft.app.state.controller;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.controller.AbstractClassyAction;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import raf.dsw.classycraft.app.gui.swing.view.PackageView;
import raf.dsw.classycraft.app.logg.messages.ErrorType;

import java.awt.event.ActionEvent;

public class ConnectStateAction extends AbstractClassyAction {

    public ConnectStateAction() {

        putValue(NAME, "Connect element");
        putValue(SMALL_ICON, loadIcon("/images/connectionstate.png"));
        putValue(SHORT_DESCRIPTION, "Connect element");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (MainFrame.getInstance().getSplitPane().getRightComponent() instanceof PackageView){
            MainFrame.getInstance().getWorkspace().getPackageView().startConnectState();
        }else {
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(ErrorType.NO_DIAGRAM_VIEW_SELECTED);
        }
    }
}
