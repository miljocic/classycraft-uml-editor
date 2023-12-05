package raf.dsw.classycraft.app.repository.implementation.interclassElements;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.implementation.DiagramElement;
import raf.dsw.classycraft.app.repository.implementation.classcontentElements.ClassContent;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class Interclass extends DiagramElement {


    private List<ClassContent> classContents;
    private String name;

    public Interclass(String name, ClassyNode parent, Integer stroke, int color, double xCoordinate, double yCoordinate) {
        super(name, parent, stroke, color, xCoordinate, yCoordinate);
        this.classContents = new ArrayList<>();
        this.name = name;
    }




}