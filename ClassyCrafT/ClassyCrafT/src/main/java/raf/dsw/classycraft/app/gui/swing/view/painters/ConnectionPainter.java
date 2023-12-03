package raf.dsw.classycraft.app.gui.swing.view.painters;

import raf.dsw.classycraft.app.repository.implementation.DiagramElement;
import raf.dsw.classycraft.app.repository.implementation.connectionElements.Connection;

import javax.swing.text.Element;
import java.awt.*;
import java.awt.geom.Line2D;

public class ConnectionPainter extends ElementPainter {

    private Shape shape;
    private DiagramElement element;
    private Point pos1;
    private Point pos2;

    public ConnectionPainter(Connection connection) {
        super(connection);

    }

    @Override
    public void paint(Graphics2D g) {

    }

    @Override
    public boolean elementAt(Point pos) {
        return false;
    }
}
