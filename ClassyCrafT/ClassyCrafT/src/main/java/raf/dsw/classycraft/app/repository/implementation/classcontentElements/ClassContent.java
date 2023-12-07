package raf.dsw.classycraft.app.repository.implementation.classcontentElements;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.implementation.DiagramElement;
@Getter
@Setter
public abstract class ClassContent extends DiagramElement {

    private String visibility;

    public ClassContent(String name, ClassyNode parent, Integer stroke, int color, double xCoordinate, double yCoordinate, String visibility) {
        super(name, parent, stroke, color, xCoordinate, yCoordinate);
        this.visibility = visibility;
    }
}
