package raf.dsw.classycraft.app.repository.factory;


import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.implementation.Diagram;
import raf.dsw.classycraft.app.repository.implementation.Project;

public class DiagramFactory extends ClassyNodeFactory {

    @Override
    ClassyNode createNode(ClassyNode parent) {
        return new Diagram("Diagram ", parent);
    }
}

