package raf.dsw.classycraft.app.state.model;

import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.painters.ElementPainter;
import raf.dsw.classycraft.app.state.State;

import java.awt.*;
import java.awt.event.MouseEvent;


public class SelectState implements State {


    @Override
    public void mousePressed(MouseEvent e, DiagramView dV) {

        Point pos = e.getPoint();
        for(ElementPainter elementPainter : dV.getElementPainters()) {
            if(elementPainter.elementAt(pos)) {
                dV.setSelected(elementPainter);
                break;
            }
            dV.setSelected(null);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e, DiagramView dV) {

    }

    @Override
    public void mouseDragged(MouseEvent e, DiagramView dV) {

    }
}
