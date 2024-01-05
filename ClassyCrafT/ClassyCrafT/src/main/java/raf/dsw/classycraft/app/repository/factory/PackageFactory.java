package raf.dsw.classycraft.app.repository.factory;

import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.implementation.Package;

public class PackageFactory extends ClassyNodeFactory {

    @Override
    ClassyNode createNode(ClassyNode parent) {
        return new Package("Package ", parent);
    }
}
