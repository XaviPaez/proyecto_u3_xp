package com.uce.edu.demo.hilos.paralelo;

import java.util.concurrent.TimeUnit;

public class PCRecepcion extends Thread {
	
	private RecepcionistaParalelo pcRecepcion;
	
	public PCRecepcion(RecepcionistaParalelo pcRecepcion) {
		this.pcRecepcion=pcRecepcion;
		
	}
	
	// Disparar el metodo a paralelizar
	@Override
	public void run() {
		this.reservar(this.pcRecepcion);
	}

	public void reservar(RecepcionistaParalelo reserva) {

		long tiempoInicial = System.currentTimeMillis();
		System.out.println("Nombre  hilo procesar:" + Thread.currentThread().getName());
		System.out.println("Procesando reserva: " + reserva.getNombre());
		for (String cliente : reserva.getClientes()) {
			this.atenderCliente(cliente);
		}
		
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTrans = (tiempoFinal - tiempoInicial) / 1000;

		
		
		System.out.println("termino: "+reserva.getNombre()+" en "+tiempoTrans+" seg");
        
	
	}

	private void atenderCliente(String cliente) {
		System.out.println("Atendiendo: a:" + cliente);
		// Demorar el metodo 5 seg
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
