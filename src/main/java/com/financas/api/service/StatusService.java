package com.financas.api.service;

import java.util.List;

import com.financas.api.model.Status;

public interface StatusService {

	public void excluir(Long id);

	public List<Status> listar();

	public Status salvar(Status status);

	public Status visualizar(Long id);
}
