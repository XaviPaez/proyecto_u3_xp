package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Producto;

public interface IProductoRepository {

	public void insertar(Producto producto);
	public Producto buscarPorNombre(String nombre);
	public void actualizar(Producto producto);
	public Producto buscarPorCodigoBarra(String codigoBarra);


}
