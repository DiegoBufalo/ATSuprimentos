package br.edu.infnet.cotacao.persistence.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.cotacao.persistence.model.Cotacao;

@Repository
public interface CotacaoRepository extends JpaRepository<Cotacao, Long>{
	
	List<Cotacao> findByValidadeCotacaoGreaterThanEqual(LocalDate validadeCotacao);
	
	List<Cotacao> findByValidadeCotacaoLessThan(LocalDate validadeCotacao);
	
	List<Cotacao> findByIdProdutoOrderById(Long idProduto);
}
