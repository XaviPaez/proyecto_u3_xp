package com.uce.edu.demo.service.funcional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.uce.edu.demo.ProyectoU3XpApplication;

public class MainInterfacesFuncionales {

	private static final Logger LOG = LoggerFactory.getLogger(ProyectoU3XpApplication.class);

	public static boolean prueba(Integer numero) {
		return numero >= 3;
	}

	public static void imprimir(String cadena) {
		LOG.info("Impresion: " + cadena);

	}

	public static void guardar() {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConsumoMetodosHighOrder metodosHO = new ConsumoMetodosHighOrder();
		// SUPPLIER
		// JAVA
		LOG.info("Java Supplier");
		Random rand = new Random();
		Stream<Integer> stream = Stream.generate(() -> rand.nextInt(100)).limit(20);
		stream.forEach(cadena -> System.out.println(cadena));

		// CONSUMER
		// JAVA
		LOG.info("Java consumer");

		List<String> listaPalabras = Arrays.asList("Xavier", "Sebastian", "Mike", "Pablo");
		listaPalabras.forEach(System.out::println);

		// PREDICATE
		// JAVA
		LOG.info("JAVA Predicate");
		List<String> nombres = Arrays.asList("Pablo", "Miguel", "Romina", "Xavier");
		List<String> listaNombres = nombres.stream().filter(nombre -> nombre.startsWith("X"))
				.collect(Collectors.toList());
		listaNombres.forEach(System.out::println);
		
		//FUNCTION
		//JAVA
		LOG.info("JAVA Function");
		LOG.info("Se cambia la letra a por la 0 si cumple con la condicion");

		
		 Stream<String> listaCambiada=nombres.stream().filter(nombre -> nombre.contains("a")).map(nombreLista-> nombreLista.replace("a", "o"));
			listaCambiada.forEach(System.out::println);
		
		
		
	}

}
