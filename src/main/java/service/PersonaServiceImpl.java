package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import model.Persona;

public class PersonaServiceImpl implements PersonaService {
   
    private static final List<Persona> PERSONAS = new ArrayList<>();

    static {
        PERSONAS.add(new Persona(1, "Juan", "Pérez", "juan@mail.com"));
        PERSONAS.add(new Persona(2, "María", "Gómez", "maria@mail.com"));
        PERSONAS.add(new Persona(3, "Carlos", "López", "carlos@mail.com"));
    }
	@Override
	public List<Persona> listarPersonas() {
		
		return PERSONAS;
	}

	@Override
    public List<Persona> search(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return PERSONAS;
        }
        String lower = keyword.toLowerCase();
        return PERSONAS.stream()
                .filter(p -> p.getNombre().toLowerCase().contains(lower)
                        || p.getApellido().toLowerCase().contains(lower))
                .collect(Collectors.toList());
    }

}
