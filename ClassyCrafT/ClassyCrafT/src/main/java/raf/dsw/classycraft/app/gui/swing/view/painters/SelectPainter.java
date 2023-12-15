package raf.dsw.classycraft.app.gui.swing.view.painters;

import raf.dsw.classycraft.app.repository.implementation.DiagramElement;

import java.awt.*;

public class SelectPainter extends ElementPainter{


    private int x;
    private int y;
    private int width;
    private int height;

    public SelectPainter(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void paint(Graphics2D g) {
        g.setColor(new Color(200, 200, 200, 100));
        g.fillRect(x, y, width, height);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, height);
    }

    @Override
    public boolean elementAt(Point pos) {
        return false;
    }

    @Override
    public void paintSelected(Graphics2D g) {

    }
}
