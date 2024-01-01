package raf.dsw.classycraft.app.command.commands;

import raf.dsw.classycraft.app.command.AbstractCommand;
import raf.dsw.classycraft.app.repository.implementation.Diagram;
import raf.dsw.classycraft.app.repository.implementation.DiagramElement;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Interclass;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MoveSelectedCommand extends AbstractCommand {

    private Map<Interclass, Point> startPoints;

    private Map<Interclass, Point> endPoints;
    private Diagram diagram;

    public MoveSelectedCommand(Diagram diagram, Map<Interclass, Point> startPoints) {
        this.diagram = diagram;
        this.startPoints = startPoints;
        this.endPoints = new HashMap<>();
        for(Interclass i : startPoints.keySet()) {
            endPoints.put(i, new Point((int) i.getXCoordinate(), (int) i.getYCoordinate()));
        }
    }
    @Override
    public void doCommand() {
        diagram.moveSelected(endPoints);
    }

    @Override
    public void undoCommand() {
        diagram.moveSelected(startPoints);
    }

}
