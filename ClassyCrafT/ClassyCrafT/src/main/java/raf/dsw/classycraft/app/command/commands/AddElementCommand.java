package raf.dsw.classycraft.app.command.commands;

import raf.dsw.classycraft.app.command.AbstractCommand;
import raf.dsw.classycraft.app.repository.implementation.Diagram;
import raf.dsw.classycraft.app.repository.implementation.DiagramElement;

public class AddElementCommand extends AbstractCommand {

    private Diagram diagram;
    private DiagramElement element;

    public AddElementCommand(Diagram diagram, DiagramElement element){
        this.element = element;
        this.diagram = diagram;

    }
    @Override
    public void doCommand() {
        diagram.addChild(element);
    }

    @Override
    public void undoCommand() {
        diagram.deleteChild(element);
    }
}
