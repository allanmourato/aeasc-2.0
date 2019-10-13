package br.com.abm.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;


@Table(name = "associacao_responsavel")
@Entity
public class UsuarioResposavel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String associacao;
	private String cnpj;
	private String email;
	private Endereco endereco;
	
	//Funcionarios
	
	private List<Funcionario> funcionarios;

}
