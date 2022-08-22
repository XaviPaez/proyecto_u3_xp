package com.uce.edu.demo.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IFacturaRepository;
import com.uce.edu.demo.repository.modelo.Factura;


@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaRepository FacturaRepository;
	
	@Override
	public List<Factura> buscarFacturaInnerJoin(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.FacturaRepository.buscarFacturaInnerJoin(cantidad);
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinLeft(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.FacturaRepository.buscarFacturaOuterJoinLeft(cantidad);
	}

	@Override
	public List<Factura> buscarFacturaOuterJoinRight(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.FacturaRepository.buscarFacturaOuterJoinRight(cantidad);
	}

	@Override
	public List<Factura> buscarInnerJoin() {
		// TODO Auto-generated method stub
		return this.FacturaRepository.buscarInnerJoin();
	}

	@Override
	public List<Factura> buscarOuterJoinLeft() {
		// TODO Auto-generated method stub
		return this.FacturaRepository.buscarOuterJoinLeft();
	}

	@Override
	public List<Factura> buscarFacturaJoinWhere(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.FacturaRepository.buscarFacturaJoinWhere(cantidad);
	}

	@Override
	public List<Factura> buscarFacturaFetchJoin(Integer cantidad) {
		// TODO Auto-generated method stub
		return this.FacturaRepository.buscarFacturaFetchJoin(cantidad);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(Factura factura) {
		// TODO Auto-generated method stub
		this.FacturaRepository.insertar(factura);
	}


}
