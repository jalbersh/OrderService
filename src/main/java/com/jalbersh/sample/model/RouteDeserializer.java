package com.jalbersh.sample.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class RouteDeserializer extends StdDeserializer<Route> {

    private static final JsonPointer distancePath = JsonPointer.compile(
            "/route/distance"
    );
    private static final JsonPointer formattedTimePath = JsonPointer.compile(
            "/route/formattedTime"
    );
    private static final JsonPointer executedViewNamePath = JsonPointer.compile(
            "/executedViewName"
    );

    public RouteDeserializer() {
        this(null);
    }

    public RouteDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Route deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {
        // TODO(gab): Review once schema is concrete for optimizations (currently non-optimal)
        Route res = new Route();

        JsonNode root = jsonParser.getCodec().readTree(jsonParser);

        res.setDistance(root.at(RouteDeserializer.distancePath).floatValue());
        res.setFormattedTime(root.at(RouteDeserializer.formattedTimePath).asText());

        return res;
    }
}
