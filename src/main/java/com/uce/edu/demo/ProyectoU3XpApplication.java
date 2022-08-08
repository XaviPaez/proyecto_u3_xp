package com.uce.edu.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.DetalleFactura;
import com.uce.edu.demo.repository.modelo.Factura;
import com.uce.edu.demo.service.IFacturaService;

@SpringBootApplication
public class ProyectoU3XpApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(ProyectoU3XpApplication.class);

	@Autowired
	private IFacturaService facturaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3XpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated metfod stub

		LOG.info("RELACIONAMIENTO WHERE");
		List<Factura> listaFactura = this.facturaService.buscarFacturaJoinWhere(2);
		for (Factura f : listaFactura) {
			LOG.info("Factura: " + f.getNumero() + " " + f.getFecha());
		}

	
		LOG.info("JOIN FETCH");
		List<Factura> listaFactura3 = this.facturaService.buscarFacturaFetchJoin(2);
		for (Factura f : listaFactura3) {
			LOG.info("Factura: " + f.getNumero() + " " + f.getFecha());
			for (DetalleFactura  df: f.getDetalles()) {
				LOG.info("Detalle: " + df);
			}

		}
}
}