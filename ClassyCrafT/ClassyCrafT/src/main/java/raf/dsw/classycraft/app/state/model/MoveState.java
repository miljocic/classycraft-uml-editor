package raf.dsw.classycraft.app.state.model;

import java.awt.Point;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.painters.ElementPainter;
import raf.dsw.classycraft.app.gui.swing.view.painters.InterclassPainter;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Interclass;
import raf.dsw.classycraft.app.state.State;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.Map;

public class MoveState implements State {

    private Point2D startPoint;
    private Map<Interclass, Point2D.Double> initialPositions;

    @Override
    public void mousePressed(MouseEvent e, DiagramView dV) {
        initialPositions = new HashMap<>();
        startPoint = e.getPoint();
        for (ElementPainter elementPainter : dV.getSelectedPainters()) {
            if (elementPainter instanceof InterclassPainter) {
                Interclass interclass = (Interclass) elementPainter.getElement();
                initialPositions.put(interclass, new Point2D.Double(interclass.getLocation().getX(), interclass.getLocation().getY()));
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e, DiagramView dV) {
        initialPositions = null;
    }

    @Override
    public void mouseDragged(MouseEvent e, DiagramView dV) {
        if (initialPositions != null) {
            Point2D currentPoint = e.getPoint();
            double xTranslate = (currentPoint.getX() - startPoint.getX()) / dV.getScalingFactor();
            double yTranslate = (currentPoint.getY() - startPoint.getY()) / dV.getScalingFactor();

            for (Map.Entry<Interclass, Point2D.Double> entry : initialPositions.entrySet()) {
                Interclass interclass = entry.getKey();
                Point2D.Double initialPosition = entry.getValue();

                double newX = initialPosition.getX() + xTranslate;
                double newY = initialPosition.getY() + yTranslate;

                interclass.setLocation(new Point2D.Double(newX, newY));
            }

            startPoint = currentPoint;
            dV.repaint();
        }
    }
}
