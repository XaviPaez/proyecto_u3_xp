package com.uce.edu.demo.service.funcional;

public class EstudiantePredicateImpl implements IEstudiantePredicate<String> {

	@Override
	public boolean evaluar(String arg1) {
		// TODO Auto-generated method stub
		
		return arg1.endsWith("p");
	}

}
