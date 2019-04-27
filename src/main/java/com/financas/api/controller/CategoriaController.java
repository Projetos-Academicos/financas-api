package com.financas.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financas.api.model.Categoria;
import com.financas.api.service.CategoriaService;

@RestController
@CrossOrigin
@RequestMapping("/categorias")
public class CategoriaController {


	@Autowired
	private CategoriaService service;

	@PutMapping("/{id}")
	public Categoria editar(@Valid @RequestBody Categoria categoria, @PathVariable Long id) {
		categoria.setId(id);
		return this.service.salvar(categoria);
	}

	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		this.service.excluir(id);
	}

	@GetMapping
	public List<Categoria> listar(){
		return this.service.listar();
	}

	@PostMapping
	public Categoria salvar(@Valid @RequestBody Categoria categoria) {
		return this.service.salvar(categoria);
	}

	@GetMapping("/{id}")
	public Categoria visualizar(@PathVariable Long id) {
		return this.service.visualizar(id);
	}
}
