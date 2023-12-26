package raf.dsw.classycraft.app.serializer;

import com.google.gson.Gson;
import raf.dsw.classycraft.app.core.Serializer;
import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.composite.ClassyNodeComposite;
import raf.dsw.classycraft.app.repository.implementation.Project;
import raf.dsw.classycraft.app.repository.implementation.connectionElements.Connection;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Interclass;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GsonSerializer implements Serializer {
    private final Gson gson = new Gson();

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
        try (FileWriter writer = new FileWriter(project.getDirectory())) {
            gson.toJson(project, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
