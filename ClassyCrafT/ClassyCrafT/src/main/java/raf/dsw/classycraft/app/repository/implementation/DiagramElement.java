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
    private double width;
    private double height;

    public DiagramElement(String name, ClassyNode parent,Integer stroke, int color, double xCoordinate, double yCoordinate, double width, double height) {
        super(name, parent);
        this.color = color;
        this.stroke = stroke;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.width = width;
        this.height = height;
    }

}
