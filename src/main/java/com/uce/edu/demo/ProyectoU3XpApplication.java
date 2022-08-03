package com.uce.edu.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU3XpApplication implements CommandLineRunner{

	private static final Logger LOG = LoggerFactory.getLogger(ProyectoU3XpApplication.class);
	@Autowired
	private IHotelService hotelService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3XpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		List<Hotel> listaHoteles = this.hotelService.buscarHotelInnerJoin("Familiar");
		for (Hotel h : listaHoteles) {
			LOG.info("Hotel: " + h.getNombre() + " " + h.getDireccion());
		}
		
		List<Hotel> listaHoteles2 = this.hotelService.buscarInnerJoin();
		for (Hotel h : listaHoteles2) {
			LOG.info("Hotel2: " + h.getNombre() + " " + h.getDireccion());
		}

		// LEFT
		List<Hotel> listaHotelesLeft = this.hotelService.buscarHotelOuterJoinLeft("Familiar");
		for (Hotel h : listaHotelesLeft) {
			LOG.info("Hotel: " + h.getNombre() + " " + h.getDireccion());
		}

		// LEFT
		List<Hotel> listaHotelesLeft2 = this.hotelService.buscarOuterJoinLeft();
		for (Hotel h : listaHotelesLeft2) {
			LOG.info("Hotel2: " + h.getNombre() + " " + h.getDireccion());
		}

		// RIGHT
		List<Hotel> listaHotelesRight = this.hotelService.buscarHotelOuterJoinRight("Familiar");
		for (Hotel h : listaHotelesRight) {
			LOG.info("Hotel: " + h.getNombre() + " " + h.getDireccion());
		}
		}
	

}
