package br.gov.sp.fatec.springapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springapplication.entity.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Long>{
    
}
