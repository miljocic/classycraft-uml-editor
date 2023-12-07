package raf.dsw.classycraft.app.gui.swing.view.painters;

import raf.dsw.classycraft.app.repository.implementation.connectionElements.*;

import java.awt.*;

public abstract class ConnectionPainter extends ElementPainter {

    public ConnectionPainter(Connection connection) {
        super(connection);
    }

    @Override
    public void paint(Graphics2D g) {

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
