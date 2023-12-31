package raf.dsw.classycraft.app.command.commands;

import raf.dsw.classycraft.app.command.AbstractCommand;
import raf.dsw.classycraft.app.repository.implementation.Diagram;
import raf.dsw.classycraft.app.repository.implementation.DiagramElement;

public class AddAttributeOrMethodCommand extends AbstractCommand {

    private Diagram diagram;
    private DiagramElement element;
    public AddAttributeOrMethodCommand(Diagram diagram, DiagramElement element) {
        this.element = element;
        this.diagram = diagram;
    }
    @Override
    public void doCommand() {
        diagram.addAttributeOrMethod(element);
    }

    @Override
    public void undoCommand() {
        diagram.deleteChild(element);
    }
}
