package test;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import mx.comr.jdbc.IPersonaDao;
import mx.comr.jdbc.Persona;
import mx.comr.servicio.IPersonaSerivico;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = { "classpath:datasource-test.xml","classpath:applicationContext.xml" })
public class TestJdbcOracle {
	
	private static Log log = LogFactory.getLog("TestJdbcOracle");
	
	@Autowired 
	private IPersonaSerivico personaService; 
	@Autowired 
	private IPersonaDao personaDao;
	
	@Test
	@Ignore
	public void testCount(){
		try {
			log.info("Inicia testCount");
			log.info("Personas:" + personaService.contarPersonas());
			log.info("Fin testCount");
		} catch (Exception e) {
			log.error("Error:" + e.getMessage());
		}
	}
	
	@Test	
	@Ignore
	public void testSeq(){
		try {
			log.info("Inicia testSeq");
			log.info("Personas seq:" + personaDao.getIdSequence());
			log.info("Personas seq2:" + personaService.contarPersonas());
			log.info("Fin testSeq");
		} catch (Exception e) {
			log.error("Error:" + e.getMessage());
		}
	}
	
	@Test	
	@Ignore
	public void insertarPersona(){
		try {
			System.out.println();
			log.info("Inicia insertarPersona");
			Persona p = new Persona();
			//p.setIdPersona(personaDao.getIdSequence());
			p.setNombre("Omar");
			p.setApePaterno("Munguia");
			p.setApeMaterno("Rivera");
			p.setEmail(p.getNombre() + "."+p.getApePaterno()+"@gmail.com");
			personaService.agregarPersona(p);
			
			List<Persona> personas = personaService.listarPersonas();
			for (Persona persona : personas) {
				log.info(persona);
			}
			log.info("Fin insertarPersona");
			System.out.println();
		} catch (Exception e) {
			log.error("Error:" + e.getMessage());
		}
	}
	
	@Test		
	public void updatePersona(){
		try {
			System.out.println();
			log.info("Inicia updatePersona");
			Persona p = personaService.recuperarPersonaPorId(new Persona(21));
			//p.setIdPersona(personaDao.getIdSequence());
			p.setNombre("Juan");
			p.setApePaterno("Munguia");
			p.setApeMaterno("Romano");
			p.setEmail(p.getNombre() + "."+p.getApePaterno()+"@outlook.com");
			personaService.modificarPersona(p);
			
			List<Persona> personas = personaService.listarPersonas();
			for (Persona persona : personas) {
				log.info(persona);
			}
			log.info("Fin updatePersona");
			System.out.println();
		} catch (Exception e) {
			log.error("Error:" + e.getMessage());
		}
	}
	
	@Test
	@Ignore
	public void testDelete(){
		try {
			log.info("Inicia testDelete");
			Persona persona = personaService.recuperarPersonaPorId(new Persona(16));
			log.info("Eliminar:" + persona);
			personaService.eliminarPersona(persona);
			log.info("Fin testDelete");
		} catch (Exception e) {
			log.error("Error:" + e.getMessage());
		}
	}
}
