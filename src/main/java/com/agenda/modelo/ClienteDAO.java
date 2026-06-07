package com.agenda.dao;

import com.agenda.modelo.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class ClienteDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    public ClienteDAO() {
        // 1. Inicializa o JPA usando o nome exato definido no persistence.xml
        this.emf = Persistence.createEntityManagerFactory("AgendaClientes");
        this.em = emf.createEntityManager();
    }

    public void salvar(Cliente cliente) {
        try {
            // 2. Inicia a transação, salva o objeto e consolida (commit)
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
            System.out.println("[DAO] Cliente salvo com sucesso no banco SQLite!");
        } catch (Exception e) {
            em.getTransaction().rollback(); // Se der erro, desfaz as alterações
            System.err.println("[DAO] Erro ao salvar cliente: " + e.getMessage());
        }
    }

    public List<Cliente> listarTodos() {
        // 3. Usa JPQL (Java Persistence Query Language) para buscar os dados.
        // Observe que usamos "Cliente" (nome da classe) e não o nome da tabela no SQL.
        return em.createQuery("FROM Cliente", Cliente.class).getResultList();
    }
}