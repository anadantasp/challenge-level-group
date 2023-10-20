package br.com.fiap.domain.entity;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "TB_REQUISICAO")
public class Requisicao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_REQUISICAO")
    @SequenceGenerator(name = "SQ_REQUISICAO", sequenceName = "SQ_REQUISICAO")
    @Column(name = "ID_REQUISICAO")
    private Long id;


    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "TB_REQUISICAO_ITENS_PEDIDO",
            joinColumns = {
                    @JoinColumn(
                            name = "REQUISICAO",
                            referencedColumnName = "ID_REQUISICAO",
                            foreignKey = @ForeignKey(name = "FK_REQUISICAO_ITEM_PEDIDO")
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "ITEM_PEDIDO",
                            referencedColumnName = "ID_ITEM_PEDIDO",
                            foreignKey = @ForeignKey(name = "FK_ITEM_PEDIDO_REQUISICAO")
                    )
            }
    )
    private Set<ItemPedido> itensPedido;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "ID_FORMA_PAGAMENTO",
            referencedColumnName = "ID_FORMA_PAGAMENTO",
            foreignKey = @ForeignKey(name = "TB_REQUISICAO_FK_FORMA_PAGAMENTO")
    )
    private FormaPagamento formaPagamento;

    public Requisicao() {
    }

    public Requisicao(Long id, Set<ItemPedido> itensPedido) {
        this.id = id;
        this.itensPedido = Objects.nonNull(itensPedido) ? itensPedido : new LinkedHashSet<>();
    }

    public Long getId() {
        return id;
    }

    public Requisicao setId(Long id) {
        this.id = id;
        return this;
    }

    public Set<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public Requisicao addItem(ItemPedido itemPedido) {
        itensPedido.add(itemPedido);
        return this;
    }

    public Requisicao removeItem(ItemPedido itemPedido) {
        itensPedido.remove(itemPedido);
        return this;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public Requisicao setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
        return this;
    }


    @Override
    public String toString() {
        return "Requisicao{" +
                "id=" + id +
                //", itensPedido=" + itensPedido +
                ", formaPagamento=" + formaPagamento +
                '}';
    }
}
