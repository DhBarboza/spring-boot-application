package br.gov.sp.fatec.springapplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToAny;
import javax.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private Long id;

    @Column(name = "cliente_nome")
    private String nome;

    @Column(name = "cliente_matricula")
    private String matricula;

    @ManyToAny(fetch = FetchType.EAGER)
    @JoinTable(name = "compra",
        joinColumns = { @JoinColumn(name = "cliente_id")},
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
