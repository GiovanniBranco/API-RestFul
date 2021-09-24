package org.serratec.backend.padaria.controller;

import java.util.List;

import org.serratec.backend.padaria.model.Produto;
import org.serratec.backend.padaria.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/padaria/produto")
public class ProdutoController {

	@Autowired
	ProdutoService service;
	
	
	@GetMapping
	public ResponseEntity<List<Produto>> listarProdutos(){
		return new ResponseEntity<List<Produto>>(service.obterProdutos(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Produto> adicionarProduto(@RequestBody Produto produto) {
		return new ResponseEntity<Produto>(service.adicionar(produto), HttpStatus.CREATED);
	}
}
