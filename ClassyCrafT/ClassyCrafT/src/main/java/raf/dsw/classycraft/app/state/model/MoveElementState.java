package raf.dsw.classycraft.app.state.model;

import raf.dsw.classycraft.app.command.commands.MoveSelectedCommand;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.painters.ElementPainter;
import raf.dsw.classycraft.app.gui.swing.view.painters.InterclassPainter;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Interclass;
import raf.dsw.classycraft.app.state.State;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.HashMap;

public class MoveElementState implements State {
    private Point startPoint;
    private HashMap<Interclass, Point> map = new HashMap<>();

    @Override
    public void mousePressed(MouseEvent e, DiagramView dV) {
        map.clear();
        startPoint = e.getPoint();
        for (ElementPainter elementPainter : dV.getSelectedElements()) {
            if (elementPainter.getElement() instanceof Interclass) {
                Interclass interclass = (Interclass) elementPainter.getElement();
                Point point = new Point((int) interclass.getLocation().getX(),
                        (int) interclass.getLocation().getY());
                map.put(interclass, point);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e, DiagramView dV) {
        for (ElementPainter elementPainter : dV.getSelectedElements()) {
            for (ElementPainter ep : dV.getElementPainters()) {
                if (ep instanceof InterclassPainter && elementPainter instanceof InterclassPainter
                        && !dV.getSelectedElements().contains(ep)
                        && elementPainter.getShape().intersects(ep.getShape().getBounds())) {
                    for (Interclass interclass : map.keySet()) {
                        interclass.setLocation(map.get(interclass));
                    }
                    dV.getSelectedElements().clear();
                    dV.repaint();
                    return;
                }
            }
        }
        MoveSelectedCommand moveSelectedCommand = new MoveSelectedCommand(dV.getDiagram(), dV, map);
        dV.getDiagram().getCommandManager().addCommand(moveSelectedCommand);
        dV.getSelectedElements().clear();
        dV.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e, DiagramView dV) {
        HashMap<Interclass, Point> help = new HashMap<>();
        Point current = e.getPoint();
        for (ElementPainter elementPainter : dV.getSelectedElements()) {
            if (elementPainter.getElement() instanceof Interclass) {
                Interclass interclass = (Interclass) elementPainter.getElement();
                help.put(interclass, new Point((int) (map.get(interclass).getX() +
                        (current.getX() - startPoint.getX()) / dV.getScalingFactor()),
                        (int) (map.get(interclass).getY() +
                                (current.getY() - startPoint.getY()) / dV.getScalingFactor())));
            }
        }
        for (Interclass interclass : help.keySet()) {
            interclass.setLocation(help.get(interclass));
        }
        dV.repaint();
    }
}
