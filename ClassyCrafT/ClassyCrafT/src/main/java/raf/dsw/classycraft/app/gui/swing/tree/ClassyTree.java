package raf.dsw.classycraft.app.gui.swing.tree;



import raf.dsw.classycraft.app.gui.swing.tree.model.ClassyTreeItem;
import raf.dsw.classycraft.app.gui.swing.tree.view.ClassyTreeView;
import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.implementation.Diagram;
import raf.dsw.classycraft.app.repository.implementation.Project;
import raf.dsw.classycraft.app.repository.implementation.ProjectExplorer;


public interface ClassyTree {

    ClassyTreeView generateTree(ProjectExplorer projectExplorer);


    void addChild(ClassyTreeItem parent);

    void delete(ClassyTreeItem child);
    ClassyTreeItem getSelectedNode();

    ClassyTreeItem findNode(ClassyNode parent);
    void loadProject(Project project);
    void loadTemplate(Diagram template);
}

