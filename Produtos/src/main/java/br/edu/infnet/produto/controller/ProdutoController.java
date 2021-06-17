package br.edu.infnet.produto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.produto.dto.ProdutoDto;
import br.edu.infnet.produto.service.ProdutoService;

@RestController
@RequestMapping("produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;
	
	@GetMapping("/listar")
	@ResponseStatus(value = HttpStatus.OK)
	public List<ProdutoDto> getAll(){
		return service.getAll();	
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public ProdutoDto getById(@PathVariable Long id) {
		return service.getById(id);
	}
	
	@PostMapping("/criar")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ProdutoDto create(@RequestBody ProdutoDto produto) {
		return service.create(produto);
	}
	
	@PutMapping("/atualizar")
	@ResponseStatus(value = HttpStatus.OK)
	public ProdutoDto update(@RequestBody ProdutoDto produto) throws Exception {
		return service.update(produto);
	}
	
	@DeleteMapping("/{id}/excluir")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) throws Exception {
		service.delete(id);
	}

}
