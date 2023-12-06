package raf.dsw.classycraft.app.repository.implementation.interclassElements;

import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.implementation.classcontentElements.ClassContent;

import java.awt.*;

public class Class extends Interclass {

    public Class(String name, ClassyNode parent, Integer stroke, int color, double xCoordinate, double yCoordinate, String visibility) {
        super(name, parent, stroke, color, xCoordinate, yCoordinate, visibility);
    }
}
