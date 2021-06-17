package br.edu.infnet.produto.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.produto.dto.ProdutoDto;
import br.edu.infnet.produto.persistence.model.Produto;
import br.edu.infnet.produto.persistence.repository.ProdutoRepository;
import br.edu.infnet.produto.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService{

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
