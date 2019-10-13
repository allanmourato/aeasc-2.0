package br.com.abm.model;

public enum Desligamento {
	SIM("Sim"),
	NAO("Não");
	
	private String descricao;
	
	Desligamento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	

}
