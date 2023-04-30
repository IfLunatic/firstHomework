package patterns.task.CatalogClasses;

import com.google.gson.*;
import patterns.task.Children;
import patterns.task.MovieType;
import patterns.task.NewRelease;
import patterns.task.Regular;

import java.lang.reflect.Type;

public class MovieAdapter implements JsonSerializer<MovieType>, JsonDeserializer<MovieType> {
    private static final String TYPE_FIELD = "type";

    @Override
    public JsonElement serialize(MovieType src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(TYPE_FIELD, src.getClass().getSimpleName());
        return jsonObject;
    }

    @Override
    public MovieType deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String typeName = jsonObject.get(TYPE_FIELD).getAsString();

        return switch (typeName) {
            case "NewRelease" -> context.deserialize(json, NewRelease.class);
            case "Regular" -> context.deserialize(json, Regular.class);
            case "Children" -> context.deserialize(json, Children.class);
            default -> throw new JsonParseException("Unknown MovieClassification type: " + typeName);
        };
    }
}