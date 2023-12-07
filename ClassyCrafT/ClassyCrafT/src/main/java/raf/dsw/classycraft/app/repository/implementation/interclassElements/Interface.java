package raf.dsw.classycraft.app.repository.implementation.interclassElements;

import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.implementation.classcontentElements.Method;

public class Interface extends Interclass {

    public Interface(String name, ClassyNode parent, Integer stroke, int color, double xCoordinate, double yCoordinate, String visibility) {
        super(name, parent, stroke, color, xCoordinate, yCoordinate, visibility);
    }


    public void addMethod(String visibility, String methodName) {
        Method method = new Method(methodName, this, null, 0, 0, 0, visibility);
        addClassContent(method);
    }
}
