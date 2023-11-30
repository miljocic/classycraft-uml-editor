package raf.dsw.classycraft.app.gui.swing.view.painters;

import raf.dsw.classycraft.app.repository.implementation.DiagramElement;

import java.awt.*;

public class DependencyPainter extends ConnectionPainter{
    public DependencyPainter(DiagramElement element, Point pos1, Point pos2) {
        super(element, pos1, pos2);
    }
}
