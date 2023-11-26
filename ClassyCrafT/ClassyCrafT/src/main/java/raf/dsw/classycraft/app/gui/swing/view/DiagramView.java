package raf.dsw.classycraft.app.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.observer.ISubscriber;
import raf.dsw.classycraft.app.repository.implementation.Diagram;

import javax.swing.*;



@Getter
@Setter

public class DiagramView extends JPanel implements ISubscriber{


    private Diagram diagram;

    public DiagramView(Diagram diagram) {
        this.diagram = diagram;
        this.diagram.addSubscriber(this);

    }


    @Override
    public void update(Object notification) {

        if(notification instanceof Diagram) {
            setName(((Diagram) notification).getName());
            ((MyTabbedPane)this.getParent()).setTitleAt(((MyTabbedPane)this.getParent()).indexOfComponent(this), this.getName());
        }

    }
}
