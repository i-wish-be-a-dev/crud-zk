package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Persona;
import util.Conexion;

public class PersonaDAO {

	public List<Persona> listarPersonas() {
		
		String sql = "SELECT * FROM personas";
		List<Persona> lista = null;
		
		try {
			Connection con = Conexion.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String email = rs.getString("email");
				
				Persona persona = new Persona(id, nombre, apellido, email);
				lista.add(persona);
				System.out.println("Cargada persona: " + persona.getNombre());
			}
			
			con.close();
			return lista;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	 public boolean agregarPersona(Persona persona) {
	        String sql = "INSERT INTO persona (nombre, apellido, email) VALUES (?, ?, ?)";
	        try (Connection con = Conexion.getConnection();
	             PreparedStatement ps = con.prepareStatement(sql)) {

	            ps.setString(1, persona.getNombre());
	            ps.setString(2, persona.getApellido());
	            ps.setString(3, persona.getEmail());

	            int filas = ps.executeUpdate();
	            System.out.println("Persona agregada: " + persona.getNombre());
	            return filas > 0;

	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	
	
}
