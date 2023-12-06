package raf.dsw.classycraft.app.gui.swing.view.painters;

import raf.dsw.classycraft.app.repository.implementation.connectionElements.*;

import java.awt.*;

public  abstract class ConnectionPainter extends ElementPainter {

    public ConnectionPainter(Connection connection) {
        super(connection);
    }

    @Override
    public void paint(Graphics2D g) {
        Connection connection = (Connection) element;

        double xFrom = connection.getFrom().getXCoordinate();
        double yFrom = connection.getFrom().getYCoordinate();

        double xTo = connection.getTo().getXCoordinate();
        double yTo = connection.getTo().getYCoordinate();

        if (connection instanceof Aggregation) {
            // Draw arrow with empty rhombus at the beginning
            drawArrow(g, xFrom, yFrom, xTo, yTo);
            drawRhombus(g, xFrom, yFrom);
        } else if (connection instanceof Generalization) {
            // Draw arrow with empty triangle at the end
            drawArrow(g, xFrom, yFrom, xTo, yTo);
            drawTriangle(g, xTo, yTo);
        } else if (connection instanceof Composition) {
            // Draw arrow with black rhombus at the beginning
            drawArrow(g, xFrom, yFrom, xTo, yTo);
            drawFilledRhombus(g, xFrom, yFrom);
        } else if (connection instanceof Dependency) {
            // Draw interrupted line for Dependency
            drawDashedLine(g, xFrom, yFrom, xTo, yTo);
        }
    }


    public static void drawArrow(Graphics2D g, double x1, double y1, double x2, double y2) {
        // Replace this with actual arrow drawing logic
        g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
    }

    public static void drawRhombus(Graphics2D g, double x, double y) {
        // Replace this with actual rhombus drawing logic
        // For example, draw a rhombus using four lines
        g.drawLine((int) x, (int) y - 10, (int) x + 10, (int) y);
        g.drawLine((int) x + 10, (int) y, (int) x, (int) y + 10);
        g.drawLine((int) x, (int) y + 10, (int) x - 10, (int) y);
        g.drawLine((int) x - 10, (int) y, (int) x, (int) y - 10);
    }

    public static void drawTriangle(Graphics2D g, double x, double y) {
        // Replace this with actual triangle drawing logic
        // For example, draw a triangle using three lines
        g.drawLine((int) x, (int) y - 10, (int) x + 10, (int) y + 10);
        g.drawLine((int) x + 10, (int) y + 10, (int) x - 10, (int) y + 10);
        g.drawLine((int) x - 10, (int) y + 10, (int) x, (int) y - 10);
    }

    public static void drawFilledRhombus(Graphics2D g, double x, double y) {
        // Replace this with actual filled rhombus drawing logic
        // For example, fill a rhombus using Polygon
        int[] xPoints = {(int) x, (int) x + 10, (int) x, (int) x - 10};
        int[] yPoints = {(int) y - 10, (int) y, (int) y + 10, (int) y};
        g.fillPolygon(xPoints, yPoints, 4);
    }

    public static void drawDashedLine(Graphics2D g, double x1, double y1, double x2, double y2) {
        // Replace this with actual dashed line drawing logic
        // For example, draw a dashed line using Stroke
        Stroke oldStroke = g.getStroke();
        g.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{5}, 0));
        g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
        g.setStroke(oldStroke);
    }

    @Override
    public boolean elementAt(Point pos) {
        if (element instanceof Connection) {
            Connection connection = (Connection) element;

            double xFrom = connection.getFrom().getXCoordinate();
            double yFrom = connection.getFrom().getYCoordinate();

            double xTo = connection.getTo().getXCoordinate();
            double yTo = connection.getTo().getYCoordinate();


            double tolerance = 5.0;


            return pointToLineDistance(xFrom, yFrom, xTo, yTo, pos.getX(), pos.getY()) < tolerance;
        }


        return false;
    }

    private double pointToLineDistance(double x1, double y1, double x2, double y2, double x, double y) {
        double A = x - x1;
        double B = y - y1;
        double C = x2 - x1;
        double D = y2 - y1;

        double dot = A * C + B * D;
        double lenSq = C * C + D * D;
        double param = dot / lenSq;

        double xx, yy;

        if (param < 0 || (x1 == x2 && y1 == y2)) {
            xx = x1;
            yy = y1;
        } else if (param > 1) {
            xx = x2;
            yy = y2;
        } else {
            xx = x1 + param * C;
            yy = y1 + param * D;
        }

        double dx = x - xx;
        double dy = y - yy;
        return Math.sqrt(dx * dx + dy * dy);
    }


    @Override
    public void paintSelected(Graphics2D g) {

    }
}
