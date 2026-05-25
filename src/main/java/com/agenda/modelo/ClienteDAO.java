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
        // 1. Inicializa o JPA usando o nome exato definido no persistence.xml
        this.emf = Persistence.createEntityManagerFactory("AgendaClientes");
        this.em = emf.createEntityManager();
    }

    public void salvar(Cliente cliente) {
        try{
            // 2. Inicia a transação, salva o objeto e consolida (commit)
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
            System.out.println("[DAO] Cliente salvo com sucesso no banco SQLite!");
        }catch(Exception e){
            em.getTransaction().rollback();
            System.err.println("[DAO] Erro ao salvar cliente: " + e.getMessage());
        }
    }

    public List<Cliente> listarTodos() {
        // 3. Usa JPQL (Java Persistence Query Language) para buscar os dados.
        // Observe que usamos "Cliente" (nome da classe) e não o nome da tabela no SQL.
        List<Cliente> lista = em.createQuery("FROM Cliente", Cliente.class).getResultList();
        return lista;
    }

    public void apagar(long id){
        try{
            /*
                No JPA, não é possível remover um objeto diretamente passando apenas uma instância nova com o ID. O ciclo de vida do JPA exige que o objeto seja colocado 
                no estado Gerenciado (Managed) primeiro. Por isso, precisamos do em.find() e, caso exista, chama-se o em.remove().

                Como o relacionamento mapeado na classe Cliente possui a configuração de cascata, ao apagar um cliente, todos os telefones vinculados a ele serão automaticamente 
                removidos do banco de dados SQLite pelo próprio Hibernate, mantendo a integridade referencial.
            */
            em.getTransaction().begin();
            Cliente cliente = em.find(Cliente.class, id);
            if (cliente != null) {
                em.remove(cliente);
                em.getTransaction().commit();
                System.out.println("[DAO] Cliente removido com sucesso!");
            } else {
                System.out.println("[DAO] Cliente não encontrado.");
                em.getTransaction().rollback();
            }
        }catch (Exception e){
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("[DAO] Erro ao apagar cliente: " + e.getMessage());
        }
    }

    public void editar(Cliente cliente){
        try{
            /*
                Quando passamos um objeto Cliente que já possui um id preenchido, o Hibernate detecta que ele já existe no banco de dados e executa um comando SQL UPDATE em vez de um INSERT.
            */
            em.getTransaction().begin();
            em.merge(cliente);
            em.getTransaction().commit();
            System.out.println("[DAO] Cliente atualizado com sucesso!");
        }catch (Exception e){
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("[DAO] Erro ao editar cliente: " + e.getMessage());
        }
    }
}
