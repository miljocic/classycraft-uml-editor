package raf.dsw.classycraft.app.gui.swing.view.painters;


import raf.dsw.classycraft.app.repository.implementation.DiagramElement;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Interclass;

import java.awt.*;

public class InterclassPainter extends ElementPainter{


    public InterclassPainter(DiagramElement element) {
        super(element);
    }

    @Override
    public void paint(Graphics2D g) {
        if (getElement() instanceof Interclass) {
            Interclass interclassElement = (Interclass) getElement();

            int width = 100;
            int height = 50;

            g.setColor(Color.BLUE);
            g.drawRect(interclassElement.getLocation().x, interclassElement.getLocation().y, width, height);
        }
    }

    @Override
    public boolean elementAt(Point pos) {
        return getShape().getBounds().contains(pos);
    }


}
