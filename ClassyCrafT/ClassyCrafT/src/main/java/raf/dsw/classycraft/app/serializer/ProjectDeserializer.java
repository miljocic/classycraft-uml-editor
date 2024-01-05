package raf.dsw.classycraft.app.serializer;

import com.google.gson.*;
import raf.dsw.classycraft.app.repository.composite.ClassyNode;

import java.lang.reflect.Type;

public class ProjectDeserializer implements JsonDeserializer<ClassyNode>, JsonSerializer<ClassyNode> {
    @Override
    public final JsonElement serialize(final ClassyNode object, final Type interfaceType,
                                       final JsonSerializationContext context) {
        final JsonObject member = new JsonObject();

        member.addProperty("type", object.getClass().getName());

        member.add("data", context.serialize(object));

        return member;
    }

    @Override
    public final ClassyNode deserialize(final JsonElement elem, final Type interfaceType,
                                        final JsonDeserializationContext context)
            throws JsonParseException {
        final JsonObject member = (JsonObject) elem;
        final JsonElement typeString = get(member, "type");
        final JsonElement data = get(member, "data");
        final Type actualType = typeForName(typeString);

        return context.deserialize(data, actualType);
    }

    private Type typeForName(final JsonElement typeElem) {
        try {
            return Class.forName(typeElem.getAsString());
        } catch (ClassNotFoundException e) {
            throw new JsonParseException(e);
        }
    }

    private JsonElement get(final JsonObject wrapper, final String memberName) {
        final JsonElement elem = wrapper.get(memberName);

        if (elem == null) {
            throw new JsonParseException(
                    "no '" + memberName + "' member found in json file.");
        }
        return elem;
    }
}
