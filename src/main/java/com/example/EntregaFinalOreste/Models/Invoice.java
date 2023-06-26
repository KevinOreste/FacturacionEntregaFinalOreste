package com.example.EntregaFinalOreste.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Client client;
    @OneToMany(mappedBy="invoice")
    private List<InvoiceDetail> invoiceDetails;
    private double total;
    private String created_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", client=" + client +
                ", total=" + total +
                ", created_at=" + created_at +
                '}';
    }
}
