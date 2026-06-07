package com.agenda.web;

import com.agenda.web.acao.AcaoWeb;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// A anotação abaixo transforma esta classe no Front Controller (Recebe TUDO de /app)
@WebServlet("/app")
public class SistemaController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 1. Descobre qual ação o usuário clicou (ex: acao=ListarClientes)
        String parametroAcao = req.getParameter("acao");

        // Caminho completo do pacote onde as ações estão guardadas
        String nomeDaClasse = "com.agenda.web.acao." + parametroAcao;

        try {
            // 2. Instancia a classe dinamicamente usando a API de Reflection do Java
            Class<?> classe = Class.forName(nomeDaClasse);
            AcaoWeb acao = (AcaoWeb) classe.getDeclaredConstructor().newInstance();

            // 3. Executa a regra de negócio e descobre para qual página o usuário deve ir
            String paginaJSP = acao.executar(req, resp);

            // 4. Despacha (Forward) o usuário para a tela HTML/JSP correta
            req.getRequestDispatcher(paginaJSP).forward(req, resp);

        } catch (Exception e) {
            throw new ServletException("Erro grave no Front Controller ao processar a ação.", e);
        }
    }
}