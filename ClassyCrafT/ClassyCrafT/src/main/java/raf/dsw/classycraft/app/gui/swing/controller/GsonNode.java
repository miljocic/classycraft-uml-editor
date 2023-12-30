package raf.dsw.classycraft.app.gui.swing.controller;
import com.google.gson.*;
import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.implementation.Diagram;
import raf.dsw.classycraft.app.repository.implementation.Package;
import raf.dsw.classycraft.app.repository.implementation.Project;
import raf.dsw.classycraft.app.repository.implementation.classcontentElements.Attribute;
import raf.dsw.classycraft.app.repository.implementation.classcontentElements.Method;
import raf.dsw.classycraft.app.repository.implementation.connectionElements.Aggregation;
import raf.dsw.classycraft.app.repository.implementation.connectionElements.Composition;
import raf.dsw.classycraft.app.repository.implementation.connectionElements.Dependency;
import raf.dsw.classycraft.app.repository.implementation.connectionElements.Generalization;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Class;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Enum;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Interclass;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Interface;
import java.awt.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class GsonNode implements JsonDeserializer<ClassyNode>{
    @Override
    public ClassyNode deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        String className = jsonObject.get("className").getAsString();
        System.out.println(className);
        GsonNodeArray arrayDeSe = new GsonNodeArray();

        if (Objects.equals(className, "Project")) {
            return new Project(jsonObject.get("name").getAsString(), arrayDeSe.deserialize(jsonObject.get("children"), null, jsonDeserializationContext), jsonObject.get("authorName").getAsString(), jsonObject.get("directory").getAsString());
        } else if (Objects.equals(className, "Package")) {
            return new Package(jsonObject.get("name").getAsString(), arrayDeSe.deserialize(jsonObject.get("children"), null, jsonDeserializationContext), jsonObject.get("author").getAsString(), jsonObject.get("directory").getAsString());
        } else if (Objects.equals(className, "Diagram")) {
            return new Diagram(jsonObject.get("name").getAsString(), arrayDeSe.deserialize(jsonObject.get("children"), null, jsonDeserializationContext));
        } else if (Objects.equals(className, "Class")) {
           return getKlasa(jsonObject, jsonDeserializationContext);
        } else if (Objects.equals(className, "Enum")) {
            return getEnum(jsonObject, jsonDeserializationContext);
        } else if (Objects.equals(className, "Interface")) {
            return getInterfejs(jsonObject, jsonDeserializationContext);
        } else if (Objects.equals(className, "Aggregation")) {
            return getAggregation(jsonObject, jsonDeserializationContext);
        } else if (Objects.equals(className, "Dependency")) {
            return getDependency(jsonObject, jsonDeserializationContext);
        } else if (Objects.equals(className, "Generalization")) {
           return getGeneralization(jsonObject, jsonDeserializationContext);
        } else if (Objects.equals(className, "Composition")) {
            return getComposition(jsonObject, jsonDeserializationContext);
        } else if (Objects.equals(className, "Method")) {
            return new Method(jsonObject.get("name").getAsString(), jsonDeserializationContext.deserialize(jsonObject.get("color"), Color.class),
                    jsonObject.get("stroke").getAsInt());
        } else if (Objects.equals(className, "Attribute")) {
            return new Attribute(jsonObject.get("name").getAsString(), jsonDeserializationContext.deserialize(jsonObject.get("color"), Color.class),
                    jsonObject.get("stroke").getAsInt());
        }
        return null;
    }

    private ClassyNode getComposition(JsonObject jsonObject, JsonDeserializationContext jsonDeserializationContext) {
        return new Composition(jsonObject.get("name").getAsString(),
                jsonDeserializationContext.deserialize(jsonObject.get("color"), Color.class),
                jsonObject.get("stroke").getAsInt(),
                jsonDeserializationContext.deserialize(jsonObject.get("from"), Interclass.class),
                jsonDeserializationContext.deserialize(jsonObject.get("to"), Interclass.class));
    }

    private ClassyNode getGeneralization(JsonObject jsonObject, JsonDeserializationContext jsonDeserializationContext) {
        return new Generalization(jsonObject.get("name").getAsString(),
                jsonDeserializationContext.deserialize(jsonObject.get("color"), Color.class),
                jsonObject.get("stroke").getAsInt(),
                jsonDeserializationContext.deserialize(jsonObject.get("from"), Interclass.class),
                jsonDeserializationContext.deserialize(jsonObject.get("to"), Interclass.class));
    }

    private ClassyNode getDependency(JsonObject jsonObject, JsonDeserializationContext jsonDeserializationContext) {
        return new Dependency(jsonObject.get("name").getAsString(),
                jsonDeserializationContext.deserialize(jsonObject.get("color"), Color.class),
                jsonObject.get("stroke").getAsInt(),
                jsonDeserializationContext.deserialize(jsonObject.get("from"), Interclass.class),
                jsonDeserializationContext.deserialize(jsonObject.get("to"), Interclass.class));
    }

    private ClassyNode getAggregation(JsonObject jsonObject, JsonDeserializationContext jsonDeserializationContext) {
        return new Aggregation(jsonObject.get("name").getAsString(),
                jsonDeserializationContext.deserialize(jsonObject.get("color"), Color.class),
                jsonObject.get("stroke").getAsInt(),
                jsonDeserializationContext.deserialize(jsonObject.get("from"), Interclass.class),
                jsonDeserializationContext.deserialize(jsonObject.get("to"), Interclass.class));
    }

    public static Class getKlasa(JsonObject jsonObject, JsonDeserializationContext jsonDeserializationContext){
        return new Class(jsonObject.get("name").getAsString(),
                jsonDeserializationContext.deserialize(jsonObject.get("color"), Color.class),
                jsonObject.get("stroke").getAsInt(),
                jsonDeserializationContext.deserialize(jsonObject.get("classContent"), ArrayList.class),
                jsonDeserializationContext.deserialize(jsonObject.get("dimension"), Dimension.class),
                jsonDeserializationContext.deserialize(jsonObject.get("location"), Point.class),
                jsonObject.get("visibility").getAsString());
    }

    public static Enum getEnum(JsonObject jsonObject, JsonDeserializationContext jsonDeserializationContext){
        return new Enum(jsonObject.get("name").getAsString(),
                jsonDeserializationContext.deserialize(jsonObject.get("color"), Color.class),
                jsonObject.get("stroke").getAsInt(),
                jsonDeserializationContext.deserialize(jsonObject.get("classContent"), ArrayList.class),
                jsonDeserializationContext.deserialize(jsonObject.get("dimension"), Dimension.class),
                jsonDeserializationContext.deserialize(jsonObject.get("location"), Point.class),
                jsonObject.get("visibility").getAsString());
    }

    public static Interface getInterfejs(JsonObject jsonObject, JsonDeserializationContext jsonDeserializationContext){
        return new Interface(jsonObject.get("name").getAsString(),
                jsonDeserializationContext.deserialize(jsonObject.get("color"), Color.class),
                jsonObject.get("stroke").getAsInt(),
                jsonDeserializationContext.deserialize(jsonObject.get("classContent"), ArrayList.class),
                jsonDeserializationContext.deserialize(jsonObject.get("dimension"), Dimension.class),
                jsonDeserializationContext.deserialize(jsonObject.get("location"), Point.class),
                jsonObject.get("visibility").getAsString());
    }
}
