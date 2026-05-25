package com.agenda.modelo;

import jakarta.persistence.*;

@Entity // 1. Tabela de Telefones
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ddd;
    private String numero;

    // 2. Mapeamento Nx1: Muitos telefones pertencem a UM cliente.
    @ManyToOne
    @JoinColumn(name = "cliente_id") // 3. Cria a coluna de chave estrangeira no banco
    private Cliente cliente;

    public Telefone() {
    }

    public Telefone(String ddd, String numero) {
        this.ddd = ddd;
        this.numero = numero;
    }

    // --- Getters e Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDdd() { return ddd; }
    public void setDdd(String ddd) { this.ddd = ddd; }
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    @Override
    public String toString() {
        return "(" + ddd + ") " + numero;
    }
}
