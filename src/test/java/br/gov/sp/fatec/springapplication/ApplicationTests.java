package br.gov.sp.fatec.springapplication;

import static org.junit.jupiter.api.Assertions.*;

//import java.beans.Transient;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springapplication.entity.Vendedor;
import br.gov.sp.fatec.springapplication.repository.VendedorRepository;
import br.gov.sp.fatec.springapplication.entity.Cliente;
import br.gov.sp.fatec.springapplication.repository.ClienteRepository;

@SpringBootTest
@Transactional
@Rollback
class ApplicationTests {

	@Autowired
	private VendedorRepository vendedorRepo;
	
	@Autowired
	private ClienteRepository clienteRepo;

	@Test
	void contextLoads() {
	}

	@Test
	void testInsertVendedor() {
		Vendedor vendedor = new Vendedor();
		vendedor.setNome("Astoufo");
		vendedor.setMatricula("05_06@2022");
		vendedorRepo.save(vendedor);
		assertNotNull(vendedor.getId());
	}

	@Test
	void testInsertCliente() {
		Cliente cliente = new Cliente();
		cliente.setNome("Manarildo");
		cliente.setMatricula("06_06@2022");
		clienteRepo.save(cliente);
		assertNotNull(cliente.getId());
	}

	@Test
	void testClienteCompra() {
		Cliente cliente = new clienteRepo.findById(1L).get();
		assertNotNull(cliente.getId());
	}

}
