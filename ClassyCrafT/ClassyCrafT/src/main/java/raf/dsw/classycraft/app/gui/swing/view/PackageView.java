package raf.dsw.classycraft.app.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.observer.ISubscriber;
import raf.dsw.classycraft.app.repository.composite.ClassyNode;

import raf.dsw.classycraft.app.repository.implementation.Diagram;
import raf.dsw.classycraft.app.repository.implementation.Package;
import raf.dsw.classycraft.app.state.StateManager;


import javax.swing.*;


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
        if (notification instanceof Package) {
            Package paket = (Package) notification;

            projectName.setText("Projekat: " + paket.getName());
            author.setText("Autor: " + paket.getAuthor());

        }  else if(notification instanceof Diagram) {
            revalidateTabbedPane((Diagram) notification);
        }
    }
    private void revalidateTabbedPane(Diagram updatedDiagram) {

        if(paket.getChildren().contains(updatedDiagram)) {
            this.mtp.addTab(updatedDiagram.getName(), new DiagramView(updatedDiagram));
        } else {
            System.out.println(mtp);
            for(int i = 0; i < mtp.getTabCount(); i++) {
                DiagramView diagramView = (DiagramView) mtp.getComponentAt(i);
                if(diagramView.getDiagram().equals(updatedDiagram))
                    mtp.remove(diagramView);
            }
        }

    }

    //za state manager (u StateManager setteri nesto cudno ponasaju)

    public void startAddState(){
        this.stateManager.setAddState();
    }

    public void startDeleteState(){
        this.stateManager.setDeleteState();
    }

    public void startMoveState(){
        this.stateManager.setMoveState();
    }

    public void startZoomState(){
        this.stateManager.setZoomState();
    }

    public void startSelectState(){
        this.stateManager.setSelectState();
    }



}