package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Cliente;

public interface IClienteRepository {

	public Cliente buscarCliente(String cedula);
	
	
}
