package br.edu.infnet.produto.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.produto.persistence.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
}
