package raf.dsw.classycraft.app.serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import raf.dsw.classycraft.app.core.Serializer;
import raf.dsw.classycraft.app.gui.swing.controller.GsonColor;
import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.composite.ClassyNodeComposite;
import raf.dsw.classycraft.app.repository.implementation.Diagram;
import raf.dsw.classycraft.app.repository.implementation.Project;
import raf.dsw.classycraft.app.repository.implementation.connectionElements.Connection;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Interclass;

import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class GsonSerializer implements Serializer {

    private final GsonBuilder builder = new GsonBuilder();
    private final Gson gson;

    public GsonSerializer() {
        builder.serializeNulls();
        builder.registerTypeAdapter(Color.class, new GsonColor());
        builder.setPrettyPrinting();
        gson = builder.create();
    }

    @Override
    public Project loadProject(File file) {
        try (FileReader fileReader = new FileReader(file)) {
            Project project = gson.fromJson(fileReader, Project.class);
            for(ClassyNode child : project.getChildren()) {
                child.setParent(project);
                ClassyNodeComposite childComposite = (ClassyNodeComposite) child;
                for(ClassyNode grandchild : childComposite.getChildren()) {
                    if(grandchild instanceof Connection) {
                        Connection connection = (Connection) grandchild;
                        connection.setFrom((Interclass)
                                childComposite.getChildByName(connection.getFrom().getName()));
                        connection.setTo((Interclass)
                                childComposite.getChildByName(connection.getTo().getName()));
                        System.out.println(connection.getFrom() + " " + connection.getTo());
                    } else {
                        System.out.println(grandchild);
                    }
                    grandchild.setParent(childComposite);
                }
            }
            return project;
        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void saveProject(Project project) {
        try (FileWriter writer = new FileWriter(project.getDirectory() + ".txt")) {
            gson.toJson(project, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveTemplate(Diagram diagram) {
        System.out.println(getClass().getResource(Diagram.getTemplatePath()));
        try (FileWriter writer = new FileWriter(Objects.requireNonNull(getClass().getResource(Diagram.getTemplatePath())).getPath()+ System.getProperty("file.separator") + diagram.getName() + ".txt")) {
            gson.toJson(diagram, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Diagram loadTemplate(File file) {
        try (FileReader fileReader = new FileReader(file)) {
            Diagram diagram = gson.fromJson(fileReader, Diagram.class);
            for(ClassyNode child : diagram.getChildren()) {
                if(child instanceof Connection) {
                    Connection connection = (Connection) child;
                    connection.setFrom((Interclass)diagram.getChildByName(connection.getFrom().getName()));
                    connection.setTo((Interclass)diagram.getChildByName(connection.getTo().getName()));
                    System.out.println(connection.getFrom() + " " + connection.getTo());
                } else {
                    System.out.println(diagram);
                }
                child.setParent(diagram);
            }
            return diagram;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
