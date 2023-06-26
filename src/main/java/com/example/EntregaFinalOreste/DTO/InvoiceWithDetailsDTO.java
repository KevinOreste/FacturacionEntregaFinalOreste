package com.example.EntregaFinalOreste.DTO;

import com.example.EntregaFinalOreste.Models.Client;

import java.util.List;

public class InvoiceWithDetailsDTO {

    private int invoice_id;
    private Client client_id;
    private String created_at;
    private double total;
    private List<InvoiceDetailsDTO> details;

    public InvoiceWithDetailsDTO(int invoice_id, Client client_id, String created_at, double total, List<InvoiceDetailsDTO> details) {
        this.client_id = client_id;
        this.invoice_id = invoice_id;
        this.created_at = created_at;
        this.total = total;
        this.details = details;
    }

    public Client getClient_id() {
        return client_id;
    }

    public void setClient_id(Client client_id) {
        this.client_id = client_id;
    }

    public int getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<InvoiceDetailsDTO> getDetails() {
        return details;
    }

    public void setDetails(List<InvoiceDetailsDTO> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "InvoiceWithDetailsDTO{" +
                "client_id=" + client_id +
                ", invoice_id=" + invoice_id +
                ", created_at='" + created_at + '\'' +
                ", total=" + total +
                ", details=" + details +
                '}';
    }
}
