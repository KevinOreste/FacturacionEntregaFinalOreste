package com.example.EntregaFinalOreste.DTO;


import java.util.List;

public class ClientInvoicesDTO {

    private int clientId;
    private List<InvoiceDTO> invoiceDTOList;

    public ClientInvoicesDTO(int clientId, List<InvoiceDTO> invoiceDTOList) {
        this.clientId = clientId;
        this.invoiceDTOList = invoiceDTOList;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public List<InvoiceDTO> getInvoiceDTOList() {
        return invoiceDTOList;
    }

    public void setInvoiceDTOList(List<InvoiceDTO> invoiceDTOList) {
        this.invoiceDTOList = invoiceDTOList;
    }

    @Override
    public String toString() {
        return "ClientInvoicesDTO{" +
                "clientId=" + clientId +
                ", invoiceDTOList=" + invoiceDTOList +
                '}';
    }
}
