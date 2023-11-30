package raf.dsw.classycraft.app.gui.swing.view;

import raf.dsw.classycraft.app.repository.implementation.DiagramElement;

import java.awt.*;

public abstract class DiagramElementView {
    protected DiagramElement element;
    protected Shape shape;

    public DiagramElementView(DiagramElement element) {
        this.element = element;
    }

    public abstract void paint(Graphics2D g);
    public boolean elementAt(Point pos) {
        return shape.contains(pos);
    }
}
