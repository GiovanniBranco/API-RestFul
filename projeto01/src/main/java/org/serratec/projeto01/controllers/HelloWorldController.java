//package org.serratec.projeto01.controllers;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController //Indica que é o Controller;
//@RequestMapping("/saudacao") //Cria o endPoint;
//public class HelloWorldController {
//
//	@GetMapping("/ola") //Cria o endPoint;
//	public String olaMundo(@RequestParam("name" /* Passando mascara para o parâmetro nome*/)String nome, 
//							String sobrenome, Integer idade) {
//		return "Hello World" + "\n" + "Meu nome: " + nome.toUpperCase() + "\n" 
//				+"Meu Sobrenome: "+sobrenome.toLowerCase() + "\n" 
//				+"Minha idade é " + idade + " anos";
//	}
//	
//	@GetMapping("/num") //Cria o endPoint;
//	public Integer numero() {
//		return 20;
//	}
//	@GetMapping("/bool") //Cria o endPoint;
//	public Boolean verdadeiroFalso() {
//		return true;
//	}
//}
