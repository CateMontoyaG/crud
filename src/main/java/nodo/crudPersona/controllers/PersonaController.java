package nodo.crudPersona.controllers;


import nodo.crudPersona.models.Persona;
import nodo.crudPersona.resporitories.PersonaRepository;
import nodo.crudPersona.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = "*")
public class PersonaController {

    @Autowired
    private PersonaRepository _personaRepository;

    @GetMapping("/index")
    public ResponseEntity<List<Persona>> index() {
        try {
            List<Persona> personas = new PersonaService(_personaRepository).index();

            return new ResponseEntity<>(personas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Persona> create(@RequestBody Persona persona) {
        try {
            Persona _persona = new PersonaService(_personaRepository).saveAndFlush(persona);

            return new ResponseEntity<>(_persona, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Persona> update(@PathVariable("id") int id, @RequestBody Persona persona) {
        try {
            Persona _persona = new PersonaService(_personaRepository).update(id, persona);

            return new ResponseEntity<>(_persona, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Persona> delete(@PathVariable("id") int id) {
        try {
            Persona _persona = new PersonaService(_personaRepository).delete(id);

            return new ResponseEntity<>(_persona, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getById")
    public ResponseEntity<Persona> get(@RequestParam("id") int id) {
        try {
            List<Persona> personaList = _personaRepository.findById(id);
            if (personaList.size() > 0) {
                return new ResponseEntity<>(personaList.get(0), HttpStatus.OK);
            }
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getByName")
    public ResponseEntity<List<Persona>> getByName(@RequestParam("nombre") String nombre) {
        try {
            List<Persona> personaList = _personaRepository.findByNombre(nombre);
            if (personaList.size() > 0) {
                return new ResponseEntity<>(personaList, HttpStatus.OK);
            }
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getByApellido")
    public ResponseEntity<List<Persona>> getByApellido(@RequestParam("apellido") String apellido) {
        try {
            List<Persona> personaList = _personaRepository.findByApellido(apellido);
            if (personaList.size() > 0) {
                return new ResponseEntity<>(personaList, HttpStatus.OK);
            }
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getByDocumento")
    public ResponseEntity<List<Persona>> getByDocumento(@RequestParam("documento") int documento) {
        try {
            List<Persona> personaList = _personaRepository.findByDocumento(documento);
            if (personaList.size() > 0) {
                return new ResponseEntity<>(personaList, HttpStatus.OK);
            }
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getByEmail")
    public ResponseEntity<List<Persona>> getByEmail(@RequestParam("email") String email) {
        try {
            List<Persona> personaList = _personaRepository.findByEmail(email);
            if (personaList.size() > 0) {
                return new ResponseEntity<>(personaList, HttpStatus.OK);
            }
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getByEdad")
    public ResponseEntity<List<Persona>> getByEdad(@RequestParam("edad") int edad) {
        try {
            List<Persona> personaList = _personaRepository.findByEdad(edad);
            if (personaList.size() > 0) {
                return new ResponseEntity<>(personaList, HttpStatus.OK);
            }
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getByTipo_documento")

    public ResponseEntity<List<Persona>> getByTipo_documento(@RequestParam("tipo_documento") String tipo_documento) {
        try {
            List<Persona> personaList = _personaRepository.findByTipo_documento(tipo_documento);
            if (personaList.size() > 0) {
                return new ResponseEntity<>(personaList, HttpStatus.OK);
            }
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getByGenero")
    public ResponseEntity<List<Persona>> getByGenero(@RequestParam("genero") String genero) {
        try {
            List<Persona> personaList = _personaRepository.findByGenero(genero);
            if (personaList.size() > 0) {
                return new ResponseEntity<>(personaList, HttpStatus.OK);
            }
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
