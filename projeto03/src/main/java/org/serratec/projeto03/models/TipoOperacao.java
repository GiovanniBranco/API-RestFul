package org.serratec.projeto03.models;

public enum TipoOperacao {
	
	
	DEBITO("debito"), CREDITO("credito");
	private final String descricao;

	private TipoOperacao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
