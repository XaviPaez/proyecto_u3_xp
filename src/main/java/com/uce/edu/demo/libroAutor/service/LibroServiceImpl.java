package com.uce.edu.demo.libroAutor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.libroAutor.repository.ILibroRepository;
import com.uce.edu.demo.libroAutor.repository.modelo.Libro;



@Service
public class LibroServiceImpl implements ILibroService{

	@Autowired
	private ILibroRepository iLibroRepository;
	
	@Override
	public Libro insertar(Libro libro) {
		return this.iLibroRepository.insertar(libro);
	}

	@Override
	public List<Libro> contarCantidadPaginas(Integer cant) {
		// TODO Auto-generated method stub
		return this.iLibroRepository.contarCantidadPaginas(cant);
	}

}
