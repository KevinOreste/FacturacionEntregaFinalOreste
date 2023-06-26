package com.example.EntregaFinalOreste.Services;

import com.example.EntregaFinalOreste.DTO.ClientDTO;
import com.example.EntregaFinalOreste.Models.Client;
import com.example.EntregaFinalOreste.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    public Client createClient(ClientDTO clientDTO) throws Exception {
        if (clientDTO.getName().isBlank() || clientDTO.getLastName().isBlank() || clientDTO.getDocument() == null)
            throw new Exception("Hay campos vacios! Intenta nuevamente");
        if (clientRepository.findByDocument(clientDTO.getDocument()).isPresent())
            throw new Exception("Ya existe un cliente con el mismo documento!");
        Client client = new Client();
        client.setName(clientDTO.getName());
        client.setLastName(clientDTO.getLastName());
        client.setDocument(clientDTO.getDocument());
        return clientRepository.save(client);
    }


    public Client modifyClient(ClientDTO clientDTO, int id) throws Exception {
        if (clientDTO.getName().isBlank() || clientDTO.getLastName().isBlank() || clientDTO.getDocument() == null)
            throw new Exception("Hay campos vacios! Intenta nuevamente");
        Optional<Client> client = clientRepository.findById(id);
        if (client.isEmpty())
            throw new Exception("No se encontró el usuario!");
        client.get().setName(clientDTO.getName());
        client.get().setLastName(clientDTO.getLastName());
        return clientRepository.save(client.get());
    }

    public Client deleteClient(int id) throws Exception {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isEmpty())
            throw new Exception("No se encontró el usuario");
        if(!client.get().isEnable())
            throw new Exception("El usuario ya está deshabilitado");
        client.get().setEnable(false);
        return clientRepository.save(client.get());
    }

    public Client getClient(int id) throws Exception{
        Optional<Client> clientExist = clientRepository.findById(id);
        if (clientExist.isEmpty())
            throw new Exception("El cliente con id " + id + " no fue encontrado");
        if(!clientExist.get().isEnable())
            throw new Exception("El cliente con id " + id + " está deshabilitado");
            return clientExist.get();
    }

    public Client getClientById (int id) throws Exception{
        Optional<Client> client = clientRepository.findById(id);
        if(client.isEmpty())
            throw new Exception("El cliente con id " + id + " no fue encontrado");
        return client.get();
    }

}
