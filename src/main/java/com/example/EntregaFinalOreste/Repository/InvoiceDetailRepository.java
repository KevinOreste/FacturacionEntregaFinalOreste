package com.example.EntregaFinalOreste.Repository;

import com.example.EntregaFinalOreste.DTO.InvoiceDetailsDTO;
import com.example.EntregaFinalOreste.Models.InvoiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail, Integer> {

    @Query("SELECT new com.example.EntregaFinalOreste.DTO.InvoiceDetailsDTO(" +
    "p.title, " +
    "p.description, " +
    "p.code, " +
    "d.precio, " +
    "d.cantidad" +
    ") FROM Invoice i JOIN i.invoiceDetails d JOIN d.product p WHERE i.id = :id")
    List<InvoiceDetailsDTO> getInvoiceDetailsByInvoiceId(@Param("id") int invoiceId);
    List<InvoiceDetail> findByInvoiceId(Integer id);

}
