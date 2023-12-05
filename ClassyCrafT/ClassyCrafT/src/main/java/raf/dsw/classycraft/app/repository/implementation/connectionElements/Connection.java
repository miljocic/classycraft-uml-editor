package raf.dsw.classycraft.app.repository.implementation.connectionElements;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.implementation.DiagramElement;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Interclass;

@Getter
@Setter
public abstract class Connection extends DiagramElement {

    private Interclass from;
    private Interclass to;

    public Connection(String name, ClassyNode parent, Interclass from, Interclass to) {
        super(name, parent,2, 0x000000, 0, 0);
        this.from = from;
        this.to = to;
    }


}