package org.serratec.projeto03.models;

import org.serratec.projeto03.enums.TipoOperacao;

public class Operacao {
	private TipoOperacao operacao;
	private Double valor;
	
	public Operacao(TipoOperacao operacao, Double valor) {
		super();
		this.operacao = operacao;
		this.valor = valor;
	}
	public TipoOperacao getOperacao() {
		return operacao;
	}
	public void setTOperacao(TipoOperacao operacao) {
		this.operacao = operacao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
}
