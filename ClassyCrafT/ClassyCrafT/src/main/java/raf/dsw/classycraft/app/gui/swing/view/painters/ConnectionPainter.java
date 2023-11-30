package raf.dsw.classycraft.app.gui.swing.view.painters;

import raf.dsw.classycraft.app.repository.implementation.DiagramElement;

import javax.swing.text.Element;
import java.awt.*;
import java.awt.geom.Line2D;

public class ConnectionPainter extends ElementPainter{

    private Shape shape;
    private DiagramElement element;
    private Point pos1;
    private Point pos2;

    public ConnectionPainter(DiagramElement element, Point pos1, Point pos2) {
        super(element);
        this.element = element;
        this.pos1 = pos1;
        this.pos2 = pos2;
    }

    @Override
    public void paint(Graphics2D g) {
        Graphics2D graphics = (Graphics2D) g;
        graphics.setColor(element.getColor());
        shape = new Line2D.Float(pos1.x, pos1.y, pos2.x, pos2.y);
        graphics.setStroke(new BasicStroke(2));
        graphics.draw(getShape());
    }

    @Override
    public boolean elementAt(Point pos) {
        return getShape().contains(pos);
    }


}
