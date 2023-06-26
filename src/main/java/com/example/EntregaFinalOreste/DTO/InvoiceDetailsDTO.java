package com.example.EntregaFinalOreste.DTO;

public class InvoiceDetailsDTO {

    private String title;
    private String description;
    private String code;
    private double precio;
    private int cantidad;

    public InvoiceDetailsDTO(String title, String description, String code, double precio, int cantidad) {
        this.title = title;
        this.description = description;
        this.code = code;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "InvoiceDetailsDTO{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", code='" + code + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                '}';
    }
}
