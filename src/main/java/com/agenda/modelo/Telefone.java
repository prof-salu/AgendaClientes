package com.agenda.modelo;

import jakarta.persistence.*;

// TODO 4: Transformar em Entidade JPA (@Entity)
@Entity
public class Telefone {

    // TODO 5: Configurar Chave Primária (@Id e @GeneratedValue)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ddd;
    private String numero;

    // TODO 6: Configurar o lado N do relacionamento (@ManyToOne)
    // Dica: Adicione @JoinColumn(name="cliente_id")
    @ManyToOne
    @JoinColumn(name = "cliente_id")
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