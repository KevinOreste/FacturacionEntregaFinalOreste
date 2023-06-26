package com.example.EntregaFinalOreste.Models;

import java.util.List;

public class RequestInvoice {

    private int client_id;
    private List<RequestProductDetail> productDetailList;


    public RequestInvoice(int client_id, List<RequestProductDetail> productDetailList) {
        this.client_id = client_id;
        this.productDetailList = productDetailList;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public List<RequestProductDetail> getProductDetailList() {
        return productDetailList;
    }

    public void setProductDetailList(List<RequestProductDetail> productDetailList) {
        this.productDetailList = productDetailList;
    }

    @Override
    public String toString() {
        return "RequestInvoice{" +
                "client_id=" + client_id +
                ", productDetailList=" + productDetailList +
                '}';
    }
}
