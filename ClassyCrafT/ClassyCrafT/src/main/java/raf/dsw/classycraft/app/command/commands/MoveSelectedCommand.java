package raf.dsw.classycraft.app.command.commands;

import raf.dsw.classycraft.app.command.AbstractCommand;
import raf.dsw.classycraft.app.repository.implementation.Diagram;
import raf.dsw.classycraft.app.repository.implementation.DiagramElement;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Interclass;

import java.awt.*;
import java.util.Map;

public class MoveSelectedCommand extends AbstractCommand {

    private Map<Interclass, Point> startPoints;
    private Map<Interclass, Point> currentPoints;
    private Diagram diagram;

    public MoveSelectedCommand(Diagram diagram, Map<Interclass, Point> startPoints) {
        this.diagram = diagram;
        this.startPoints = startPoints;
        this.currentPoints = startPoints;
    }

    @Override
    public void doCommand() {
        diagram.moveSelected(currentPoints);

    }

    @Override
    public void undoCommand() {
        diagram.moveSelected(startPoints);

    }

    public void setCurrentPoint(Map<Interclass, Point> currentPoints) {
        this.currentPoints = currentPoints;
    }
}
