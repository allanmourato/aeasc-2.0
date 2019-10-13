package br.com.abm.model;

public enum NivelDeAcesso {
	JUNIOR("Júnior"),
	PLENO("Pleno"),
	SENIOR("Sênior");
	
	private String descricao;
	
	NivelDeAcesso(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	

}
