package raf.dsw.classycraft.app.repository.implementation.interclassElements;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.implementation.DiagramElement;
import raf.dsw.classycraft.app.repository.implementation.classcontentElements.Attribute;
import raf.dsw.classycraft.app.repository.implementation.classcontentElements.ClassContent;
import raf.dsw.classycraft.app.repository.implementation.classcontentElements.Method;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class Interclass extends DiagramElement {


    private List<ClassContent> classContents;
    private String name;
    private String visibility;

    public Interclass(String name, ClassyNode parent, Integer stroke, int color, double xCoordinate, double yCoordinate, double width, double height, String visibility) {
        super(name, parent, stroke, color, xCoordinate, yCoordinate, width, height);
        this.classContents = new ArrayList<>();
        this.name = name;
        this.visibility = visibility;
    }



    public List<String> getAttributes() {
        List<String> attributes = new ArrayList<>();
        for (ClassContent content : classContents) {
            if (content instanceof Attribute) {
                attributes.add(content.getName());
            }
        }
        return attributes;
    }

    public List<String> getMethods() {
        List<String> methods = new ArrayList<>();
        for (ClassContent content : classContents) {
            if (content instanceof Method) {
                methods.add(content.getName());
            }
        }
        return methods;
    }
}