package com.uce.edu.demo.libroAutor.repository;

import java.util.List;

import com.uce.edu.demo.libroAutor.repository.modelo.Libro;

public interface ILibroRepository {
	public Libro insertar(Libro libro);
	public List<Libro> contarCantidadPaginas(Integer cant);

}
