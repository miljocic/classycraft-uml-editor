package raf.dsw.classycraft.app.state.model;

import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.state.State;

import java.awt.*;
import java.awt.event.MouseEvent;

public class MoveState implements State {

    private Point start;


    @Override
    public void mousePressed(MouseEvent e, DiagramView dV) {
        start = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e, DiagramView dV) {

    }

    @Override
    public void mouseDragged(MouseEvent e, DiagramView dV) {


        Point current = e.getPoint();
        double xTranslate = (current.getX() - start.getX()) / dV.getScalingFactor();
        double yTranslate = (current.getY() - start.getY()) / dV.getScalingFactor();
        start = current;
        dV.translate(xTranslate, yTranslate);

    }
}
