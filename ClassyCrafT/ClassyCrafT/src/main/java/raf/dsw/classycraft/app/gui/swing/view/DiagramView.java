package raf.dsw.classycraft.app.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.painters.ElementPainter;
import raf.dsw.classycraft.app.observer.ISubscriber;
import raf.dsw.classycraft.app.repository.implementation.Diagram;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter

public class DiagramView extends JPanel implements ISubscriber{


    private Diagram diagram;
    private List<ElementPainter> painters;
    private List<ElementPainter> selectionModel;

    public DiagramView(Diagram diagram) {
        this.diagram = diagram;
        this.diagram.addSubscriber(this);
        this.painters = new ArrayList<>();
        this.selectionModel = new ArrayList<>();

    }


    @Override
    public void update(Object notification) {

        if(notification instanceof Diagram) {
            setName(((Diagram) notification).getName());
            ((MyTabbedPane)this.getParent()).setTitleAt(((MyTabbedPane)this.getParent()).indexOfComponent(this), this.getName());
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        if(painters != null)
        {
            for(ElementPainter painter: painters)
            {
                painter.paint();
            }

            for(ElementPainter model: selectionModel)
            {
                model.paint(); // isprekidan pravougaonik
            }
        }
    }
}
