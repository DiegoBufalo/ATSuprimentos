package br.edu.infnet.produto.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.edu.infnet.produto.enums.Categoria;
import br.edu.infnet.produto.persistence.model.Produto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProdutoDto {
	
	private Long id;
	
	private String nome;

	private String foto;

	private Categoria categoria;

	private List<CotacaoDto> cotacoes;
	
	public Produto fromModel(ProdutoDto model){
		var produto = new Produto();
		produto.setId(model.getId());
		produto.setNome(model.getNome());
		produto.setFoto(model.getFoto());
		produto.setCategoria(model.getCategoria());
		
		return produto;
	}
	
	public ProdutoDto fromEntity(Produto entity){
		var model = new ProdutoDto();
		model.setId(entity.getId());
		model.setNome(entity.getNome());
		model.setFoto(entity.getFoto());
		model.setCategoria(entity.getCategoria());
		
		return model;
	}
	
	public ProdutoDto fromEntity(Produto entity, List<CotacaoDto> cotacoes){
		var model = new ProdutoDto();
		model.setId(entity.getId());
		model.setNome(entity.getNome());
		model.setFoto(entity.getFoto());
		model.setCategoria(entity.getCategoria());
		model.setCotacoes(cotacoes);
		
		return model;
	}
	
	public List<ProdutoDto> fromEntity(List<Produto> entityList){
		List<ProdutoDto> list = new ArrayList<>();
		
		for(Produto entity : entityList) {
			var model = new ProdutoDto();
			model.setId(entity.getId());
			model.setNome(entity.getNome());
			model.setFoto(entity.getFoto());
			model.setCategoria(entity.getCategoria());
			
			list.add(model);
		}
		return list;
	}
	
	public List<ProdutoDto> fromEntity(List<Produto> entityList, List<CotacaoDto> cotacoes){
		List<ProdutoDto> list = new ArrayList<>();
		
		for(Produto entity : entityList) {
			var model = new ProdutoDto();
			model.setId(entity.getId());
			model.setNome(entity.getNome());
			model.setFoto(entity.getFoto());
			model.setCategoria(entity.getCategoria());
			model.setCotacoes(cotacoes);
			
			list.add(model);
		}
		return list;
	}
}
