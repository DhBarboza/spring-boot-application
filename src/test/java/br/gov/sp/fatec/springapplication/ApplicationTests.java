package br.gov.sp.fatec.springapplication;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

//import java.beans.Transient;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.springapplication.entity.Vendedor;
import br.gov.sp.fatec.springapplication.repository.VendedorRepository;
import br.gov.sp.fatec.springapplication.entity.Cliente;
import br.gov.sp.fatec.springapplication.entity.Produto;
import br.gov.sp.fatec.springapplication.repository.ClienteRepository;
import br.gov.sp.fatec.springapplication.repository.ProdutoRepository;

@SpringBootTest
@Transactional
@Rollback
class ApplicationTests {

	@Autowired
	private VendedorRepository vendedorRepo;
	
	@Autowired
	private ClienteRepository clienteRepo;
	
	@Autowired
	private ProdutoRepository produtoRepo;

	@Test
	void contextLoads() {
	}

	@Test
	void testInsertVendedor() {
		Vendedor vendedor = new Vendedor();
		vendedor.setNome("Astoufo");
		vendedor.setMatricula("05_06@2022");
		vendedor.setProdutos(new HashSet<Produto>());
		Produto produto = new Produto();
		produto.setNome("iPhone");
		produtoRepo.save(produto);
		vendedor.getProdutos().add(produto);
		vendedorRepo.save(vendedor);
		assertNotNull(vendedor.getProdutos().iterator().next().getId());
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
	void testVendedorCompra() {
		Vendedor vendedor = vendedorRepo.findById(1L).get();
		assertEquals("Astoufo", vendedor.getProdutos().iterator().next().getNome());
	}
	
	@Test
	void testProduto() {
		Produto produto = produtoRepo.findById(1L).get();
		assertEquals("Astoufo", produto.getClientes().iterator().next().getNome());
	}

	@Test
	void testSelectVendedorNomeContains() {
		List<Vendedor> vendedores = vendedorRepo.findByNomeContainsIgnoreCase("oufo")
		assertFalse(vendedores.isEmpyt());
	}

	@Test
	void testSelectVendedorNome() {
		Vendedor vendedor = vendedorRepo.findByNome("Astoufo")
		assertNotNull(vendedor);
	}
}
