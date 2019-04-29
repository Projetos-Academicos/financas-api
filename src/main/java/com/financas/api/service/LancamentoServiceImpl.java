package com.financas.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financas.api.dto.LancamentoDTO;
import com.financas.api.model.Lancamento;
import com.financas.api.repository.LancamentoRepository;

@Service
public class LancamentoServiceImpl implements LancamentoService{

	@Autowired
	private LancamentoRepository repository;

	@Override
	public void excluir(Long id) {
		this.repository.deleteById(id);
	}

	@Override
	public List<LancamentoDTO> listar() {
		List<Lancamento> lancamentos = this.repository.findAll();
		List<LancamentoDTO> lancamentosDTO = new ArrayList<LancamentoDTO>();

		for (Lancamento lancamento : lancamentos) {
			lancamentosDTO.add(lancamento.converterParaDTO());
		}

		return lancamentosDTO;
	}

	@Override
	public LancamentoDTO salvar(LancamentoDTO lancamentoDTO) {
		return this.repository.save(lancamentoDTO.converterParaObjeto()).converterParaDTO();
	}

	@Override
	public LancamentoDTO visualizar(Long id) {
		return this.repository.findById(id).get().converterParaDTO();
	}

}
