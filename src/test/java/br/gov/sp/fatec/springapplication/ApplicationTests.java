package br.gov.sp.fatec.springapplication;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springapplication.entity.Vendedor;
import br.gov.sp.fatec.springapplication.repository.VendedorRepository;

@SpringBootTest
@Transactional
@Rollback
class ApplicationTests {

	@Autowired
	private VendedorRepository vendedorRepo;

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

}
