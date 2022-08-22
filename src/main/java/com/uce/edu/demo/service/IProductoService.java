package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Producto;

public interface IProductoService {

	public void insertar(Producto producto);
	public Producto buscarPorNombre(String nombre);
	public void actualizar(Producto producto);
	public void comprar(String cedulaCliente, String numeroFactura, List<String> codigoBarra);

}
