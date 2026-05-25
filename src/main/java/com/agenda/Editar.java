package com.agenda;

import com.agenda.modelo.Cliente;
import com.agenda.modelo.ClienteDAO;
import com.agenda.modelo.Telefone;

public class Editar {
    public static void main(String[] args) {
        ClienteDAO dao = new ClienteDAO();

        Cliente cliente = new Cliente();

        cliente.setId(2L);
        cliente.setNome("Ana Beatriz");
        cliente.setEmail("ana_beatriz@email.com");

        Telefone tel1 = new Telefone("11", "912345678");
        cliente.adicionarTelefone(tel1);

        dao.editar(cliente);
    }
}
