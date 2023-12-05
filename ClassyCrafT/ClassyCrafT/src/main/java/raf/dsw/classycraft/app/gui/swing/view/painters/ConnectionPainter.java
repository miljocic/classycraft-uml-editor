package raf.dsw.classycraft.app.gui.swing.view.painters;

import raf.dsw.classycraft.app.repository.implementation.connectionElements.Connection;

import java.awt.*;

public  abstract class ConnectionPainter extends ElementPainter {

    public ConnectionPainter(Connection connection) {
        super(connection);
    }

    @Override
    public void paint(Graphics2D g) {
        g.setStroke(new BasicStroke(element.getStroke()));
        g.setColor(new Color(element.getColor()));

        Connection connection = (Connection) element;

        double xFrom = connection.getFrom().getXCoordinate();
        double yFrom = connection.getFrom().getYCoordinate();

        double xTo = connection.getTo().getXCoordinate();
        double yTo = connection.getTo().getYCoordinate();

        g.drawLine((int) xFrom, (int) yFrom, (int) xTo, (int) yTo);
    }

    @Override
    public boolean elementAt(Point pos) {
        return false;
    }

    @Override
    public void paintSelected(Graphics2D g) {
        // No need to implement this for now
    }
}
