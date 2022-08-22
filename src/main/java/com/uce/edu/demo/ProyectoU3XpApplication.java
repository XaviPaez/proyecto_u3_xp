package com.uce.edu.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Ciudadano;
import com.uce.edu.demo.repository.modelo.Cliente;
import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.service.ICiudadanoService;
import com.uce.edu.demo.service.IFacturaService;
import com.uce.edu.demo.service.IHotelService;
import com.uce.edu.demo.service.IProductoService;
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
	@Autowired
	private IProductoService iProductoService;
	@Autowired
	private ICiudadanoService ciudadanoService;

	
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3XpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated metfod stub

		Cliente cliente=new Cliente();
		cliente.setNumeroTarjeta("001");
		
		Ciudadano ciudadano=new Ciudadano();
		ciudadano.setNombre("Xavier");
		ciudadano.setApellido("Paez");
		ciudadano.setCedula("1725161");
		ciudadano.setCliente(cliente);
		cliente.setCiudadano(ciudadano);
		
		//this.ciudadanoService.insertar(ciudadano);
		
		Producto producto=new Producto();
		producto.setNombre("Aceite");
		producto.setPrecio(new BigDecimal(2.50));
		producto.setCantidadStock(200);
		producto.setCodigoBarra("Aceite123");
	
		//this.iProductoService.insertar(producto);
		
		List<String> codigoBarra= new ArrayList<>(); 
		codigoBarra.add("Aceite123");
		
		this.iProductoService.comprar("1725161", "1243121231", codigoBarra );
	
	
		
	
	
		
	
	}
	
}