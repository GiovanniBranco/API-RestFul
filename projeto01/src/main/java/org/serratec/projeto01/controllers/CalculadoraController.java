package org.serratec.projeto01.controllers;

import java.util.List;

import org.serratec.projeto01.model.CalculatorModel;
import org.serratec.projeto01.service.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Indica que é o Controller;
@RequestMapping("/calculadora") //Cria o endPoint;	
public class CalculadoraController {

	@Autowired
	CalculadoraService service;
	
	@PostMapping
	public Double calcular(@RequestBody CalculatorModel calculator) {
		return service.calcular(calculator);
	}
	
	@PostMapping("/create")
	public void create(@RequestBody CalculatorModel calculator) {
		service.create(calculator);
	}
	
	@GetMapping("/getlist")
	public List<CalculatorModel> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/search/{n1}")
	public CalculatorModel search(@PathVariable Double n1) {
		return service.search(n1);
	}
}
