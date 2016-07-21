package test;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import mx.comr.servicio.*;
import mx.comr.jdbc.*;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = { "classpath:datasource-test.xml","classpath:applicationContext.xml" })
public class TestPersonaServicioImp {

	private static Log logger = LogFactory.getLog("TestPersonasServiceImpl");
	
	@Autowired 
	private IPersonaSerivico personaService; 
	@Autowired 
	private IPersonaDao personaDao;
	
	@Test
	public void testObtenerPersonas(){
		try{
			System.out.println();
			logger.info("Iniciar testObtenerPersonas");
			List<Persona> personas = personaService.listarPersonas();
			for (Persona persona : personas) {
				logger.info(persona);
			}
			logger.info("Fin testObtenerPersonas");
			System.out.println();
		}catch(Exception e){
			logger.error("Error:" + e.getMessage());
		}
	}
	
	@Test
	@Transactional
	public void testActualizarPersona(){
		try{
			System.out.println();
			logger.info("Iniciar testActualizarPersona");
			Persona persona = personaService.recuperarPersonaPorId(new Persona(1));
			logger.info("Persona obtenida:" + persona);
			persona.setNombre("Jonattttttttttttttaaaaaaaaannnnnn");
			personaService.modificarPersona(persona);
			persona = personaService.recuperarPersonaPorId(new Persona(1));			
			logger.info("Persona actualizada:" + persona);
			logger.info("Fin testActualizarPersona");
			System.out.println();
		}catch(Exception e){
			logger.error("Error:" + e.getMessage());
		}
	}
	
}
