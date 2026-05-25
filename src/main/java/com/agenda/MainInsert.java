package com.agenda;

import com.agenda.modelo.Cliente;
import com.agenda.modelo.ClienteDAO;
import com.agenda.modelo.Telefone;

public class MainInsert {
    public static void main(String[] args) {
        System.out.println("*** Agenda de Clientes ***");

        ClienteDAO dao = new ClienteDAO();
        Cliente c1 = new Cliente("Ana", "ana@email.com");

        Telefone tel1 = new Telefone("21", "987654321");
        Telefone tel2 = new Telefone("21", "22219896");

        //c1.adicionarTelefone(tel1);
        //c1.adicionarTelefone(tel2);

        System.out.println("Salvando o cliente no banco de dados.");
        dao.salvar(c1);

    }
}
