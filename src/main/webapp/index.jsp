<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Agenda Web - Novo Cliente</title>
    <style> body { font-family: Arial; padding: 20px; } </style>
</head>
<body>
    <h2>Cadastrar Novo Cliente</h2>

    <!-- O formulário aponta para o Front Controller (/app) e informa a ação -->
    <form action="app" method="POST">
        <input type="hidden" name="acao" value="SalvarCliente">

        <fieldset>
            <legend>Dados Pessoais</legend>
            <label>Nome:</label> <input type="text" name="nome" required><br><br>
            <label>Email:</label> <input type="email" name="email" required>
        </fieldset>
        <br>
        <fieldset>
            <legend>Telefone Principal</legend>
            <label>DDD:</label> <input type="text" name="ddd" size="2">
            <label>Número:</label> <input type="text" name="numero">
        </fieldset>
        <br>
        <button type="submit">Salvar no Banco de Dados</button>
    </form>

    <hr>
    <h3><a href="app?acao=ListarClientes">Ver Agenda Completa</a></h3>
</body>
</html>