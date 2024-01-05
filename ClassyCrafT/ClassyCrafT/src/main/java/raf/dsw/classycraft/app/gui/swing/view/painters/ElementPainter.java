package raf.dsw.classycraft.app.gui.swing.view.painters;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.repository.implementation.DiagramElement;

import java.awt.*;


@Getter
@Setter
public abstract class ElementPainter {

    public DiagramElement element;
    public Shape shape;

    public ElementPainter(DiagramElement element) {
        this.element = element;
    }

    public ElementPainter() {
    }

    public abstract void paint(Graphics2D g);

    public abstract boolean elementAt(Point pos);

    public abstract void paintSelected(Graphics2D g);

}
