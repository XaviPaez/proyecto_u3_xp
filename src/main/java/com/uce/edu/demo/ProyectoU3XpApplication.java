package com.uce.edu.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Factura;
import com.uce.edu.demo.repository.modelo.Habitacion;
import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.service.IFacturaService;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU3XpApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(ProyectoU3XpApplication.class);
	@Autowired
	private IHotelService hotelService;
	@Autowired
	private IFacturaService facturaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3XpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated metfod stub

		List<Factura> lista = this.facturaService.buscarFacturaInnerJoin(2);
		for (Factura factura : lista) {
			LOG.info("Factura: " +  factura.getNumero() + " Fecha: " + factura.getFecha());
		}

		List<Factura> lista2 = this.facturaService.buscarInnerJoin();
		for (Factura factura : lista2) {
			LOG.info("Factura2: " + factura.getNumero() + " Fecha: " + factura.getFecha());
		}

		List<Factura> listaLeft = this.facturaService.buscarFacturaOuterJoinLeft(2);
		for (Factura factura : listaLeft) {
			LOG.info("Factura Left: " + factura.getNumero() + " Fecha: " + factura.getFecha());
		}
	
		List<Factura> listaRight = this.facturaService.buscarFacturaOuterJoinRight(2);
		for (Factura factura : listaRight) {
			LOG.info("Factura Right: " + factura.getNumero() + " Fecha: " + factura.getFecha());
		}


	}
}