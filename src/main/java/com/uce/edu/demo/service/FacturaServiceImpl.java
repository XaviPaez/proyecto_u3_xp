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
import com.uce.edu.demo.repository.IFacturaRepository;
import com.uce.edu.demo.repository.IProductoRepository;
import com.uce.edu.demo.repository.modelo.Cliente;
import com.uce.edu.demo.repository.modelo.DetalleFactura;
import com.uce.edu.demo.repository.modelo.Factura;
import com.uce.edu.demo.repository.modelo.Producto;


@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaRepository FacturaRepository;
	@Autowired
	private IClienteRepository clienteRepository;
	@Autowired
	private IProductoRepository iProductoRepository;
	@Override
	public List<Factura> buscarFacturaInnerJoin(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.FacturaRepository.buscarFacturaInnerJoin(cantidad);
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinLeft(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.FacturaRepository.buscarFacturaOuterJoinLeft(cantidad);
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinRight(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.FacturaRepository.buscarFacturaOuterJoinRight(cantidad);
	}

	@Override
	public List<Factura> buscarInnerJoin() {
		// TODO Auto-generated method stub
		return this.FacturaRepository.buscarInnerJoin();
	}

	@Override
	public List<Factura> buscarOuterJoinLeft() {
		// TODO Auto-generated method stub
		return this.FacturaRepository.buscarOuterJoinLeft();
	}

	@Override
	public List<Factura> buscarFacturaJoinWhere(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.FacturaRepository.buscarFacturaJoinWhere(cantidad);
	}

	@Override
	public List<Factura> buscarFacturaFetchJoin(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.FacturaRepository.buscarFacturaFetchJoin(cantidad);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(Factura factura) {
		// TODO Auto-generated method stub
		this.FacturaRepository.insertar(factura);
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public BigDecimal procesarFactura(String cedulaCliente, String numeroFactura, List<String> codigoBarras) {
		// TODO Auto-generated method stub
		List<DetalleFactura> listDetalleFacturas = new ArrayList<>();
		
		Factura factura = new Factura();
		Cliente cliente = this.clienteRepository.buscarCliente(cedulaCliente);
		factura.setCliente(cliente);
		factura.setNumero(numeroFactura);
		factura.setFecha(LocalDateTime.now());

		BigDecimal monto= BigDecimal.ZERO;
		for (String codigo : codigoBarras) {
			Producto producto = this.iProductoRepository.buscarPorCodigoBarra(codigo);
			
			DetalleFactura detalleFactura = new DetalleFactura();
			detalleFactura.setCantidad(1);
			detalleFactura.setProducto(producto);
			detalleFactura.setFactura(factura);
			detalleFactura.setSubtotal(producto.getPrecio());
			monto = monto.add(detalleFactura.getSubtotal());
			listDetalleFacturas.add(detalleFactura);
			

			Integer stocknuevo = producto.getCantidadStock() - 1;
			producto.setCantidadStock(stocknuevo);
			this.iProductoRepository.actualizar(producto);

		}
		
		

		factura.setDetalles(listDetalleFacturas);

		FacturaRepository.insertar(factura);	
		
		return monto;
		
	}
}
