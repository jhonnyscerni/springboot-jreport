package br.com.siberius.jreport.rest;

import br.com.siberius.jfilter.core.Filterable;
import br.com.siberius.jfilter.rest.AbstractCrudRest;
import br.com.siberius.jreport.domain.JReport;
import br.com.siberius.jreport.helper.JReportTemplate;
import br.com.siberius.jreport.repository.JReportRepository;
import br.com.siberius.jreport.repository.specification.JReportSpecification;
import br.com.siberius.jreport.service.JReportService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Map;

/**
 * Classe Rest com a API de gerenciamento de reports.
 * 
 *
 */
@RestController
@RequestMapping("/api/mngt/jreport")
public class JReportMngtRest extends AbstractCrudRest<JReport, Long, JReportSpecification, JReportRepository> {

	@Autowired
	private JReportService jreportService;

	@Autowired
	private JReportTemplate template;

	/**
	 * Retorna a lista paginada de categories
	 * 
	 * @param pageable
	 * @return
	 */
	@GetMapping("/categories")
	public ResponseEntity<Page<String>> findAllCategories(Pageable pageable) {
		return ResponseEntity.ok().body(this.getRepository().findAllCategories(pageable));
	}

	@Override
	protected JReport insert(JReport jReport) {
		return jreportService.insert(jReport);
	}

	/**
	 * Atualiza um(a) JReport
	 *
	 * @param jReport
	 * @return Entidade gerenciada.
	 */
	@Override
	protected JReport update(Long id, JReport jReport) {
		if (!this.getRepository().existsById(id)) throw new EntityNotFoundException("Relatório não encontrado: Id=${id}");
		return jreportService.update(jReport);
	}

	/**
	 * Gera uma prévia da execução do código SQL.
	 * 
	 * @param jreport
	 * @return
	 */
	@PostMapping("/preview/datasource")
	public ResponseEntity<?> previewSQL(@RequestBody Map<String, Object> params, Pageable pageable) {
		if (StringUtils.isEmpty((CharSequence) params.get("sql"))) throw new IllegalArgumentException("SQL não definida na requisição.");
		return ResponseEntity.ok(jreportService.executeSQL((String) params.get("sql"), pageable.getSort(), (Filterable) params.get("filter")));
	}

//	/**
//	 * Gera uma prévia do PDF
//	 * 
//	 * @param payload
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	@PostMapping(path = "/preview/pdf", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
//	ResponseEntity<?> previewPDF(@RequestBody Map<String, Object> params, Sort sort) {
//		if (StringUtils.isEmpty((CharSequence) params.get("sql"))) throw new IllegalArgumentException("SQL não definida na requisição.");
//		if (StringUtils.isEmpty((CharSequence) params.get("gpdf"))) throw new IllegalArgumentException("Código Groovy (gpdf) não definido na requisição.");
//		if (((List<JReportColumn>) params.get("columns")).isEmpty()) throw new IllegalArgumentException("Colunas não definidas na requisição.");
//
//		String sql = (String) params.get("sql");
//		String gpdf = (String) params.get("gpdf");
//		
//
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Content-Disposition", "inline; filename=preview.pdf");
//		// @formatter:off
//		ByteArrayInputStream bais = jreportService.genGPDF(
//				new JReport(
//						params.get("sql"), 
//						params.get("gpdf"), 
//						new JReportGrid(params.columns)), 
//				sort, 
//				(Filterable) params.get("filter"));
//		ResponseEntity
//				.ok()
//				.headers(headers)
//				.contentType(MediaType.APPLICATION_PDF)
//				.body(new InputStreamResource(bais));
//		// @formatter:on
//	}

	/**
	 * 
	 * @param jreport
	 * @return
	 */
	@PostMapping("/grid/template")
	public ResponseEntity<?> genDefaultGridTemplate(@RequestBody JReport jreport) {
		if (StringUtils.isEmpty(jreport.getSql())) throw new IllegalArgumentException("SQL não definida na requisição.");
		return ResponseEntity.ok(template.genDefaultGridTemplate(jreport.getSql()));
	}

	/**
	 * 
	 * @return
	 */
	@GetMapping("/gpdf/template")
	public ResponseEntity<?> genDefaultGPDFTemplate() {
		return ResponseEntity.ok(template.genDefaultGpdfTemplate());
	}
}
