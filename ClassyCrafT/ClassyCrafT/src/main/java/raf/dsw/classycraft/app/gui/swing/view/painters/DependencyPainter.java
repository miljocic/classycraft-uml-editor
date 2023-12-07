package raf.dsw.classycraft.app.gui.swing.view.painters;

import raf.dsw.classycraft.app.repository.implementation.connectionElements.Connection;

import java.awt.*;

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

        // Draw a line from midpoints on each side
        drawLineFromMidpoints(g, xFrom, yFrom, xTo, yTo);

        // Draw arrowhead at the end
        drawArrowhead(g, xTo, yTo, xFrom, yFrom);
    }

    private void drawLineFromMidpoints(Graphics2D g, double xFrom, double yFrom, double xTo, double yTo) {
        double arrowSize = 10.0; // Adjust arrow size based on your requirements
        double offs = 20 * Math.PI / 180.0;

        // Calculate midpoints
        double midXFrom = (xFrom + xTo) / 2;
        double midYFrom = (yFrom + yTo) / 2;

        double midXTo = (xTo + xFrom) / 2;
        double midYTo = (yTo + yFrom) / 2;

        // Draw a line from midpoints
        g.drawLine((int) midXFrom, (int) midYFrom, (int) midXTo, (int) midYTo);
    }

    private void drawArrowhead(Graphics2D g, double xFrom, double yFrom, double xTo, double yTo) {
        double arrowSize = 10.0; // Adjust arrow size based on your requirements
        double offs = 20 * Math.PI / 180.0;

        double angle = Math.atan2(yFrom - yTo, xFrom - xTo);
        int[] xs = {(int) (xTo + 20 * Math.cos(angle + offs)), (int) xTo,
                (int) (xTo + 20 * Math.cos(angle - offs))};
        int[] ys = {(int) (yTo + 20 * Math.sin(angle + offs)), (int) yTo,
                (int) (yTo + 20 * Math.sin(angle - offs))};

        g.fillPolygon(xs, ys, 3);
    }
}