package com.agenda;

import com.agenda.modelo.Cliente;
import com.agenda.modelo.ClienteDAO;

import java.util.List;

public class MainSelect {
    public static void main(String[] args) {
        ClienteDAO dao = new ClienteDAO();
        List<Cliente> lista = dao.listarTodos();

        for(Cliente cliente : lista){
            System.out.println(cliente);
        }
    }
}
