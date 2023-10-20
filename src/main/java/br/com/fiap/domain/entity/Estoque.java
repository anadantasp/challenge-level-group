package br.com.fiap.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_ESTOQUE")
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ESTOQUE")
    @SequenceGenerator(name = "SQ_ESTOQUE", sequenceName = "SQ_ESTOQUE")
    @Column(name = "ID_ESTOQUE")
    private Long id;
    @Column(name = "QUANT_MIN_ESTOQUE")
    private int quantidadeMin;

    @Column(name = "QUANT_MAX_ESTOQUE")
    private int quantidadeMax;

    @Column(name = "QUANT_ATUAL_ESTOQUE")
    private int quantidadeAtual;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "ID_EMPRESA",
            referencedColumnName = "ID_EMPRESA",
            foreignKey = @ForeignKey(name = "TB_ESTOQUE_FK_EMPRESA")
    )
    Empresa empresa;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "ID_PRODUTO",
            referencedColumnName = "ID_PRODUTO",
            foreignKey = @ForeignKey(name = "TB_ESTOQUE_FK_PRODUTO")
    )
    Produto produto;

    public Estoque() {
    }

    public Estoque(Long id, int quantidadeMin, int quantidadeMax, int quantidadeAtual, Empresa empresa, Produto produto) {
        this.id = id;
        this.quantidadeMin = quantidadeMin;
        this.quantidadeMax = quantidadeMax;
        this.quantidadeAtual = quantidadeAtual;
        this.empresa = empresa;
        this.produto = produto;
    }

    public Long getId() {
        return id;
    }

    public Estoque setId(Long id) {
        this.id = id;
        return this;
    }

    public int getQuantidadeMin() {
        return quantidadeMin;
    }

    public Estoque setQuantidadeMin(int quantidadeMin) {
        this.quantidadeMin = quantidadeMin;
        return this;
    }

    public int getQuantidadeMax() {
        return quantidadeMax;
    }

    public Estoque setQuantidadeMax(int quantidadeMax) {
        this.quantidadeMax = quantidadeMax;
        return this;
    }

    public int getQuantidadeAtual() {
        return quantidadeAtual;
    }

    public Estoque setQuantidadeAtual(int quantidadeAtual) {
        this.quantidadeAtual = quantidadeAtual;
        return this;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public Estoque setEmpresa(Empresa empresa) {
        this.empresa = empresa;
        return this;
    }

    public Produto getProduto() {
        return produto;
    }

    public Estoque setProduto(Produto produto) {
        this.produto = produto;
        return this;
    }


    @Override
    public String toString() {
        return "Estoque{" +
                "id=" + id +
                ", quantidadeMin=" + quantidadeMin +
                ", quantidadeMax=" + quantidadeMax +
                ", quantidadeAtual=" + quantidadeAtual +
                ", empresa=" + empresa +
                ", produto=" + produto +
                '}';
    }
}
