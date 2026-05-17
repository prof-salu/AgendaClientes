package com.agenda;

import java.util.ArrayList;
import java.util.List;

// TODO 1: Transformar esta classe em uma Entidade JPA (@Entity)
public class Cliente {

    // TODO 2: Configurar a Chave Primária (@Id e @GeneratedValue)
    private Long id;
    private String nome;
    private String email;

    // TODO 3: Configurar o relacionamento 1xN (@OneToMany)
    // Dica: Use mappedBy="cliente", cascade=CascadeType.ALL
    private List<Telefone> telefones = new ArrayList<>();

    public Cliente() {
        // Construtor vazio obrigatório para o JPA
    }

    public Cliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    // Método utilitário para manter a consistência bidirecional
    public void adicionarTelefone(Telefone telefone) {
        telefone.setCliente(this);
        this.telefones.add(telefone);
    }

    // --- Getters e Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public List<Telefone> getTelefones() { return telefones; }
    public void setTelefones(List<Telefone> telefones) { this.telefones = telefones; }

    @Override
    public String toString() {
        return "Cliente [" + id + "] " + nome + " (" + email + ")";
    }
}