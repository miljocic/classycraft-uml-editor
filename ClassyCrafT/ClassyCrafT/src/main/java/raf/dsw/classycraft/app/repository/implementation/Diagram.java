package raf.dsw.classycraft.app.repository.implementation;

import lombok.Getter;
import lombok.Setter;

import raf.dsw.classycraft.app.command.CommandManager;
import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.composite.ClassyNodeComposite;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Interclass;

import java.awt.*;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Diagram extends ClassyNodeComposite {

    private static int counter = 1;
    private final String type = "Diagram";
    private transient CommandManager commandManager;
    private boolean template;
    @Getter
    private static final String templatePath = "/DiagramTemplates";

    public Diagram(String name, ClassyNode parent) {
        super(name, parent);
        setName(name + counter);
        counter++;
        className = "Diagram";
    }

    public Diagram(String name, List<ClassyNode> children) {
        super(name, children);
        className = "Diagram";
    }

    @Override
    public void addChild(ClassyNode child) {
        if (child instanceof Interclass) {
            Interclass interclass = (Interclass) child;
            if (!this.getChildren().contains(interclass)) {
                this.getChildren().add(interclass);
                child.setParent(this);
                notifySubscribers(child);
            }
            ((Package) getParent()).setChanged(true);
        }
    }

    @Override
    public void deleteChild(ClassyNode child) {
        if (child instanceof DiagramElement) {
            DiagramElement diagramElement = (DiagramElement) child;
            this.getChildren().remove(diagramElement);
            notifySubscribers(child);
        }
        ((Package) getParent()).setChanged(true);
    }

    public void moveSelected(Map<Interclass, Point> points) {
        for (Interclass interclass : points.keySet()) {
            interclass.setLocation(points.get(interclass));
        }
    }

    public CommandManager getCommandManager() {
        if (commandManager == null) commandManager = new CommandManager();
        return commandManager;
    }

}
