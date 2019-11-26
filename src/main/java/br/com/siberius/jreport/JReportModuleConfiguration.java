package br.com.siberius.jreport;

import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "br.com.siberius.jreport")
@AutoConfigurationPackage
public class JReportModuleConfiguration {

}
