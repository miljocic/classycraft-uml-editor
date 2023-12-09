package raf.dsw.classycraft.app.repository.implementation.interclassElements;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.repository.composite.ClassyNode;

import java.awt.*;

@Getter
@Setter
public class Class extends Interclass{


    public Class(String name, ClassyNode parent, Point location, String visibility, Dimension dimension) {
        super(name, parent, location, visibility, dimension);
    }


}