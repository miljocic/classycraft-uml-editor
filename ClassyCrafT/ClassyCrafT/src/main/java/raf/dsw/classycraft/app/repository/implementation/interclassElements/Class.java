package raf.dsw.classycraft.app.repository.implementation.interclassElements;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.implementation.classcontentElements.ClassContent;

import java.awt.*;
import java.util.List;

@Getter
@Setter
public class Class extends Interclass {


    public Class(String name, ClassyNode parent, Point location, String visibility, Dimension dimension) {
        super(name, parent, location, visibility, dimension);
        className = "Class";
    }

    public Class(String name, Color color, int stroke, List<ClassContent> classContents, Dimension dimension, Point location, String visibility) {
        super(name, color, stroke, classContents, dimension, location, visibility);
        className = "Class";
    }
}