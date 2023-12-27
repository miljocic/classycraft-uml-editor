package raf.dsw.classycraft.app.command.commands;

import raf.dsw.classycraft.app.command.AbstractCommand;
import raf.dsw.classycraft.app.repository.implementation.Diagram;
import raf.dsw.classycraft.app.repository.implementation.DiagramElement;

import java.util.List;

public class DeleteElementCommand extends AbstractCommand {

    private Diagram diagram;
    private List<DiagramElement> elementsToRemove;

    public DeleteElementCommand(Diagram diagram, List<DiagramElement> elementsToRemove) {
        this.elementsToRemove = elementsToRemove;
        this.diagram = diagram;
    }

    @Override
    public void doCommand() {
        for (DiagramElement element : elementsToRemove) {
            diagram.deleteChild(element);
        }
    }

    @Override
    public void undoCommand() {
        for (DiagramElement element : elementsToRemove) {
            diagram.addChild(element);
        }
    }
}
