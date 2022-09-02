package com.uce.edu.demo.hilos.paralelo;

import java.util.Arrays;

public class MainRecepcion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long tiempoInicial= System.currentTimeMillis();
		
		System.out.println("Nombre Hilo: "+ Thread.currentThread().getName());
	
		RecepcionistaParalelo recepcionistaParalelo=new RecepcionistaParalelo("Xavier", Arrays.asList("Pablo", "Josue","Alisson"));
		RecepcionistaParalelo recepcionistaParalelo1=new RecepcionistaParalelo("Pablo", Arrays.asList("Rodrigo","Cristiano"));
		RecepcionistaParalelo recepcionistaParalelo2=new RecepcionistaParalelo("Fernando", Arrays.asList("Leonel","Erick"));
		RecepcionistaParalelo recepcionistaParalelo3=new RecepcionistaParalelo("Mike", Arrays.asList("Kevin", "Sebastian", "Ricardo","Juan"));
		RecepcionistaParalelo recepcionistaParalelo4=new RecepcionistaParalelo("Romina", Arrays.asList("Ignacio","Cristina"));
		
		
		
		
		PCRecepcion reserva=new PCRecepcion(recepcionistaParalelo);
		reserva.start(); //procesar

		PCRecepcion reserva1=new PCRecepcion(recepcionistaParalelo1);
		reserva1.start(); //procesar
		
		PCRecepcion reserva2=new PCRecepcion(recepcionistaParalelo2);
		reserva2.start(); //procesar
		
		PCRecepcion reserva3=new PCRecepcion(recepcionistaParalelo3);
		reserva3.start(); //procesar
		
		PCRecepcion reserva4=new PCRecepcion(recepcionistaParalelo4);
		reserva4.start(); //procesar
		
		
		
		long tiempoFinal= System.currentTimeMillis();
		
		long tiempoTranscurrido=(tiempoFinal-tiempoInicial)/1000;
		
		System.out.println(tiempoTranscurrido+" seg");
	}

}
