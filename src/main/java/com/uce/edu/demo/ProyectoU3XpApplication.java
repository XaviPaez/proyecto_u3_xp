package com.uce.edu.demo;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Habitacion;
import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.service.IFacturaService;
import com.uce.edu.demo.service.IHotelService;
import com.uce.edu.demo.service.ITransferenciaService;

@SpringBootApplication
public class ProyectoU3XpApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(ProyectoU3XpApplication.class);

	@Autowired
	private IFacturaService facturaService;
	@Autowired
	private IHotelService hotelService;
	@Autowired
	private ITransferenciaService iTransferenciaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3XpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated metfod stub

	/*	LOG.info("RELACIONAMIENTO WHERE");
		List<Factura> listaFactura = this.facturaService.buscarFacturaJoinWhere(2);
		for (Factura f : listaFactura) {
			LOG.info("Factura: " + f.getNumero() + " " + f.getFecha());
		}

	
		LOG.info("JOIN FETCH");
		List<Hotel> listaHoteles3 = this.hotelService.buscarHotelFetchJoin("Familiar");
		for (Hotel h: listaHoteles3) {
			LOG.info("Hotel3: " + h.getNombre() + " " +h.getDireccion());
			for(Habitacion ha: h.getHabitaciones()) {
				LOG.info("Habitacion3: " +ha );
			}
}*/

		this.iTransferenciaService.realizarTransferencia("1234", "12134", new BigDecimal(10));
	
	}
	
}