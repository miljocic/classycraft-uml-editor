package raf.dsw.classycraft.app.repository.implementation;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.observer.ISubscriber;
import raf.dsw.classycraft.app.repository.composite.ClassyNode;

@Getter
@Setter
public class Diagram extends ClassyNode {

    private static int counter=1;
    public Diagram(String name, ClassyNode parent) {
        super(name, parent);
        setName(name+counter);
        counter++;

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
