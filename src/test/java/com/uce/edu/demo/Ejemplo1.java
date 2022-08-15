package com.uce.edu.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.uce.edu.demo.repository.modelo.CuentaBancaria;
import com.uce.edu.demo.service.ITransferenciaService;

@SpringBootTest
@Rollback(true)
@Transactional
class Ejemplo1 {

	//private static final Logger log =LoggerFactory.getLogger(ApplicationTests.class);
	
	@Autowired
	private ITransferenciaService transferenciaService;
	
	@Test
	void contextLoads() {	
		
		CuentaBancaria c3=this.transferenciaService.buscarPorNumero("3");
		
		
		assertEquals(new BigDecimal(200.55), c3.getSaldo());
		
	}
	
	@BeforeEach
	void datos() {
		
		CuentaBancaria c1=new CuentaBancaria();
		c1.setNumero("3");
		c1.setSaldo(new BigDecimal(300.55));
		c1.setTipo("ahorros");
		this.transferenciaService.insertarCuenta(c1);
		
		CuentaBancaria c2=new CuentaBancaria();
		c2.setNumero("4");
		c2.setSaldo(new BigDecimal(100));
		c2.setTipo("corriente");
		this.transferenciaService.insertarCuenta(c2);
		
		this.transferenciaService.realizarTransferencia("3", "4", new BigDecimal(100));
		
	}

}
