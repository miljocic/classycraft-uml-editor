package raf.dsw.classycraft.app.gui.swing.tree;


import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.tree.model.ClassyTreeItem;
import raf.dsw.classycraft.app.gui.swing.tree.view.ClassyTreeView;
import raf.dsw.classycraft.app.logg.messages.ErrorType;
import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.composite.ClassyNodeComposite;
import raf.dsw.classycraft.app.repository.factory.ClassyNodeFactory;
import raf.dsw.classycraft.app.repository.factory.Utils;
import raf.dsw.classycraft.app.repository.implementation.Diagram;
import raf.dsw.classycraft.app.repository.implementation.Package;
import raf.dsw.classycraft.app.repository.implementation.Project;
import raf.dsw.classycraft.app.repository.implementation.ProjectExplorer;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.util.Random;
@Getter
@Setter
public class ClassyTreeImplementation implements ClassyTree{

    private ClassyTreeView treeView;
    private DefaultTreeModel treeModel;

    @Override
    public ClassyTreeView generateTree(ProjectExplorer projectExplorer) {
        ClassyTreeItem root = new ClassyTreeItem(projectExplorer);
        treeModel = new DefaultTreeModel(root);
        treeView = new ClassyTreeView(treeModel);
        return treeView;
    }

    @Override
    public void addChild(ClassyTreeItem parent) {

        if (!(parent.getClassyNode() instanceof ClassyNodeComposite))
            return;

        ClassyNode child = createChild(parent.getClassyNode());
        parent.add(new ClassyTreeItem(child));
        ((ClassyNodeComposite) parent.getClassyNode()).addChild(child);
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);


        
    }

    @Override
    public void delete(ClassyTreeItem child) {

        if (child == null) {
            //Prazan prostor izabran
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(ErrorType.NODE_NOT_SELECTED);
            return;
        }

        ClassyTreeItem parent = (ClassyTreeItem) child.getParent();

        if (parent == null) {
            //Komponenta se ne moze obrisati jer mu je roditelj nepostojeci
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(ErrorType.NODE_CANNOT_BE_DELETED);
            return;
        }
        else{

            ClassyNode nodeToDelete = child.getClassyNode();
            //brisanje komponente
            if (parent.getClassyNode() instanceof ClassyNodeComposite) {
                ((ClassyNodeComposite) parent.getClassyNode()).deleteChild(nodeToDelete);
            }

            parent.remove(child);
            treeView.updateUI();
            /*
            Nakon sto se obrise objekat, vraca se na prvi sledeci
            zarad izbegavanja moguceh neregistrovanog Node not selected problema
            doduse na svog roditelja se penje
             */
            treeView.setSelectionPath(new TreePath(parent.getPath()));
        }



    }

    private ClassyNode createChild(ClassyNode parent) {

        /*
        serijalizacija
         */

        ClassyNodeFactory nodeFactory = Utils.getFactory(parent);
        return nodeFactory.getClassyNode(parent);
    }

    @Override
    public ClassyTreeItem getSelectedNode() {
        return (ClassyTreeItem) treeView.getLastSelectedPathComponent();
    }
}
