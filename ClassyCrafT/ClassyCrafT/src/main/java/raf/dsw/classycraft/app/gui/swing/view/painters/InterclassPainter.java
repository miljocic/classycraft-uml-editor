package raf.dsw.classycraft.app.gui.swing.view.painters;


import lombok.Getter;
import raf.dsw.classycraft.app.repository.implementation.DiagramElement;



import java.awt.*;

@Getter
public class InterclassPainter extends ElementPainter{
    protected Shape shape;

    public InterclassPainter(DiagramElement element) {
        super(element);
        }

    @Override
    public void paint(Graphics2D g) {


    }

    @Override
    public boolean elementAt(Point pos) {
        return getShape().getBounds().contains(pos);
    }


}
