package br.com.abm.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "socio")
public class Socio implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Nome é obrigatório")
	private String nome;
	
	@NotBlank(message = "E-Mail é obrigatório")
	private String email;
	
	private String docClasse;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Tipo de pessoa é obrigatório")
	private TipoPessoa tipoPessoa;
	
	@NotBlank(message = "CFP/CNPJ é obrigatório")
	private String documento;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Status do sócio é obrigatório")
	private StatusSocio statusSocio;
	
	@Column(name = "data_nascimento")
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@ManyToOne
	@JoinColumn(name = "codigo_categoria")
	@NotNull(message = "Categoria é obrigatório")
	private CategoriaSocio categoriaSocio;
	
	private String celular;
	
	private String telefone;
	
	@Embedded
	private Endereco endereco;
	
	
	
	//Dados Complementares
	
	@Temporal(TemporalType.DATE)
	private Date dataDeCadastro;
	
	@Min(value = 6, message = "Senha deve conter no mínimo 6 caracteres")
	@Max(value = 10, message = "Senha deve conter no máximo 10 caracteres")
	@Column(name = "senha_de_socio")
	private String senhaDeSocio;
	
	@Enumerated(EnumType.STRING)
	private Desligamento desligamento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDocClasse() {
		return docClasse;
	}

	public void setDocClasse(String docClasse) {
		this.docClasse = docClasse;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public StatusSocio getStatusSocio() {
		return statusSocio;
	}

	public void setStatusSocio(StatusSocio statusSocio) {
		this.statusSocio = statusSocio;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public CategoriaSocio getCategoriaSocio() {
		return categoriaSocio;
	}

	public void setCategoriaSocio(CategoriaSocio categoriaSocio) {
		this.categoriaSocio = categoriaSocio;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Date getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(Date dataDeCadastro) {
		Date dataAtual = new Date();
		this.dataDeCadastro = dataAtual;
	}

	public String getSenhaDeSocio() {
		return senhaDeSocio;
	}

	public void setSenhaDeSocio(String senhaDeSocio) {
		this.senhaDeSocio = senhaDeSocio;
	}

	public Desligamento getDesligamento() {
		return desligamento;
	}

	public void setDesligamento(Desligamento desligamento) {
		this.desligamento = Desligamento.NAO;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Socio other = (Socio) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	

}
