package raf.dsw.classycraft.app.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.view.painters.ConnectionPainter;
import raf.dsw.classycraft.app.gui.swing.view.painters.ElementPainter;
import raf.dsw.classycraft.app.gui.swing.view.painters.InterclassPainter;
import raf.dsw.classycraft.app.observer.ISubscriber;
import raf.dsw.classycraft.app.repository.implementation.Diagram;
import raf.dsw.classycraft.app.repository.implementation.DiagramElement;
import raf.dsw.classycraft.app.repository.implementation.connectionElements.Connection;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Interclass;
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
    private ElementPainter selected;


    public DiagramView(Diagram diagram) {
        this.diagram = diagram;
        this.diagram.addSubscriber(this);
        this.painters = new ArrayList<>();
        this.addMouseListener(new StateMouseManager(this)); // ili mouseListener?
    }


    @Override
    public void update(Object notification) {

        if(notification instanceof Diagram) {
            setName(((Diagram) notification).getName());
            ((MyTabbedPane)this.getParent()).setTitleAt(((MyTabbedPane)this.getParent()).indexOfComponent(this), this.getName());
        } else if(notification instanceof DiagramElement) {
            ElementPainter contains = containsElementPainter((DiagramElement) notification);
            if(notification instanceof Interclass) {
                if(contains == null)
                    painters.add(new InterclassPainter((Interclass) notification));
                else
                    painters.remove(contains);
            } else if(notification instanceof Connection){
                if(contains == null)
                    painters.add(new ConnectionPainter((Connection) notification));
                else
                    painters.remove(contains);
            }
            repaint();
        }
    }
    private ElementPainter containsElementPainter(DiagramElement diagramElement) {
        for(ElementPainter elementPainter : painters) {
            if(elementPainter.element.equals(diagramElement))
                return elementPainter;
        }
        return null;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
        for(ElementPainter elementPainter : painters) {
            elementPainter.paint(g2);
        }
    }
    public List<ElementPainter> getElementPainters() {
        return painters;
    }
    public ElementPainter getSelected() {
        return selected;
    }
    public void setSelected(ElementPainter selected) {
        this.selected = selected;
        repaint();
    }
}
