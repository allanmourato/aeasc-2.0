package br.com.abm.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "funcionario")
public class Funcionario implements Serializable, DataCadastro {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotBlank(message = "Nome é obrigatório")
	private String nome;
	
	@NotBlank(message = "CPF é obrigatório")
	private String cpf;
	
	@NotBlank(message = "Número da carteira é obrigatório")
	private String numeroCarteiraTrabalho;
	
	@NotBlank(message = "PIS é obrigatório")
	private String numeroPis;
	
	@NotBlank(message = "Função é obrigatório")
	private String funcao;
	
	@Temporal(TemporalType.DATE)
	private Date dataDeCadastro;
	
	@NotBlank(message = "Data de admissão é obrigatório")
	private Date dataAdmissao;
	
	@Temporal(TemporalType.DATE)
	private Date dataDemissao;
	
	@NotBlank(message = "")
	private BigDecimal salarioAtual;
	
	@NotBlank(message = "")
	private NivelDeAcesso nivelDeAcesso;
	
	
	
	//Pega a data atual do sistema e seta na data de cadastro.
	@Override
	public Date geraDataDeCadastro() {
		return new Date();
	}

	
	
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNumeroCarteiraTrabalho() {
		return numeroCarteiraTrabalho;
	}

	public void setNumeroCarteiraTrabalho(String numeroCarteiraTrabalho) {
		this.numeroCarteiraTrabalho = numeroCarteiraTrabalho;
	}

	public String getNumeroPis() {
		return numeroPis;
	}

	public void setNumeroPis(String numeroPis) {
		this.numeroPis = numeroPis;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public Date getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(Date dataDeCadastro) {
		this.dataDeCadastro = geraDataDeCadastro();
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Date getDataDemissao() {
		return dataDemissao;
	}

	public void setDataDemissao(Date dataDemissao) {
		this.dataDemissao = dataDemissao;
	}

	public BigDecimal getSalarioAtual() {
		return salarioAtual;
	}

	public void setSalarioAtual(BigDecimal salarioAtual) {
		this.salarioAtual = salarioAtual;
	}

	public NivelDeAcesso getNivelDeAcesso() {
		return nivelDeAcesso;
	}

	public void setNivelDeAcesso(NivelDeAcesso nivelDeAcesso) {
		this.nivelDeAcesso = nivelDeAcesso;
	}
	
	
	
	

}
