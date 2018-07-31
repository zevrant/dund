package com.dnd.resources.dundresourceorganizer.config;

import com.dnd.resources.dundresourceorganizer.dto.EntryDTO;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EntryDTODeserializer extends StdDeserializer<EntryDTO> {

    public EntryDTODeserializer(){
        this(null);
    }

    protected EntryDTODeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public EntryDTO deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = p.getCodec().readTree(p);
        EntryDTO entryDTO = new EntryDTO();
        try {
            entryDTO.setType(node.get("type").asText());
            entryDTO.setName(node.get("name").asText());
            List<String> entries = new ArrayList<>();
            node.withArray("entries").iterator().forEachRemaining(entry -> {
                entries.add(entry.asText());
            });
            entryDTO.setEntries(entries);
        } catch (NullPointerException ex) {
            entryDTO.setEntry(node.asText());
        }
        return entryDTO;
    }

}
