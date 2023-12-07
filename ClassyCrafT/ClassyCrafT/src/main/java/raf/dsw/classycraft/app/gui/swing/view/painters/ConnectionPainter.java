package raf.dsw.classycraft.app.gui.swing.view.painters;

import raf.dsw.classycraft.app.repository.implementation.DiagramElement;
import raf.dsw.classycraft.app.repository.implementation.connectionElements.*;

import java.awt.*;
import java.util.ArrayList;


public abstract class ConnectionPainter extends ElementPainter {

//    public ConnectionPainter(Connection connection) {
//        super(connection);
//    }

    public ConnectionPainter(DiagramElement element) {
        super(element);



    }

    @Override
    public void paint(Graphics2D g) {

    }

    @Override
    public boolean elementAt(Point pos) {
        return false;
    }

    @Override
    public void paintSelected(Graphics2D g) {

    }
}
