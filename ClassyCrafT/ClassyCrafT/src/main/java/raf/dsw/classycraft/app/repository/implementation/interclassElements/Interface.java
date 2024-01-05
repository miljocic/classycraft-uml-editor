package raf.dsw.classycraft.app.repository.implementation.interclassElements;

import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.implementation.classcontentElements.ClassContent;

import java.awt.*;
import java.util.List;

public class Interface extends Interclass {


    public Interface(String name, ClassyNode parent, Point location, String visibility, Dimension dimension) {
        super(name, parent, location, visibility, dimension);
        className = "Interface";
    }

    public Interface(String name, Color color, int stroke, List<ClassContent> classContents, Dimension dimension, Point location, String visibility) {
        super(name, color, stroke, classContents, dimension, location, visibility);
        className = "Interface";
    }
}