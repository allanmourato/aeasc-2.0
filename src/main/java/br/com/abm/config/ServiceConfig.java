package br.com.abm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.abm.service.CategoriaSocioService;

@Configuration
@ComponentScan(basePackageClasses = CategoriaSocioService.class)
public class ServiceConfig {

}
