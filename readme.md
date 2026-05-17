# 📖 Agenda de Clientes (Módulo 9 - JPA e SQLite)

Bem-vindo(a) ao repositório oficial do **Módulo 9** da disciplina de Padrões de Projetos de Software.

## 📜 O Contexto (Sua Missão)

Você faz parte da equipe de engenharia responsável por criar o núcleo de uma nova Agenda de Clientes. O modelo de negócios exige que um `Cliente` possa ter múltiplos `Telefones` associados a ele. Esse é o clássico **Relacionamento 1xN (Um-para-Muitos)**.

As classes já foram desenhadas utilizando Orientação a Objetos pura, mas elas não estão conectadas a nenhum banco de dados.

A sua missão é transformar essa aplicação simples em uma arquitetura corporativa utilizando o framework **JPA (Java Persistence API)** em conjunto com o banco de dados **SQLite**, e isolar a comunicação com o banco utilizando o padrão **DAO**.

### 🎯 Laboratórios (O que você deve fazer):

1. **Anotações JPA:** Transformar as classes `Cliente` e `Telefone` em tabelas reais de banco de dados. Você precisará usar `@Entity`, `@Id`, `@GeneratedValue`.
2. **O Relacionamento 1xN:** Configurar a ligação entre as classes usando `@OneToMany` no Cliente e `@ManyToOne` no Telefone.
3. **Construir o DAO:** Implementar os métodos da classe `ClienteDAO` utilizando o `EntityManager` para salvar e buscar os dados.
4. **O Teste Final:** Rodar a classe `Main`, inserir um cliente e confirmar que o arquivo `agenda.sqlite` foi gerado com sucesso no seu projeto!

*Dica: As bibliotecas do Maven e as configurações de conexão (persistence.xml) já estão prontas. Foco no código Java!*
