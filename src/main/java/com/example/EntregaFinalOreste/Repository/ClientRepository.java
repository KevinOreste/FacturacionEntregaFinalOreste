package com.example.EntregaFinalOreste.Repository;

import com.example.EntregaFinalOreste.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Optional<Client> findByDocument(Integer document);

}
