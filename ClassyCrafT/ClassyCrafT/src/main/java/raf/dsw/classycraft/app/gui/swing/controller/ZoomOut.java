package raf.dsw.classycraft.app.gui.swing.controller;

import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import raf.dsw.classycraft.app.gui.swing.view.PackageView;

import java.awt.event.ActionEvent;

public class ZoomOut extends AbstractClassyAction {

    public ZoomOut() {

        putValue(NAME, "Zoom in");
        putValue(SMALL_ICON, loadIcon("/images/zoom_minus.png"));
        putValue(SHORT_DESCRIPTION, "Zoom In");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (MainFrame.getInstance().getSplitPane().getRightComponent() instanceof PackageView) {
            PackageView packageView = (PackageView) MainFrame.getInstance().getSplitPane().getRightComponent();
            DiagramView dV = (DiagramView) packageView.getMtp().getSelectedComponent();
            dV.zoomOut();
        }
    }
}
