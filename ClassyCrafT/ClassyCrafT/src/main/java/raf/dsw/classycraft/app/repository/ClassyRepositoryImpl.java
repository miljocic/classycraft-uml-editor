package raf.dsw.classycraft.app.repository;

import raf.dsw.classycraft.app.core.ClassyRepository;
import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.composite.ClassyNodeComposite;
import raf.dsw.classycraft.app.repository.implementation.ProjectExplorer;

public class ClassyRepositoryImpl implements ClassyRepository {

    private ProjectExplorer projectExplorer;

    public ClassyRepositoryImpl() {
        projectExplorer = new ProjectExplorer("My Project Explorer");
    }

    @Override
    public ProjectExplorer getProjectExplorer() {
        return projectExplorer;
    }

    @Override
    public void addChild(ClassyNodeComposite parent, ClassyNode child) {
        parent.addChild(child);
    }

    @Override
    public void removeChild(ClassyNodeComposite parent, ClassyNode child) {
        parent.deleteChild(child);
    }

}
