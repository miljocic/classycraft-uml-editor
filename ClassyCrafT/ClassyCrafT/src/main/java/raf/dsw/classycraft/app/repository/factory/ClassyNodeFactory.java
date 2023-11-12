package raf.dsw.classycraft.app.repository.factory;

import raf.dsw.classycraft.app.repository.composite.ClassyNode;

public abstract class ClassyNodeFactory  {
    public ClassyNodeFactory() {
    }

    public ClassyNode getClassyNode(ClassyNode parent){
        ClassyNode node = createNode(parent);
        node.setParent(parent);
        return node;
    }

    abstract ClassyNode createNode(ClassyNode parent);

}
