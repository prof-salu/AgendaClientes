package com.agenda.web.acao;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface AcaoWeb {
    // Retorna o nome da página JSP que deve ser renderizada ao final
    String executar(HttpServletRequest req, HttpServletResponse resp) throws Exception;
}