package raf.dsw.classycraft.app.state;

import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class StateMouseManager implements MouseListener, MouseMotionListener {

    private DiagramView diagramView;

    public StateMouseManager() {
    }

    public StateMouseManager(DiagramView diagramView) {
        this.diagramView = diagramView;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point pos = e.getPoint();
        double scaling = diagramView.getScalingF();
        int x = (int) (pos.x / scaling);
        int y = (int) (pos.y / scaling);
        MainFrame.getInstance().getWorkspace().getPackageView().startMousePressed(e.getX(),e.getY(),diagramView);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Point pos = e.getPoint();
        double scaling = diagramView.getScalingF();
        int x = (int) (pos.x / scaling);
        int y = (int) (pos.y / scaling);
        MainFrame.getInstance().getWorkspace().getPackageView().startMouseReleased(e.getX(),e.getY(),diagramView);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Point pos = e.getPoint();
        double scaling = diagramView.getScalingF();
        int x = (int) (pos.x / scaling);
        int y = (int) (pos.y / scaling);
        MainFrame.getInstance().getWorkspace().getPackageView().startMouseDragged(e.getX(),e.getY(),diagramView);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}




