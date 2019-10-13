package br.com.abm.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class SocioDao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager manager;
	
	
	

}
