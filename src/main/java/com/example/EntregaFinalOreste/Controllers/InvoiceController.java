package com.example.EntregaFinalOreste.Controllers;


import com.example.EntregaFinalOreste.DTO.ClientInvoicesDTO;
import com.example.EntregaFinalOreste.DTO.InvoiceDTO;
import com.example.EntregaFinalOreste.DTO.InvoiceWithDetailsDTO;
import com.example.EntregaFinalOreste.Middleware.ResponseHandler;
import com.example.EntregaFinalOreste.Models.InvoiceDetail;
import com.example.EntregaFinalOreste.Models.RequestInvoice;
import com.example.EntregaFinalOreste.Repository.InvoiceDetailRepository;
import com.example.EntregaFinalOreste.Services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (path = "api/v1/invoice")
public class InvoiceController {

    @Autowired
    public InvoiceService invoiceService;

    @Autowired
    public InvoiceDetailRepository invoiceDetailRepository;

    @PostMapping (path = "/")
    public ResponseEntity<Object> createInvoice (@RequestBody RequestInvoice requestInvoice) throws Exception {
        try {
            InvoiceDTO data = invoiceService.createInvoice(requestInvoice);
            return ResponseHandler.generateResponse(
                    "Invoice created succesful",
                    HttpStatus.OK,
                    data
            );
        }catch (Exception e){
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }

    @GetMapping (path = "invoiceId/{id}")
    public ResponseEntity<Object> getInvoiceById (@PathVariable int id){
        try {
            InvoiceWithDetailsDTO data = invoiceService.getInvoiceDetailsByInvoiceId(id);
            return ResponseHandler.generateResponse("Factura encontrada con exito!", HttpStatus.OK, data);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping (path = "clientId/{id}")
    public ResponseEntity<Object> getInvoiceByClientId (@PathVariable int id){

        try {
            ClientInvoicesDTO data = invoiceService.getInvoicesByClientId(id);
            return ResponseHandler.generateResponse("OK", HttpStatus.OK, data);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }

    }

}
