<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.agenda.modelo.Cliente" %>
<%@ page import="com.agenda.modelo.Telefone" %>
<html>
<head>
    <title>Agenda Web - Lista de Clientes</title>
    <style>
        body { font-family: Arial; padding: 20px; }
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid black; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
    <h2>Meus Clientes</h2>
    <a href="index.jsp">⬅ Voltar para o Cadastro</a><br><br>

    <table>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Email</th>
            <th>Telefones</th>
        </tr>

        <%-- Lendo a lista que o Controller injetou no Request --%>
        <%
            List<Cliente> clientes = (List<Cliente>) request.getAttribute("listaClientes");
            if(clientes != null && !clientes.isEmpty()) {
                for(Cliente c : clientes) {
        %>
        <tr>
            <td><%= c.getId() %></td>
            <td><%= c.getNome() %></td>
            <td><%= c.getEmail() %></td>
            <td>
                <%-- Iterando sobre a relação 1xN (Telefones do Cliente) --%>
                <% for(Telefone t : c.getTelefones()) { %>
                    <%= t.toString() %><br>
                <% } %>
            </td>
        </tr>
        <%
                }
            } else {
        %>
            <tr><td colspan="4">Nenhum cliente cadastrado no momento.</td></tr>
        <%  } %>
    </table>
</body>
</html>