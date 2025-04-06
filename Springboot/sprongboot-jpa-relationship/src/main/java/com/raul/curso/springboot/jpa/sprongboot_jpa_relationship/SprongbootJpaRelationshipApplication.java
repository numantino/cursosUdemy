package com.raul.curso.springboot.jpa.sprongboot_jpa_relationship;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.raul.curso.springboot.jpa.sprongboot_jpa_relationship.entities.Address;
import com.raul.curso.springboot.jpa.sprongboot_jpa_relationship.entities.Client;
import com.raul.curso.springboot.jpa.sprongboot_jpa_relationship.entities.Invoice;
import com.raul.curso.springboot.jpa.sprongboot_jpa_relationship.repositories.ClientRepository;
import com.raul.curso.springboot.jpa.sprongboot_jpa_relationship.repositories.InvoiceRepository;

@SpringBootApplication
public class SprongbootJpaRelationshipApplication implements CommandLineRunner{

	@Autowired
	private ClientRepository clienteRep;
	@Autowired
	private InvoiceRepository invoiceRep;

	public static void main(String[] args) {
		SpringApplication.run(SprongbootJpaRelationshipApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		oneToMeny();
	}

	@Transactional
	public void removeAddress(){
		oneToMeny();

		Optional<Client> opCliente = clienteRep.findById(3L);
		opCliente.ifPresent(c -> {
			c.getAddresses().remove(0);
			clienteRep.save(c);
		});

	}

	@Transactional
	public void oneToMeny(){
		Client cliente = new Client("Moras", "juan");
		Address a1= new Address("calle 1", 1);
		Address a2= new Address("calle nueva", 13);
		cliente.getAddresses().add(a1);
		cliente.getAddresses().add(a2);

		clienteRep.save(cliente);
		System.out.println("oneToMeny, cliente: " + cliente);
	}

	@Transactional
	public void manyToOne(){
		Client cliente = new Client("Raul", "Fermin");
		clienteRep.save(cliente);

		Invoice invoice1 = new Invoice("comora de oficina", 200L);
		invoice1.setClient(cliente);
		Invoice db = invoiceRep.save(invoice1);
		System.out.println("Dato nuevo: " + db);
	}

	@Transactional
	public void manyToOne2(){
		Optional<Client> opCliente = clienteRep.findById(1L);

		if(opCliente.isPresent()){
			Invoice invoice1 = new Invoice("comora de oficina", 200L);
			invoice1.setClient(opCliente.orElseThrow());
			Invoice db = invoiceRep.save(invoice1);
			System.out.println("Dato nuevo: " + db);
		}
	}
}
