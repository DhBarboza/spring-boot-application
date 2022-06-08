package br.gov.sp.fatec.springapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springapplication.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}
