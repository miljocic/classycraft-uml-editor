package raf.dsw.classycraft.app.gui.swing.view.painters;

import raf.dsw.classycraft.app.repository.implementation.DiagramElement;
import raf.dsw.classycraft.app.repository.implementation.connectionElements.Connection;

import java.awt.*;

public class CompositionPainter extends ConnectionPainter {
    public CompositionPainter(Connection connection) {
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

        // Draw line with a black diamond at the beginning
        drawLineWithDiamond(g, xFrom, yFrom, xTo, yTo);
    }


    private void drawLineWithDiamond(Graphics2D g, double x1, double y1, double x2, double y2) {
        // Implement line with diamond drawing logic here
        g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
        drawDiamond(g, x1, y1);
    }

    private void drawDiamond(Graphics2D g, double x, double y) {
        // Implement diamond drawing logic here
        int[] xPoints = {(int) x, (int) x - 10, (int) x, (int) x + 10};
        int[] yPoints = {(int) y - 10, (int) y, (int) y + 10, (int) y};
        g.fillPolygon(xPoints, yPoints, 4);
    }
}