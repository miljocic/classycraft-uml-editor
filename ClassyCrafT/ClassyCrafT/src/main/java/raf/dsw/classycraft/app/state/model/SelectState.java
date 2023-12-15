package raf.dsw.classycraft.app.state.model;

import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.painters.ConnectionPainter;
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

        pos = new Point((int)
                ((e.getPoint().getX()-dV.getXTranslate())/dV.getScalingFactor()),
                (int) ((e.getPoint().getY()-dV.getYTranslate())/dV.getScalingFactor()));


        dV.setSelectedPainters(new ArrayList<>());

        boolean ctrlPressed = (e.getModifiersEx() & MouseEvent.CTRL_DOWN_MASK) == MouseEvent.CTRL_DOWN_MASK;
        if (ctrlPressed) {
            MoveState moveState = new MoveState();
            moveState.mousePressed(e, dV);
            dV.setCurrentState(moveState);
        } else {
            for (ElementPainter elementPainter : dV.getElementPainters()) {
                if (elementPainter instanceof ConnectionPainter) {
                    continue; // Skip ConnectionPainter instances
                }
                if (elementPainter.elementAt(pos)) {
                    selected = elementPainter;
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e, DiagramView dV) {

        if (current != null) {
            dV.getPainters().remove(current);
            for (ElementPainter elementPainter : dV.getElementPainters()) {
                if (elementPainter instanceof ConnectionPainter) {
                    continue; // Skip ConnectionPainter instances
                }
                if (elementPainter.getShape().intersects(current.shape.getBounds2D())) {
                    dV.getSelectedPainters().add(elementPainter);
                }
            }
            dV.repaint();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e, DiagramView dV) {
        Point currentPos = new Point((int)
                ((e.getPoint().getX() - dV.getXTranslate()) / dV.getScalingFactor()),
                (int) ((e.getPoint().getY() - dV.getYTranslate()) / dV.getScalingFactor()));

        if (dV.getCurrentState() instanceof MoveState) {
            dV.getCurrentState().mouseDragged(e, dV);
            return;
        }

        if (current != null) {
            dV.getPainters().remove(current);
        }


        int width = (int) Math.abs(currentPos.getX() - pos.getX());
        int height = (int) Math.abs(currentPos.getY() - pos.getY());


        int x = (int) Math.min(currentPos.getX(), pos.getX());
        int y = (int) Math.min(currentPos.getY(), pos.getY());

        current = new SelectPainter(x, y, width, height);
        dV.getPainters().add(current);
        dV.repaint();
    }
}
