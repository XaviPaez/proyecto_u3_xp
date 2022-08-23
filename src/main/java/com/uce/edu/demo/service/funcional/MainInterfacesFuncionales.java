package com.uce.edu.demo.service.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.uce.edu.demo.ProyectoU3XpApplication;

public class MainInterfacesFuncionales {

	private static final Logger LOG = LoggerFactory.getLogger(ProyectoU3XpApplication.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		//SUPPLIER
		//Clases
		IPersonaSupplier<String> supplier=new PersonaSupplierImpl();
		LOG.info("Supplier Clase: "+supplier.getNombre());
		
		IPersonaSupplier<String> supplierTE=new PersonaSupplierTEImpl();
		LOG.info("Supplier Clase: "+supplierTE.getNombre());
		
		//Lambdas
		IPersonaSupplier<String> supplierLambda=() -> "Xavier 2";
		LOG.info("Supplier Lmabda: "+supplierLambda.getNombre());
		
		IPersonaSupplier<String> supplierLambdaTE=() -> "Pablo TE 2";
		LOG.info("Supplier Lmabda: "+supplierLambdaTE.getNombre());
		
		//CONSUMER
		//Clases
		IPersonaConsumer<String> consumerClase=new PersonaConsumerImpl();
		consumerClase.accept("Prueba Consumer");
		
		//Lambdas
		IPersonaConsumer<String> consumerLambda=cadena -> System.out.println(cadena);
		consumerLambda.accept("Prueba consumer Lambda");
		
		//PREDICATE
		//Clases
		
		//Lambdas
				
		
		//FUNCTION
		//Clases
		
		//Lambdas
		
		
		//UNARY OPERATOR(FUNCTION)
		//Clases
		
		//Lambdas
		
		
	}

}
