package raf.dsw.classycraft.app.repository.factory;

import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.implementation.Diagram;
import raf.dsw.classycraft.app.repository.implementation.Package;
import raf.dsw.classycraft.app.repository.implementation.Project;
import raf.dsw.classycraft.app.repository.implementation.ProjectExplorer;

public class Utils {

    public static ClassyNodeFactory getFactory(ClassyNode parent){
        if(parent instanceof ProjectExplorer)
            return new ProjectFactory();
        else if (parent instanceof Project)
            return new PackageFactory();
        else if (parent instanceof Package)
            return new DiagramFactory();
        return null;
    }

}
