package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IFacturaElectronicaRepository;
import com.uce.edu.demo.repository.modelo.FacturaElectronica;

@Service
public class FacturaElectronicaServiceImpl implements IFacturaElectronicaService {

	@Autowired
	private IFacturaElectronicaRepository electronicaRepository; 
	
	@Override
	public void insertar(FacturaElectronica electronica) {
		// TODO Auto-generated method stub
		this.electronicaRepository.insertar(electronica);
	}

}
