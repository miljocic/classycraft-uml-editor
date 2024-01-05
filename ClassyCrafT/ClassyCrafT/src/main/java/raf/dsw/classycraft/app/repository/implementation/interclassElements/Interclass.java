package raf.dsw.classycraft.app.repository.implementation.interclassElements;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.implementation.DiagramElement;
import raf.dsw.classycraft.app.repository.implementation.Package;
import raf.dsw.classycraft.app.repository.implementation.classcontentElements.Attribute;
import raf.dsw.classycraft.app.repository.implementation.classcontentElements.ClassContent;
import raf.dsw.classycraft.app.repository.implementation.classcontentElements.Method;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class Interclass extends DiagramElement {

    private List<ClassContent> classContents;
    private Dimension dimension;
    private Point location;
    private String visibility;
    private final String type = "Interclass";
    public Interclass(String name, ClassyNode parent, Point location, String visibility, Dimension dimension) {
        super(name, parent, Color.BLACK, 2);
        this.name = name;
        this.location = location;
        this.visibility = visibility;
        this.classContents = new ArrayList<>();
        this.dimension = dimension;
        className = "Interclass";
    }
    public Interclass(String name, Color color, int stroke, List<ClassContent> classContents, Dimension dimension, Point location, String visibility) {
        super(name, color, stroke);
        this.classContents = classContents;
        if(classContents == null)
            classContents = new ArrayList<>();
        this.dimension = dimension;
        this.location = location;
        this.visibility = visibility;
        className = "Interclass";
    }
    public void addClassContent(ClassContent content) {
        classContents.add(content);
    }
    public List<String> getAttributes() {
        List<String> attributes = new ArrayList<>();
        if(classContents == null) // todo: ne radi
            classContents = new ArrayList<>();
        for (ClassContent content : classContents) {
            if (content instanceof Attribute) {
                attributes.add(content.getName());
            }
        }
        return attributes;
    }
    public List<String> getMethods() {
        List<String> methods = new ArrayList<>();
        if(classContents == null)
            classContents = new ArrayList<>();
        for (ClassContent content : classContents) {
            if (content instanceof Method) {
                methods.add(content.getName());
            }
        }
        return methods;
    }
    public void setLocation(Point location) {
        this.location = location;
        ((Package) getParent().getParent()).setChanged(true);
        notifySubscribers(this);
    }
}
