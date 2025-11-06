package controller;

import java.util.List;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.*;

import model.Persona;
import service.PersonaService;
import service.PersonaServiceImpl;

public class PersonaController extends SelectorComposer<Component> {

    @Wire
    private Textbox keywordBox;

    @Wire
    private Listbox personaListbox;

    @Wire
    private Label nombreLabel, apellidoLabel, emailLabel;
    
    @Wire
    private Button editButton;
    

    private PersonaService personaService = new PersonaServiceImpl();

    
    @Listen("onCreate = #personaListbox")
    public void initList() {
		List<Persona> personas = personaService.listarPersonas();
		personaListbox.setModel(new ListModelList<>(personas));
	    editButton.setVisible(false); // inicia oculto

	}

    
    @Listen("onClick = #searchButton")
    public void search() {
        String keyword = keywordBox.getValue();
        List<Persona> result = personaService.search(keyword);
        personaListbox.setModel(new ListModelList<>(result));
    }

    @Listen("onSelect = #personaListbox")
    public void showDetail() {
        Persona selected = personaListbox.getSelectedItem().getValue();
        nombreLabel.setValue("Nombre: " + selected.getNombre());
        apellidoLabel.setValue("Apellido: " + selected.getApellido());
        emailLabel.setValue("Email: " + selected.getEmail());
        editButton.setVisible(true);

    }
    @Listen("onClick = #editButton")
    public void ocultarDetalle() {
        personaListbox.clearSelection();

        nombreLabel.setValue("");
        apellidoLabel.setValue("");
        emailLabel.setValue("");

        editButton.setVisible(false);
    }

    
    
    
    
}
