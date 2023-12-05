package raf.dsw.classycraft.app.repository.implementation;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.repository.composite.ClassyNode;


@Getter
@Setter
public abstract class DiagramElement extends ClassyNode {

    private int  color;
    Integer stroke;
    private double xCoordinate;
    private double yCoordinate;

    public DiagramElement(String name, ClassyNode parent,Integer stroke, int color, double xCoordinate, double yCoordinate) {
        super(name, parent);
        this.color = color;
        this.stroke = stroke;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

}
