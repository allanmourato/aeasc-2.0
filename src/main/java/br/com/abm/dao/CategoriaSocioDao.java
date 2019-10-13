package br.com.abm.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.abm.model.CategoriaSocio;

@Repository
public class CategoriaSocioDao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager manager;
	
	
	public void adiciona (CategoriaSocio categoriaSocio) {
		manager.persist(categoriaSocio);
	}
	
	public CategoriaSocio buscaPorId(long id) {
		CategoriaSocio categoriaSocio = this.manager.find(CategoriaSocio.class, id);
		return categoriaSocio;
	}
	
	public List<CategoriaSocio> lista() {
		return manager.createQuery("select c from CategoriaSocio  c " + "order by c.nome ASC", CategoriaSocio.class).getResultList();
	}
	
	
}
