package org.serratec.projeto01.model;

public class CalculatorModel {
	private Double n1;
	private Double n2;
	private String operador;

	public CalculatorModel(Double n1, Double n2) {
		super();
		this.n1 = n1;
		this.n2 = n2;
	}
	
	public Double getN1() {
		return n1;
	}
	public void setN1(Double n1) {
		this.n1 = n1;
	}
	public Double getN2() {
		return n2;
	}
	public void setN2(Double n2) {
		this.n2 = n2;
	}

	public String getOperador() {
		return operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}

}
