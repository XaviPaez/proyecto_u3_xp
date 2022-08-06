package com.uce.edu.demo;

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

@SpringBootApplication
public class ProyectoU3XpApplication implements CommandLineRunner{

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
		

		LOG.info("RELACIONAMIENTO WHERE");
		List<Hotel> listaHoteles = this.hotelService.buscarHotelJoinWhere("Familiar");
		for (Hotel h : listaHoteles) {
			LOG.info("Hotel: " + h.getNombre() + " " +h.getDireccion());
		}
		
		LOG.info("INNER JOIN EAGER/LAZY");
		List<Hotel> listaHoteles2 = this.hotelService.buscarHotelInnerJoin("Familiar");
		for (Hotel h: listaHoteles2) {
			LOG.info("Hotel2: " + h.getNombre() + " " +h.getDireccion());
			for(Habitacion ha: h.getHabitaciones()) {
				LOG.info("Habitacion2: " +ha );
			}
			
		}
		
		LOG.info("JOIN FETCH");
		List<Hotel> listaHoteles3 = this.hotelService.buscarHotelFetchJoin("Familiar");
		for (Hotel h: listaHoteles3) {
			LOG.info("Hotel3: " + h.getNombre() + " " +h.getDireccion());
			for(Habitacion ha: h.getHabitaciones()) {
				LOG.info("Habitacion3: " +ha );
			}
			
		}
	}}