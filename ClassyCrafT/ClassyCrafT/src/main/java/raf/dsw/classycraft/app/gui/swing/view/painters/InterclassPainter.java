package raf.dsw.classycraft.app.gui.swing.view.painters;

import raf.dsw.classycraft.app.repository.implementation.classcontentElements.ClassContent;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Interclass;

import java.awt.*;

public class InterclassPainter extends ElementPainter {

    public InterclassPainter(Interclass interclass) {
        super(interclass);
    }

    @Override
    public void paint(Graphics2D g) {
        Interclass interclass = (Interclass) getElement();
        if (interclass == null) {
            System.out.println("Crash!");
            return;
        }

        String name = interclass.getName();
        String type = determineType(interclass);
        String visibility = interclass.getVisibility();

        g.setColor(Color.white);
        g.fillRect((int) interclass.getXCoordinate(), (int) interclass.getYCoordinate(), 200, 250);
        g.setColor(Color.black);
        g.drawRect((int) interclass.getXCoordinate(), (int) interclass.getYCoordinate(), 200, 250);

        g.drawString(visibility + " " + type + ": " + name, (int) interclass.getXCoordinate() + 10, (int) interclass.getYCoordinate() + 20);

        // Draw line under the name
        g.drawLine((int) interclass.getXCoordinate() + 10, (int) interclass.getYCoordinate() + 35, (int) interclass.getXCoordinate() + 190, (int) interclass.getYCoordinate() + 35);

        int yOffset = (int) interclass.getYCoordinate() + 70;

        // Draw attributes
        for (String attribute : interclass.getAttributes()) {
            g.drawString(attribute, (int) interclass.getXCoordinate() + 20, yOffset);
            yOffset += 15;
        }

        // Draw line after attributes
        g.drawLine((int) interclass.getXCoordinate() + 10, yOffset, (int) interclass.getXCoordinate() + 190, yOffset);

        // Draw methods
        yOffset += 15;
        for (String method : interclass.getMethods()) {
            g.drawString(method, (int) interclass.getXCoordinate() + 20, yOffset);
            yOffset += 15;
        }
    }

    private String determineType(Interclass interclass) {
        if (interclass instanceof raf.dsw.classycraft.app.repository.implementation.interclassElements.Class) {
            return "C";
        } else if (interclass instanceof raf.dsw.classycraft.app.repository.implementation.interclassElements.Enum) {
            return "E";
        } else if (interclass instanceof raf.dsw.classycraft.app.repository.implementation.interclassElements.Interface) {
            return "I";
        } else {
            return "";
        }
    }

    @Override
    public boolean elementAt(Point pos) {
        Interclass interclass = (Interclass) getElement();
        return new Rectangle((int) interclass.getXCoordinate(), (int) interclass.getYCoordinate(), 200, 250).contains(pos);
    }

    @Override
    public void paintSelected(Graphics2D g) {
        g.setPaint(Color.BLUE);
        Interclass interclass = (Interclass) getElement();
        Rectangle shape = new Rectangle((int) interclass.getXCoordinate(), (int) interclass.getYCoordinate(), 200, 250);
        g.fill(shape);
    }
}
