package raf.dsw.classycraft.app.state.model;

import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.painters.ElementPainter;
import raf.dsw.classycraft.app.repository.implementation.classcontentElements.Attribute;
import raf.dsw.classycraft.app.repository.implementation.classcontentElements.Method;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Class;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Interface;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Interclass;
import raf.dsw.classycraft.app.state.State;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class EditState implements State {
    private DiagramView dV;
    private Interclass selectedElement;

    @Override
    public void mousePressed(MouseEvent e, DiagramView dV) {
        this.dV = dV;
        selectedElement = getClickedElement(e, dV);
        if (selectedElement != null) {
            showEditPopup(selectedElement, dV);
        }
    }

    private Interclass getClickedElement(MouseEvent e, DiagramView dV) {
        for (ElementPainter elementPainter : dV.getElementPainters()) {
            if (elementPainter.elementAt(e.getPoint())) {
                return (Interclass) elementPainter.getElement();
            }
        }
        return null;
    }

    private void showEditPopup(Interclass element, DiagramView dV) {
        if (element instanceof Class) {
            editClass((Class) element);
        } else if (element instanceof Interface) {
            editInterface((Interface) element);
        }
    }

    private void editClass(Class element) {
        String[] options = {"Edit Attributes", "Edit Methods"};
        int choice = JOptionPane.showOptionDialog(
                dV,
                "Select the type of edit:",
                "Edit Options",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );
        if (choice == 0) {
            editAttributes(element);
        } else if (choice == 1) {
            editMethods(element);
        }
    }

    private void editAttributes(Interclass element) {
        String visibility = showVisibilityPopup();
        String attributeName = JOptionPane.showInputDialog("Enter attribute name:");

        if (attributeName != null && !attributeName.isEmpty()) {
            Attribute attribute = new Attribute(attributeName, element, 1, 0, 0, 0, visibility);
            element.addClassContent(attribute);
            dV.repaint();
        }
    }

    private void editMethods(Interclass element) {
        String visibility = showVisibilityPopup();
        String methodName = JOptionPane.showInputDialog("Enter method name:");

        if (methodName != null && !methodName.isEmpty()) {
            Method method = new Method(methodName, element, 1, 0, 0, 0, visibility);
            element.addClassContent(method);
            dV.repaint();
        }
    }

    private void editInterface(Interface element) {
        String[] options = {"Edit Methods"};
        int choice = JOptionPane.showOptionDialog(
                dV,
                "Select the type of edit:",
                "Edit Options",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );
        if (choice == 0) {
            editMethods(element);
        }
    }

    private String showVisibilityPopup() {
        String[] visibilityOptions = {"Public", "Private", "Protected"};
        return (String) JOptionPane.showInputDialog(
                dV,
                "Select visibility:",
                "Visibility Options",
                JOptionPane.QUESTION_MESSAGE,
                null,
                visibilityOptions,
                visibilityOptions[0]
        );
    }

    @Override
    public void mouseReleased(MouseEvent e, DiagramView dV) {
        // Implement if needed
    }

    @Override
    public void mouseDragged(MouseEvent e, DiagramView dV) {
        // Implement if needed
    }
}
