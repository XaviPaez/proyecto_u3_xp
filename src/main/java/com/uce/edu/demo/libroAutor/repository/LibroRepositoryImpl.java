package com.uce.edu.demo.libroAutor.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.libroAutor.repository.modelo.Libro;

@Repository
@Transactional
public class LibroRepositoryImpl implements ILibroRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Libro insertar(Libro libro) {
		// TODO Auto-generated method stub
		this.entityManager.persist(libro);
		return libro;
	}

	@Override
	public List<Libro> contarCantidadPaginas(Integer cant) {
		TypedQuery<Libro> myQuery = this.entityManager.createQuery("SELECT p From Libro p where p.cantidadPaginas >:datoCantidad",Libro.class);
		myQuery.setParameter("datoCantidad", cant);
		return myQuery.getResultList();
	}

}
