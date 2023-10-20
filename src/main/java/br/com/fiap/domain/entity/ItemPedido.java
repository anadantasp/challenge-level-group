package br.com.fiap.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_ITEM_PEDIDO")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ITEM_PEDIDO")
    @SequenceGenerator(name = "SQ_ITEM_PEDIDO", sequenceName = "SQ_ITEM_PEDIDO")
    @Column(name = "ID_ITEM_PEDIDO")
    private Long id;

    @Column(name = "QAUNT_ITEM_PEDIDO")
    private int quantidade;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "ID_ESTOQUE",
            referencedColumnName = "ID_ESTOQUE",
            foreignKey = @ForeignKey(name = "TB_ITEM_PEDIDO_FK_ESTOQUE")
    )
    private Estoque estoque;

    public ItemPedido() {
    }

    public ItemPedido(Long id, Estoque estoque) {
        this.id = id;
        this.quantidade = setQuantidade(estoque).getQuantidade();
        this.estoque = estoque;
    }

    public Long getId() {
        return id;
    }

    public ItemPedido setId(Long id) {
        this.id = id;
        return this;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public ItemPedido setQuantidade(Estoque estoque) {
        this.quantidade = estoque.getQuantidadeMax() - estoque.getQuantidadeMin();
        return this;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public ItemPedido setEstoque(Estoque estoque) {
        this.estoque = estoque;
        return this;
    }


    @Override
    public String toString() {
        return "ItemPedido{" +
                "id=" + id +
                ", quantidade=" + quantidade +
                ", estoque=" + estoque +
                '}';
    }
}
