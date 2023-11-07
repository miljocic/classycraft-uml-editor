package raf.dsw.classycraft.app.repository.implementation;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.repository.composite.ClassyNode;

@Getter
@Setter
public class Project extends ClassyNode {


    private String authorName;
    private String directory;


    public Project(String name, ClassyNode parent, String authorName, String directory) {
        super(name, parent);
        this.authorName = authorName;
        this.directory = directory;//Potreban path za folder sa resursima
    }
}
