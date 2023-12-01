package raf.dsw.classycraft.app.state.model;

import lombok.Getter;

import raf.dsw.classycraft.app.gui.swing.view.DiagramView;


import raf.dsw.classycraft.app.gui.swing.view.painters.ClassPainter;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Class;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Interclass;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Interface;
import raf.dsw.classycraft.app.state.State;

import java.awt.*;

@Getter
public class AddState implements State {

    private String elementType;

    public AddState() {
    }

    public AddState(String elementType) {
        this.elementType = elementType;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType;
    }


    @Override
    public void mousePressed(int x, int y, DiagramView dV) {
        System.out.println("Mouse pressed. elementType: " + elementType);
        System.out.println("x: " + x + ", y: " + y);

        if (elementType != null) {
            switch (elementType) {
                case "Class":
                    Interclass aClass = new Class("NewClass", dV.getDiagram(), "public");
                    aClass.setLocation(new Point(x, y));
                    ClassPainter newCPainter = new ClassPainter(aClass);
                    dV.getPainters().add(newCPainter);
                    dV.repaint();
                    break;
                case "Enum":
                    Interclass anEnum = new Interface("NewEnum", dV.getDiagram(), "public");
                    anEnum.setLocation(new Point(x, y));
                    ClassPainter newEPainter = new ClassPainter(anEnum);
                    dV.getPainters().add(newEPainter);
                    dV.repaint();
                    break;
                case "Interface":
                    Interclass anInterface = new Interface("NewInterface", dV.getDiagram(), "public");
                    anInterface.setLocation(new Point(x, y));
                    ClassPainter newIPainter = new ClassPainter(anInterface);
                    dV.getPainters().add(newIPainter);
                    dV.repaint();
                    break;
                default:

            }
        }
    }




//        Interclass newInterclass = new Class("NewClass", dV.getDiagram(), "public");
//        newInterclass.setLocation(new Point(x, y));
//        ClassPainter newPainter = new ClassPainter(newInterclass);
//        dV.getPainters().add(newPainter);
//        dV.repaint();




    @Override
    public void mouseReleased(int x, int y, DiagramView dV) {

    }

    @Override
    public void mouseDragged(int x, int y, DiagramView dV) {

    }



}




