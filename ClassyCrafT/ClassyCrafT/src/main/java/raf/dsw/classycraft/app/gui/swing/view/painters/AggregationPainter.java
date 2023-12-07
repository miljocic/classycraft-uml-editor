package raf.dsw.classycraft.app.gui.swing.view.painters;

import raf.dsw.classycraft.app.repository.implementation.connectionElements.Connection;

import java.awt.*;

public class AggregationPainter extends ConnectionPainter {
    public AggregationPainter(Connection connection) {
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

        // Draw line with an empty diamond at the beginning
        drawLineWithEmptyDiamond(g, xFrom, yFrom, xTo, yTo);

    }

    private void drawLineWithEmptyDiamond(Graphics2D g, double x1, double y1, double x2, double y2) {
        g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);

        // Determine the direction of the line and draw the empty diamond accordingly
        if (x1 == x2) {
            // Vertical line
            if (y1 < y2) {
                drawEmptyDiamond(g, x1, y1);
            } else {
                drawEmptyDiamond(g, x1, y2);
            }
        } else if (y1 == y2) {
            // Horizontal line
            if (x1 < x2) {
                drawEmptyDiamond(g, x1, y1);
            } else {
                drawEmptyDiamond(g, x2, y1);
            }
        } else {
            // Diagonal line (choose the appropriate side based on the slope)
            if (Math.abs(x2 - x1) > Math.abs(y2 - y1)) {
                if (x1 < x2) {
                    drawEmptyDiamond(g, x1, y1);
                } else {
                    drawEmptyDiamond(g, x2, y2);
                }
            } else {
                if (y1 < y2) {
                    drawEmptyDiamond(g, x1, y1);
                } else {
                    drawEmptyDiamond(g, x2, y2);
                }
            }
        }
    }

    private void drawEmptyDiamond(Graphics2D g, double x, double y) {

        int[] xPoints = {(int) x, (int) x - 10, (int) x, (int) x + 10};
        int[] yPoints = {(int) y - 10, (int) y, (int) y + 10, (int) y};
        g.drawPolygon(xPoints, yPoints, 4);
    }
}