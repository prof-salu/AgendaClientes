package com.agenda.modelo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;
// Dica: Você precisará importar o jakarta.persistence.*

public class ClienteDAO {

    // TODO 7: Criar a fábrica e o EntityManager aqui
    private EntityManager em;
    private EntityManagerFactory emf;

    public ClienteDAO(){
        this.emf = Persistence.createEntityManagerFactory("AgendaClientes");
        this.em = emf.createEntityManager();
    }

    public void salvar(Cliente cliente) {
        // TODO 8: Abrir transação, persistir o cliente e commitar a transação.
        try{
            //Iniciando a transação
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            System.out.println("Error: " + e);
        }
    }

    public List<Cliente> listarTodos() {
        //CUIDADO*** --> Cliente fazz referencia ao nome da Classe Cliente.
        List<Cliente> lista = em.createQuery("FROM Cliente", Cliente.class).getResultList();
        return lista;
    }

    public void apagar(long id){
        try{
            em.getTransaction().begin();
            Cliente cliente = em.find(Cliente.class, id);

            if(cliente != null){
                em.remove(cliente);
                em.getTransaction().commit();
                System.out.println("Cliente removido com sucesso.");
            }else{
                System.out.println("Cliente não encontrado.");
                em.getTransaction().rollback();
            }
        }catch (Exception e){
            em.getTransaction().rollback();
            System.out.println("Error: " + e);
        }
    }

    public void editar(Cliente cliente){
        try{
            em.getTransaction().begin();
            em.merge(cliente);
            em.getTransaction().commit();
            System.out.println("Cliente alterado com sucesso!");
        }catch (Exception e){
            em.getTransaction().rollback();
            System.out.println("Error: " + e);
        }
    }
}