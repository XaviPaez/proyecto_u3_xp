package com.uce.edu.demo.libroAutor.service;

import java.util.List;

import com.uce.edu.demo.libroAutor.repository.modelo.Libro;

public interface ILibroService {
	public Libro insertar(Libro libro);
	public List<Libro> contarCantidadPaginas(Integer cant);
	
}
