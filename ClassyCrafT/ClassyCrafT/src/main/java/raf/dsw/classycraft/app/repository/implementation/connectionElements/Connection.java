package raf.dsw.classycraft.app.repository.implementation.connectionElements;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.implementation.DiagramElement;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Interclass;

import java.awt.*;

@Getter
@Setter
public abstract class Connection extends DiagramElement {

    private Interclass from;
    private Interclass to;
    private final String type = "Connection";

    public Connection(String name, ClassyNode parent, Interclass from, Interclass to) {
        super(name, parent, Color.BLACK, 2);
        this.from = from;
        this.to = to;
    }

    public abstract boolean intersectsRectangle(Rectangle rect);


}