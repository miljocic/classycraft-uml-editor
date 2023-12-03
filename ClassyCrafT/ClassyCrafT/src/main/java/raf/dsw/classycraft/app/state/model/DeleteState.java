package raf.dsw.classycraft.app.state.model;

import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.painters.ElementPainter;
import raf.dsw.classycraft.app.repository.implementation.Diagram;
import raf.dsw.classycraft.app.state.State;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Iterator;


public class DeleteState implements State {


    @Override
    public void mousePressed(MouseEvent e, DiagramView dV) {

        Diagram diagram = dV.getDiagram();
        Point pos = e.getPoint();
        Iterator<ElementPainter> it = dV.getElementPainters().iterator();
        while(it.hasNext()) {
            ElementPainter elementView = it.next();
            if(elementView.elementAt(pos)) {
                if(elementView.equals(dV.getSelected())) dV.setSelected(null);
                diagram.deleteChild(elementView.getElement());
                break;
            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent e, DiagramView dV) {

    }

    @Override
    public void mouseDragged(MouseEvent e, DiagramView dV) {

    }
}
