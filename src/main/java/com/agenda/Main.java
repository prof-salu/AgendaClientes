package com.agenda;

import com.agenda.dao.ClienteDAO;
import com.agenda.modelo.Cliente;
import com.agenda.modelo.Telefone;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== AGENDA DE CLIENTES CORPORATIVA ===");

        // 1. Instanciamos o DAO (Isso já cria as tabelas automaticamente no SQLite)
        ClienteDAO dao = new ClienteDAO();

        // 2. Criamos os objetos
        Cliente cliente = new Cliente("Carlos Silva", "carlos.silva@email.com");

        Telefone celular = new Telefone("11", "99999-1111");
        Telefone comercial = new Telefone("11", "3333-0000");

        // 3. Estabelecemos a relação bidirecional (1 Cliente -> 2 Telefones)
        cliente.adicionarTelefone(celular);
        cliente.adicionarTelefone(comercial);

        // 4. Mandamos o DAO salvar (Devido ao Cascade, os telefones vão junto!)
        System.out.println("\nSalvando cliente no banco de dados...");
        dao.salvar(cliente);

        // 5. Buscamos do banco para confirmar
        System.out.println("\nBuscando clientes direto do arquivo SQLite...");
        List<Cliente> clientesNoBanco = dao.listarTodos();

        for (Cliente c : clientesNoBanco) {
            System.out.println(c);
            for (Telefone t : c.getTelefones()) {
                System.out.println("   -> " + t);
            }
        }

        System.out.println("\nSucesso! Pode fechar o programa. O arquivo 'agenda.db' guardou seus dados.");
    }
}
