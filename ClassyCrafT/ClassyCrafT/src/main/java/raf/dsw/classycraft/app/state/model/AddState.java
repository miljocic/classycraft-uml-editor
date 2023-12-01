package raf.dsw.classycraft.app.state.model;

import raf.dsw.classycraft.app.gui.swing.view.DiagramView;

import raf.dsw.classycraft.app.gui.swing.view.painters.InterclassPainter;
import raf.dsw.classycraft.app.repository.implementation.DiagramElement;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Class;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Interclass;
import raf.dsw.classycraft.app.state.State;

import java.awt.*;


public class AddState implements State {


    @Override
    public void mousePressed(int x, int y, DiagramView dV) {

        Interclass newInterclass = new Class("NewClass", dV.getDiagram(), "public");
        newInterclass.setLocation(new Point(x, y));


        InterclassPainter newPainter = new InterclassPainter(newInterclass);

        dV.getPainters().add(newPainter);

        dV.repaint();
    }

    @Override
    public void mouseReleased(int x, int y, DiagramView dV) {

    }

    @Override
    public void mouseDragged(int x, int y, DiagramView dV) {

    }
}
