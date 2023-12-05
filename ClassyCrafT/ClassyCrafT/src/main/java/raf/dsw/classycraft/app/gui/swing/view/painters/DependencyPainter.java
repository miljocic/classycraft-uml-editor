package raf.dsw.classycraft.app.gui.swing.view.painters;

import raf.dsw.classycraft.app.repository.implementation.connectionElements.Connection;

import java.awt.*;

public class DependencyPainter extends ConnectionPainter {
    public DependencyPainter(Connection connection) {
        super(connection);
    }

    @Override
    public void paint(Graphics2D g) {
        // Set stroke to a dashed pattern
        float[] dashPattern = {5, 5}; // Adjust these values for different dash lengths
        BasicStroke dashedStroke = new BasicStroke(element.getStroke(), BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 10, dashPattern, 0);
        g.setStroke(dashedStroke);

        g.setColor(new Color(element.getColor()));

        Connection connection = (Connection) element;

        double xFrom = connection.getFrom().getXCoordinate();
        double yFrom = connection.getFrom().getYCoordinate();

        double xTo = connection.getTo().getXCoordinate();
        double yTo = connection.getTo().getYCoordinate();

        g.drawLine((int) xFrom, (int) yFrom, (int) xTo, (int) yTo);
    }

}