package raf.dsw.classycraft.app.state.model;

import raf.dsw.classycraft.app.command.commands.AddConnectionCommand;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.painters.ElementPainter;
import raf.dsw.classycraft.app.gui.swing.view.painters.InterclassPainter;
import raf.dsw.classycraft.app.repository.implementation.Diagram;
import raf.dsw.classycraft.app.repository.implementation.connectionElements.*;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Interclass;
import raf.dsw.classycraft.app.state.State;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class ConnectState implements State {

    private int aggCounter = 0;
    private int comCounter = 0;
    private int depCounter = 0;
    private int genCounter = 0;
    private InterclassPainter from;
    private InterclassPainter to;
    private AddConnectionCommand addConnectionCommand;

    @Override
    public void mousePressed(MouseEvent e, DiagramView dV) {
        Point pos = new Point(
                (int) ((e.getPoint().getX() - dV.getXTranslate()) / dV.getScalingFactor()),
                (int) ((e.getPoint().getY() - dV.getYTranslate()) / dV.getScalingFactor())
        );

        System.out.println("from");
        for (ElementPainter elementPainter : dV.getElementPainters()) {
            if (elementPainter.elementAt(pos)) {
                if (elementPainter instanceof InterclassPainter) {
                    elementPainter.getElement().notifySubscribers(elementPainter);
                    from = (InterclassPainter) elementPainter;
                    return;
                }
                from = null;
                return;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e, DiagramView dV) {
        Diagram diagram = dV.getDiagram();
        Point pos = new Point(
                (int) ((e.getPoint().getX() - dV.getXTranslate()) / dV.getScalingFactor()),
                (int) ((e.getPoint().getY() - dV.getYTranslate()) / dV.getScalingFactor())
        );
        System.out.println("to");
        for (ElementPainter elementPainter : dV.getElementPainters()) {
            if (elementPainter.elementAt(pos)) {
                if (elementPainter instanceof InterclassPainter) {
                    to = (InterclassPainter) elementPainter;
                } else to = null;
                break;
            }
        }

        if (to != null && from != null && to != from) {
            String[] options = {"Aggregation", "Composition", "Dependency", "Generalization"};
            int choice = JOptionPane.showOptionDialog(
                    dV,
                    "Select the type of connection to create:",
                    "Connection Type",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            if (choice >= 0) {
                String type;
                switch (choice) {
                    case 0:
                        type = "Aggregation";
                        break;
                    case 1:
                        type = "Composition";
                        break;
                    case 2:
                        type = "Dependency";
                        break;
                    case 3:
                        type = "Generalization";
                        break;
                    default:
                        type = "";
                }

                Connection element;
                switch (type) {
                    case "Aggregation":
                        element = new Aggregation("NewAggregation" + aggCounter, diagram, (Interclass) from.getElement(), (Interclass) to.getElement());
                        aggCounter++;
                        break;
                    case "Composition":
                        element = new Composition("NewComposition" + comCounter, diagram, (Interclass) from.getElement(), (Interclass) to.getElement());
                        comCounter++;
                        break;
                    case "Dependency":
                        element = new Dependency("NewDependency" + depCounter, diagram, (Interclass) from.getElement(), (Interclass) to.getElement());
                        depCounter++;
                        break;
                    case "Generalization":
                        element = new Generalization("NewGeneralization" + genCounter, diagram, (Interclass) from.getElement(), (Interclass) to.getElement());
                        genCounter++;
                        break;
                    default:
                        element = null;
                }

                if (element != null) {
                    addConnectionCommand = new AddConnectionCommand(diagram, dV, element);
                    diagram.getCommandManager().addCommand(addConnectionCommand);
                    dV.repaint();
                    dV.update(element);
                    element.notifySubscribers(dV);
                }
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e, DiagramView dV) {
    }
}
