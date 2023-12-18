package raf.dsw.classycraft.app.gui.swing.tree;


import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.tree.model.ClassyTreeItem;
import raf.dsw.classycraft.app.gui.swing.tree.view.ClassyTreeView;
import raf.dsw.classycraft.app.logg.messages.ErrorType;
import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.composite.ClassyNodeComposite;
import raf.dsw.classycraft.app.repository.composite.NodeType;
import raf.dsw.classycraft.app.repository.factory.Utils;
import raf.dsw.classycraft.app.repository.implementation.Package;
import raf.dsw.classycraft.app.repository.implementation.Project;
import raf.dsw.classycraft.app.repository.implementation.ProjectExplorer;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

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


        if (parent.getClassyNode() instanceof ProjectExplorer ){
            ClassyNode child = this.createChild(parent.getClassyNode(), NodeType.PROJECT);
            parent.add(new ClassyTreeItem(child));
            ((ProjectExplorer) parent.getClassyNode()).addChild(child);
            treeView.expandPath(treeView.getSelectionPath());
            SwingUtilities.updateComponentTreeUI(treeView);
        }

        else if (parent.getClassyNode() instanceof Project ){
            ClassyNode child = this.createChild(parent.getClassyNode(), NodeType.PACKAGE);
            parent.add(new ClassyTreeItem(child));
            ((Project) parent.getClassyNode()).addChild(child);
            treeView.expandPath(treeView.getSelectionPath());
            SwingUtilities.updateComponentTreeUI(treeView);
        }

        else if(parent.getClassyNode() instanceof Package ){
            choosePackageChild(parent);
        }

        
    }

    private  void choosePackageChild(ClassyTreeItem parent) {

        JFrame packageOption = new JFrame("Izaberite paket ili dijagram");
        packageOption.setLocationRelativeTo(null);
        packageOption.setSize(new Dimension(400, 250));
        packageOption.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        packageOption.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;

        JButton diagramBtn = new JButton("Dijagram");
        diagramBtn.setPreferredSize(new Dimension(100, 30));
        JButton packageBtn = new JButton("Paket");
        packageBtn.setPreferredSize(new Dimension(100, 30));

        panel.add(diagramBtn, gbc);
        gbc.gridy = 1;
        panel.add(packageBtn, gbc);
        packageOption.add(panel);
        packageOption.setVisible(true);

        diagramBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ClassyNode child = createChild(parent.getClassyNode(), NodeType.DIAGRAM);
                System.out.println("Created child: " + child.getClass().getName());

                parent.add(new ClassyTreeItem(child));
                ((Package) parent.getClassyNode()).addChild(child);
                treeView.expandPath(treeView.getSelectionPath());
                SwingUtilities.updateComponentTreeUI(treeView);
                packageOption.setVisible(false);
            }


        });

        packageBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ClassyNode child = createChild(parent.getClassyNode(), NodeType.PACKAGE);
                System.out.println("Created child: " + child.getClass().getName());

                parent.add(new ClassyTreeItem(child));
                ((Package) parent.getClassyNode()).addChild(child);
                treeView.expandPath(treeView.getSelectionPath());
                SwingUtilities.updateComponentTreeUI(treeView);
                packageOption.setVisible(false);
            }


        });
    }

    private ClassyNode createChild(ClassyNode parent, NodeType type) {

        return Utils.getFactory(type).getClassyNode(parent);


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
            treeView.setSelectionPath(new TreePath(parent.getPath()));
        }



    }



    @Override
    public ClassyTreeItem getSelectedNode() {
        return (ClassyTreeItem) treeView.getLastSelectedPathComponent();
    }

    @Override
    public ClassyTreeItem findNode(ClassyNode parent) {
        return searchTree((ClassyTreeItem) treeModel.getRoot(), parent);
    }


    private ClassyTreeItem searchTree(ClassyTreeItem currentItem, ClassyNode targetNode) {
        if (isMatching(currentItem, targetNode))
            return currentItem;

        Enumeration children = currentItem.children();
        while (children.hasMoreElements()) {
            ClassyTreeItem child = (ClassyTreeItem) children.nextElement();
            ClassyTreeItem result = searchTree(child, targetNode);
            if (result != null)
                return result;
        }
        return null;
    }

    private boolean isMatching(ClassyTreeItem currentItem, ClassyNode targetNode) {
        return currentItem.getClassyNode().equals(targetNode);
    }

    @Override
    public void loadProject(Project project) {

    }

}
