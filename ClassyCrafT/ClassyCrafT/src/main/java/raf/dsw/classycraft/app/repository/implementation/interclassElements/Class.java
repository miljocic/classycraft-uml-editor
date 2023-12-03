package raf.dsw.classycraft.app.repository.implementation.interclassElements;

import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.implementation.classcontentElements.ClassContent;

import java.awt.*;

public class Class extends Interclass {

    private ClassContent classContent;

    public Class(String name, ClassyNode parent, String visibility, Point location) {
        super(name, parent, visibility, location);
        this.classContent= classContent;

    }


}
