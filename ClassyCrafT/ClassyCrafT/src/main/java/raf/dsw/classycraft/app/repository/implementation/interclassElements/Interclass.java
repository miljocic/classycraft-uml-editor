package raf.dsw.classycraft.app.repository.implementation.interclassElements;

import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.implementation.DiagramElement;
import raf.dsw.classycraft.app.repository.implementation.classcontentElements.ClassContent;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Interclass extends DiagramElement {

    private String visibility;
    private Point location;
    private List<ClassContent> classContents;
    private String name;

    public Interclass(String name, ClassyNode parent, String visibility) {
        super(name, parent);
        this.visibility = visibility;
        this.location = location;
        this.classContents = new ArrayList<>();
        this.name = name;
    }
}