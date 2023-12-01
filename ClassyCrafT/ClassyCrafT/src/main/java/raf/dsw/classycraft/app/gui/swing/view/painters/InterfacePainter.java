package raf.dsw.classycraft.app.gui.swing.view.painters;


import raf.dsw.classycraft.app.repository.implementation.DiagramElement;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Interface;


import java.awt.*;


public class InterfacePainter extends InterclassPainter{

    public InterfacePainter(DiagramElement element) {
        super(element);
    }


    @Override
    public void paint(Graphics2D g) {
        super.paint(g);
        if (getElement() instanceof Interface) {
            Interface interfaceElement = (Interface) getElement();

            int width = 100;
            int height = 50;

            g.setColor(Color.RED);
            g.fillRect(interfaceElement.getLocation().x, interfaceElement.getLocation().y, width, height);
            g.drawRect(interfaceElement.getLocation().x, interfaceElement.getLocation().y, width, height);

        }
    }

}
