package raf.dsw.classycraft.app.command.commands;

import raf.dsw.classycraft.app.command.AbstractCommand;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.repository.implementation.Diagram;
import raf.dsw.classycraft.app.repository.implementation.connectionElements.Connection;

public class AddConnectionCommand extends AbstractCommand {
    private Diagram diagram;
    private DiagramView diagramView;
    private Connection connection;

    public AddConnectionCommand(Diagram diagram, DiagramView diagramView, Connection connection) {
        this.diagram = diagram;
        this.diagramView = diagramView;
        this.connection = connection;
    }

    @Override
    public void doCommand() {
        diagram.addChild(connection);
        diagramView.repaint();
    }

    @Override
    public void undoCommand() {
        diagram.deleteChild(connection);
        diagramView.repaint();
    }
}
