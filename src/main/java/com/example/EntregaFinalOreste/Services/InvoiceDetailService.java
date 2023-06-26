package com.example.EntregaFinalOreste.Services;

import com.example.EntregaFinalOreste.DTO.InvoiceDetailsDTO;
import com.example.EntregaFinalOreste.Models.InvoiceDetail;
import com.example.EntregaFinalOreste.Repository.InvoiceDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceDetailService {

    @Autowired
    private InvoiceDetailRepository invoiceDetailRepository;

    public InvoiceDetail newInvoiceDetail(InvoiceDetail newInvoice){
        return invoiceDetailRepository.save(newInvoice);
    }

    public List<InvoiceDetailsDTO> getInvoiceDetailsByInvoiceId (int invoiceId) {
        return invoiceDetailRepository.getInvoiceDetailsByInvoiceId(invoiceId);
    }

}
