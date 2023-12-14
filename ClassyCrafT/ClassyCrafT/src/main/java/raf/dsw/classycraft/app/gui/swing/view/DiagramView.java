package raf.dsw.classycraft.app.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.view.painters.*;
import raf.dsw.classycraft.app.observer.ISubscriber;
import raf.dsw.classycraft.app.repository.implementation.Diagram;
import raf.dsw.classycraft.app.repository.implementation.DiagramElement;
import raf.dsw.classycraft.app.repository.implementation.connectionElements.*;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Interclass;
import raf.dsw.classycraft.app.state.StateMouseManager;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter

public class DiagramView extends JPanel implements ISubscriber{


    private Diagram diagram;
    private List<ElementPainter> painters;
    private ElementPainter selected;


    private double scalingFactor;
    private AffineTransform transform;

    private double xTranslate;
    private double yTranslate;

    public DiagramView(Diagram diagram) {
        this.diagram = diagram;
        this.diagram.addSubscriber(this);
        this.painters = new ArrayList<>();
        this.addMouseListener(new StateMouseManager(this));
        this.transform = new AffineTransform();
        this.scalingFactor = 1;
        this.xTranslate = 0;
        this.yTranslate = 0;

    }


    @Override
    public void update(Object notification) {

        System.out.println("Received update: " + notification.toString());
        System.out.println("Notification type: " + notification.getClass());
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
            } else if (notification instanceof Connection) {
                Connection connection = (Connection) notification;


                if (contains == null) {
                    ConnectionPainter connectionPainter = createConnectionPainter(connection);
                    painters.add(connectionPainter);
                } else {
                    painters.remove(contains);
                }
            }

            repaint();
        }
    }

    private ConnectionPainter createConnectionPainter(Connection connection) {
        if (connection instanceof Dependency) {
            return new DependencyPainter((Dependency) connection);
        } else if (connection instanceof Generalization) {
            return new GeneralizationPainter((Generalization) connection);
        } else if (connection instanceof Composition) {
            return new CompositionPainter((Composition) connection);
        } else if (connection instanceof Aggregation) {
            return new AggregationPainter((Aggregation) connection);
        } else {
            return null;
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
        g2.setTransform(transform);
        for(ElementPainter elementPainter : painters) {
            if(elementPainter.equals(selected)) elementPainter.paintSelected(g2);
            else elementPainter.paint(g2);
        }
    }

    public void zoomIn() {
        scalingFactor *= 1.2;
        if(scalingFactor > 5) {
            scalingFactor = 5;
        }
        System.out.println(scalingFactor);
        setupTransform();
    }

    public void zoomOut() {
        scalingFactor /= 1.2;
        if (scalingFactor < 0.2) {
            scalingFactor = 0.2;
        }
        System.out.println(scalingFactor);
        setupTransform();
    }

    private void setupTransform() {
        transform.setToIdentity();
        transform.translate(xTranslate, yTranslate);
        transform.scale(scalingFactor, scalingFactor);
        repaint();
    }

    public void translate(double xTranslate, double yTranslate) {
        this.xTranslate += xTranslate;
        this.yTranslate += yTranslate;
        setupTransform();
    }

    public List<ElementPainter> getElementPainters() {
        return painters;
    }
    public void setSelected(ElementPainter selected) {
        this.selected = selected;
        repaint();
    }
}
