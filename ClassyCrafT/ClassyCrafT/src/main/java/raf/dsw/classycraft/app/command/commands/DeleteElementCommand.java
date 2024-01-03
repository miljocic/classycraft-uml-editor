package raf.dsw.classycraft.app.command.commands;

import raf.dsw.classycraft.app.command.AbstractCommand;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.painters.ConnectionPainter;
import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.implementation.Diagram;
import raf.dsw.classycraft.app.repository.implementation.DiagramElement;
import raf.dsw.classycraft.app.repository.implementation.connectionElements.Connection;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Interclass;

import java.util.ArrayList;
import java.util.List;

public class DeleteElementCommand extends AbstractCommand {
    private Diagram diagram;
    private DiagramView diagramView;
    private List<DiagramElement> diagramElements;
    private List<Connection> connectionList;
    public DeleteElementCommand(Diagram parent, DiagramView diagramView, List<DiagramElement> children, List<ConnectionPainter> connectionPainters) {
        this.diagramElements = children;
        this.diagram = parent;
        this.diagramView = diagramView;
        this.connectionList = new ArrayList<>();

        for (DiagramElement child : children) {
            if (child instanceof Interclass) {
                for (ClassyNode e : parent.getChildren()) {
                    DiagramElement element = (DiagramElement) e;
                    if (element instanceof Connection &&
                            (((Connection) element).getFrom().equals(child) || ((Connection) element).getTo().equals(child))) {
                        Connection connection = (Connection) element;
                        connectionList.add(connection);
                    }
                }
            }
        }
        for (ConnectionPainter connectionPainter : connectionPainters) {
            this.connectionList.add(connectionPainter.getConnection());
        }
    }

    @Override
    public void doCommand() {
        for (Connection c : connectionList) {
            diagram.deleteChild(c);
        }
        for (DiagramElement diagramElement : diagramElements) {
            diagram.deleteChild(diagramElement);
        }
        notifyDiagramView();
    }

    @Override
    public void undoCommand() {
        for (DiagramElement diagramElement : diagramElements) {
            diagram.addChild(diagramElement);
        }
        for (Connection c : connectionList) {
            diagram.addChild(c);
        }
        notifyDiagramView();
    }
    private void notifyDiagramView() {
        if (diagramView != null) {
            diagramView.repaint();
        }
    }
}
