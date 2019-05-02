package com.financas.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financas.api.dto.LancamentoDTO;
import com.financas.api.exception.GenericException;
import com.financas.api.model.Lancamento;
import com.financas.api.repository.LancamentoRepository;
import com.financas.api.utils.FinUtil;

@Service
public class LancamentoServiceImpl implements LancamentoService {

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
		LancamentoDTO lancamentoValido = new LancamentoDTO();

		try {

			lancamentoValido = this.validarLancamento(lancamentoDTO);
			return this.repository.save(lancamentoValido.converterParaObjeto()).converterParaDTO();

		} catch (GenericException e) {
			e.printStackTrace();
		}
		return lancamentoValido;
	}

	private LancamentoDTO validarLancamento(LancamentoDTO lancamento) throws GenericException {

		if (lancamento.isDespesa() && lancamento.isParcelado()) {
			if (!FinUtil.isValorInteiroValido(lancamento.getQntParcelas())
					|| FinUtil.isNullOrEmpty(lancamento.getVlrParcelas())) {
				throw new GenericException("Se o lançamento for parcelado, os campos: Quantidade de parcelas e Valor de cada parcela são obrigatórios.");
			}
		}

		if (lancamento.isDespesa() && !lancamento.isParcelado()) {
			lancamento.setQntParcelas(null);
			lancamento.setVlrParcelas(null);
		}

		if(!lancamento.isDespesa()) {
			lancamento.setParcelado(false);
		}

		return lancamento;
	}

	@Override
	public LancamentoDTO visualizar(Long id) {
		return this.repository.findById(id).get().converterParaDTO();
	}

}
