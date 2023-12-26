package raf.dsw.classycraft.app.repository.implementation;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import raf.dsw.classycraft.app.gui.swing.view.PackageView;
import raf.dsw.classycraft.app.observer.ISubscriber;
import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.composite.ClassyNodeComposite;

import javax.swing.*;

@Getter
@Setter
public class Project extends ClassyNodeComposite {

    private static int counter=1;
    private String authorName;
    private String directory;

    private boolean changed;

    public Project(String name, ClassyNode parent) {
        super(name, parent);
        setName(name+counter);
        counter++;
        this.changed = true;
    }

    @Override
    public void addChild(ClassyNode child) {
        if (child != null &&  child instanceof Package){
            Package paket = (Package) child;
            paket.setParentProject(this);
            if (!this.getChildren().contains(paket)){
                this.getChildren().add(paket);
            }
        }
    }

    @Override
    public void deleteChild(ClassyNode child) {

        if(child instanceof Package) {
            Package paket = (Package) child;
            this.getChildren().remove(paket);
            if(MainFrame.getInstance().getSplitPane().getRightComponent() instanceof PackageView) {
                if(((PackageView) MainFrame.getInstance().getSplitPane().getRightComponent()).getPaket().equals(paket)) {
                    MainFrame.getInstance().getSplitPane().setRightComponent(new JPanel());
                }
            }
        }

    }

    public void setDirectory(String directory){
        this.directory = directory;
        changed = true;
    }

}
