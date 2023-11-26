package raf.dsw.classycraft.app.repository.composite;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class ClassyNodeComposite extends ClassyNode{

    List<ClassyNode> children;

    public ClassyNodeComposite(String name, ClassyNode parent) {
        super(name, parent);
        this.children = new ArrayList<>();
    }

    public ClassyNodeComposite(String name, ClassyNode parent, List<ClassyNode> children) {
        super(name, parent);
        this.children = children;
    }

    public abstract void addChild(ClassyNode child);
    public abstract void deleteChild(ClassyNode child);

    public ClassyNode getChildByName(String name) {
        for (ClassyNode child: this.getChildren()) {
            if (name.equals(child.getName())) {
                return child;
            }
        }
        return null;
    }

    public List<ClassyNode> getChildren() {
        return children;
    }


}
