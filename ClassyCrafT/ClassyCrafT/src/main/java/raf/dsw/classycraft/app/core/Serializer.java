package raf.dsw.classycraft.app.core;

import raf.dsw.classycraft.app.repository.implementation.Project;

import java.io.File;

public interface Serializer {

    Project loadProject(File file);
    void saveProject(Project project);
}