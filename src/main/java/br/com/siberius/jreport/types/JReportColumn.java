package br.com.siberius.jreport.types;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JReportColumn {

	String dataField;

	String caption;

	String dataType;
	
	String javaType;
	
	Integer width = 20;

	Map<String, Object> properties = new HashMap<>();

	@JsonAnyGetter
	public Map<String, Object> getProperties() {
		return properties;
	}

	@JsonAnySetter
	void setProperty(String name, Object value) {
		this.properties.put(name, value);
	}

	public static Class<?> toJavaType(int type) {
		Class<?> result = Object.class;

		switch (type) {
			case Types.CHAR:
			case Types.VARCHAR:
			case Types.LONGVARCHAR:
				result = String.class;
				break;

			case Types.NUMERIC:
			case Types.DECIMAL:
				result = java.math.BigDecimal.class;
				break;

			case Types.BIT:
				result = Boolean.class;
				break;

			case Types.TINYINT:
				result = Byte.class;
				break;

			case Types.SMALLINT:
				result = Short.class;
				break;

			case Types.INTEGER:
				result = Integer.class;
				break;

			case Types.BIGINT:
				result = Long.class;
				break;

			case Types.REAL:
			case Types.FLOAT:
				result = Float.class;
				break;

			case Types.DOUBLE:
				result = Double.class;
				break;

			case Types.BINARY:
			case Types.VARBINARY:
			case Types.LONGVARBINARY:
				result = Byte[].class;
				break;

			case Types.DATE:
				result = java.sql.Date.class;
				break;

			case Types.TIME:
				result = java.sql.Time.class;
				break;

			case Types.TIMESTAMP:
				result = java.sql.Timestamp.class;
				break;
		}
		return result;
	}
	
	public static String toTypescriptType(int type) {
		String result = "undefined";

		switch (type) {
			case Types.CHAR:
			case Types.VARCHAR:
			case Types.LONGVARCHAR:
				result = "string";
				break;

			case Types.NUMERIC:
			case Types.DECIMAL:
				result = "number";
				break;

			case Types.BIT:
				result = "boolean";
				break;

			case Types.TINYINT:
				result = "number";
				break;

			case Types.SMALLINT:
				result = "number";
				break;

			case Types.INTEGER:
				result = "number";
				break;

			case Types.BIGINT:
				result = "number";
				break;

			case Types.REAL:
			case Types.FLOAT:
				result = "number";
				break;

			case Types.DOUBLE:
				result = "number";
				break;

			case Types.BINARY:
			case Types.VARBINARY:
			case Types.LONGVARBINARY:
				result = "string";
				break;

			case Types.DATE:
				result = "date";
				break;

			case Types.TIME:
				result = "datetime";
				break;

			case Types.TIMESTAMP:
				result = "datetime";
				break;
		}
		return result;
	}
	
	
}
