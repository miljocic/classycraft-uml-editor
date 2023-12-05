package raf.dsw.classycraft.app.gui.swing.view.painters;

import raf.dsw.classycraft.app.repository.implementation.interclassElements.Class;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Enum;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Interclass;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Interface;

import java.awt.*;

public class InterclassPainter extends ElementPainter {

    public InterclassPainter(Interclass interclass) {
        super(interclass);
       }

    @Override
    public void paint(Graphics2D g) {
        // Retrieve Interclass information
        Interclass interclass = (Interclass) getElement();
        if (interclass == null) {
            System.out.println("Crash!");
            return;
        }
        String name = interclass.getName();
        String type = determineType(interclass);

        // Paint the rectangle
        g.setColor(Color.white);
        g.fillRect((int) interclass.getXCoordinate(), (int) interclass.getYCoordinate(), 100, 50);
        g.setColor(Color.black);
        g.drawRect((int) interclass.getXCoordinate(), (int) interclass.getYCoordinate(), 100, 50);

        // Paint the top section with name and type
        g.drawString(name, (int) interclass.getXCoordinate() + 10, (int) interclass.getYCoordinate() + 20);
        g.drawString(type, (int) interclass.getXCoordinate() + 80, (int) interclass.getYCoordinate() + 20);
        g.drawString( " ", (int) interclass.getXCoordinate() + 10, (int) interclass.getYCoordinate() + 35);
    }

    private String determineType(Interclass interclass) {
        if (interclass instanceof Class) {
            return "C";
        } else if (interclass instanceof Enum) {
            return "E";
        } else if (interclass instanceof Interface) {
            return "I";
        } else {
            return ""; // Default case, handle as needed
        }
    }

    @Override
    public boolean elementAt(Point pos) {
        // Check if the point is within the bounds of the rectangle
        Interclass interclass = (Interclass) getElement();
        return new Rectangle((int) interclass.getXCoordinate(), (int) interclass.getYCoordinate(), 100, 50).contains(pos);
    }

    @Override
    public void paintSelected(Graphics2D g) {
        g.setPaint(Color.BLUE);
        Interclass interclass = (Interclass) getElement();
        Rectangle shape = new Rectangle((int) interclass.getXCoordinate(), (int) interclass.getYCoordinate(), 100, 50);
        g.fill(shape);
    }
}
