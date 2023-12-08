package raf.dsw.classycraft.app.repository.implementation.connectionElements;

import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Interclass;

public class Composition extends Connection {


    public Composition(String name, ClassyNode parent, Interclass from, Interclass to) {
        super(name, parent, from, to);
    }
}
