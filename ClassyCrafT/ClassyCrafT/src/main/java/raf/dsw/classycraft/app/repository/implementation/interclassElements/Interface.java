package raf.dsw.classycraft.app.repository.implementation.interclassElements;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.implementation.classcontentElements.Method;

@Getter
@Setter
public class Interface extends Interclass {

    private Method method;

    public Interface(String name, ClassyNode parent, String visibility) {
        super(name, parent, visibility);
        this.method=method;
    }


}