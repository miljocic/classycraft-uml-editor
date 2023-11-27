package raf.dsw.classycraft.app.repository.implementation.interclassElements;

import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.implementation.DiagramElement;

public abstract class Interclass extends DiagramElement {

    private String visibility;

    public Interclass(String name, ClassyNode parent, String visibility) {
        super(name, parent);
        this.visibility = visibility;
    }


}