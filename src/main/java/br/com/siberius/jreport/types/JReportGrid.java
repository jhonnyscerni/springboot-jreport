package br.com.siberius.jreport.types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class JReportGrid {

	/**
	 * Defininição das colunas do relatório utilizados tanto nos relatórios online quanto no relatórios PDF.
	 *
	 * Ex:
	 *
	 * [{ "dataField" : "nome", "caption" : "Nome", "width" : 80 }]
	 *
	 */
	List<JReportColumn> columns = new ArrayList<>();

	/**
	 * Outras propriedades de customização do DxDataGrid
	 */
	Map<String, Object> properties = new HashMap<>();

}
