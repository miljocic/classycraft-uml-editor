package raf.dsw.classycraft.app.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.controller.MyMouseListener;
import raf.dsw.classycraft.app.observer.ISubscriber;
import raf.dsw.classycraft.app.repository.implementation.Diagram;

import javax.swing.*;
import java.awt.*;


@Getter
@Setter

public class DiagramView extends JPanel implements ISubscriber{


    private Package paket;
    private JToolBar packageToolbar;
    private Diagram diagram;

    public DiagramView(Diagram diagram) {
        this.diagram = diagram;
        this.diagram.addSubscriber(this);

        this.setLayout(new BorderLayout());
        setDiagram(diagram);
        MyMouseListener myMouseListener = new MyMouseListener();
        addMouseListener(myMouseListener);
        repaint();

    }


    public void setDiagram(Diagram diagram){
        this.diagram = diagram;
        this.diagram.addSubscriber(this);
    }

    @Override
    public void update(Object notification) {

    }
}
