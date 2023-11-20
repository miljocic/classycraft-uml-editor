package raf.dsw.classycraft.app.repository.implementation;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.observer.IPublisher;
import raf.dsw.classycraft.app.observer.ISubscriber;
import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.composite.ClassyNodeComposite;



@Getter
@Setter

public class Package extends ClassyNodeComposite implements IPublisher{

    private static int counter = 1;
    private String author;
    private Project parentProject;

    public Package(String name, ClassyNode parent) {
        super(name, parent);
        setName(name+counter);
        counter++;
    }

    @Override
    public void addChild(ClassyNode child) {
        if (child != null &&  child instanceof Package ){
            Package paket = (Package) child;
            if (!this.getChildren().contains(paket)){
                this.getChildren().add(paket);
                notifySubscribers(this);
            }
        }
        else if (child != null &&  child instanceof Diagram ){
            Diagram diagram = (Diagram) child;
            if (!this.getChildren().contains(diagram)){
                this.getChildren().add(diagram);
                notifySubscribers(this);
            }
        }
    }

    @Override
    public void deleteChild(ClassyNode child) {
        if (child != null && this.getChildren().contains(child)) {
            this.getChildren().remove(child);
            notifySubscribers(this);
        }
    }
    @Override
    public void addSubscriber(ISubscriber sub) {
        if (sub == null || subs.contains(sub)) return;
        subs.add(sub);
    }

    @Override
    public void removeSubscriber(ISubscriber sub) {
        if (sub == null || !(subs.contains((sub)))) return;
        subs.remove(sub);
    }

    @Override
    public void notifySubscribers(Object notification) {
        if (notification == null || subs.isEmpty()) return;
        for (ISubscriber s : subs) {
            s.update(this);

        }
    }
}
