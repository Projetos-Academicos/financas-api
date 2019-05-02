package com.financas.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financas.api.model.Categoria;
import com.financas.api.repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	@Override
	public void excluir(Long id) {
		this.repository.deleteById(id);
	}

	@Override
	public List<Categoria> listar() {
		return this.repository.findAll();
	}

	@Override
	public Categoria salvar(Categoria categoria) {
		return this.repository.save(categoria);
	}

	@Override
	public Categoria visualizar(Long id) {
		return this.repository.findById(id).get();
	}

}
