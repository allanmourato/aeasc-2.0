package br.com.abm.model;

public enum StatusSocio {
	
	ATIVO("Ativo"),
	INATIVO("Inativo");
	
	private String descricao;
	
	StatusSocio(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	

}
