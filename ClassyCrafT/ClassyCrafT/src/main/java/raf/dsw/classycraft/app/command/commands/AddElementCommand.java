package raf.dsw.classycraft.app.command.commands;

import raf.dsw.classycraft.app.command.AbstractCommand;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.repository.implementation.Diagram;
import raf.dsw.classycraft.app.repository.implementation.DiagramElement;

public class AddElementCommand extends AbstractCommand {
    private Diagram diagram;
    private DiagramElement element;
    private DiagramView diagramView;

    public AddElementCommand(Diagram diagram, DiagramView diagramView, DiagramElement element) {
        this.element = element;
        this.diagram = diagram;
        this.diagramView = diagramView;
    }

    @Override
    public void doCommand() {
        diagram.addChild(element);
        notifyDiagramView();
    }

    @Override
    public void undoCommand() {
        diagram.deleteChild(element);
        notifyDiagramView();
    }

    private void notifyDiagramView() {
        if (diagramView != null) {
            diagramView.repaint();
        }
    }
}
