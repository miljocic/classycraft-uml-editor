package raf.dsw.classycraft.app.gui.swing.view.painters;


import raf.dsw.classycraft.app.repository.implementation.DiagramElement;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Class;



import java.awt.*;


public class ClassPainter extends InterclassPainter{
    public ClassPainter(DiagramElement element) {
        super(element);
    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);
        if (getElement() instanceof Class) {
            Class classElement = (Class) getElement();

            int width = 100;
            int height = 50;

            g.setColor(Color.GREEN);
            g.fillRect(classElement.getLocation().x, classElement.getLocation().y, width, height);
            g.drawRect(classElement.getLocation().x, classElement.getLocation().y, width, height);
        }

    }

}
