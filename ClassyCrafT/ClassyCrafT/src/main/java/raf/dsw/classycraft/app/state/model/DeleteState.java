package raf.dsw.classycraft.app.state.model;

import raf.dsw.classycraft.app.command.commands.DeleteElementCommand;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.painters.ConnectionPainter;
import raf.dsw.classycraft.app.gui.swing.view.painters.ElementPainter;
import raf.dsw.classycraft.app.repository.implementation.DiagramElement;
import raf.dsw.classycraft.app.repository.implementation.connectionElements.Connection;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Interclass;
import raf.dsw.classycraft.app.state.State;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import java.util.List;

public class DeleteState implements State {
    @Override
    public void mousePressed(MouseEvent e, DiagramView dV) {
        Point pos = new Point(
                (int) ((e.getPoint().getX() - dV.getXTranslate()) / dV.getScalingFactor()),
                (int) ((e.getPoint().getY() - dV.getYTranslate()) / dV.getScalingFactor())
        );
        List<DiagramElement> elementsToDelete = new ArrayList<>();
        List<ConnectionPainter> connectionsToDelete = new ArrayList<>();
        for (ElementPainter elementPainter : dV.getElementPainters()) {
            if (elementPainter.elementAt(pos)) {
                if (elementPainter instanceof ConnectionPainter) {
                    connectionsToDelete.add((ConnectionPainter) elementPainter);
                } else {
                    Interclass selectedInterclass = null;
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
                        if (elementPainter.getElement() instanceof Interclass) {
                            selectedInterclass = (Interclass) elementPainter.getElement();
                        }
                    }
                    if (selectedInterclass != null) {
                        for (ElementPainter connectionPainter : dV.getElementPainters()) {
                            if (connectionPainter instanceof ConnectionPainter) {
                                ConnectionPainter connectionPainterElement = (ConnectionPainter) connectionPainter;
                                Connection connection = connectionPainterElement.getConnection();
                                if (connection.getTo().equals(selectedInterclass) || connection.getFrom().equals(selectedInterclass)) {
                                    connectionsToDelete.add(connectionPainterElement);
                                }
                            }
                        }
                    }
                }
                break;
            }
        }

        DeleteElementCommand deleteElementCommand = new DeleteElementCommand(dV.getDiagram(), dV, elementsToDelete, connectionsToDelete);
        dV.getDiagram().getCommandManager().addCommand(deleteElementCommand);
    }

    @Override
    public void mouseReleased(MouseEvent e, DiagramView dV) {
    }

    @Override
    public void mouseDragged(MouseEvent e, DiagramView dV) {
    }
}
