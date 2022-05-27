package paquete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonaService {

    @Autowired
    PersonaRepositorio personaRepositorio;

    public Persona addPersona(Persona persona) throws Exception {
        if (persona.getUsuario() == null || persona.getPassword() == null || persona.getName() == null || persona.getCompany_email() == null
        ||persona.getPersonal_email() == null ||persona.getCity() == null ||persona.getActive() == null ||persona.getCreated_date() == null){throw new Exception("Faltan campos imprescindibles");}
        if (persona.getUsuario().length() > 10){throw new Exception("El campo usuario no puede contener mas de 10 digitos");}

        else return personaRepositorio.save(persona);
    }

    public Persona findPersona(Integer id) throws Exception {

        return personaRepositorio.findById(id).orElseThrow(() -> new Exception("Not found"));
    }

    public List<Persona> findUsuario(String usuario){

        List<Persona> personaList = personaRepositorio.findByUsuario(usuario);
        return personaList;
    }

    public Iterable<Persona> findAll() {
        Iterable<Persona> personaList = personaRepositorio.findAll();
        return personaList;
    }
    public void deletePersona(Persona persona) {
        personaRepositorio.delete(persona);
    }

    public Persona updatePersona(Persona personaOld, PersonaDTO personaNew) {

        personaOld.setPassword(personaNew.getPassword());
        personaOld.setName(personaNew.getName());
        personaOld.setSurname(personaNew.getSurname());
        personaOld.setCompany_email(personaNew.getCompany_email());
        personaOld.setPersonal_email(personaNew.getPersonal_email());
        personaOld.setCity(personaNew.getCity());
        personaOld.setActive(personaNew.getActive());
        personaOld.setCreated_date(personaNew.getCreated_date());
        personaOld.setImage_url(personaNew.getImage_url());
        personaOld.setTermination_date(personaNew.getTermination_date());
        personaOld.setUsuario(personaNew.getUsuario());
        personaOld.setId(personaOld.getId());

        return personaRepositorio.save(personaOld);
    }

}
