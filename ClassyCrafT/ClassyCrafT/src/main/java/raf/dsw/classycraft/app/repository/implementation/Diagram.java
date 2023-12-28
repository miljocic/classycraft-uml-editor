package raf.dsw.classycraft.app.repository.implementation;

import lombok.Getter;
import lombok.Setter;

import raf.dsw.classycraft.app.command.CommandManager;
import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.composite.ClassyNodeComposite;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Interclass;


@Getter
@Setter
public class Diagram extends ClassyNodeComposite {

    private static int counter=1;
    private final String type = "Diagram";
    private transient CommandManager commandManager;
    private boolean template;
    @Getter
    private static final String templatePath = "/DiagramTemplates";
    public Diagram(String name, ClassyNode parent) {
        super(name, parent);
        setName(name+counter);
        counter++;

    }

    @Override
    public void addChild(ClassyNode child) {
        if(child instanceof Interclass){
            Interclass interclass = (Interclass) child;
            if(!this.getChildren().contains(interclass)) {
                this.getChildren().add(interclass);
                child.setParent(this);
                notifySubscribers(child);
            }
            ((Package)getParent()).setChanged(true);
        }
    }

    @Override
    public void deleteChild(ClassyNode child) {
        if(child instanceof DiagramElement) {
            DiagramElement diagramElement = (DiagramElement) child;
            this.getChildren().remove(diagramElement);
            notifySubscribers(child);
        }
        ((Package)getParent()).setChanged(true);

    }

    public CommandManager getCommandManager() {
        if(commandManager == null) commandManager = new CommandManager();
        return commandManager;
    }

}
