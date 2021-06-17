package br.edu.infnet.cotacao.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.cotacao.persistence.model.Cotacao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CotacaoDto {

	private Long id;

	private BigDecimal preco;

	private Long idProduto;

	private String fornecedor;
	
	private LocalDate dataCotacao;

	private LocalDate validadeCotacao;
	
	public Cotacao fromModel(CotacaoDto model, LocalDate date) {
		var entity = new Cotacao();
		
		entity.setId(model.getId());
		entity.setIdProduto(model.getIdProduto());
		entity.setFornecedor(model.getFornecedor());
		entity.setPreco(model.getPreco());
		entity.setValidadeCotacao(model.getValidadeCotacao());
		entity.setDataCotacao(date);
		
		return entity;
	}
	
	public Cotacao fromModel(CotacaoDto model) {
		var entity = new Cotacao();
		
		entity.setId(model.getId());
		entity.setIdProduto(model.getIdProduto());
		entity.setFornecedor(model.getFornecedor());
		entity.setPreco(model.getPreco());
		entity.setValidadeCotacao(model.getValidadeCotacao());
		entity.setDataCotacao(model.getDataCotacao());
		
		return entity;
	}
	
	public CotacaoDto fromEntity(Cotacao model) {
		var entity = new CotacaoDto();
		
		entity.setId(model.getId());
		entity.setIdProduto(model.getIdProduto());
		entity.setFornecedor(model.getFornecedor());
		entity.setPreco(model.getPreco());
		entity.setValidadeCotacao(model.getValidadeCotacao());
		entity.setDataCotacao(model.getDataCotacao());
		
		return entity;
	}
	
	public List<CotacaoDto> fromEntity(List<Cotacao> models) {
		List<CotacaoDto> list = new ArrayList<>();
		
		for(Cotacao model : models) {
			
			var entity = new CotacaoDto();
			entity.setId(model.getId());
			entity.setIdProduto(model.getIdProduto());
			entity.setFornecedor(model.getFornecedor());
			entity.setPreco(model.getPreco());
			entity.setValidadeCotacao(model.getValidadeCotacao());
			entity.setDataCotacao(model.getDataCotacao());
			
			list.add(entity);
		}
		return list;
	}
}
