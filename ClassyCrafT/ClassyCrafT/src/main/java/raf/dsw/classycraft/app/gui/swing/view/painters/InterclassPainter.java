package raf.dsw.classycraft.app.gui.swing.view.painters;


import raf.dsw.classycraft.app.repository.implementation.interclassElements.Class;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Enum;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Interclass;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Interface;

import java.awt.*;
import java.awt.geom.Rectangle2D;

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

        this.shape = new Rectangle2D.Double((int) interclass.getLocation().getX(), (int) interclass.getLocation().getY(), 200, 250);
        g.setColor(Color.white);
        g.fillRect((int) interclass.getLocation().getX(), (int) interclass.getLocation().getY(), 200, 250);
        g.setColor(Color.black);
        g.drawRect((int) interclass.getLocation().getX(), (int) interclass.getLocation().getY(), 200, 250);

        g.drawString(visibility + " " + type + ": " + name, (int) interclass.getLocation().getX() + 10, (int) interclass.getLocation().getY() + 20);

        // Linija ispod Imena
        g.drawLine((int) interclass.getLocation().getX(), (int) interclass.getLocation().getY() + 35, (int) interclass.getLocation().getX() + 200, (int) interclass.getLocation().getY() + 35);

        int yOffset = (int) interclass.getLocation().getY() + 70;

        // Crtanje atributa
        for (String attribute : interclass.getAttributes()) {
            g.drawString(attribute, (int) interclass.getLocation().getX() + 20, yOffset);
            yOffset += 15;
        }

        // Linija ispod atributa
        g.drawLine((int) interclass.getLocation().getX(), yOffset, (int) interclass.getLocation().getX() + 200, yOffset);

        // Crtanje metoda
        yOffset += 15;
        for (String method : interclass.getMethods()) {
            g.drawString(method, (int) interclass.getLocation().getX() + 20, yOffset);
            yOffset += 15;
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
            return "";
        }
    }

    @Override
    public boolean elementAt(Point pos) {
        Interclass interclass = (Interclass) getElement();
        return new Rectangle((int) interclass.getLocation().getX(),
                (int) interclass.getLocation().getY(), 200, 250).contains(pos);
    }

    @Override
    public void paintSelected(Graphics2D g) {
        g.setPaint(Color.BLUE);
        Interclass interclass = (Interclass) getElement();
        Rectangle shape = new Rectangle((int) interclass.getLocation().getX(),
                (int) interclass.getLocation().getY(), 200, 250);
        g.fill(shape);
        this.shape = shape;
    }
}
