package br.gov.sp.fatec.springapplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produto_id")
    private Long id;

    @Column(name = "produto_nome")
    private String nome;

    @Column(name = "produto_preco")
    private Float preco;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "produtos")
    private Set<Cliente> clientes;

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

    //GET & SET PRECO
    public Float getPreco(){
        return this.preco;
    }
    public void setPreco(Float preco) {
        this.preco = preco;
    }

    // GET & SET:
    public Set<Cliente> getClientes(){
        return this.clientes;
    }
    public void setClientes(Set<Cliente> clientes){
        this.clientes = clientes;
    }
}
