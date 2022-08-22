package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IClienteRepository;
import com.uce.edu.demo.repository.IFacturaElectronicaRepository;
import com.uce.edu.demo.repository.IFacturaRepository;
import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.modelo.Cliente;
import com.uce.edu.demo.repository.modelo.DetalleFactura;
import com.uce.edu.demo.repository.modelo.Factura;
import com.uce.edu.demo.repository.modelo.FacturaElectronica;
import com.uce.edu.demo.repository.modelo.Producto;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoRepository iProductoRepository;
	@Autowired
	private IClienteRepository clienteRepository;
	@Autowired
	private IFacturaRepository facturaRepository;
	@Autowired
	private IFacturaElectronicaRepository electronicaRepository;
	
	@Override
	public Producto buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.iProductoRepository.buscarPorNombre(nombre);
	}

	@Override
	public void actualizar(Producto producto) {
		// TODO Auto-generated method stub
		this.iProductoRepository.actualizar(producto);
	}
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void comprar(String cedulaCliente, String numeroFactura, List<String> codigoBarra) {
		// TODO Auto-generated method stub
		Cliente cliente = this.clienteRepository.buscarCliente(cedulaCliente);
		Factura factura = new Factura();
		factura.setCliente(cliente);
		factura.setNumero(numeroFactura);
		factura.setFecha(LocalDateTime.now());

		List<DetalleFactura> listDetalleFacturas = new ArrayList<>();

		for (String codigo : codigoBarra) {
			Producto producto = this.iProductoRepository.buscarPorCodigoBarra(codigo);
			DetalleFactura detalleFactura = new DetalleFactura();
			detalleFactura.setCantidad(1);
			detalleFactura.setProducto(producto);
			detalleFactura.setFactura(factura);
			detalleFactura.setSubtotal(producto.getPrecio());
			listDetalleFacturas.add(detalleFactura);
			
			Integer stocknuevo = producto.getCantidadStock()-1;
			producto.setCantidadStock(stocknuevo);
			this.iProductoRepository.actualizar(producto);
			
		}

		factura.setDetalles(listDetalleFacturas);
		
		facturaRepository.insertar(factura);
		
		
		BigDecimal monto= new BigDecimal(0);
		FacturaElectronica facturaElectronica = new  FacturaElectronica();
		facturaElectronica.setFechaCreacion(LocalDateTime.now());
		for(DetalleFactura detalle : listDetalleFacturas) {
		monto =monto.add(detalle.getSubtotal());
			
		}
		
		
		facturaElectronica.setMontoFactura(monto);
		facturaElectronica.setNumero(numeroFactura);
		facturaElectronica.setNumeroItem(listDetalleFacturas.size());
		//inserta factura electronica
		this.electronicaRepository.insertar(facturaElectronica);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(Producto producto) {
		// TODO Auto-generated method stub
		this.iProductoRepository.insertar(producto);
	}
}
