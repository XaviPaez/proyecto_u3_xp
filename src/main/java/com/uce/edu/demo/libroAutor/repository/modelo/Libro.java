package com.uce.edu.demo.libroAutor.repository.modelo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name ="libro")
public class Libro {

	@Id
	@Column(name="libr_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "libr_id_sec")
	@SequenceGenerator(name = "libr_id_sec", sequenceName = "libr_id_sec", allocationSize = 1)
	private Integer id;
	
	@Column(name = "libr_titulo")
	private String titulo;
	
	@Column(name = "libr_cantidad_paginas")
	private Integer cantidadPaginas;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="libro_autor",joinColumns = @JoinColumn(name="liau_id_libro"),inverseJoinColumns = @JoinColumn(name="liau_id_autor"))//libro primero por que elejimos la tabla principal, no necesariamente
	private Set<Autor> autores;
	
	
	
	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", cantidadPaginas=" + cantidadPaginas + "]";
	}

	//set y get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getCantidadPaginas() {
		return cantidadPaginas;
	}

	public void setCantidadPaginas(Integer cantidadPaginas) {
		this.cantidadPaginas = cantidadPaginas;
	}

	public Set<Autor> getAutores() {
		return autores;
	}

	public void setAutores(Set<Autor> autores) {
		this.autores = autores;
	}


	
	
}
