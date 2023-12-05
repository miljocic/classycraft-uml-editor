package raf.dsw.classycraft.app.repository.implementation.interclassElements;

import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.implementation.classcontentElements.ClassContent;


public class Class extends Interclass {

    private ClassContent classContent;

    public Class(String name, ClassyNode parent, Integer stroke, int color, double xCoordinate, double yCoordinate) {
        super(name, parent, stroke, color, xCoordinate, yCoordinate);
        this.classContent= classContent;
    }



}
