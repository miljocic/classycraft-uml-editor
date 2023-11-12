package raf.dsw.classycraft.app.repository.composite;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import raf.dsw.classycraft.app.observer.IPublisher;
import raf.dsw.classycraft.app.observer.ISubscriber;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class ClassyNode implements IPublisher {

    protected List<ISubscriber> subs;
    private String name;
    @ToString.Exclude private ClassyNode parent;

    public ClassyNode(String name, ClassyNode parent) {
        this.name = name;
        this.parent = parent;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof ClassyNode) {
            ClassyNode otherObj = (ClassyNode) obj;
            return this.getName().equals(otherObj.getName());
        }
        return false;
    }

    @Override
    public void addSubscriber(ISubscriber sub) {
        if(sub == null)
            this.subs = new ArrayList<>();
        subs.add(sub);
    }

    @Override
    public void removeSubscriber(ISubscriber sub) {
        subs.remove(sub);
    }

    @Override
    public void notifySubscriber(Object notification) {
        if(subs == null) return;
        for(ISubscriber sub : subs){
            sub.update(notification);
        }
    }

}
