package raf.dsw.classycraft.app.repository.implementation.interclassElements;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.implementation.classcontentElements.Attribute;
import raf.dsw.classycraft.app.repository.implementation.classcontentElements.Method;

import java.awt.*;

@Getter
@Setter
public class Class extends Interclass{


    public Class(String name, ClassyNode parent, Point location, String visibility, Dimension dimension) {
        super(name, parent, location, visibility, dimension);
    }

    public void addAttribute(String visibility, String attributeName) {
        Attribute attribute = new Attribute(attributeName, this, Color.BLACK, 2);
        addClassContent(attribute);
    }

    public void addMethod(String visibility, String methodName) {
        Method method = new Method(methodName, this, Color.BLACK, 2);
        addClassContent(method);
    }
}