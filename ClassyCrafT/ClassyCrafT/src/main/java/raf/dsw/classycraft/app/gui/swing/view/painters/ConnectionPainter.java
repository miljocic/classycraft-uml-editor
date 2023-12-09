package raf.dsw.classycraft.app.gui.swing.view.painters;
import raf.dsw.classycraft.app.repository.implementation.DiagramElement;


import java.awt.*;



public abstract class ConnectionPainter extends ElementPainter {


    public ConnectionPainter(DiagramElement element) {
        super(element);


    }

    @Override
    public void paint(Graphics2D g) {

    }

    @Override
    public boolean elementAt(Point pos) {
        return true ;
    }

    @Override
    public void paintSelected(Graphics2D g) {

    }
}
