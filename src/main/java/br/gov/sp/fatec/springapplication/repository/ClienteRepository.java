package br.gov.sp.fatec.springapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springapplication.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
}
