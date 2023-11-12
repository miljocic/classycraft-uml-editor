package raf.dsw.classycraft.app.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.observer.ISubscriber;
import raf.dsw.classycraft.app.repository.composite.ClassyNode;

import raf.dsw.classycraft.app.repository.implementation.Diagram;
import raf.dsw.classycraft.app.repository.implementation.Package;


import javax.swing.*;


@Getter
@Setter

public class PackageView extends JPanel implements ISubscriber {

    private JTabbedPane jtp;
    private JLabel projectName;
    private JLabel author;
    private Package paket;

    public PackageView() {
        this.paket = (Package) MainFrame.getInstance().getTree().getSelectedNode().getClassyNode();
        this.paket.addSubscriber(this);
        this.projectName = new JLabel(this.paket.getName());
        this.author = new JLabel(this.paket.getAuthor());
        this.jtp = new JTabbedPane(SwingConstants.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
        add(jtp);
        for (ClassyNode node : paket.getChildren()) {
            if (node instanceof Diagram) {
                addTab((Diagram) node);
            }
        }
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(projectName);
        add(author);
        add(jtp);
    }
    private void addTab(Diagram diagram) {
        DiagramView diagramView = new DiagramView(diagram);
        jtp.addTab(diagram.getName(), diagramView);
    }
    public DiagramView getDiagramView() {
        return (DiagramView) jtp.getSelectedComponent();
    }
    @Override
    public void update(Object notification) {
        if (notification instanceof Package) {
            Package paket = (Package) notification;

            projectName.setText("Projekat: " + paket.getName());
            author.setText("Autor: " + paket.getAuthor());

            this.revalidate();
            this.repaint();
        } else if (notification instanceof Diagram) {
            // Update diagrams in the tabbed pane
            Diagram updatedDiagram = (Diagram) notification;
            revalidateTabbedPane(updatedDiagram);
        }
    }
    private void revalidateTabbedPane(Diagram updatedDiagram) {
        for (int i = 0; i < jtp.getTabCount(); i++) {
            DiagramView diagramView = (DiagramView) jtp.getComponentAt(i);
            Diagram diagram = diagramView.getDiagram();
            if (diagram.equals(updatedDiagram)) {
                jtp.remove(i);
                addTab(updatedDiagram);
                break;
            }
        }

    }
}