package raf.dsw.classycraft.app.repository.implementation;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.repository.composite.ClassyNode;

import java.awt.*;

@Getter
@Setter
public abstract class DiagramElement extends ClassyNode {

    Color color;
    Integer stroke;

    public DiagramElement(String name, ClassyNode parent) {
        super(name, parent);
        this.color = color;
        this.stroke = stroke;
    }

}
