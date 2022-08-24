package com.uce.edu.demo.service.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.uce.edu.demo.ProyectoU3XpApplication;

public class MainInterfacesFuncionales {

	private static final Logger LOG = LoggerFactory.getLogger(ProyectoU3XpApplication.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConsumoMetodosHighOrder metodosHO = new ConsumoMetodosHighOrder();

		// SUPPLIER
		// Clases
		IPersonaSupplier<String> supplier = new PersonaSupplierImpl();
		LOG.info("Supplier Clase: " + supplier.getNombre());

		IPersonaSupplier<String> supplierTE = new PersonaSupplierTEImpl();
		LOG.info("Supplier Clase: " + supplierTE.getNombre());

		// Lambdas
		IPersonaSupplier<String> supplierLambda = () -> "Xavier 2";
		LOG.info("Supplier Lmabda: " + supplierLambda.getNombre());

		IPersonaSupplier<String> supplierLambdaTE = () -> "Pablo TE 2";
		LOG.info("Supplier Lmabda: " + supplierLambdaTE.getNombre());

		// Metodos High Order
		String valorHO = metodosHO.consumirSupplier(() -> "Hola mundo");
		LOG.info("HO Supplier: " + valorHO);

		String valorHO1 = metodosHO.consumirSupplier(() -> {
			String valorConsultado = "127812781";
			return valorConsultado;
		});
		LOG.info("HO Supplier: " + valorHO1);
		// CONSUMER
		// Clases
		IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
		consumerClase.accept("Prueba Consumer");

		// Lambdas
		IPersonaConsumer<String> consumerLambda = cadena -> System.out.println(cadena);
		consumerLambda.accept("Prueba consumer Lambda");
		
		//Metodos High Order
		metodosHO.consumirConsumer(valor -> System.out.println(valor), 2);

		// PREDICATE
		// Clases

		// Lambdas

		IPersonaPredicate<String> predicateLambda = cadena -> cadena.contains("Z");
		LOG.info("Predicate Lambda: " + predicateLambda.evaluar("EdiZon"));
		
		//Metodos High Order
		boolean respuesta=metodosHO.consumirPredicate(cadena -> cadena.contains("Z"), "EdiZon");
		LOG.info("HO PREDICATE" + respuesta);
		// FUNCTION
		// Clases

		// Lambdas

		IPersonaFunction<Integer, String> functionLambda = cadena -> {
			Integer valor = Integer.parseInt(cadena);
			Integer valorFinal = valor - 2;
			return valorFinal;
		};
		LOG.info("Function Lambda: " + functionLambda.aplicar("7"));
		//Metodos High Order
		String valorFinalHO=metodosHO.consumirFunction(valor -> {
			String retorn= valor.toString()+"A";
			return retorn;
		},1);
		LOG.info("HO Function: "+ valorFinalHO);

		// UNARY OPERATOR(FUNCTION)
		// Clases

		// Lambdas
		IPersonaFunctionUnaryOperator<String> unaryLambda = cade -> {
			String valorFinal = cade.concat("sufijo");
			return valorFinal;
		};
		LOG.info("Predicate Lambda: " + unaryLambda.aplicar("Daniel"));

	}

}
