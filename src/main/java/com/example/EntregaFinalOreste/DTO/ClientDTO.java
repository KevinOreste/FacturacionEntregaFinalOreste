package com.example.EntregaFinalOreste.DTO;

public class ClientDTO {
    private String name;
    private String lastName;
    private Integer document;

    public Integer getDocument() {
        return document;
    }

    public void setDocument(Integer document) {
        this.document = document;
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
        return "ClientDTO{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", document=" + document +
                '}';
    }
}
