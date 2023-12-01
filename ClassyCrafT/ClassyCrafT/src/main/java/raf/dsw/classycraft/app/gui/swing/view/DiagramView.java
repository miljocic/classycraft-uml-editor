package raf.dsw.classycraft.app.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.view.painters.ElementPainter;
import raf.dsw.classycraft.app.observer.ISubscriber;
import raf.dsw.classycraft.app.repository.implementation.Diagram;
import raf.dsw.classycraft.app.state.StateMouseManager;

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

    double translateX = 0;
    double translateY = 0;
    double scalingF = 1;



    public DiagramView(Diagram diagram) {
        this.diagram = diagram;
        this.diagram.addSubscriber(this);
        this.painters = new ArrayList<>();
        this.selectionModel = new ArrayList<>();
        this.addMouseListener(new StateMouseManager(this));
    }


    @Override
    public void update(Object notification) {

        if(notification instanceof Diagram) {
            setName(((Diagram) notification).getName());
            ((MyTabbedPane)this.getParent()).setTitleAt(((MyTabbedPane)this.getParent()).indexOfComponent(this), this.getName());
        }

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        if(painters != null)
        {
            for(ElementPainter painter: painters)
            {
                painter.paint(g2);
            }

            for(ElementPainter model: selectionModel)
            {
                float[] dashPattern = {5f, 5f}; // Adjust the values as needed
                BasicStroke dashedStroke = new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10f, dashPattern, 0f);
                g2.setStroke(dashedStroke);
                model.paint(g2); // isprekidan pravougaonik
            }
        }
    }
}
