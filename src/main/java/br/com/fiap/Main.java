package br.com.fiap;

import br.com.fiap.domain.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {


        EntityManagerFactory factory = Persistence.createEntityManagerFactory("oracle");

        EntityManager manager = factory.createEntityManager();

        cadastroDados(manager);

        //buscarInventarioPorId(manager);


        //buscarTodosBens(manager);

        manager.close();
        factory.close();


    }
/*
    private static void buscarTodosBens(EntityManager manager) {
        List<Bem> bens = manager.createQuery("FROM Bem").getResultList();

        bens.forEach(System.out::println);
    }

    private static void buscarInventarioPorId(EntityManager manager) {
        Long id = Long.valueOf(JOptionPane.showInputDialog("ID do inventário: "));
        Inventario inventario = manager.find(Inventario.class, id);
        System.out.println(inventario);
    }
*/
    private static void cadastroDados(EntityManager manager) {
        Empresa empresa = new Empresa(null, "Flor de Mim", "15683171000130", "04005060");
        Funcionario funcionario = new Funcionario(null, "Yasmim", "yasmim@email.com.br", "senha123", empresa );

        Produto produto = new Produto(null, "Planner do Ano", "19x15");
        Estoque estoque = new Estoque(null, 150, 800, 150, empresa, produto);
        ItemPedido itemPedido = new ItemPedido(null, estoque);
        FormaPagamento formaPagamento = new FormaPagamento(null, "debito", "à vista");
        Requisicao requisicao = new Requisicao(null, null);
        requisicao.addItem(itemPedido);
        requisicao.setFormaPagamento(formaPagamento);

        manager.getTransaction().begin();
        manager.persist(funcionario);
        manager.persist(requisicao);
        manager.getTransaction().commit();
    }
}