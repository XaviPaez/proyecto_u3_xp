package com.uce.edu.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;

import com.uce.edu.demo.libroAutor.repository.ILibroRepository;
import com.uce.edu.demo.libroAutor.repository.modelo.Libro;



@SpringBootTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@TestMethodOrder(OrderAnnotation.class)
public class Ejemplo2 {
	private static final Logger LOG = LoggerFactory.getLogger(ProyectoU3XpApplication.class);



   @Autowired
    private ILibroRepository iLibroRepository;
    
    
    @Test
    public void testCantidadPaginas() {
    
        List<Libro> libroCant=this.iLibroRepository.contarCantidadPaginas(50);
        assertThat(libroCant).size().isGreaterThan(0);
        LOG.info(libroCant+"");
        
    
    }



   
}
