package viewmodel;

import java.util.List;
import dao.PersonaDAO;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import model.Persona;

public class PersonaVM {

	private List<Persona> personas;
	 
	@WireVariable
	private PersonaDAO personaDAO = new PersonaDAO();	
	
	  private Persona nuevaPersona = new Persona();
	
	@Init
    public void init() {
        personas = personaDAO.listarPersonas();
    }
	

    public Persona getNuevaPersona() {
        return nuevaPersona;
    }

    public void setNuevaPersona(Persona nuevaPersona) {
        this.nuevaPersona = nuevaPersona;
    }

    @Command
    @NotifyChange({"persona", "nuevaPersona"})
    public void guardar() {
        personaDAO.agregarPersona(nuevaPersona);
        personas = personaDAO.listarPersonas();
        nuevaPersona = new Persona(); 
    }

	
	
	
	 // Getters y Setters
    public List<Persona> getPersonas() { return personas; }
    
    
}
