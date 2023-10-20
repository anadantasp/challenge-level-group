package br.com.fiap.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_EMPRESA", uniqueConstraints = {
        @UniqueConstraint(name = "UK_EMPRESA_CNPJ", columnNames = {"CNPJ_EMPRESA"})
})
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_EMPRESA")
    @SequenceGenerator(name = "SQ_EMPRESA", sequenceName = "SQ_EMPRESA")
    @Column(name = "ID_EMPRESA")
    private Long id;

    @Column(name = "NM_EMPRESA", nullable = false)
    private String nome;

    @Column(name = "CNPJ_EMPRESA", nullable = false)
    private String cnpj;

    @Column(name = "CEP_EMPRESA", nullable = false)
    private String cep;

    public Empresa() {
    }

    public Empresa(Long id, String nome, String cnpj, String cep) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.cep = cep;
    }

    public Long getId() {
        return id;
    }

    public Empresa setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Empresa setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Empresa setCnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public String getCep() {
        return cep;
    }

    public Empresa setCep(String cep) {
        this.cep = cep;
        return this;
    }


    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}
