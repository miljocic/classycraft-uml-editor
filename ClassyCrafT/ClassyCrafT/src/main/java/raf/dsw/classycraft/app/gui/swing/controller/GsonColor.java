package raf.dsw.classycraft.app.gui.swing.controller;

import com.google.gson.*;

import java.awt.*;
import java.lang.reflect.Type;

public class GsonColor implements JsonSerializer<Color>, JsonDeserializer<Color> {
    @Override
    public JsonElement serialize(Color color, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject obj = new JsonObject();
        obj.addProperty("red", color.getRed());
        obj.addProperty("green", color.getGreen());
        obj.addProperty("blue", color.getBlue());

        return obj;
    }

    @Override
    public Color deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jobject = jsonElement.getAsJsonObject();
        Color color = new Color(jobject.get("red").getAsInt(), jobject.get("green").getAsInt(),jobject.get("blue").getAsInt());
        return color;
    }
}
