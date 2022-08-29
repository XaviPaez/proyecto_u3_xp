package com.uce.edu.demo.service.funcional;

public class EstudianteFunctionImpl implements IEstudianteFunction<String, Integer>{

	@Override
	public String aplicar(Integer arg1) {
		// TODO Auto-generated method stub
		String ejemplo=arg1.toString().concat("  Estudiante  function");
		
		return ejemplo;
	}



}
