package raf.dsw.classycraft.app.gui.swing.controller;

import com.google.gson.*;
import raf.dsw.classycraft.app.repository.composite.ClassyNode;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GsonNodeArray implements JsonDeserializer<List<ClassyNode>>{

    @Override
    public List<ClassyNode> deserialize(JsonElement jsonElement, Type typeOfT, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonArray json = jsonElement.getAsJsonArray();

        ArrayList<ClassyNode> arrayList = new ArrayList<>();
        GsonNode node = new GsonNode();

        for (JsonElement element : json) {
            arrayList.add(node.deserialize(element, null, jsonDeserializationContext));
        }

        return arrayList;
    }
}
