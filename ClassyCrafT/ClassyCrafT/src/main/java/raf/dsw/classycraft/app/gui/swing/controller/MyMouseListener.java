package raf.dsw.classycraft.app.gui.swing.controller;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import raf.dsw.classycraft.app.gui.swing.view.PackageView;
import raf.dsw.classycraft.app.repository.implementation.Package;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@Getter
@Setter
public class MyMouseListener implements MouseListener{


    @Override
    public void mouseClicked(MouseEvent e) {

        if(e.getClickCount() == 2){
            System.out.println("Detektovao");
            if(MainFrame.getInstance().getTree().getSelectedNode().getClassyNode() instanceof Package){
                PackageView pv = MainFrame.getInstance().getWorkspace().generateWorkspace();
                MainFrame.getInstance().getSplitPane().setRightComponent(pv);
            } /*
            else if(MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() instanceof MindMap){
                if(MainFrame.getInstance().getSplit().getRightComponent() instanceof ProjectView) {
                    ProjectView pv = (ProjectView) MainFrame.getInstance().getSplit().getRightComponent();
                    MapView mv = new MapView((MindMap) MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode());
                    JTabbedPane tabbedPane = pv.getMapsTabbedPane();
                    tabbedPane.addTab(mv.getMindMap().getName(), mv);
                }
            } */
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