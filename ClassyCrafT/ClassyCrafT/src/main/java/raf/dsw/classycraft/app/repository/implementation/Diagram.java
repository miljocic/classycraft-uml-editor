package raf.dsw.classycraft.app.repository.implementation;

import lombok.Getter;
import lombok.Setter;

import raf.dsw.classycraft.app.observer.ISubscriber;
import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.composite.ClassyNodeComposite;

@Getter
@Setter
public class Diagram extends ClassyNodeComposite {

    private static int counter=1;
    public Diagram(String name, ClassyNode parent) {
        super(name, parent);
        setName(name+counter);
        counter++;

    }

    @Override
    public void addChild(ClassyNode child) {
        if(child instanceof Element){
            Element element = (Element) child;
            if(!this.getChildren().contains(element)) {
                this.getChildren().add(element);
                notifySubscribers(child);
            }
        }
    }

    @Override
    public void deleteChild(ClassyNode child) {
        if(child instanceof Element) {
            Element element = (Element) child;
            this.getChildren().remove(element);
            notifySubscribers(child);
        }
    }



}
