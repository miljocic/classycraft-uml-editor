package raf.dsw.classycraft.app.repository.implementation;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.view.MainFrame;
import raf.dsw.classycraft.app.gui.swing.view.PackageView;
import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.composite.ClassyNodeComposite;

import javax.swing.*;
import java.util.List;

@Getter
@Setter
public class Project extends ClassyNodeComposite {

    private static int counter = 1;
    private String authorName = "";
    private String directory = "";
    private transient boolean changed;

    public Project(String name, ClassyNode parent) {
        super(name, parent);
        setName(name + counter);
        counter++;
        this.changed = true;
    }

    public Project(String name, List<ClassyNode> children, String authorName, String directory) {
        super(name, children);
        this.authorName = authorName;
        this.directory = directory;
        className = "Project";
    }

    @Override
    public void addChild(ClassyNode child) {
        if (child != null && child instanceof Package) {
            Package paket = (Package) child;
            paket.setParentProject(this);
            if (!this.getChildren().contains(paket)) {
                this.getChildren().add(paket);
            }
        }
    }

    @Override
    public void deleteChild(ClassyNode child) {

        if (child instanceof Package) {
            Package paket = (Package) child;
            this.getChildren().remove(paket);
            if (MainFrame.getInstance().getSplitPane().getRightComponent() instanceof PackageView) {
                if (((PackageView) MainFrame.getInstance().getSplitPane().getRightComponent()).getPaket().equals(paket)) {
                    MainFrame.getInstance().getSplitPane().setRightComponent(new JPanel());
                }
            }
        }

    }

    public void setDirectory(String directory) {
        this.directory = directory;
        changed = true;
    }

}
