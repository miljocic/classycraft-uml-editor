package raf.dsw.classycraft.app.repository.implementation;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.observer.ISubscriber;
import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.composite.ClassyNodeComposite;

@Getter
@Setter
public class Project extends ClassyNodeComposite {

    private static int counter=1;
    private String authorName;
    private String directory;

    public Project(String name, ClassyNode parent) {
        super(name, parent);
        setName(name+counter);
        counter++;
    }

    @Override
    public void addChild(ClassyNode child) {
        if (child != null &&  child instanceof Package){
            Package paket = (Package) child;
            if (!this.getChildren().contains(paket)){
                this.getChildren().add(paket);
            }
        }
    }

    @Override
    public void deleteChild(ClassyNode child) {
        Package paket = (Package) child;
        if(this.getChildren().contains(paket))
        {
            this.getChildren().remove(paket);
        }
    }

    @Override
    public void addSubscriber(ISubscriber sub) {
        if (sub == null || subs.contains(sub))
            return;
        subs.add(sub);
    }

    @Override
    public void removeSubscriber(ISubscriber sub) {
        if (sub == null || !subs.contains(sub))
            return;
        subs.remove(sub);
    }

    @Override
    public void notifySubscribers(Object obj) {
        if (obj == null || subs.isEmpty()) {
            return;
        }

        for (ISubscriber sub:subs)
            sub.update(obj);
    }
}
