package raf.dsw.classycraft.app.gui.swing.controller;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import raf.dsw.classycraft.app.repository.composite.ClassyNode;
import raf.dsw.classycraft.app.repository.implementation.Diagram;
import raf.dsw.classycraft.app.repository.implementation.Package;
import raf.dsw.classycraft.app.repository.implementation.Project;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Class;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Enum;
import raf.dsw.classycraft.app.repository.implementation.interclassElements.Interface;

import java.lang.reflect.Type;

public class GsonNode implements JsonDeserializer<ClassyNode>{
    @Override
    public ClassyNode deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if()
    }
}
