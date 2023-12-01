package raf.dsw.classycraft.app.repository.implementation.interclassElements;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.implementation.classcontentElements.ClassContent;

@Getter
@Setter
public class Class extends Interclass{

    private ClassContent classContent;

    public Class(String name, ClassyNode parent, String visibility) {
        super(name, parent, visibility);
        this.classContent= classContent;
    }


}
