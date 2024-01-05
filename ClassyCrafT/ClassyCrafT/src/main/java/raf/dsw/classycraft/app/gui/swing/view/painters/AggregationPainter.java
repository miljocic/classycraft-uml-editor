package raf.dsw.classycraft.app.gui.swing.view.painters;

import raf.dsw.classycraft.app.repository.implementation.connectionElements.Aggregation;
import raf.dsw.classycraft.app.repository.implementation.connectionElements.Connection;

import java.awt.*;
import java.util.ArrayList;

public class AggregationPainter extends ConnectionPainter {

    private Connection d;

    public AggregationPainter(Connection connection) {
        super(connection);
        this.d = connection;
    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);

        java.util.List<Point> beginningsList = new ArrayList<>();
        beginningsList.add(new Point((int) d.getFrom().getLocation().getX() + (int) d.getFrom().getDimension().getWidth() / 2, (int) d.getFrom().getLocation().getY()));
        beginningsList.add(new Point((int) d.getFrom().getLocation().getX() + (int) d.getFrom().getDimension().getWidth() / 2, (int) d.getFrom().getLocation().getY() + (int) d.getFrom().getDimension().getHeight()));
        beginningsList.add(new Point((int) d.getFrom().getLocation().getX(), (int) d.getFrom().getLocation().getY() + (int) d.getFrom().getDimension().getHeight() / 2));
        beginningsList.add(new Point((int) d.getFrom().getLocation().getX() + (int) d.getFrom().getDimension().getWidth(), (int) d.getFrom().getLocation().getY() + (int) d.getFrom().getDimension().getHeight() / 2));

        java.util.List<Point> endingsList = new ArrayList<>();
        endingsList.add(new Point((int) d.getTo().getLocation().getX() + (int) d.getTo().getDimension().getWidth() / 2, (int) d.getTo().getLocation().getY()));
        endingsList.add(new Point((int) d.getTo().getLocation().getX() + (int) d.getTo().getDimension().getWidth() / 2, (int) d.getTo().getLocation().getY() + (int) d.getTo().getDimension().getHeight()));
        endingsList.add(new Point((int) d.getTo().getLocation().getX(), (int) d.getTo().getLocation().getY() + (int) d.getTo().getDimension().getHeight() / 2));
        endingsList.add(new Point((int) d.getTo().getLocation().getX() + (int) d.getTo().getDimension().getWidth(), (int) d.getTo().getLocation().getY() + (int) d.getTo().getDimension().getHeight() / 2));

        Point beginningPoint = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
        Point endPoint = new Point(0, 0);

        for (Point b : beginningsList) {
            for (Point e : endingsList) {
                if (b.distance(e) <= beginningPoint.distance(endPoint)) {
                    beginningPoint = b;
                    endPoint = e;
                }
            }
        }
        drawDiamond(g, (int) beginningPoint.getX(), (int) beginningPoint.getY());
        g.drawLine((int) beginningPoint.getX(), (int) beginningPoint.getY(), (int) endPoint.getX(), (int) endPoint.getY());
    }

    private void drawDiamond(Graphics2D g, int x, int y) {
        int size = 10;

        g.setColor(Color.BLACK);

        int[] xPoints = {x, x + size, x, x - size};
        int[] yPoints = {y - size, y, y + size, y};

        g.drawPolygon(xPoints, yPoints, 4);
    }

    @Override
    public Connection getConnection() {
        return (Aggregation) getElement();
    }

}