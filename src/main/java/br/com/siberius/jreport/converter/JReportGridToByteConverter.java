package br.com.siberius.jreport.converter;

import javax.persistence.AttributeConverter;

import br.com.siberius.jreport.types.JReportGrid;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;

public class JReportGridToByteConverter implements AttributeConverter<JReportGrid, byte[]> {

	@Override
	@SneakyThrows
	public byte[] convertToDatabaseColumn(JReportGrid attribute) {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsBytes(attribute);
	}

	@Override
	@SneakyThrows
	public JReportGrid convertToEntityAttribute(byte[] dbData) {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(dbData, new TypeReference<JReportGrid>() {});
	}

}
