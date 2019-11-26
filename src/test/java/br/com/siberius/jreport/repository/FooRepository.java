package br.com.siberius.jreport.repository;

import br.com.siberius.jreport.domain.Foo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.siberius.jfilter.jpa.JFilterRepository;

@Repository
public interface FooRepository extends JpaRepository<Foo, Long>, JFilterRepository<Foo>{

}
