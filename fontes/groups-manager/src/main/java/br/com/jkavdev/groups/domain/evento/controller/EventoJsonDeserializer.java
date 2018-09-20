package br.com.jkavdev.groups.domain.evento.controller;

import br.com.jkavdev.groups.domain.evento.entity.UF;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;

import java.io.IOException;
import java.util.Optional;

//caso queiramos montar um enum UF

public class EventoJsonDeserializer extends JsonDeserializer<UF> {

    @Override
    public UF deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Optional<UF> opt = UF.forValue(jsonParser.getValueAsString());
        opt.orElseThrow(() -> new RuntimeJsonMappingException("invalid value for type"));
        return opt.get();
    }

}
