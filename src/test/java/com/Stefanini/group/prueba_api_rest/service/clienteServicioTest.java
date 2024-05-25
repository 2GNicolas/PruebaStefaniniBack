package com.Stefanini.group.prueba_api_rest.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.Stefanini.group.prueba_api_rest.Entity.Cliente;
import com.Stefanini.group.prueba_api_rest.model.clienteDao;

public class clienteServicioTest {

    @Mock
    private clienteDao clienteDaoMock;

    @InjectMocks
    private clienteServicio clienteServicio;

    private Cliente clienteMock; 

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        clienteMock = new Cliente("Juan", "Carlos", "Perez", "Gomez", "1234567890", "Calle 123", "Bogotá");
    }
    
    @Test
    void testConsultarInfo() {
        String tipoDocumento = "C";
        String numeroDocumento = "23445322";

        when(clienteDaoMock.informacion(numeroDocumento, tipoDocumento)).thenReturn(clienteMock);

        Cliente cliente = clienteServicio.consultarInfo(numeroDocumento, tipoDocumento);

        assertEquals(clienteMock.getPrimerNombre(), cliente.getPrimerNombre());
        assertEquals(clienteMock.getSegundoNombre(), cliente.getSegundoNombre());
        assertEquals(clienteMock.getPrimerApellido(), cliente.getPrimerApellido());
        assertEquals(clienteMock.getSegundoApellido(), cliente.getSegundoApellido());
        assertEquals(clienteMock.getTelefono(), cliente.getTelefono());
        assertEquals(clienteMock.getDireccion(), cliente.getDireccion());
        assertEquals(clienteMock.getCiudadResidencia(), cliente.getCiudadResidencia());
    }
}
