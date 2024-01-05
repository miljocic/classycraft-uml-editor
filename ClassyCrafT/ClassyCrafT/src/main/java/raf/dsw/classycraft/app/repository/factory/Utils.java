package raf.dsw.classycraft.app.repository.factory;


import raf.dsw.classycraft.app.repository.composite.NodeType;

public class Utils {

    public static ClassyNodeFactory getFactory(NodeType type) {
        if (type.equals(NodeType.PROJECT_EXPLORER))
            return new ProjectExplorerFactory();
        else if (type.equals(NodeType.PROJECT))
            return new ProjectFactory();
        else if (type.equals(NodeType.PACKAGE))
            return new PackageFactory();
        else if (type.equals(NodeType.DIAGRAM))
            return new DiagramFactory();
        return null;
    }

}
