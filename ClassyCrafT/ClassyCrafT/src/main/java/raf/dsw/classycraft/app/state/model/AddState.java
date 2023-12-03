package raf.dsw.classycraft.app.state.model;

import raf.dsw.classycraft.app.gui.swing.view.DiagramView;

import raf.dsw.classycraft.app.repository.implementation.Diagram;
import raf.dsw.classycraft.app.repository.implementation.DiagramElement;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Class;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Enum;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Interclass;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Interface;
import raf.dsw.classycraft.app.state.State;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.util.Random;


public class AddState implements State {


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
                    element = new Class("NewClass", null, "defaultVisibility", e.getPoint());
                    break;
                case "Enum":
                    element = new Enum("NewEnum", null, "defaultVisibility", e.getPoint());
                    break;
                case "Interface":
                    element = new Interface("NewInterface", null, "defaultVisibility", e.getPoint());
                    break;
                default:
                    element = null;
            }

            // Add the created element to the diagram
            if (element != null) {
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
