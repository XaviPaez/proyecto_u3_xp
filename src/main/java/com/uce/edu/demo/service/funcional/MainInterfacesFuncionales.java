package com.uce.edu.demo.service.funcional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.uce.edu.demo.ProyectoU3XpApplication;

public class MainInterfacesFuncionales {

	private static final Logger LOG = LoggerFactory.getLogger(ProyectoU3XpApplication.class);

	public static boolean prueba(Integer numero) {
		return numero>=3;
	}
	public static void imprimir(String cadena) {
		LOG.info("Impresion: "+ cadena);

	}
	public static void guardar() {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		ConsumoMetodosHighOrder metodosHO = new ConsumoMetodosHighOrder();
		//SUPPLIER
		//JAVA
		LOG.info("Java Supplier");
		Stream<String> test= Stream.generate(()-> "Edison 3").limit(7);
		test.forEach(cadena -> System.out.println(cadena));
		//JAVA
		//CONSUMER
		LOG.info("Java Consumer");

		List<Integer> listaNumeros=Arrays.asList(1,2,3,4,5);
		listaNumeros.forEach(numero -> System.out.println(numero));
		
		//PREDICATE
		LOG.info("JAVA Predicate");
		Stream<Integer> nuevaLista=listaNumeros.stream().filter(numero -> prueba(numero));
		nuevaLista.forEach(numero -> System.out.println(numero));
		
		//FUNCTION
		LOG.info("JAVA Function");
		//Conversiones/cast Empleado -> EmpleadoDTO (Ligero)
		Stream<String> listaCambiada=listaNumeros.stream().map(numeroLista-> {
			Integer valor=numeroLista +1;
			String cadena = "num: "+valor.toString();
			return cadena;
		});
		//Declarativa: ideas/intencion
		listaCambiada.forEach(valor-> imprimir(valor));
		List<String> lista1=new ArrayList<>();
		Map<String, String> mpaq=new HashMap<String, String>();
		
		//Imperativa: paso a paso
		
		//for(String valor:) {
		//	imprimir(valor);
		//}
	
	}

}
