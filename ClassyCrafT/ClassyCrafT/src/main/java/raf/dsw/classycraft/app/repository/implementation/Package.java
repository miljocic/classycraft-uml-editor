package raf.dsw.classycraft.app.repository.implementation;

import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.composite.ClassyNodeComposite;

public class Package extends ClassyNodeComposite {  // ima JFPane i neke tabove
    public Package(String name, ClassyNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(ClassyNode child) {
        if (child != null &&  child instanceof Package ){
            Package paket = (Package) child;
            if (!this.getChildren().contains(paket)){
                this.getChildren().add(paket);
            }
        }
        else if (child != null &&  child instanceof Diagram ){
            Diagram diagram = (Diagram) child;
            if (!this.getChildren().contains(diagram)){
                this.getChildren().add(diagram);
            }
        }
    }

    @Override
    public void deleteChild(ClassyNode child) {
        Package paket = (Package) child;
        if(this.getChildren().contains(paket))
        {
            this.getChildren().remove(paket);
        }
        Diagram diagram = (Diagram) child;
        if(this.getChildren().contains(diagram))
        {
            this.getChildren().remove(diagram);
        }
    }
}
