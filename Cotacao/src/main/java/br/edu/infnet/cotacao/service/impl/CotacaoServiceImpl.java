package br.edu.infnet.cotacao.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.cotacao.dto.CotacaoDto;
import br.edu.infnet.cotacao.dto.ProdutoDto;
import br.edu.infnet.cotacao.feign.client.ProdutoClient;
import br.edu.infnet.cotacao.persistence.model.Cotacao;
import br.edu.infnet.cotacao.persistence.repository.CotacaoRepository;
import br.edu.infnet.cotacao.service.CotacaoService;
import feign.FeignException;

@Service
public class CotacaoServiceImpl implements CotacaoService {

	@Autowired
	private ProdutoClient client;
	
	@Autowired
	private CotacaoRepository repository;
	
	@Override
	public List<CotacaoDto> getAll() {
		return new CotacaoDto().fromEntity(
				repository.findByValidadeCotacaoGreaterThanEqual(LocalDate.now()));
	}
	
	@Override
	public List<CotacaoDto> getAllExpired() {
		return new CotacaoDto().fromEntity(
				repository.findByValidadeCotacaoLessThan(LocalDate.now()));
	}

	@Override
	public List<CotacaoDto> getById(Long id) {
		return new CotacaoDto().fromEntity(repository.findByIdProdutoOrderById(id));
	}

	@Override
	public CotacaoDto create(CotacaoDto cotacao) throws Exception {
		
		try {
			ProdutoDto produto = client.getById(cotacao.getIdProduto());
			
			if(produto != null)
				return new CotacaoDto().fromEntity(
						repository.save(new CotacaoDto().fromModel(cotacao, LocalDate.now())));
			else
				return null;
		} catch (FeignException e) {
			throw new Error("NAO EXISTE PRODUTO COM ID INFORMADO", e);
		}
	}

	@Override
	public CotacaoDto update(CotacaoDto cotacao) throws Exception {
		
		Optional<Cotacao> cotacaoEncontrada = repository.findById(cotacao.getId());
		
		if(cotacaoEncontrada.isPresent()) {
			return new CotacaoDto().fromEntity(
						repository.save(new CotacaoDto().fromModel(cotacao)));
		}else {
			throw new Exception("ID NAO ENCONTRADO");
		}
	}

	@Override
	public void delete(Long id) throws Exception {
		Optional<Cotacao> cotacaoEncontrada = repository.findById(id);
		
		if(cotacaoEncontrada.isPresent()) {
			repository.deleteById(id);
		}else {
			throw new Exception("ID NAO ENCONTRADO");
		}
		
	}

}
