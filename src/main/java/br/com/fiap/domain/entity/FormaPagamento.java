package br.com.fiap.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_FORMA_PAGAMENTO", uniqueConstraints = {
        @UniqueConstraint(name = "UK_FORMA_PAGAMENTO_TP", columnNames = {"TP_FORMA_PAGAMENTO"})
})
public class FormaPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_FORMA_PAGAMENTO")
    @SequenceGenerator(name = "SQ_FORMA_PAGAMENTO", sequenceName = "SQ_FORMA_PAGAMENTO")
    @Column(name = "ID_FORMA_PAGAMENTO")
    private Long id;

    @Column(name = "TP_FORMA_PAGAMENTO", nullable = false)
    private String tipo;

    @Column(name = "DESC_FORMA_PAGAMENTO")
    private String descricao;

    public FormaPagamento() {
    }

    public FormaPagamento(Long id, String tipo, String descricao) {
        this.id = id;
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public FormaPagamento setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTipo() {
        return tipo;
    }

    public FormaPagamento setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public FormaPagamento setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }


    @Override
    public String toString() {
        return "FormaPagamento{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
