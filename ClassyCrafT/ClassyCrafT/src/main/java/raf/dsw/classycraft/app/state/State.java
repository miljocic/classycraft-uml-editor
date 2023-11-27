package raf.dsw.classycraft.app.state;

import java.awt.event.MouseEvent;

public interface State {

    void mousePressed(MouseEvent e);

    void mouseReleased(MouseEvent e);

    void mouseDragged(MouseEvent e);


}
