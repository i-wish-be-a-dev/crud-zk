package service;

import java.util.List;

import model.Persona;

public interface PersonaService {

	public List<Persona> listarPersonas();
    public List<Persona> search(String keyword);

	
}
