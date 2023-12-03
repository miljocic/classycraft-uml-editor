package raf.dsw.classycraft.app.state;

import raf.dsw.classycraft.app.gui.swing.view.DiagramView;

import java.awt.event.MouseEvent;


public interface State {


    void mousePressed(MouseEvent e, DiagramView dV);

    void mouseReleased(MouseEvent e, DiagramView dV);

    void mouseDragged(MouseEvent e, DiagramView dV);


}
