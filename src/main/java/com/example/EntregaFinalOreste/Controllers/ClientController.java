package com.example.EntregaFinalOreste.Controllers;


import com.example.EntregaFinalOreste.DTO.ClientDTO;
import com.example.EntregaFinalOreste.Middleware.ResponseHandler;
import com.example.EntregaFinalOreste.Models.Client;
import com.example.EntregaFinalOreste.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping (path = "api/v1/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping (path = "/")
    public ResponseEntity<Object> createClient(@RequestBody ClientDTO client) {
        try {
            Client data = clientService.createClient(client);
            return ResponseHandler.generateResponse("Se creó el cliente!", HttpStatus.OK, data);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }

    }

    @DeleteMapping (path = "/{id}")
        public ResponseEntity<Object> deleteClient (@PathVariable int id){
        try{
            Client client = clientService.deleteClient(id);
            return ResponseHandler.generateResponse("Se deshabilitó el cliente!",
                    HttpStatus.OK,
                    client);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null);
        }

    }

    @GetMapping (path = "/{id}")
    public ResponseEntity<Object> getClientById (@PathVariable int id){
        try {
            Client data = clientService.getClientById(id);
            return ResponseHandler.generateResponse("Se encontró el cliente!", HttpStatus.OK, data);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @PutMapping (path = "/{id}")
    public ResponseEntity<Object> modifyClient(@RequestBody ClientDTO clientDTO, @PathVariable int id){
        try {
        Client data = clientService.modifyClient(clientDTO, id);
        return ResponseHandler.generateResponse("Se modificó el cliente!", HttpStatus.OK, data);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }

    }

}
