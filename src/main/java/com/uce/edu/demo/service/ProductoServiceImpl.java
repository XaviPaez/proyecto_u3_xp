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
	@Autowired
	private IFacturaService facturaService;
	@Autowired
	private IFacturaElectronicaService electronicaService;
	
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
	BigDecimal totalPagar = this.facturaService.procesarFactura(cedulaCliente, numeroFactura, codigoBarra);
		
		this.electronicaService.procesarElectronica(numeroFactura, codigoBarra.size(), totalPagar);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(Producto producto) {
		// TODO Auto-generated method stub
		this.iProductoRepository.insertar(producto);
	}
}
