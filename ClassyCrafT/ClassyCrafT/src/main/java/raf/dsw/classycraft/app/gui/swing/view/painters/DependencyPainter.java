package raf.dsw.classycraft.app.gui.swing.view.painters;

import raf.dsw.classycraft.app.repository.implementation.connectionElements.Connection;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;

public class DependencyPainter extends ConnectionPainter {
    public DependencyPainter(Connection connection) {
        super(connection);
    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);
        Connection connection = (Connection) element;

        double xFrom = connection.getFrom().getXCoordinate();
        double yFrom = connection.getFrom().getYCoordinate();

        double xTo = connection.getTo().getXCoordinate();
        double yTo = connection.getTo().getYCoordinate();

        // Calculate midpoint coordinates
        double midX = (xFrom + xTo) / 2.0;
        double midY = (yFrom + yTo) / 2.0;

        // Draw a simple line from one element to another
        g.drawLine((int) xFrom, (int) yFrom, (int) xTo, (int) yTo);

        // Draw arrowhead at the midpoint
        drawArrowhead(g, midX, midY, xTo, yTo);
    }

    private void drawArrowhead(Graphics2D g, double xFrom, double yFrom, double xTo, double yTo) {
        double arrowSize = 10.0; // Adjust arrow size based on your requirements

        double angle = Math.atan2(yTo - yFrom, xTo - xFrom);
        AffineTransform tx = g.getTransform();
        tx.translate(xTo, yTo);
        tx.rotate(angle - Math.PI / 2.0);

        Path2D arrow = new Path2D.Double();
        arrow.moveTo(0, -arrowSize / 2.0);
        arrow.lineTo(arrowSize, 0);
        arrow.lineTo(0, arrowSize / 2.0);
        arrow.closePath();

        g.fill(tx.createTransformedShape(arrow));
    }

}