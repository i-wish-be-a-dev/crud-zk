package viewmodel;

import java.util.List;
import dao.PersonaDAO;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import model.Persona;

public class PersonaVM {

	private List<Persona> personas;
	 
	@WireVariable
	private PersonaDAO personaDAO = new PersonaDAO();	
	@Init
    public void init() {
        personas = personaDAO.listarPersonas();
    }
	 // Getters y Setters
    public List<Persona> getPersonas() { return personas; }
}
