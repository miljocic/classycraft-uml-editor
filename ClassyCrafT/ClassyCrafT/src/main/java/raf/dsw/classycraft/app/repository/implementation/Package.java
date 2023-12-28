package raf.dsw.classycraft.app.repository.implementation;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.observer.IPublisher;
import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.composite.ClassyNodeComposite;



@Getter
@Setter

public class Package extends ClassyNodeComposite implements IPublisher{

    private static int counter = 1;
    private String author;
    private Project parentProject;
    private String directory;
    private boolean changed;

    public Package(String name, ClassyNode parent) {
        super(name, parent);
        setName(name+counter);
        this.changed = true;
        counter++;
    }

    @Override
    public void addChild(ClassyNode child) {
        if ( child instanceof Package ){
            Package paket = (Package) child;
            paket.setParentProject(this.parentProject);
            if (!this.getChildren().contains(paket)){
                this.getChildren().add(paket);
                child.setParent(this);
                notifySubscribers(this);
            }
            changed = true;
        }
        else if ( child instanceof Diagram ){
            Diagram diagram = (Diagram) child;
            if (!this.getChildren().contains(diagram)){
                this.getChildren().add(diagram);
                notifySubscribers(this);
            }
            changed = true;
        }
    }

    @Override
    public void deleteChild(ClassyNode child) {
        if (child != null && this.getChildren().contains(child)) {
            this.getChildren().remove(child);
            notifySubscribers(this);
        }
        changed = true;
    }

    public String getAuthor() {
        return parentProject.getAuthorName();
    }

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }


    public String getDirectory(){
        return parentProject.getDirectory();
    }
}
