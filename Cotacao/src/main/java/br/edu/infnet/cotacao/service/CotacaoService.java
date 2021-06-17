package br.edu.infnet.cotacao.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.infnet.cotacao.dto.CotacaoDto;

@Service
public interface CotacaoService {

	public List<CotacaoDto> getAll();
	
	public List<CotacaoDto> getAllExpired();

	public List<CotacaoDto> getById(Long id);
	
	public CotacaoDto create(CotacaoDto cotacao);
	
	public CotacaoDto update(CotacaoDto cotacao) throws Exception;
	
	public void delete(Long id) throws Exception;

}
