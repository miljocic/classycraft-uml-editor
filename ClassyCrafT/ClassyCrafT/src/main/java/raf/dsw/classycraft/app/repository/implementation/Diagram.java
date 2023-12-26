package raf.dsw.classycraft.app.repository.implementation;

import lombok.Getter;
import lombok.Setter;

import raf.dsw.classycraft.app.command.AbstractCommand;
import raf.dsw.classycraft.app.command.commands.AddElementCommand;
import raf.dsw.classycraft.app.command.commands.DeleteElementCommand;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.composite.ClassyNodeComposite;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Interclass;

@Getter
@Setter
public class Diagram extends ClassyNodeComposite {

    private static int counter=1;
    private final String type = "Diagram";
    public Diagram(String name, ClassyNode parent) {
        super(name, parent);
        setName(name+counter);
        counter++;

    }

    @Override
    public void addChild(ClassyNode child) {
//        if(child instanceof Interclass){
//            Interclass interclass = (Interclass) child;
//            if(!this.getChildren().contains(interclass)) {
//                this.getChildren().add(interclass);
//                notifySubscribers(child);
//            }
//            ((Package)getParent()).setChanged(true);
//        }

        if(child instanceof DiagramElement){
            DiagramElement element = (DiagramElement) child;

            if(!this.getChildren().contains(element)) {
                this.getChildren().add(element);
                notifySubscribers(child);
                AbstractCommand command = new AddElementCommand(this, (DiagramElement) child);
                ApplicationFramework.getInstance().getGui().getCommandManager().addCommand(command);
            }

            ((Package)getParent()).setChanged(true);
        }
    }

    @Override
    public void deleteChild(ClassyNode child) {
//        if(child instanceof DiagramElement) {
//            DiagramElement diagramElement = (DiagramElement) child;
//            this.getChildren().remove(diagramElement);
//            notifySubscribers(child);
//        }
//        ((Package)getParent()).setChanged(true);

        if(child instanceof DiagramElement) {
            DiagramElement element = (DiagramElement) child;
            this.getChildren().remove(element);
            notifySubscribers(child);
            AbstractCommand command = new DeleteElementCommand(this, (DiagramElement) child);
            ApplicationFramework.getInstance().getGui().getCommandManager().addCommand(command);
        }

        ((Package)getParent()).setChanged(true);
    }

}
