package raf.dsw.classycraft.app.repository.implementation;

import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.composite.ClassyNodeComposite;

import java.util.List;

public class ProjectExplorer extends ClassyNodeComposite {

    // Parent == null

    public ProjectExplorer(String name) {
        super(name, (ClassyNode) null);
    }

    public ProjectExplorer(String name, List<ClassyNode> children) {
        super(name, children);
    }

    @Override
    public void addChild(ClassyNode child) {
        if (child != null && child instanceof Project) {
            Project project = (Project) child;
            if (!this.getChildren().contains(project)) {
                this.getChildren().add(project);
                child.setParent(this);
            }
        }
    }

    @Override
    public void deleteChild(ClassyNode child) {
        Project project = (Project) child;
        if (this.getChildren().contains(project)) {
            this.getChildren().remove(project);
        }

    }

}
