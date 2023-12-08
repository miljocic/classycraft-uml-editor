package raf.dsw.classycraft.app.repository.implementation.interclassElements;

import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.implementation.classcontentElements.Method;

import java.awt.*;

public class Interface extends Interclass {


    public Interface(String name, ClassyNode parent, Point location, String visibility, Dimension dimension) {
        super(name, parent, location, visibility, dimension);
    }

    public void addMethod(String visibility, String methodName) {
        Method method = new Method(methodName, this, Color.BLACK, 2);
        addClassContent(method);
    }
}