package raf.dsw.classycraft.app.command.commands;

import raf.dsw.classycraft.app.command.AbstractCommand;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.repository.implementation.Diagram;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Interclass;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MoveSelectedCommand extends AbstractCommand {

    private Map<Interclass, Point> startPoints;
    private Map<Interclass, Point> endPoints;
    private Diagram diagram;
    private DiagramView diagramView;

    public MoveSelectedCommand(Diagram diagram, DiagramView diagramView, Map<Interclass, Point> startPoints) {
        this.diagram = diagram;
        this.diagramView = diagramView;
        this.startPoints = startPoints;
        this.endPoints = new HashMap<>();
        for (Interclass i : startPoints.keySet()) {
            endPoints.put(i, new Point((int) i.getLocation().getX(), (int) i.getLocation().getY()));
        }
    }

    @Override
    public void doCommand() {
        diagram.moveSelected(endPoints);
        notifyDiagramView();  // Notify DiagramView to repaint
    }

    @Override
    public void undoCommand() {
        diagram.moveSelected(startPoints);
        notifyDiagramView();  // Notify DiagramView to repaint
    }

    private void notifyDiagramView() {
        if (diagramView != null) {
            diagramView.repaint();
        }
    }
}
