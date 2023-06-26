package com.example.EntregaFinalOreste.Services;


import com.example.EntregaFinalOreste.DTO.ClientInvoicesDTO;
import com.example.EntregaFinalOreste.DTO.InvoiceDTO;
import com.example.EntregaFinalOreste.DTO.InvoiceDetailsDTO;
import com.example.EntregaFinalOreste.DTO.InvoiceWithDetailsDTO;
import com.example.EntregaFinalOreste.Models.*;
import com.example.EntregaFinalOreste.Repository.ClientRepository;
import com.example.EntregaFinalOreste.Repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientService clientService;

    @Autowired
    private ProductService productService;
    @Autowired
    private InvoiceDetailService invoiceDetailService;


    public InvoiceDTO createInvoice(RequestInvoice requestInvoice) throws Exception{

        Client clientExist = clientService.getClient(requestInvoice.getClient_id());

        List<Product> productList = productService.getProducstById(requestInvoice.getProductDetailList());

        double total = 0;
        int i = 0;

        for (Product product:productList) {

            total += product.getPrice() * requestInvoice.getProductDetailList().get(i).getQuantity();
            i++;

        }

        Invoice invoiceCreated = new Invoice();

        invoiceCreated.setCreated_at(new Date().toString());

        invoiceCreated.setClient(clientExist);

        invoiceCreated.setTotal(total);

        invoiceCreated = invoiceRepository.save(invoiceCreated);

        i = 0;

        for (Product productForDetail : productList){

            InvoiceDetail newInvoiceDetail = new InvoiceDetail();
            newInvoiceDetail.setPrecio(productForDetail.getPrice());
            newInvoiceDetail.setInvoice(invoiceCreated);
            newInvoiceDetail.setProduct(productForDetail);
            newInvoiceDetail.setCantidad(requestInvoice.getProductDetailList().get(i).getQuantity());
            invoiceDetailService.newInvoiceDetail(newInvoiceDetail);

            i++;

        }

        return new InvoiceDTO(invoiceCreated.getId(), invoiceCreated.getCreated_at(), invoiceCreated.getTotal());

    }

    public InvoiceWithDetailsDTO getInvoiceDetailsByInvoiceId (int id) throws Exception{

        Optional<Invoice> invoice = invoiceRepository.findById(id);
        if (invoice.isEmpty())
            throw new Exception("No se encontró la factura solicitada");

        List<InvoiceDetailsDTO> invoiceDetails = invoiceDetailService.getInvoiceDetailsByInvoiceId(id);

        return new InvoiceWithDetailsDTO(invoice.get().getId(), invoice.get().getClient(), invoice.get().getCreated_at(), invoice.get().getTotal(),invoiceDetails);

    }

    public ClientInvoicesDTO getInvoicesByClientId(int id) throws Exception{

        Client client = clientService.getClientById(id);

        List<InvoiceDTO> invoiceList = invoiceRepository.getInvoiceByClientId(client.getId());

        if (invoiceList.isEmpty())
        throw new Exception("El cliente no tiene facturas asociadas!");

        return new ClientInvoicesDTO(client.getId(), invoiceList);

    }

}
