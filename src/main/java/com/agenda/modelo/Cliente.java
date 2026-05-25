package com.agenda.modelo;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // 1. Indica que esta classe será uma tabela no banco de dados
public class Cliente {

    @Id // 2. Indica que este é o campo Chave Primária (Primary Key)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 3. Autoincremento (1, 2, 3...)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(unique = true)
    private String email;

    // 4. Mapeamento 1xN: Um cliente tem muitos telefones.
    // 'mappedBy' aponta para o nome do atributo lá na classe Telefone.
    // 'cascade' garante que, ao salvar o Cliente, os Telefones sejam salvos juntos.
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Telefone> telefones = new ArrayList<>();

    public Cliente() {
        // Construtor vazio exigido pelo JPA
    }

    public Cliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public void adicionarTelefone(Telefone telefone) {
        telefone.setCliente(this); // Mantém a relação bidirecional
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
