package raf.dsw.classycraft.app.gui.swing.tree.model;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.logg.messages.ErrorType;
import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.implementation.ProjectExplorer;

import javax.swing.tree.DefaultMutableTreeNode;

@Getter
@Setter
public class ClassyTreeItem extends DefaultMutableTreeNode {

    private ClassyNode classyNode;

    public ClassyTreeItem(ClassyNode classyModel) {
        this.classyNode = classyModel;
    }

    @Override
    public String toString() {
        return classyNode.getName();
    }

    public void setName(String name) {
        if (!(this.getClassyNode() instanceof ProjectExplorer)) {
            this.classyNode.setName(name);
        } else {
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage(ErrorType.NODE_CANNOT_BE_RENAMED);
        }

    }

}
