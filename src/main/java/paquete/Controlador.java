package paquete;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controlador {

    @Autowired
    private PersonaService personaService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/addPersona")
    public PersonaDTO addPersona(@RequestBody PersonaDTO personaDTO) throws Exception {
        Persona persona = personaService.addPersona(modelMapper.map(personaDTO, Persona.class));
        personaDTO.setId(persona.getId());
        return personaDTO;
    }

    @PutMapping("/updatePersona/{id}")
    public Persona updatePersona(@PathVariable("id") Integer id, @RequestBody PersonaDTO personaDTO) throws Exception {
        Persona persona = personaService.findPersona(id);
        personaService.updatePersona(persona, personaDTO);
        return persona;
    }

    @DeleteMapping("/deletePersona/{id}")
    public String deletePersona(@PathVariable("id") Integer id) throws Exception{
        Persona persona = personaService.findPersona(id);
        personaService.deletePersona(persona);
        return "Persona borrada";
    }

    @GetMapping("/getPersona/findId/{id}")
    public PersonaDTO getPersonaId(@PathVariable("id") Integer id) throws Exception{
        PersonaDTO personaDTO = modelMapper.map(personaService.findPersona(id), PersonaDTO.class);
        return personaDTO;
    }

    @GetMapping("/getPersona/findUser/{usuario}")
    public List<Persona> getPersonaId(@PathVariable("usuario") String usuario) throws Exception{
        return personaService.findUsuario(usuario);
    }

    @GetMapping("/getPersona/findAll")
    public Iterable<Persona> getAll() {
        return personaService.findAll();
    }
}
