package com.agenda.web.acao;

import com.agenda.dao.ClienteDAO;
import com.agenda.modelo.Cliente;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

public class ListarClientes implements AcaoWeb {

    @Override
    public String executar(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        ClienteDAO dao = new ClienteDAO();

        // Busca os clientes no Banco de Dados SQLite
        List<Cliente> clientes = dao.listarTodos();

        // Coloca a lista dentro da requisição para o JSP conseguir acessar
        req.setAttribute("listaClientes", clientes);

        return "listar.jsp";
    }
}