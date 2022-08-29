package com.uce.edu.demo.service.funcional;

public class ConsumoMetodosHighOrder {

	public String consumirSupplier(IPersonaSupplier<String> funcion) {
		/*
		 * String valor=funcion.getNombre(); //Calcular/Sumar consultar en la base ...
		 * Integer numero= Integer.parseInt(valor); return numero; ¨
		 */
		return funcion.getNombre() + " se proceso el dato ";
	}

	public void consumirConsumer(IPersonaConsumer<Integer> funcion, Integer valor) {

		funcion.accept(valor);
	}

	public boolean consumirPredicate(IPersonaPredicate<String> funcion, String valor) {

		return funcion.evaluar(valor);
	}

	public String consumirFunction(IPersonaFunction<String, Integer> funcion, Integer valor) {
		return funcion.aplicar(valor);
	}

	// Estudiante

	public String consumirEstudianteSupplier(IEstudianteSupplier<String> estudianteSupplier) {
		return estudianteSupplier.getNombre() + "se da el nombre";
	}

	public void consumirEstudianteConsumer(IEstudianteConsumer<String> estudianteConsumer, String valor) {
		estudianteConsumer.accept(valor);
	}

	public boolean consumirEstudiantePredicate(IEstudiantePredicate<String> estudiantePredicate, String valor) {
		return estudiantePredicate.evaluar(valor);
	}

	public String consumirEstudianteFunction(IEstudianteFunction<String, Integer> estudianteFunction, Integer valor) {
		return estudianteFunction.aplicar(valor);
	}
	public String consumirEstudianteUnaryOperator(IEstudianteFunctionUnaryOperator<String> estudianteFunctionUnaryOperator, String valor) {
		return estudianteFunctionUnaryOperator.aplicar(valor);
	}
}
