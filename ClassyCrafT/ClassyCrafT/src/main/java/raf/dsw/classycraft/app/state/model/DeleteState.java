package raf.dsw.classycraft.app.state.model;

import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.painters.ConnectionPainter;
import raf.dsw.classycraft.app.gui.swing.view.painters.ElementPainter;
import raf.dsw.classycraft.app.gui.swing.view.painters.InterclassPainter;
import raf.dsw.classycraft.app.repository.implementation.Diagram;
import raf.dsw.classycraft.app.repository.implementation.connectionElements.Connection;
import raf.dsw.classycraft.app.state.State;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class DeleteState implements State {


    @Override
    public void mousePressed(MouseEvent e, DiagramView dV) {

        Diagram diagram = dV.getDiagram();
        Point pos = e.getPoint();
        ElementPainter deleted = null;
        Iterator<ElementPainter> it = dV.getElementPainters().iterator();
        while(it.hasNext()) {
            ElementPainter elementPainter = it.next();
            if(elementPainter.elementAt(pos)) {
                if(elementPainter.equals(dV.getSelected())) dV.setSelected(null);
                diagram.deleteChild(elementPainter.getElement());
                deleted = elementPainter;
                break;
            }
        }

        if(deleted instanceof InterclassPainter) {
            List<Connection> connectionList = new ArrayList<>();
            it = dV.getElementPainters().iterator();
            while (it.hasNext()) {
                ElementPainter elementPainter = it.next();
                if(elementPainter instanceof ConnectionPainter) {
                    ConnectionPainter connectionPainter = (ConnectionPainter) elementPainter;
                    Connection connection = (Connection) connectionPainter.getElement();
                    if(connection.getTo().equals(deleted.getElement()) || connection.getFrom().equals(deleted.getElement())) {
                        connectionList.add(connection);
                    }
                }
            }
            for(Connection c : connectionList) {
                diagram.deleteChild(c);
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
