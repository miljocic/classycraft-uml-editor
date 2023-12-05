package raf.dsw.classycraft.app.repository.implementation.classcontentElements;

import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.implementation.DiagramElement;

public abstract class ClassContent extends DiagramElement {


    public ClassContent(String name, ClassyNode parent, Integer stroke, int color, double xCoordinate, double yCoordinate) {
        super(name, parent, stroke, color, xCoordinate, yCoordinate);
    }
}
