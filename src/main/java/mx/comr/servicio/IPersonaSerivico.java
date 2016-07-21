package mx.comr.servicio;

import java.util.List;
import mx.comr.jdbc.Persona;

public interface IPersonaSerivico {
	public List<Persona> listarPersonas();

	public Persona recuperarPersonaPorId(Persona persona);

	public int contarPersonas();

	public long personaIdSeq();

	public void agregarPersona(Persona persona);

	public void modificarPersona(Persona persona);

	public void eliminarPersona(Persona persona);
}
