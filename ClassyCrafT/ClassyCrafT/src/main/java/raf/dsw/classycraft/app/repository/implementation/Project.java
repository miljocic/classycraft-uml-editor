package raf.dsw.classycraft.app.repository.implementation;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.composite.ClassyNodeComposite;

@Getter
@Setter
public class Project extends ClassyNodeComposite {

    private static int counter=1;
    private String authorName;
    private String directory;

    public Project(String name, ClassyNode parent) {
        super(name, parent);
        setName(name+counter);
        counter++;
    }

    @Override
    public void addChild(ClassyNode child) {
        if (child != null &&  child instanceof Package){
            Package paket = (Package) child;
            if (!this.getChildren().contains(paket)){
                this.getChildren().add(paket);
            }
        }
    }

    @Override
    public void deleteChild(ClassyNode child) {
        Package paket = (Package) child;
        if(this.getChildren().contains(paket))
        {
            this.getChildren().remove(paket);
        }
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String author) {
        this.authorName = author;
        //notifySubscriber(this);
    }

    public void setFilePath(String directory) {
        this.directory = directory;
    }

}
