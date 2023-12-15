package raf.dsw.classycraft.app.state.model;


import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.painters.ElementPainter;
import raf.dsw.classycraft.app.gui.swing.view.painters.InterclassPainter;
import raf.dsw.classycraft.app.repository.implementation.DiagramElement;
import raf.dsw.classycraft.app.repository.implementation.connectionElements.*;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Interclass;
import raf.dsw.classycraft.app.state.State;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class ConnectState implements State {

    private int aggCounter = 0;
    private int comCounter = 0;
    private int depCounter = 0;
    private int genCounter = 0;
    private InterclassPainter from;
    private InterclassPainter to;

    @Override
    public void mousePressed(MouseEvent e, DiagramView dV) {
//        System.out.println("from");
//        for (ElementPainter elementPainter : dV.getElementPainters()) {
//            if (elementPainter.elementAt(e.getPoint())) {
//                if (elementPainter instanceof InterclassPainter) {
//                    from = (InterclassPainter) elementPainter;
//                    return;
//                }
//                from = null;
//                return;
//
//            }
//        }

        System.out.println("from");
        for (ElementPainter elementPainter : dV.getElementPainters()) {
            if (elementPainter.elementAt(e.getPoint())) {
                if (elementPainter instanceof InterclassPainter) {
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
        System.out.println("to");
        for (ElementPainter elementPainter : dV.getElementPainters()) {
            if (elementPainter.elementAt(e.getPoint())) {
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
                        element = new Aggregation("NewAggregation" + aggCounter, dV.getDiagram(),(Interclass) from.getElement(), (Interclass) to.getElement());
                        aggCounter++;
                        break;
                    case "Composition":
                        element = new Composition("NewComposition" + comCounter, dV.getDiagram(),(Interclass) from.getElement(), (Interclass) to.getElement());
                        comCounter++;
                        break;
                    case "Dependency":
                        element = new Dependency("NewDependency" + depCounter, dV.getDiagram(),(Interclass) from.getElement(), (Interclass) to.getElement() );
                        depCounter++;
                        break;
                    case "Generalization":
                        element = new Generalization("NewGeneralization" + genCounter, dV.getDiagram(),(Interclass) from.getElement(), (Interclass) to.getElement());
                        genCounter++;
                        break;
                    default:
                        element = null;
                }



                if (element != null) {
                    System.out.println("Dodat");
                    dV.getDiagram().addChild(element);
                    dV.repaint();
                    dV.update(element);
                }


            }

        }
    }



    @Override
    public void mouseDragged(MouseEvent e, DiagramView dV) {

    }


}