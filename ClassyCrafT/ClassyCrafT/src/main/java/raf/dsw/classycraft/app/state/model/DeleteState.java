package raf.dsw.classycraft.app.state.model;

import raf.dsw.classycraft.app.gui.swing.tree.ClassyTreeImplementation;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
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


        List<ElementPainter> selectedPainters = new ArrayList<>();
        List<ElementPainter> paintersToRemove = new ArrayList<>(dV.getElementPainters());

        Iterator<ElementPainter> it = paintersToRemove.iterator();
        while (it.hasNext()) {
            ElementPainter elementPainter = it.next();
            if (elementPainter.elementAt(pos)) {
                if (elementPainter.equals(dV.getSelected())) {
                    dV.setSelected(null);
                }
                selectedPainters.add(elementPainter);
                diagram.deleteChild(elementPainter.getElement());
                ClassyTreeImplementation treeImp = (ClassyTreeImplementation) MainFrame.getInstance().getTree();
                treeImp.delete(treeImp.findNode(elementPainter.getElement()));
            }
        }


        for (ElementPainter selectedPainter : selectedPainters) {
            if (selectedPainter instanceof InterclassPainter) {
                Iterator<ElementPainter> connectionIterator = dV.getElementPainters().iterator();
                while (connectionIterator.hasNext()) {
                    ElementPainter elementPainter = connectionIterator.next();
                    if (elementPainter instanceof ConnectionPainter) {
                        ConnectionPainter connectionPainter = (ConnectionPainter) elementPainter;
                        Connection connection = (Connection) connectionPainter.getElement();
                        if (connection.getTo().equals(selectedPainter.getElement()) || connection.getFrom().equals(selectedPainter.getElement())) {
                            paintersToRemove.add(elementPainter);
                            diagram.deleteChild(connection);
                        }
                    }
                }
            }
        }


        dV.getElementPainters().removeAll(paintersToRemove);
        dV.repaint();
    }


    @Override
    public void mouseReleased(MouseEvent e, DiagramView dV) {

    }

    @Override
    public void mouseDragged(MouseEvent e, DiagramView dV) {

    }
}
