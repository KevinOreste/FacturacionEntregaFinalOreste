package com.example.EntregaFinalOreste;

import com.example.EntregaFinalOreste.Models.Client;
import com.example.EntregaFinalOreste.Models.Product;
import com.example.EntregaFinalOreste.Repository.ClientRepository;
import com.example.EntregaFinalOreste.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FacturacionSegundaEntregaOresteApplication implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(FacturacionSegundaEntregaOresteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Server listening on. http://localhost:8888/h2-console");

		//Clientes
		Client client1 = new Client();
		client1.setName("Kevin");
		client1.setLastName("Oreste");
		client1.setDocument(43103878);
		this.clientRepository.save(client1);

		Client client2 = new Client();
		client2.setName("Cristian");
		client2.setLastName("Oreste");
		client2.setDocument(41236457);
		this.clientRepository.save(client2);

		Client client3 = new Client();
		client3.setName("Yaniuska");
		client3.setLastName("Avila");
		client3.setDocument(93714730);
		this.clientRepository.save(client3);

		Client client4 = new Client();
		client4.setName("Iara");
		client4.setLastName("De Vita");
		client4.setDocument(45605486);
		this.clientRepository.save(client4);

		//Productos

		Product product1 = new Product();
		product1.setTitle("Remera");
		product1.setDescription("Remera manga corta, modelo liso");
		product1.setCode("FKOSL45");
		product1.setPrice(4500);
		product1.setStock(50);
		this.productRepository.save(product1);

		Product product2 = new Product();
		product2.setTitle("Remera");
		product2.setDescription("Remera manga larga, modelo con dibujos");
		product2.setCode("HEFD165");
		product2.setPrice(7000);
		product2.setStock(30);
		this.productRepository.save(product2);

		Product product3 = new Product();
		product3.setTitle("Buzo");
		product3.setDescription("Buzo oversize liso");
		product3.setCode("POWQD4583");
		product3.setPrice(4500);
		product3.setStock(50);
		this.productRepository.save(product3);

		Product product4 = new Product();
		product4.setTitle("Medias");
		product4.setDescription("Medias largas con diseño");
		product4.setCode("CXXX569");
		product4.setPrice(300);
		product4.setStock(100);
		this.productRepository.save(product4);

		Product product5 = new Product();
		product5.setTitle("Campera");
		product5.setDescription("Campera polar con plumas");
		product5.setCode("SSS895A");
		product5.setPrice(20000);
		product5.setStock(25);
		this.productRepository.save(product5);

	}
}
