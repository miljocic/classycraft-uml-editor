package raf.dsw.classycraft.app.repository.implementation;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.repository.composite.ClassyNode;

import java.awt.*;

@Getter
@Setter
public abstract class DiagramElement extends ClassyNode {

    private Color color;
    private Integer stroke;
    private Point location;


    public DiagramElement(String name, ClassyNode parent) {
        super(name, parent);
        this.color = Color.BLACK;
        this.stroke = 1;
        this.location = new Point(0, 0);
    }



}
