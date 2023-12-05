package raf.dsw.classycraft.app.state.model;

import raf.dsw.classycraft.app.core.ApplicationFramework;
import raf.dsw.classycraft.app.gui.swing.view.DiagramView;

import raf.dsw.classycraft.app.gui.swing.view.painters.ElementPainter;
import raf.dsw.classycraft.app.logg.messages.ErrorType;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Class;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Enum;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Interclass;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Interface;
import raf.dsw.classycraft.app.state.State;

import javax.swing.*;
import java.awt.event.MouseEvent;


public class AddState implements State {

    private int classCounter = 0;
    private int enumCounter = 0;
    private int interfaceCounter = 0;

    @Override
    public void mousePressed(MouseEvent e, DiagramView dV) {
        // Show a pop-up window to choose the type of element to create
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
            // Determine the type based on the user's choice
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

            // Create the corresponding element based on the type
            Interclass element;
            switch (type) {
                case "Class":
                    element = new Class("NewClass" + classCounter, dV.getDiagram(), dV.getStroke(), dV.getColor(), e.getPoint().getX(), e.getPoint().getY());
                    classCounter++;
                    break;
                case "Enum":
                    element = new Enum("NewEnum" + enumCounter, dV.getDiagram(), dV.getStroke(), dV.getColor(), e.getPoint().getX(), e.getPoint().getY());
                    enumCounter++;
                    break;
                case "Interface":
                    element = new Interface("NewInterface" + interfaceCounter, dV.getDiagram(), dV.getStroke(), dV.getColor(), e.getPoint().getX(), e.getPoint().getY());
                    interfaceCounter++;
                    break;
                default:
                    element = null;
            }

            for (ElementPainter elementPainter : dV.getElementPainters()) {
                if (elementPainter.elementAt(e.getPoint())) {
                    ApplicationFramework.getInstance().getMessageGenerator().generateMessage( ErrorType.ELEMENT_FOUND_AT_POINT);
                    return;
                }
            }

            // Add the created element to the diagram
            if (element != null) {
                System.out.println("Dodat");
                dV.getDiagram().addChild(element);
            }


        }

    }

    @Override
    public void mouseReleased(MouseEvent e, DiagramView dV) {

    }

    @Override
    public void mouseDragged(MouseEvent e, DiagramView dV) {

    }

}
