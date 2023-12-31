package raf.dsw.classycraft.app.gui.swing.view.painters;


import raf.dsw.classycraft.app.repository.implementation.connectionElements.Aggregation;
import raf.dsw.classycraft.app.repository.implementation.connectionElements.Connection;
import raf.dsw.classycraft.app.repository.implementation.connectionElements.Dependency;

import java.awt.*;
import java.awt.geom.Path2D;
import java.util.ArrayList;

public class DependencyPainter extends ConnectionPainter {

    private Connection d;

    public DependencyPainter(Connection connection) {
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
        g.drawLine((int) beginningPoint.getX(), (int) beginningPoint.getY(), (int)  endPoint.getX(), (int) endPoint.getY());
        drawArrowHead(g, beginningPoint, endPoint);
    }

    private void drawArrowHead(Graphics2D g, Point start, Point end) {
        double angle = Math.atan2(end.getY() - start.getY(), end.getX() - start.getX());


        int arrowLength = 10;


        int x1 = (int) (end.getX() - arrowLength * Math.cos(angle - Math.PI / 6));
        int y1 = (int) (end.getY() - arrowLength * Math.sin(angle - Math.PI / 6));

        int x2 = (int) (end.getX() - arrowLength * Math.cos(angle + Math.PI / 6));
        int y2 = (int) (end.getY() - arrowLength * Math.sin(angle + Math.PI / 6));


        Path2D arrowhead = new Path2D.Double();
        arrowhead.moveTo(end.getX(), end.getY());
        arrowhead.lineTo(x1, y1);
        arrowhead.moveTo(end.getX(), end.getY());
        arrowhead.lineTo(x2, y2);

        g.setColor(Color.BLACK);
        g.draw(arrowhead);
    }
    @Override
    public Connection getConnection() {
        return (Dependency) getElement();
    }
}