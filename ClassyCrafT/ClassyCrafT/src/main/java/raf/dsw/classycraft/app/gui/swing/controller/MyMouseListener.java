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

//        if(e.getClickCount() == 2){
//            System.out.println("Detektovao");
//            if(MainFrame.getInstance().getTree().getSelectedNode().getClassyNode() instanceof Package){
//                PackageView pv = MainFrame.getInstance().getWorkspace().generateWorkspace();
//                MainFrame.getInstance().getSplitPane().setRightComponent(pv);
//            }
//        }

        if(e.getButton() != MouseEvent.BUTTON1) return;
        if(e.getClickCount() == 2){
            if(MainFrame.getInstance().getTree().getSelectedNode() != null &&
                    MainFrame.getInstance().getTree().getSelectedNode().getClassyNode() != null){
                if(MainFrame.getInstance().getTree().getSelectedNode().getClassyNode() instanceof Package) {
                    for (PackageView packageView : MainFrame.getInstance().getPackageViews()) {
                        if (packageView.getPaket().equals(MainFrame.getInstance().getTree().getSelectedNode().getClassyNode())) {
                            MainFrame.getInstance().getSplitPane().setRightComponent(packageView);
                            return;
                        }
                    }
                    PackageView packageView = MainFrame.getInstance().getWorkspace().generateWorkspace();
                    MainFrame.getInstance().getPackageViews().add(packageView);
                    MainFrame.getInstance().getSplitPane().setRightComponent(packageView);
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