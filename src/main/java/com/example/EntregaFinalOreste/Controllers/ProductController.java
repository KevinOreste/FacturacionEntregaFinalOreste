package com.example.EntregaFinalOreste.Controllers;


import com.example.EntregaFinalOreste.DTO.ProductDTO;
import com.example.EntregaFinalOreste.Middleware.ResponseHandler;
import com.example.EntregaFinalOreste.Models.Product;
import com.example.EntregaFinalOreste.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (path = "api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping (path = "/")
    public ResponseEntity<Object> createProduct (@RequestBody ProductDTO productDTO){
        try {
            Product data = productService.createProduct(productDTO);
            return ResponseHandler.generateResponse("Se creó el producto!", HttpStatus.OK, data);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping (path = "/")
    public ResponseEntity<Object> getProducts (){
        try {
            List<Product> data = productService.getProducts();
            return ResponseHandler.generateResponse("Se encontraron: " + data.size() + " producto/s!", HttpStatus.OK, data);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping (path = "/{id}")
    public ResponseEntity<Object> getProductById (@PathVariable int id){
        try {
            Product data = productService.getProductById(id);
            return ResponseHandler.generateResponse("Se encontró el producto!", HttpStatus.OK, data);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @DeleteMapping (path = "/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable int id){
        try{
            Product data = productService.deleteProduct(id);
            return ResponseHandler.generateResponse("Se deshabilitó el producto!", HttpStatus.OK, data);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @PutMapping (path = "/{id}")
    public ResponseEntity<Object> modifyProduct (@RequestBody ProductDTO productDTO, @PathVariable int id){
        try {
            Product data = productService.modifyProduct(productDTO, id);
            return ResponseHandler.generateResponse("Se modificó el producto!", HttpStatus.OK, data);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }



}
