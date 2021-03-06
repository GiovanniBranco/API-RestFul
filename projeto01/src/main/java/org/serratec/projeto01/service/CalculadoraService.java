package org.serratec.projeto01.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.projeto01.model.CalculatorModel;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {
	
	static List<CalculatorModel> list= new ArrayList<CalculatorModel>();
	
	public Double calcular(CalculatorModel calculator) {
		if(calculator.getOperador() != null) {
			switch (calculator.getOperador()) {
			case "+":
				return somar(calculator);
			case "-":
				return subtrair(calculator);
			case "*":
				return multiplicar(calculator);
			case "/":
				return dividir(calculator);

			default:
				System.out.println("Operador inválido");
				return null;
			}
		}
		System.out.println("Operador inválido");
		return null;
	}
	
	
	public Double somar(CalculatorModel calculator) {
		return (calculator.getN1() + calculator.getN2());	
	}
	
	public Double subtrair(CalculatorModel calculator) {
		return (calculator.getN1() - calculator.getN2());
	}

	public Double multiplicar(CalculatorModel calculator) {
		return (calculator.getN1() * calculator.getN2());
	}
	
	public Double dividir(CalculatorModel calculator) {
		if(calculator.getN2() ==0) {
			System.out.println("O divisor deve ser diferente de 0");
			return null;
		}
		return (calculator.getN1() / calculator.getN2());
	}
	
	public void create(CalculatorModel calculator) {
		list.add(calculator);
	}
	
	public List<CalculatorModel> getAll() {
		return list;
	}
	
	public CalculatorModel search(Double n1) {
		for (CalculatorModel calculatorModel : list) {
			if(calculatorModel.getN1()==n1) {
				return calculatorModel;
			}
		}
		System.out.println("Número não encontrado!");
		return null;
	}
}
