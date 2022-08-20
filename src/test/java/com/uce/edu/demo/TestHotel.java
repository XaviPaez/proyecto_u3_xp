package com.uce.edu.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;

import com.uce.edu.demo.repository.HotelRepositoryImpl;
import com.uce.edu.demo.repository.modelo.Hotel;

@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)

public class TestHotel {

	@Autowired
	private HotelRepositoryImpl hotelRepositoryImpl;



	@Test
	public void testActualizarHotel() {
		
		Hotel hotel=new Hotel();
		
		hotel.setNombre("Tambo Real");
		hotel.setDireccion("Av. Patria");
		
		this.hotelRepositoryImpl.insertar(hotel);
		
		Hotel hotelActualizado=new Hotel();
		hotelActualizado.setNombre("Tambo Real 1");
		hotelActualizado.setDireccion("Av. Patria");
		hotelActualizado.setId(33);
		this.hotelRepositoryImpl.actualizar(hotelActualizado);
		
		Hotel hotel1=this.hotelRepositoryImpl.buscarPorNombre("Tambo Real 1");
		
		assertThat(hotel1.getNombre()).isEqualTo(hotelActualizado.getNombre());
		
		
	}
}
