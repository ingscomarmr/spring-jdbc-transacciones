package mx.comr.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mx.comr.jdbc.IPersonaDao;
import mx.comr.jdbc.Persona;
import mx.comr.servicio.IPersonaSerivico;;

@Service
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class PersonaServicioImp implements mx.comr.servicio.IPersonaSerivico{

	@Autowired
	private IPersonaDao personaDao;
	
	public List<Persona> listarPersonas() {
		return this.personaDao.findAllPersonas();
	}

	public Persona recuperarPersonaPorId(Persona persona) {
		return this.personaDao.findPersonaById(persona.getIdPersona());
	}		
	
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public int contarPersonas() {
		return personaDao.contadorPersonas();		
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public long personaIdSeq() {
		return this.personaIdSeq();
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void agregarPersona(Persona persona) {
		this.personaDao.insertPersona(persona);		
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void modificarPersona(Persona persona) {
		this.personaDao.updatePersona(persona);		
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void eliminarPersona(Persona persona) {
		this.personaDao.deletePersona(persona);
	}	

	
}
