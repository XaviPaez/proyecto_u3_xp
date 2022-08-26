package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.util.List;

import com.uce.edu.demo.repository.modelo.Factura;

public interface IFacturaService {

	public List<Factura> buscarFacturaInnerJoin(Integer cantidad);

	public List<Factura> buscarInnerJoin();

	public List<Factura> buscarFacturaOuterJoinLeft(Integer cantidad);

	public List<Factura> buscarOuterJoinLeft();

	public List<Factura> buscarFacturaOuterJoinRight(Integer cantidad);

	public List<Factura> buscarFacturaJoinWhere(Integer cantidad);

	public List<Factura> buscarFacturaFetchJoin(Integer cantidad);
	
	public void insertar(Factura factura);
	
	
	public BigDecimal procesarFactura(String cedulaCliente, String numeroFactura, List<String> codigoBarras);
}
