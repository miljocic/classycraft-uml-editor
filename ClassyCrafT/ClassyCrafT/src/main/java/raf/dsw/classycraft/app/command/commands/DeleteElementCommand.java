package raf.dsw.classycraft.app.command.commands;

import raf.dsw.classycraft.app.command.AbstractCommand;
import raf.dsw.classycraft.app.repository.implementation.Diagram;
import raf.dsw.classycraft.app.repository.implementation.DiagramElement;

import java.util.ArrayList;
import java.util.List;

public class DeleteElementCommand extends AbstractCommand {

    private Diagram diagram;
    private List<DiagramElement> elementsToRemove;
    private List<DiagramElement> removedElements;

    public DeleteElementCommand(Diagram diagram, List<DiagramElement> elementsToRemove) {
        this.elementsToRemove = elementsToRemove;
        this.diagram = diagram;
        this.removedElements = new ArrayList<>();
    }

    @Override
    public void doCommand() {
        removedElements.clear();

        for (DiagramElement element : elementsToRemove) {
            removedElements.add(element);
            diagram.deleteChild(element);
        }
    }

    @Override
    public void undoCommand() {
        for (DiagramElement element : removedElements) {
            diagram.addChild(element);
        }
        removedElements.clear();
    }
}
