package raf.dsw.classycraft.app.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.controller.MouseController;
import raf.dsw.classycraft.app.repository.implementation.Diagram;

import javax.swing.*;
import java.awt.*;


@Getter
@Setter

public class DiagramView extends JPanel {


    private Package paket;
    private JToolBar packageToolbar;
    MouseController mouseController;
    private Diagram diagram;

    public DiagramView(Diagram diagram) {
        this.diagram = diagram;
        this.setLayout(new BorderLayout());
        setDiagram(diagram);
        addMouseListener(new MouseController(this));

    }

    public void setDiagram(Diagram diagram){
        this.diagram = diagram;
        //this.diagram.addSubscriber(this);
    }

}
