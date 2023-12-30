package raf.dsw.classycraft.app.repository.implementation.classcontentElements;

import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.implementation.DiagramElement;

import java.awt.*;

public abstract class ClassContent extends DiagramElement {


    public ClassContent(String name, ClassyNode parent, Color color, int stroke) {
        super(name, parent, color, stroke);
        className = "ClassContent";
    }

    public ClassContent(String name, Color color, int stroke) {
        super(name, color, stroke);
        className = "ClassContent";
    }
}