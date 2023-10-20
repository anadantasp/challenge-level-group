package br.com.fiap.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_FUNCIONARIO", uniqueConstraints = {
        @UniqueConstraint(name = "UK_FUNCIONARIO_EMAIL", columnNames = {"EMAIL_FUNCIONARIO"})
})
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_FUNCIONARIO")
    @SequenceGenerator(name = "SQ_FUNCIONARIO", sequenceName = "SQ_FUNCIONARIO")
    @Column(name = "ID_FUNCIONARIO")
    private Long id;

    @Column(name = "NM_FUNCIONARIO", nullable = false)
    private String nome;

    @Column(name = "EMAIL_FUNCIONARIO", nullable = false)
    private String email;

    @Column(name = "SENHA_FUNCIONARIO", nullable = false)
    private String senha;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "ID_EMPRESA",
            referencedColumnName = "ID_EMPRESA",
            foreignKey = @ForeignKey(name = "TB_FUNCIONARIO_FK_EMPRESA")
    )
    private Empresa empresa;

    public Funcionario() {
    }

    public Funcionario(Long id, String nome, String email, String senha, Empresa empresa) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.empresa = empresa;
    }

    public Long getId() {
        return id;
    }

    public Funcionario setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Funcionario setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Funcionario setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getSenha() {
        return senha;
    }

    public Funcionario setSenha(String senha) {
        this.senha = senha;
        return this;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public Funcionario setEmpresa(Empresa empresa) {
        this.empresa = empresa;
        return this;
    }


    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", empresa=" + empresa +
                '}';
    }
}
