package br.edu.infnet.produto.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.produto.dto.CotacaoDto;
import br.edu.infnet.produto.dto.ProdutoDto;
import br.edu.infnet.produto.feign.client.CotacaoClient;
import br.edu.infnet.produto.persistence.model.Produto;
import br.edu.infnet.produto.persistence.repository.ProdutoRepository;
import br.edu.infnet.produto.service.ProdutoService;
import feign.FeignException;

@Service
public class ProdutoServiceImpl implements ProdutoService{

	@Autowired
	private CotacaoClient client;
	
	@Autowired
	private ProdutoRepository repository;
	
	@Override
	public List<ProdutoDto> getAll() {
		return new ProdutoDto().fromEntity(repository.findAll());
	}

	@Override
	public ProdutoDto getById(Long id) {
		return new ProdutoDto().fromEntity(repository.findById(id).get());
	}
	
	@Override
	public List<ProdutoDto> getAllWithQuotes() {
		
		try {
			List<ProdutoDto> produtosWithQuotes = new ArrayList<>();
			List<Produto> produtos = repository.findAll();
			
			for(Produto produto : produtos) {
				List<CotacaoDto> quotes = client.getById(produto.getId());
				produtosWithQuotes.add(new ProdutoDto().fromEntity(produto, quotes));
			}
			
			return produtosWithQuotes;
		} catch (FeignException e) {
			throw new Error("ALGO DEU ERRADO");
		}
	}

	@Override
	public ProdutoDto getByIdWithQuotes(Long id) {
		
		try {
			
			List<CotacaoDto> cotacao = client.getById(id);
			
			return new ProdutoDto().fromEntity(repository.findById(id).get(), cotacao);
			
		} catch (FeignException e) {
			throw new Error("ALGO DEU ERRADO");
		}
	}

	@Override
	public ProdutoDto create(ProdutoDto produto) {
		return new ProdutoDto().fromEntity(
					repository.save(
							new ProdutoDto().fromModel(produto)));
	}

	@Override
	public ProdutoDto update(ProdutoDto produto) throws Exception {
		
		Optional<Produto> produtoEncontrado = repository.findById(produto.getId());
		
		if(produtoEncontrado.isPresent()) {
			return new ProdutoDto().fromEntity(
					repository.save(
							new ProdutoDto().fromModel(produto)));
		}
		else {
			throw new Exception("ID NAO ENCONTRADO");
		}
	}

	@Override
	public void delete(Long id) throws Exception {
		Optional<Produto> produtoEncontrado = repository.findById(id);
		
		if(produtoEncontrado.isPresent()) {
			repository.deleteById(id);
		}
		else {
			throw new Exception("ID NAO ENCONTRADO");
		}
		
	}
	
}
