package br.com.jkavdev.groups.domain.noticia;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class TopicoJsonSerializer extends StdSerializer<Topico> {

	private static final long serialVersionUID = 1L;

	public TopicoJsonSerializer() {
		super(Topico.class);
	}

	@Override
	public void serialize(Topico value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeStartObject();
		gen.writeFieldName("topico");
		gen.writeString(value.name());
		gen.writeFieldName("descricao");
		gen.writeString(value.getDescricao());
		gen.writeEndObject();
	}

}
