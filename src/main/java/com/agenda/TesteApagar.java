package com.agenda;

import com.agenda.modelo.ClienteDAO;

public class TesteApagar {

    public static void main(String[] args) {
        ClienteDAO dao = new ClienteDAO();

        dao.apagar(1);
    }
}
