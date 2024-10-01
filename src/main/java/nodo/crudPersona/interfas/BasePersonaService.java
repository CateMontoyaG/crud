package nodo.crudPersona.interfas;

import nodo.crudPersona.models.Persona;

import java.util.List;

public interface BasePersonaService {

    // Metodos para Leer o Buscar Datos
    List<Persona> index();
    List<Persona> findById(int  id);
    List<Persona> findByNombre(String nombre);
    List<Persona> findByApellido(String apellido);
    List<Persona> findByEdad(int edad);
    List<Persona> findByEmail(String email);
    List<Persona> findByDocumento(int documento);
    List<Persona> findByTipo_documento(String tipo_documento);
    List<Persona> findByGenero(String genero);

    // Metodos para Crear, Actualizar y Eliminar Datos

    // Metodo para crear
    Persona saveAndFlush(Persona persona);

    // Metodo para actualizar
    Persona update(int id, Persona persona);

    // Metodo para eliminar
    Persona delete(int id);
}
