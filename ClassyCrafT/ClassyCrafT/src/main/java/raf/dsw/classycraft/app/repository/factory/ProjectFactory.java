package raf.dsw.classycraft.app.repository.factory;

import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.implementation.Project;
import raf.dsw.classycraft.app.repository.implementation.ProjectExplorer;

public class ProjectFactory extends ClassyNodeFactory {

    @Override
    ClassyNode createNode(ClassyNode parent) {
        return new Project("Project ", parent);
    }
}