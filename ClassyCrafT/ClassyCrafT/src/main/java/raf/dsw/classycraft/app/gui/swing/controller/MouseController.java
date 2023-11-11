package raf.dsw.classycraft.app.gui.swing.controller;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import raf.dsw.classycraft.app.gui.swing.view.PackageView;
import raf.dsw.classycraft.app.repository.implementation.Package;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@Getter
@Setter
public class MouseController implements MouseListener{

    private DiagramView diagramView;

    public MouseController(DiagramView mapView) {
        this.diagramView = mapView;
    }



    @Override
    public void mouseClicked(MouseEvent e) {

        if(e.getButton() != MouseEvent.BUTTON1) return;
        if(e.getClickCount()==3){
            if(MainFrame.getInstance().getTree().getSelectedNode() != null &&
                    MainFrame.getInstance().getTree().getSelectedNode().getClassyNode() != null){
                if(MainFrame.getInstance().getTree().getSelectedNode().getClassyNode() instanceof Package) {
                    for (PackageView pv : MainFrame.getInstance().getPackageViewList()) {
                        if (pv.getPaket().equals(MainFrame.getInstance().getTree().getSelectedNode().getClassyNode())) {
                            MainFrame.getInstance().getSplitPane().setRightComponent(pv);
                            return;
                        }
                    }
                    PackageView pv = MainFrame.getInstance().getWorkspace().generateWorkspace();
                    MainFrame.getInstance().getPackageViewList().add(pv);
                    MainFrame.getInstance().getSplitPane().setRightComponent(pv);
                }
            }
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
