package br.com.siberius.jreport.repository;

import br.com.siberius.jfilter.jpa.JFilterRepository;
import br.com.siberius.jreport.domain.JReport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JReportRepository extends JpaRepository<JReport, Long>, JpaSpecificationExecutor<JReport>, JFilterRepository<JReport> {

	@Query("select distinct r.category from JReport r")
	Page<String> findAllCategories(Pageable pageable);
}
