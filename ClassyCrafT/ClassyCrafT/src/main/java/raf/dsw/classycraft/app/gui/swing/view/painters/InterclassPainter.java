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
        String visibility = interclass.getVisibility();

        // Paint the rectangle
        g.setColor(Color.white);
        g.fillRect((int) interclass.getXCoordinate(), (int) interclass.getYCoordinate(), 200, 250);
        g.setColor(Color.black);
        g.drawRect((int) interclass.getXCoordinate(), (int) interclass.getYCoordinate(), 200, 250);

        // Paint the top section with name, type, and visibility
        g.drawString(visibility + " " + type+ ": " + name, (int) interclass.getXCoordinate() + 10, (int) interclass.getYCoordinate() + 20);  // Updated line
        g.drawLine((int) interclass.getXCoordinate() + 10, (int) interclass.getYCoordinate() + 25, (int) interclass.getXCoordinate() + 190, (int) interclass.getYCoordinate() + 25);
        // No change for the type drawing

        // Adjust the vertical offset based on the top section
        int yOffset = (int) interclass.getYCoordinate() + 70;

        if (interclass instanceof Class) {
            for (String attribute : interclass.getAttributes()) {
                g.drawString(attribute, (int) interclass.getXCoordinate() + 10, yOffset);
                yOffset += 15;
            }

            for (String method : interclass.getMethods()) {
                g.drawString(method, (int) interclass.getXCoordinate() + 10, yOffset);
                yOffset += 15;
            }
        } else if(interclass instanceof Enum) {
            //POSEBNO ZA ENUM MORA!
        } else if (interclass instanceof Interface) {
            for (String method : interclass.getMethods()) {
                g.drawString(method, (int) interclass.getXCoordinate() + 10, yOffset);
                yOffset += 15;
            }
        }
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
