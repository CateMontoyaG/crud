package nodo.crudPersona.services;

import nodo.crudPersona.interfas.BasePersonaService;
import nodo.crudPersona.models.Persona;
import nodo.crudPersona.resporitories.PersonaRepository;

import java.util.List;

public class PersonaService implements BasePersonaService {

    private PersonaRepository _personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        _personaRepository = personaRepository;
    }

    // Metodo para Treaer todo
    @Override
    public List<Persona> index() {
        return _personaRepository.index();
    }

    // Metodo para crear personas
    @Override
    public Persona saveAndFlush(Persona persona) {
        return _personaRepository.saveAndFlush(persona);
    }

    // Metodo para actualizar personas
    @Override
    public Persona update(int id, Persona persona) {
        List<Persona> personaList = _personaRepository.findById(id);
        if (personaList.size() > 0) {
            Persona personaUpdate = personaList.get(0);

            personaUpdate.setNombre(persona.getNombre());
            personaUpdate.setApellido(persona.getApellido());
            personaUpdate.setEdad(persona.getEdad());
            personaUpdate.setEmail(persona.getEmail());
            personaUpdate.setDocumento(persona.getDocumento());
            personaUpdate.setTipo_documento(persona.getTipo_documento());
            personaUpdate.setGenero(persona.getGenero());

            return _personaRepository.saveAndFlush(personaUpdate);
        }
        return null;
    }

    // Metodo para eliminar personas
    @Override
    public Persona delete(int id) {
        List<Persona> personaList = _personaRepository.findById(id);
        if (personaList.size() > 0) {

            Persona personaDelete = personaList.get(0);

            _personaRepository.delete(personaDelete);

            return personaDelete;
        }
        return null;
    }

    // Metodos de busqueda por
    @Override
    public List<Persona> findById(int  id) {
        return _personaRepository.findById(id);
    }

    @Override
    public List<Persona> findByNombre(String nombre) {
        return _personaRepository.findByNombre(nombre);
    }

    @Override
    public List<Persona> findByApellido(String apellido) {
        return _personaRepository.findByApellido(apellido);
    }

    @Override
    public List<Persona> findByEdad(int edad) {
        return _personaRepository.findByEdad(edad);
    }

    @Override
    public List<Persona> findByEmail(String email) {
        return _personaRepository.findByEmail(email);
    }

    @Override
    public List<Persona> findByDocumento(int documento) {
        return _personaRepository.findByDocumento(documento);
    }

    @Override
    public List<Persona> findByTipo_documento(String tipo_documento) {
        return _personaRepository.findByTipo_documento(tipo_documento);
    }

    @Override
    public List<Persona> findByGenero(String genero) {
        return _personaRepository.findByGenero(genero);
    }
}