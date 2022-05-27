package paquete;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonaRepositorio extends CrudRepository<Persona, Integer> {
    List<Persona> findByUsuario(String usuario);
}
