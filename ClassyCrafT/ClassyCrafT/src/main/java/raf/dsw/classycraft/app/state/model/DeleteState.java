package raf.dsw.classycraft.app.state.model;

import raf.dsw.classycraft.app.command.commands.DeleteElementCommand;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.painters.ConnectionPainter;
import raf.dsw.classycraft.app.gui.swing.view.painters.ElementPainter;
import raf.dsw.classycraft.app.gui.swing.view.painters.SelectPainter;
import raf.dsw.classycraft.app.repository.implementation.DiagramElement;
import raf.dsw.classycraft.app.repository.implementation.connectionElements.Connection;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Interclass;
import raf.dsw.classycraft.app.state.State;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DeleteState implements State {

    private DeleteElementCommand deleteElementCommand;

    @Override
    public void mousePressed(MouseEvent e, DiagramView dV) {
        Point pos = new Point(
                (int) ((e.getPoint().getX() - dV.getXTranslate()) / dV.getScalingFactor()),
                (int) ((e.getPoint().getY() - dV.getYTranslate()) / dV.getScalingFactor())
        );

        ElementPainter clicked = null;
        Iterator<ElementPainter> it = dV.getElementPainters().iterator();
        List<DiagramElement> elementsToDelete = new ArrayList<>();
        List<ConnectionPainter> connectionsToDelete = new ArrayList<>();

        while (it.hasNext()) {
            ElementPainter elementPainter = it.next();
            if (elementPainter.elementAt(pos)) {
                if (elementPainter instanceof ConnectionPainter) {
                    connectionsToDelete.add((ConnectionPainter) elementPainter);
                } else {
                    if (dV.getSelectedPainters().contains(elementPainter)) {
                        for (ElementPainter selectedPainter : dV.getSelectedPainters()) {
                            if (selectedPainter instanceof ConnectionPainter) {
                                connectionsToDelete.add((ConnectionPainter) selectedPainter);
                            } else {
                                elementsToDelete.add(selectedPainter.getElement());
                            }
                        }
                        dV.clearSelected();
                    } else {
                        elementsToDelete.add(elementPainter.getElement());
                        clicked = elementPainter;
                    }
                }
                break;
            }
        }

        for (ElementPainter selectedPainter : dV.getSelectedPainters()) {
            if (selectedPainter.getElement() instanceof Interclass) {
                Interclass selectedInterclass = (Interclass) selectedPainter.getElement();
                Iterator<ElementPainter> connectionIterator = dV.getElementPainters().iterator();
                while (connectionIterator.hasNext()) {
                    ElementPainter elementPainter = connectionIterator.next();
                    if (elementPainter instanceof ConnectionPainter) {
                        ConnectionPainter connectionPainter = (ConnectionPainter) elementPainter;
                        Connection connection = connectionPainter.getConnection();
                        if (connection.getTo().equals(selectedInterclass) || connection.getFrom().equals(selectedInterclass)) {
                            connectionsToDelete.add(connectionPainter);
                        }
                    }
                }
            }
        }

        if (clicked != null && clicked instanceof SelectPainter) {
            deleteElementCommand = new DeleteElementCommand(dV.getDiagram(), elementsToDelete, connectionsToDelete);
            dV.getDiagram().getCommandManager().addCommand(deleteElementCommand);
        } else {
            deleteElementCommand = new DeleteElementCommand(dV.getDiagram(), elementsToDelete, connectionsToDelete);
            dV.getDiagram().getCommandManager().addCommand(deleteElementCommand);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e, DiagramView dV) {
    }

    @Override
    public void mouseDragged(MouseEvent e, DiagramView dV) {
    }
}
