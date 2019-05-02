package com.financas.api.service;

import java.util.List;

import com.financas.api.model.Categoria;

public interface CategoriaService {

	public void excluir(Long id);

	public List<Categoria> listar();

	public Categoria salvar(Categoria categoria);

	public Categoria visualizar(Long id);
}
