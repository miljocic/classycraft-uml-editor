package raf.dsw.classycraft.app.state.model;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.painters.ElementPainter;
import raf.dsw.classycraft.app.logg.messages.ErrorType;
import raf.dsw.classycraft.app.repository.implementation.DiagramElement;
import raf.dsw.classycraft.app.repository.implementation.connectionElements.Connection;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Class;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Enum;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Interclass;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Interface;
import raf.dsw.classycraft.app.state.State;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class AddState implements State {

    private int classCounter = 0;
    private int enumCounter = 0;
    private int interfaceCounter = 0;

    @Override
    public void mousePressed(MouseEvent e, DiagramView dV) {

        String[] options = {"Class", "Enum", "Interface"};
        int choice = JOptionPane.showOptionDialog(
                dV,
                "Select the type of element to create:",
                "Element Type",
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
                    type = "Class";
                    break;
                case 1:
                    type = "Enum";
                    break;
                case 2:
                    type = "Interface";
                    break;
                default:
                    type = "";
            }


            Interclass element;
            switch (type) {
                case "Class":
                    element = new Class("NewClass" + classCounter, dV.getDiagram(), e.getPoint(), getVisibility(),new Dimension(200, 250));
                    classCounter++;
                    break;
                case "Enum":
                    element = new Enum("NewEnum" + enumCounter, dV.getDiagram(), e.getPoint(), getVisibility(),new Dimension(200, 250));
                    enumCounter++;
                    break;
                case "Interface":
                    element = new Interface("NewInterface" + interfaceCounter, dV.getDiagram(), e.getPoint(), getVisibility(), new Dimension(200, 250));
                    interfaceCounter++;
                    break;
                default:
                    element = null;
            }

            if (element != null && !checkOverlap(element, dV.getElementPainters())) {

                System.out.println("Dodat");
                dV.getDiagram().addChild(element);
            }
        }
    }



    private boolean checkOverlap(Interclass newElement, Iterable<ElementPainter> painters) {
        for (ElementPainter elementPainter : painters) {
            DiagramElement element = elementPainter.getElement();

            if (element instanceof Interclass) {
                Interclass existingElement = (Interclass) element;
                if (existingElement != null && newElement != null) {
                    Rectangle newBounds = new Rectangle((int) newElement.getLocation().getX(), (int) newElement.getLocation().getY(), 200, 250);
                    Rectangle existingBounds = new Rectangle((int) existingElement.getLocation().getX(), (int) existingElement.getLocation().getY(), 200, 250);

                    if (newBounds.intersects(existingBounds)) {
                        ApplicationFramework.getInstance().getMessageGenerator().generateMessage(ErrorType.ELEMENT_FOUND_AT_POINT);
                        return true;
                    }
                }
            } else if (element instanceof Connection) {
                Connection connection = (Connection) element;
                Rectangle newBounds = new Rectangle((int) newElement.getLocation().getX(), (int) newElement.getLocation().getY(), 200, 250);
                if (connection.intersectsRectangle(newBounds)) {
                    System.out.println("Usao u check dal se preseca"); //Ne valja check ovde
                    ApplicationFramework.getInstance().getMessageGenerator().generateMessage(ErrorType.ELEMENT_FOUND_AT_POINT);
                    return true;
                }
            }
        }
        return false;
    }



    private String getVisibility() {
        String[] options = {"public", "private", "protected"};
        int choice = JOptionPane.showOptionDialog(
                null,
                "Select the visibility for the new element:",
                "Visibility",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        switch (choice) {
            case 0:
                return "public";
            case 1:
                return "private";
            case 2:
                return "protected";
            default:
                return "";
        }
    }

    @Override
    public void mouseReleased(MouseEvent e, DiagramView dV) {

    }

    @Override
    public void mouseDragged(MouseEvent e, DiagramView dV) {

    }

}
