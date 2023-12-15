package raf.dsw.classycraft.app.state.model;

import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.painters.ElementPainter;
import raf.dsw.classycraft.app.gui.swing.view.painters.InterclassPainter;
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

        dV.setSelectedPainters(new ArrayList<>()) ;

        pos = e.getPoint();
        for (ElementPainter elementPainter : dV.getElementPainters()) {
            if(elementPainter.elementAt(e.getPoint())){
                selected = elementPainter;
            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent e, DiagramView dV) {
        dV.getPainters().remove(current);
        for (ElementPainter elementPainter : dV.getElementPainters()) {
            if( elementPainter instanceof InterclassPainter && elementPainter.getShape().intersects( current.shape.getBounds2D())){
                dV.getSelectedPainters().add(elementPainter);
            }
        }

        if(!dV.getSelectedPainters().contains(selected))
        {
            dV.getSelectedPainters().add(selected);
        }
        dV.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e, DiagramView dV) {

        if (current != null)
            dV.getPainters().remove(current);
        current = new SelectPainter((int) Double.min(e.getX(), pos.getX()), (int) Double.min(e.getY(), pos.getY()), (int) Math.abs(e.getX() - pos.getX()), (int) Math.abs(e.getY() - pos.getY()));
        dV.getPainters().add(current);
        dV.repaint();
    }
}
