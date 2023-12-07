package raf.dsw.classycraft.app.repository.implementation.interclassElements;

import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.implementation.classcontentElements.Attribute;
import raf.dsw.classycraft.app.repository.implementation.classcontentElements.ClassContent;
import raf.dsw.classycraft.app.repository.implementation.classcontentElements.Method;

import java.awt.*;

public class Class extends Interclass {


    public Class(String name, ClassyNode parent, Integer stroke, int color, double xCoordinate, double yCoordinate, double width, double height, String visibility) {
        super(name, parent, stroke, color, xCoordinate, yCoordinate, width, height, visibility);
    }

    public void addAttribute(String visibility, String attributeName) {
        Attribute attribute = new Attribute(attributeName, this, null, 0, 0, 0, visibility);
        addClassContent(attribute);
    }

    public void addMethod(String visibility, String methodName) {
        Method method = new Method(methodName, this, null, 0, 0, 0, visibility);
        addClassContent(method);
    }
}
