package raf.dsw.classycraft.app.repository.implementation;

import raf.dsw.classycraft.app.repository.composite.ClassyNode;

import java.awt.*;

public abstract class DiagramElement extends ClassyNode {

    Color color;
    Integer stroke;

    public DiagramElement(String name, ClassyNode parent) {
        super(name, parent);
        this.color = color;
        this.stroke = stroke;
    }
}
