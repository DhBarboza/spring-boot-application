package br.gov.sp.fatec.springapplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "vendedor")
public class Vendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vendedor_id")
    private Long id;

    @Column(name = "vendedor_nome")
    private String nome;

    @Column(name = "vendedor_matricula")
    private String matricula;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "compra",
        joinColumns = { @JoinColumn(name = "vendedor_id")},
        inverseJoinColumns = { @JoinColumn(name = "produto_id")}
        )
        
    private Set<Produto> produtos;

    // GET & SET ID:
    public Long getId(){
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    //GET & SET NOME
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    //GET & SET MATRICULA
    public String getMatricula(){
        return this.matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

     // GET & SET PRODUTOS
     public Set<Produto> getProdutos(){
        return this.produtos;
    }
    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }
}
