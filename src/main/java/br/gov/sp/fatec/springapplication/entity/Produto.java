package br.gov.sp.fatec.springapplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
}
