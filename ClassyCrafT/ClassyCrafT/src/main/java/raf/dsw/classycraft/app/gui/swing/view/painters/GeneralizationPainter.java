package raf.dsw.classycraft.app.gui.swing.view.painters;

import raf.dsw.classycraft.app.repository.implementation.connectionElements.Connection;

import java.awt.*;

public class GeneralizationPainter extends ConnectionPainter {
    public GeneralizationPainter(Connection connection) {
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

        // Draw arrow with empty triangle at the end
        drawArrow(g, xFrom, yFrom, xTo, yTo);
        drawTriangle(g, xTo, yTo);
    }

    private void drawArrow(Graphics2D g, double x1, double y1, double x2, double y2) {
        // Implement arrow drawing logic here
        g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
    }

    private void drawTriangle(Graphics2D g, double x, double y) {
        // Implement triangle drawing logic here
        // For example, draw a triangle using three lines
        int[] xPoints = {(int) x, (int) x + 10, (int) x - 10};
        int[] yPoints = {(int) y - 10, (int) y, (int) y};
        g.drawPolygon(xPoints, yPoints, 3);
    }

}