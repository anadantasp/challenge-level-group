package br.com.fiap.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_PRODUTO")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PRODUTO_C")
    @SequenceGenerator(name = "SQ_PRODUTO_C", sequenceName = "SQ_PRODUTO_C")
    @Column(name = "ID_PRODUTO")
    private Long id;

    @Column(name = "NM_PRODUTO", nullable = false)
    private String nome;

    @Column(name = "TAMANHO_PRODUTO", nullable = false)
    private String tamanho;


    public Produto() {
    }

    public Produto(Long id, String nome, String tamanho) {
        this.id = id;
        this.nome = nome;
        this.tamanho = tamanho;
    }

    public Long getId() {
        return id;
    }

    public Produto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Produto setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getTamanho() {
        return tamanho;
    }

    public Produto setTamanho(String tamanho) {
        this.tamanho = tamanho;
        return this;
    }


    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tamanho='" + tamanho + '\'' +
                '}';
    }
}
