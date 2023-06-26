package com.example.EntregaFinalOreste.Models;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "client")
public class Client {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @OneToMany(mappedBy="client")
    private List<Invoice> invoiceList;
    private String name;
    private String lastName;
    private Integer document;
    private boolean enabled = true;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enable) {
        this.enabled = enable;
    }

    public Integer getDocument() {
        return document;
    }

    public void setDocument(Integer document) {
        this.document = document;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", document=" + document +
                ", enable=" + enabled+
                '}';
    }
}
