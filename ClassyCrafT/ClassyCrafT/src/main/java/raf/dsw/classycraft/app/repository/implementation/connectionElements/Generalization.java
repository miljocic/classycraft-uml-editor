package raf.dsw.classycraft.app.repository.implementation.connectionElements;

import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Interclass;

import java.awt.*;

public class Generalization extends Connection {


    public Generalization(String name, ClassyNode parent, Interclass from, Interclass to) {
        super(name, parent, from, to);
        className = "Generalization";
    }

    public Generalization(String name, Color color, int stroke, Interclass from, Interclass to) {
        super(name, color, stroke, from, to);
        className = "Generalization";
    }

    @Override
    public boolean intersectsRectangle(Rectangle rect) {

        return rect.contains((int) getFrom().getLocation().getX(), (int) getFrom().getLocation().getY())
                || rect.contains((int) getTo().getLocation().getX(), (int) getTo().getLocation().getY())
                || lineIntersectsRectangle(rect, getFrom().getLocation(), getTo().getLocation());
    }


    private boolean lineIntersectsRectangle(Rectangle rect, Point p1, Point p2) {
        return rect.intersectsLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }
}
