package raf.dsw.classycraft.app.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.observer.ISubscriber;
import raf.dsw.classycraft.app.repository.composite.ClassyNode;

import raf.dsw.classycraft.app.repository.implementation.Diagram;
import raf.dsw.classycraft.app.repository.implementation.Package;
import raf.dsw.classycraft.app.state.StateManager;


import javax.swing.*;
import java.awt.event.MouseEvent;


@Getter
@Setter

public class PackageView extends JPanel implements ISubscriber {

    private MyTabbedPane mtp;
    private JLabel projectName;
    private JLabel author;
    private Package paket;

    private StateManager stateManager;

    public PackageView() {
        this.paket = (Package) MainFrame.getInstance().getTree().getSelectedNode().getClassyNode();
        this.paket.addSubscriber(this);
        this.projectName = new JLabel(this.paket.getName());
        this.author = new JLabel(this.paket.getAuthor());
        this.mtp = new MyTabbedPane(SwingConstants.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);

        for (ClassyNode node : paket.getChildren()) {
            if (node instanceof Diagram) {
                System.out.println("Lista checkova dal je Diagram");
                node.addSubscriber(this);
                revalidateTabbedPane((Diagram) node);
            }
        }
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(projectName);
        add(author);
        add(mtp);
        stateManager = new StateManager();
    }

    @Override
    public void update(Object notification) {
        System.out.println("Received update: " + notification.toString());
        System.out.println("Notification type: " + notification.getClass());
        if(notification instanceof Package) {
            System.out.println("Paket");
            projectName.setText(paket.getName());
            author.setText(paket.getAuthor());
        } else if(notification instanceof Diagram) {
            System.out.println("Dijagram i Krece revalidate");
            revalidateTabbedPane((Diagram) notification);
        }
    }
    private void revalidateTabbedPane(Diagram updatedDiagram) {

//        if(paket.getChildren().contains(updatedDiagram)) {
//            DiagramView dV = new DiagramView(updatedDiagram);
//            this.mtp.addTab(updatedDiagram.getName(), dV);
//            this.mtp.setSelectedComponent(dV);
//            updatedDiagram.addSubscriber(dV);
//        } else {
//            System.out.println(mtp);
//            for(int i = 0; i < mtp.getTabCount(); i++) {
//                DiagramView diagramView = (DiagramView) mtp.getComponentAt(i);
//                if(diagramView.getDiagram().equals(updatedDiagram))
//                    mtp.remove(diagramView);
//            }
//        }

        boolean diagramFound = false;

        for (int i = 0; i < mtp.getTabCount(); i++) {
            DiagramView diagramView = (DiagramView) mtp.getComponentAt(i);

            if (diagramView.getDiagram().equals(updatedDiagram)) {
                // If the diagram is already in the tab, select it
                mtp.setSelectedComponent(diagramView);
                diagramFound = true;
                System.out.println("Diagram found in tab. Selected existing tab.");
                break;
            }
        }

        if (!diagramFound) {
            // If the diagram is not in the tab, add a new tab
            DiagramView newDiagramView = new DiagramView(updatedDiagram);
            mtp.addTab(updatedDiagram.getName(), newDiagramView);
            mtp.setSelectedIndex(mtp.getTabCount() - 1);
            System.out.println("Diagram not found in tab. Added a new tab.");
        }

    }


    public void startAddState(){
        this.stateManager.setAddState();
    }
    public void startEditState(){
        this.stateManager.setEditState();
    }

    public void startDeleteState(){
        this.stateManager.setDeleteState();
    }

    public void startMoveState(){
        this.stateManager.setMoveState();
    }

    public void startSelectState(){
        this.stateManager.setSelectState();
    }

    public void startConnectState(){ this.stateManager.setConnectState();
    }
    public void startMoveDiagramState() { this.stateManager.setMoveDiagramState();}

    public void startMousePressed(MouseEvent e, DiagramView dV) {
        stateManager.getCurrent().mousePressed(e, dV);
    }

    public void startMouseDragged(MouseEvent e, DiagramView dV) {
        stateManager.getCurrent().mouseDragged(e, dV);
    }

    public void startMouseReleased(MouseEvent e, DiagramView dV) {
        stateManager.getCurrent().mouseReleased(e, dV);
    }


}