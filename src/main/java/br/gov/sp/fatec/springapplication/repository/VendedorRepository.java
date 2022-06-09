package br.gov.sp.fatec.springapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springapplication.entity.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Long>{

    public List<Vendedor> findByNomeContainsIgnoreCase(String nome);

    public List<Vendedor> findByNomeOrMatricula(String nome, String matricula);

    public List<Vendedor> findByMatriculaContainsIgnoreCase(String matricula);

    public Vendedor findByNome(String nome);

    @Query("select v from Vendedor v where v.nome = %1")

    public Vendedor findByMatricula(String matricula);

    public List<Vendedor> findByProdutosNome(String produto);

}
