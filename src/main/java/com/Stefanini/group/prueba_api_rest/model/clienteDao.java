package com.Stefanini.group.prueba_api_rest.model;

import org.springframework.stereotype.Component;

import com.Stefanini.group.prueba_api_rest.Entity.Cliente;

@Component
public class clienteDao {

    public Cliente informacion(String numeroDocumento, String tipoDocumento){
            return new Cliente("Juan", "Carlos", "Perez", "Gomez", "1234567890", "Calle 123", "Bogotá");
        
    }

}
