package raf.dsw.classycraft.app.state.model;

import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.painters.ElementPainter;
import raf.dsw.classycraft.app.repository.implementation.classcontentElements.Attribute;
import raf.dsw.classycraft.app.repository.implementation.classcontentElements.Method;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Class;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Enum;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Interface;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Interclass;
import raf.dsw.classycraft.app.state.State;

import javax.swing.*;
import java.awt.*;
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
        }else if (element instanceof Enum){
            editEnum((Enum) element);
        }
    }

    private void editClass(Class element) {
        String[] options = {"Add an Attribute", "Add a Method"};
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

    private void editInterface(Interface element) {
        String[] options = {"Add an Attribute", "Add a Method"};
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

    private void editEnum(Enum element) {
        String[] options = {"Add Enum Element", "Add a Method"};
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
            editEnumElement(element);
        } else if (choice == 1) {
            editEnumMethods(element);
        }
    }

    private void editAttributes(Interclass element) {
        String visibility = showVisibilityPopup();
        String attributetype = showAttributeTypePopup();
        String attributeName = JOptionPane.showInputDialog("Enter attribute name:");
        String visibilitySymbol = convertVisibilityToSymbol(visibility);
        String attributetypeShort = convertAttributeTypeToShortened(attributetype);

        if (attributeName != null && !attributeName.isEmpty()) {
            Attribute attribute = new Attribute(visibilitySymbol+" "+attributeName+": "+attributetypeShort, element, Color.BLACK,2 );
            element.addClassContent(attribute);
            dV.repaint();
        }
    }

    private void editEnumElement(Interclass element) {
        String attributeName = JOptionPane.showInputDialog("Enter Enum element name:");
        if (attributeName != null && !attributeName.isEmpty()) {
            Attribute attribute = new Attribute(attributeName, element, Color.BLACK,2 );
            element.addClassContent(attribute);
            dV.repaint();
        }
    }

    private void editMethods(Interclass element) {
        String visibility = showVisibilityPopup();
        String methodType = showMethodTypePopup();
        String methodName = JOptionPane.showInputDialog("Enter method name:");
        String visibilitySymbol = convertVisibilityToSymbol(visibility);
        String methodTypeShort = convertAttributeTypeToShortened(methodType);

        if (methodName != null && !methodName.isEmpty()) {
            Method method = new Method(visibilitySymbol+" "+methodName+"(): "+methodTypeShort, element, Color.BLACK, 2);
            element.addClassContent(method);
            dV.repaint();
        }
    }

    private void editEnumMethods(Interclass element) {

        String methodType = showMethodTypePopup();
        String methodName = JOptionPane.showInputDialog("Enter method name:");
        String methodTypeShort = convertAttributeTypeToShortened(methodType);

        if (methodName != null && !methodName.isEmpty()) {
            Method method = new Method(methodName+": "+methodTypeShort, element, Color.BLACK, 2);
            element.addClassContent(method);
            dV.repaint();
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

    private String showAttributeTypePopup() {
        String[] attributeTypeOptions = {"Integer", "Float", "Double", "Boolean", "Character",
                "String", "DateTime", "List"};
        return (String) JOptionPane.showInputDialog(
                dV,
                "Select the type for the new attribute:",
                "Attribute Type",
                JOptionPane.QUESTION_MESSAGE,
                null,
                attributeTypeOptions,
                attributeTypeOptions[0]
        );
    }

    private String showMethodTypePopup() {
        String[] mehodTypeOptions = {"Integer", "Float", "Double", "Boolean", "Character",
                "String", "DateTime", "List"};
        return (String) JOptionPane.showInputDialog(
                dV,
                "Select the type for the new method:",
                "Attribute Type",
                JOptionPane.QUESTION_MESSAGE,
                null,
                mehodTypeOptions,
                mehodTypeOptions[0]
        );
    }

    private String convertVisibilityToSymbol(String visibility) {
        switch (visibility) {
            case "Public":
                return "+";
            case "Private":
                return "-";
            case "Protected":
                return "#";
            default:
                return "";
        }
    }

    private String convertAttributeTypeToShortened(String visibility) {
        switch (visibility) {
            case "Integer":
                return "int";
            case "Float":
                return "float";
            case "Double":
                return "double";
            case "Boolean":
                return "bool";
            case "Character":
                return "char";
            case "String":
                return "String";
            case "DateTime":
                return "DateTime";
            case "List":
                return "List";
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
