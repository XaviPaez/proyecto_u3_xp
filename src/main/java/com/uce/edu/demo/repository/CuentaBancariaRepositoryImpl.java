package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.demo.repository.modelo.CuentaBancaria;
@Repository
@Transactional
public class CuentaBancariaRepositoryImpl implements ICuentaBancariaRepository {
	
	private static final Logger LOG = LoggerFactory.getLogger(HotelRepositoryImpl.class);

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public void insertar(CuentaBancaria cuentaBancaria) {
		this.entityManager.persist(cuentaBancaria);
	}
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void actualizar(CuentaBancaria cuenta) {
		this.entityManager.merge(cuenta);
	//	throw new RuntimeException();

	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public CuentaBancaria buscarPorNumero(String numero) {
		LOG.info("Transacción activa: " + TransactionSynchronizationManager.isActualTransactionActive());
		TypedQuery<CuentaBancaria> myQuery = this.entityManager
				.createQuery("SELECT c FROM CuentaBancaria c WHERE c.numero= :datoNumero", CuentaBancaria.class);
		myQuery.setParameter("datoNumero", numero);
		return myQuery.getSingleResult();
	}

}