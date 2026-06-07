package com.agenda.web.acao;

import com.agenda.dao.ClienteDAO;
import com.agenda.modelo.Cliente;
import com.agenda.modelo.Telefone;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SalvarCliente implements AcaoWeb {

    @Override
    public String executar(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        // Lendo os dados digitados no formulário HTML
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String ddd = req.getParameter("ddd");
        String numero = req.getParameter("numero");

        // Montando o modelo orientado a objetos
        Cliente novoCliente = new Cliente(nome, email);
        if (ddd != null && !ddd.isEmpty() && numero != null && !numero.isEmpty()) {
            Telefone tel = new Telefone(ddd, numero);
            novoCliente.adicionarTelefone(tel); // Associa e mantém a relação 1xN
        }

        // Salvando no banco de dados
        ClienteDAO dao = new ClienteDAO();
        dao.salvar(novoCliente);

        // Após salvar, redireciona de volta para a tela inicial
        return "index.jsp";
    }
}
