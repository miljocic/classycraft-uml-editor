package raf.dsw.classycraft.app.repository.composite;


import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.observer.IPublisher;
import raf.dsw.classycraft.app.observer.ISubscriber;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class ClassyNode implements IPublisher {

    protected String className = "ClassyNode";
    protected transient List<ISubscriber> subs;
    protected String name;
    private transient ClassyNode parent;


    public ClassyNode(String name, ClassyNode parent) {
        this.name = name;
        this.parent = parent;
    }

    public ClassyNode(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof ClassyNode){
            ClassyNode Obj = (ClassyNode) obj;
            return this.getName().equals(Obj.getName());
        }
        return false;
    }

    public void setName(String name) {
        this.name = name;
        notifySubscribers(this);
    }

    @Override
    public void addSubscriber(ISubscriber sub){
        if(subs == null)
            this.subs = new ArrayList<>();
        subs.add(sub);
    }

    @Override
    public void removeSubscriber(ISubscriber sub){
        subs.remove(sub);
    }

    @Override
    public void notifySubscribers(Object notification){
        if(subs == null) return;
        for(ISubscriber sub : subs){
            sub.update(notification);
        }
    }
}
