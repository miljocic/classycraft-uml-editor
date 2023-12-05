package raf.dsw.classycraft.app.state.model;

import raf.dsw.classycraft.app.gui.swing.view.DiagramView;
import raf.dsw.classycraft.app.gui.swing.view.painters.ElementPainter;
import raf.dsw.classycraft.app.gui.swing.view.painters.InterclassPainter;
import raf.dsw.classycraft.app.repository.implementation.connectionElements.Connection;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Interclass;
import raf.dsw.classycraft.app.state.State;

import java.awt.event.MouseEvent;

public class ConnectState implements State {

    private static int count = 0;
    private InterclassPainter from;
    private InterclassPainter to;

    @Override
    public void mousePressed(MouseEvent e, DiagramView dV) {
        System.out.println("here");
        for(ElementPainter elementPainter : dV.getElementPainters()) {
            if(elementPainter.elementAt(e.getPoint())) {
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
        System.out.println("Here2");
        for(ElementPainter elementPainter : dV.getElementPainters()){
            if(elementPainter.elementAt(e.getPoint())) {
                if (elementPainter instanceof InterclassPainter) {
                    to = (InterclassPainter) elementPainter;
                } else to = null;
                break;
            }
        }

        if(to != null && from != null && to != from) {
            dV.getDiagram().addChild(new Connection("Connection " + count++, dV.getDiagram(), (Interclass) from.getElement(), (Interclass) to.getElement()) {
            });
        }
    }


    @Override
    public void mouseDragged(MouseEvent e, DiagramView dV) {

    }


}



