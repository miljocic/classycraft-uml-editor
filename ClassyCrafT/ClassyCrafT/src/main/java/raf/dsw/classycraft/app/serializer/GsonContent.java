package raf.dsw.classycraft.app.serializer;

import com.google.gson.*;
import raf.dsw.classycraft.app.repository.implementation.classcontentElements.ClassContent;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GsonContent implements JsonDeserializer<List<ClassContent>> {


    @Override
    public List<ClassContent> deserialize(JsonElement jsonElement, Type typeOfT, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonArray json = jsonElement.getAsJsonArray();

        ArrayList<ClassContent> arrayList = new ArrayList<>();
        GsonNode node = new GsonNode();

        for (JsonElement element : json) {
            arrayList.add((ClassContent) node.deserialize(element, null, jsonDeserializationContext));
        }

        return arrayList;
    }
}
