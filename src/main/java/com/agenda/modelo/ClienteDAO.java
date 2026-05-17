package com.agenda;

import java.util.ArrayList;
import java.util.List;
// Dica: Você precisará importar o jakarta.persistence.*

public class ClienteDAO {

    // TODO 7: Criar a fábrica e o EntityManager aqui
    // EntityManagerFactory emf = Persistence.createEntityManagerFactory("agenda-sqlite");
    // EntityManager em = emf.createEntityManager();

    public void salvar(Cliente cliente) {
        // TODO 8: Abrir transação, persistir o cliente e commitar a transação.
        System.out.println("[ALERTA DAO] O método salvar() ainda não tem implementação real de banco de dados!");
    }

    public List<Cliente> listarTodos() {
        // TODO 9: Usar o EntityManager para fazer a busca JPQL: "FROM Cliente"
        return new ArrayList<>();
    }
}