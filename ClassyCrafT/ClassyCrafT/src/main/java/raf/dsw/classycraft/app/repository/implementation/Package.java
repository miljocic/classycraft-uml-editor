package raf.dsw.classycraft.app.repository.implementation;

import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.composite.ClassyNodeComposite;

public class Package extends ClassyNodeComposite {  // ima JFPane i neke tabove
    public Package(String name, ClassyNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(ClassyNode child) {

    }

    @Override
    public void deleteChild(ClassyNode child) {

    }
}
