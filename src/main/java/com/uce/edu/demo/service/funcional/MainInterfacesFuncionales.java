package com.uce.edu.demo.service.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.uce.edu.demo.ProyectoU3XpApplication;

public class MainInterfacesFuncionales {

	private static final Logger LOG = LoggerFactory.getLogger(ProyectoU3XpApplication.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConsumoMetodosHighOrder metodosHO = new ConsumoMetodosHighOrder();

		
		LOG.info("Ejemplos Supplier");
		LOG.info("\n");

		
		// SUPPLIER
		// Clases
		IEstudianteSupplier<String> supplier = new EstudianteSupplierImpl();
		LOG.info("Supplier Clase: " + supplier.getNombre());
		// Lambdas
		IEstudianteSupplier<String> supplierLambda = () -> "Estudiante Supplier";
		LOG.info("Supplier Lambda: " + supplierLambda.getNombre());
		// Metodos High Order
		String valorHo = metodosHO.consumirEstudianteSupplier(() -> "Estudiante Supplier High order");
		LOG.info("HO Supplier Estudiante: " + valorHo);

		LOG.info("\n");

		LOG.info("Ejemplos Consumer");
		
		LOG.info("\n");


		// CONSUMER
		// Clases
		IEstudianteConsumer<String> consumer = new EstudianteConsumerImpl();
		consumer.accept(" Consumer Estudiante");
		// Lambdas
		IEstudianteConsumer<String> consumerLambda = cadena -> LOG.info(cadena);
		consumerLambda.accept("Consumer Lambda Estudiante");
		// Metodos High Order
		metodosHO.consumirConsumer(valor -> System.out.println(valor), 2);

		LOG.info("\n");

		LOG.info("Ejemplos Predicate");
		LOG.info("\n");


		// PREDICATE
		// Clase
		IEstudiantePredicate<String> predicate = new EstudiantePredicateImpl();
		predicate.evaluar("Predicate estudiante clase");
		// Lambdas
		IEstudiantePredicate<String> predicateLambda = cadena -> cadena.contains("p");
		LOG.info("Predicate Lambda: " + predicateLambda.evaluar("Estudiante predicate"));
		// Metodos High Order
		boolean respuesta = metodosHO.consumirEstudiantePredicate(cadena -> cadena.contains("p"), "Estudiante predicate 2");
		LOG.info("HO predicate" + respuesta);

		LOG.info("\n");

		LOG.info("Ejemplos Function");
		LOG.info("\n");

		
		// FUNCTION
		// Clases
		IEstudianteFunction<String, Integer> function = new EstudianteFunctionImpl();
		LOG.info("Function clase: " + function.aplicar(3));
		// Lambdas
		IEstudianteFunction<Integer, String> functionLambda = cadena -> {
			Integer valor = Integer.parseInt(cadena);
			Integer valorFinal = valor - 2;
			return valorFinal;
		};
		LOG.info("Function Lambda: " + functionLambda.aplicar("7"));
		// Metodos High Order
		String valorFinalHO = metodosHO.consumirEstudianteFunction(valor -> {
			String retorn = valor.toString() + "A";
			return retorn;
		}, 1);
		LOG.info("HO Function: " + valorFinalHO);

		LOG.info("\n");

		LOG.info("Ejemplos UnaryOperator");

		LOG.info("\n");
		
		// UNARY LAMBDA OPERATOR
		// Clases

		IEstudianteFunctionUnaryOperator<String> unaryOperator=new EstudianteFunctionUnaryOperatorImpl();
		LOG.info("Unary Operator Estudiante: " + unaryOperator.aplicar("Unary") );
		// Lambdas
		IEstudianteFunctionUnaryOperator<String> unaryLambda = cadena -> {
			String valorFinal = cadena.concat("cadena");
			return valorFinal;
		};
	
		// Metodos High Order
		LOG.info("HO UnaryOperator");
		LOG.info(metodosHO.consumirEstudianteUnaryOperator(unaryOperator, "Holaaa"));
		



	}

}
