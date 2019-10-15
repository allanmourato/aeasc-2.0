package br.com.abm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.abm.model.CategoriaSocio;

@Repository
public interface Categorias extends JpaRepository<CategoriaSocio, Long> {

}
