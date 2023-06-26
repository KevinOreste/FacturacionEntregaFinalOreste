package com.example.EntregaFinalOreste.Services;


import com.example.EntregaFinalOreste.DTO.ProductDTO;
import com.example.EntregaFinalOreste.Models.Product;
import com.example.EntregaFinalOreste.Models.RequestProductDetail;
import com.example.EntregaFinalOreste.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product createProduct (ProductDTO productDTO) throws Exception {
        if (productDTO.getCode().isBlank() || productDTO.getDescription().isBlank() ||
                productDTO.getStock() == null || productDTO.getPrice() == null || productDTO.getTitle().isBlank())
            throw new Exception("Hay campos vaciós!");
        if (productRepository.findByCode(productDTO.getCode()).isPresent())
            throw new Exception("Ya existe un producto con el mismo código");
        Product product = new Product();
        product.setTitle(productDTO.getTitle());
        product.setDescription(productDTO.getDescription());
        product.setCode(productDTO.getCode());
        product.setPrice(productDTO.getPrice());
        product.setStock(productDTO.getStock());
        return productRepository.save(product);
    }

    public List<Product> getProducts() throws Exception {
        List<Product> productList = productRepository.findAll();
        if (productList.isEmpty())
            throw new Exception("No se encontraron productos en la BD!");
        return productRepository.findAll();
    }

    public Product deleteProduct(int id) throws Exception {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty())
            throw new Exception("No se encontró el producto!");
        if (!product.get().isEnabled())
            throw new Exception("El producto ya se encuentra deshabilitado!");
        product.get().setEnabled(false);
        return productRepository.save(product.get());
    }

    public Product modifyProduct (ProductDTO productDTO, int id) throws Exception {
        if (productDTO.getCode().isBlank() || productDTO.getDescription().isBlank() ||
                productDTO.getStock() == null || productDTO.getPrice() == null || productDTO.getTitle().isBlank())
            throw new Exception("Hay campos vaciós!");
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty())
            throw new Exception("No se encontró el producto!");
        product.get().setTitle(productDTO.getTitle());
        product.get().setDescription(productDTO.getDescription());
        product.get().setStock(productDTO.getStock());
        product.get().setPrice(productDTO.getPrice());
        product.get().setCode(productDTO.getCode());
        return productRepository.save(product.get());
    }

    public List<Product> getProducstById(List<RequestProductDetail> productListId) throws Exception{

        List<Product> productList = new ArrayList<>();

        for(RequestProductDetail requestProductDetail:productListId){

            Optional<Product> productOptional = productRepository.findById(requestProductDetail.getProduct_id());

            if(productOptional.isEmpty())
                throw new Exception("El producto con id: " + requestProductDetail.getProduct_id() + " no existe");
            if (!productOptional.get().isEnabled())
                throw new Exception("El producto con id " + requestProductDetail.getProduct_id() + " no está habilitado");
            if ((productOptional.get().getStock()- requestProductDetail.getQuantity()) <= 0)
                throw new Exception("No quedó stock disponible para el producto con id " + requestProductDetail.getProduct_id());
            productList.add(productOptional.get());
            productOptional.get().setStock(productOptional.get().getStock() - requestProductDetail.getQuantity());
            productRepository.save(productOptional.get());
        }
        return productList;
    }

    public Product getProductById(int id) throws Exception{
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty())
            throw new Exception("El producto con id " + id + " no fue encontrado");
        return product.get();
    }

}
