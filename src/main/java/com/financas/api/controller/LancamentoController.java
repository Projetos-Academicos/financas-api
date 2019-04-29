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

import com.financas.api.dto.LancamentoDTO;
import com.financas.api.service.LancamentoService;

@RestController
@CrossOrigin
@RequestMapping("/lancamentos")
public class LancamentoController {

	@Autowired
	private LancamentoService service;

	@PutMapping
	public LancamentoDTO editar(@Valid @RequestBody LancamentoDTO lancamento, @PathVariable Long id) {
		lancamento.setId(id);
		return this.service.salvar(lancamento);
	}

	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		this.service.excluir(id);
	}

	@GetMapping
	public List<LancamentoDTO> listar(){
		return this.service.listar();
	}

	@PostMapping
	public LancamentoDTO salvar(@Valid @RequestBody LancamentoDTO lancamento) {
		return this.service.salvar(lancamento);
	}

	@GetMapping("/{id}")
	public LancamentoDTO visualizar(@PathVariable Long id) {
		return this.service.visualizar(id);
	}

}
