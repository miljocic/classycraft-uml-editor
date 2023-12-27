package raf.dsw.classycraft.app.repository.implementation;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.repository.composite.ClassyNode;

import java.awt.*;

@Getter
@Setter
public abstract class DiagramElement extends ClassyNode {

    private Color color;
    private int stroke;

    public DiagramElement(String name, ClassyNode parent, Color color, int stroke) {
        super(name, parent);
        this.color =color;
        this.stroke = stroke;
    }
}
