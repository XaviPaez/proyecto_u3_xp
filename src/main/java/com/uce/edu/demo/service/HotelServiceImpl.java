package com.uce.edu.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.demo.repository.IHotelRepository;
import com.uce.edu.demo.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements IHotelService {

	private static final Logger LOG = LoggerFactory.getLogger(HotelServiceImpl.class);

	@Autowired
	private IHotelRepository hotelRepository;
	
	@Override
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.hotelRepository.buscarHotelInnerJoin(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinLeft(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.hotelRepository.buscarHotelOuterJoinLeft(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinRight(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.hotelRepository.buscarHotelOuterJoinRight(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarInnerJoin() {
		// TODO Auto-generated method stub
		return this.hotelRepository.buscarInnerJoin();
	}

	@Override
	public List<Hotel> buscarOuterJoinLeft() {
		// TODO Auto-generated method stub
		return this.hotelRepository.buscarOuterJoinLeft();
	}

	@Override
	public List<Hotel> buscarHotelJoinWhere(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.hotelRepository.buscarHotelJoinWhere(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelFetchJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		LOG.info("Transaccion activa Service: "+TransactionSynchronizationManager.isActualTransactionActive());

		return this.hotelRepository.buscarHotelFetchJoin(tipoHabitacion);
	}




}
