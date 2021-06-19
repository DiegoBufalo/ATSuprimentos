package br.edu.infnet.cotacao.service;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.infnet.cotacao.dto.CotacaoDto;

@Service
public interface WriteCsvResponse {

	public void writeCotacoes(PrintWriter writer, List<CotacaoDto> cotacoes);
	
	public void writeCotacoes(PrintWriter writer, CotacaoDto cotacao);
}
