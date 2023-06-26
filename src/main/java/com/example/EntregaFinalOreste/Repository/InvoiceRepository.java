package com.example.EntregaFinalOreste.Repository;

import com.example.EntregaFinalOreste.DTO.InvoiceDTO;
import com.example.EntregaFinalOreste.Models.Client;
import com.example.EntregaFinalOreste.Models.Invoice;
import com.example.EntregaFinalOreste.Models.Product;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

    @Query("SELECT new com.example.EntregaFinalOreste.DTO.InvoiceDTO(" +
            "i.id, " +
            "i.created_at, " +
            "i.total " +
            ") FROM Client c JOIN c.invoiceList i WHERE c.id = :id")
  List<InvoiceDTO> getInvoiceByClientId (@Param("id") int clientId);

}
