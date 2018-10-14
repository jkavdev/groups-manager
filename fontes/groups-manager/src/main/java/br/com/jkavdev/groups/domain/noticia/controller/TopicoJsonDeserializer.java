package br.com.jkavdev.groups.domain.noticia.controller;

import br.com.jkavdev.groups.domain.noticia.entity.Topico;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;

import java.io.IOException;
import java.util.Optional;

public class TopicoJsonDeserializer extends JsonDeserializer<Topico> {

    @Override
    public Topico deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        Optional<Topico> opt = Topico.forValue(jsonParser.getValueAsString());
        opt.orElseThrow(() -> new RuntimeJsonMappingException("invalid value for type"));
        return opt.get();
    }

}