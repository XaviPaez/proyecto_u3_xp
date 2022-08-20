package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.management.RuntimeErrorException;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICuentaBancariaRepository;
import com.uce.edu.demo.repository.ITransferenciaRepository;
import com.uce.edu.demo.repository.modelo.CuentaBancaria;
import com.uce.edu.demo.repository.modelo.Transferencia;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService {

	@Autowired
	private ICuentaBancariaRepository bancariaRepository;
	@Autowired
	private ITransferenciaRepository iTransferenciaRepository;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void realizarTransferencia(String numeroCtaOrigen, String numeroCtaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		// 0.Buscar la cta orgien
		
		CuentaBancaria ctaOrigen=this.bancariaRepository.buscarPorNumero(numeroCtaOrigen);
		// 1. Restar el monto a la cta origen
		BigDecimal saldoOrigen=ctaOrigen.getSaldo();
		BigDecimal saldoFinal=saldoOrigen.subtract(monto);
		ctaOrigen.setSaldo(saldoFinal);
		this.bancariaRepository.actualizar(ctaOrigen);
		
		// 2. Sumar el monto a la cta destino
		CuentaBancaria ctaDestino=this.bancariaRepository.buscarPorNumero(numeroCtaDestino);
		ctaDestino.setSaldo(ctaDestino.getSaldo().add(monto));
		this.bancariaRepository.actualizar(ctaDestino);

		// 3. Insertar transferencia
		Transferencia transferencia=new Transferencia();
		transferencia.setCuentaOrigen(ctaOrigen);
		transferencia.setCuentaDestino(ctaDestino);
		transferencia.setFecha(LocalDateTime.now());
		transferencia.setMonto(monto);
		this.iTransferenciaRepository.insertar(transferencia);
		
		/*
		 * if(ctaOrigen.getTipo().equals("Ahorros")) { throw new RuntimeException();
		 * 
		 * }
		 */
		
		if(monto.compareTo(saldoOrigen)>0) {
			throw new RuntimeException();
			
		}
		
		
	}

	@Override
	public void insertarCuenta(CuentaBancaria bancaria) {
		// TODO Auto-generated method stub
		this.bancariaRepository.insertar(bancaria);
	}

	@Override
	public CuentaBancaria buscarPorNumero(String numeroCuenta) {
		// TODO Auto-generated method stub
		return this.bancariaRepository.buscarPorNumero(numeroCuenta);
	}



	
}
