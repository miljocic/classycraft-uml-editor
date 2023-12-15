package raf.dsw.classycraft.app.state.model;

import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.painters.ElementPainter;
import raf.dsw.classycraft.app.gui.swing.view.painters.SelectPainter;
import raf.dsw.classycraft.app.state.State;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class SelectState implements State {

    private Point pos;
    private ElementPainter current;
    private ElementPainter selected;

    @Override
    public void mousePressed(MouseEvent e, DiagramView dV) {

        dV.setSelectedPainters(new ArrayList<>());
        pos = e.getPoint();
        boolean ctrlPressed = (e.getModifiersEx() & MouseEvent.CTRL_DOWN_MASK) == MouseEvent.CTRL_DOWN_MASK;
        if (ctrlPressed) {
            MoveState moveState = new MoveState();
            moveState.mousePressed(e, dV);
            dV.setCurrentState(moveState);
        } else {
            for (ElementPainter elementPainter : dV.getElementPainters()) {
                if (elementPainter.elementAt(e.getPoint())) {
                    selected = elementPainter;
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e, DiagramView dV) {
//        if (dV.getCurrentState() instanceof MoveState) {
//            dV.getCurrentState().mouseReleased(e, dV);
//            return;
//        }
//
//        dV.getPainters().remove(current);
//        for (ElementPainter elementPainter : dV.getElementPainters()) {
//            if (elementPainter.getShape().intersects(current.shape.getBounds2D())) {
//                dV.getSelectedPainters().add(elementPainter);
//            }
//        }
//
//        if (!dV.getSelectedPainters().contains(selected)) {
//            dV.getSelectedPainters().add(selected);
//        }
//        dV.repaint();

        if (current != null) {
            dV.getPainters().remove(current);
            for (ElementPainter elementPainter : dV.getElementPainters()) {
                if (elementPainter.getShape().intersects(current.shape.getBounds2D())) {
                    dV.getSelectedPainters().add(elementPainter);
                }
            }
            dV.repaint();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e, DiagramView dV) {
        if (dV.getCurrentState() instanceof MoveState) {
            dV.getCurrentState().mouseDragged(e, dV);
            return;
        }

        if (current != null)
            dV.getPainters().remove(current);
        current = new SelectPainter((int) Double.min(e.getX(), pos.getX()), (int) Double.min(e.getY(), pos.getY()), (int) Math.abs(e.getX() - pos.getX()), (int) Math.abs(e.getY() - pos.getY()));
        dV.getPainters().add(current);
        dV.repaint();
    }
}
