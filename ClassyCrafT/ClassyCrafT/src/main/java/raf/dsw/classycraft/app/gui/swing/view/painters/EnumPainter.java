package raf.dsw.classycraft.app.gui.swing.view.painters;

import raf.dsw.classycraft.app.repository.implementation.DiagramElement;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Enum;


import java.awt.*;


public class EnumPainter extends InterclassPainter{
    public EnumPainter(DiagramElement element) {
        super(element);
    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);
        if (getElement() instanceof Enum) {
            Enum anEnum = (Enum) getElement();

            int width = 100;
            int height = 50;

            g.setColor(Color.BLUE);
            g.fillRect(anEnum.getLocation().x, anEnum.getLocation().y, width, height);
            g.drawRect(anEnum.getLocation().x, anEnum.getLocation().y, width, height);
        }
         }
}
