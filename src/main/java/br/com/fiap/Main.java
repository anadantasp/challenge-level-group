package br.com.fiap;

import br.com.fiap.domain.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        EntityManagerFactory factory = Persistence.createEntityManagerFactory("oracle");

        EntityManager manager = factory.createEntityManager();

        //cadastroDados(manager);

        buscarRequisicaoPorId(manager);


        //buscarTodasRequisições(manager);

        manager.close();
        factory.close();


    }

    private static void buscarTodasRequisições(EntityManager manager) {
        List<Requisicao> requisicoes = manager.createQuery("FROM Requisicao").getResultList();

        requisicoes.forEach(System.out::println);
    }

    private static void buscarRequisicaoPorId(EntityManager manager) {
        Long id = Long.valueOf(JOptionPane.showInputDialog("ID da Requisição: "));
        Requisicao requisicao = manager.find(Requisicao.class, id);
        System.out.println(requisicao);
    }

    private static void cadastroDados(EntityManager manager) {
        Empresa empresa = new Empresa(null, "Flor de Mim", "95586516000176", "04005060");
        Funcionario funcionario = new Funcionario(null, "Yasmim", "yasmim2@email.com.br", "senha123", empresa );

        Produto produto = new Produto(null, "Planner do Ano", "19x15");
        Estoque estoque = new Estoque(null, 150, 800, 150, empresa, produto);
        ItemPedido itemPedido = new ItemPedido(null, estoque);
        FormaPagamento formaPagamento = new FormaPagamento(null, "credito", "à vista");
        Requisicao requisicao = new Requisicao(null, LocalDate.now(), null, "Solicitado", null, formaPagamento);
        requisicao.addItem(itemPedido);

        manager.getTransaction().begin();
        manager.persist(funcionario);
        manager.persist(requisicao);
        manager.getTransaction().commit();
    }
}