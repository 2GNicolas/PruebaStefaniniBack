package com.Stefanini.group.prueba_api_rest.controller;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.Stefanini.group.prueba_api_rest.Entity.Cliente;
import com.Stefanini.group.prueba_api_rest.model.clienteDao;
import com.Stefanini.group.prueba_api_rest.service.clienteServicio;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class clienteControllerTest {

     @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private clienteServicio clienteServicio;

    @Mock
    private clienteDao clienteDaoMock;

    private Cliente clienteMock; 

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        clienteMock = new Cliente("Juan", "Carlos", "Perez", "Gomez", "1234567890", "Calle 123", "Bogotá");
    }

    @Test
    void testGetClienteInfo() throws Exception {
        when(clienteServicio.consultarInfo("23445322", "C")).thenReturn(clienteMock);
        mockMvc.perform(get("/api/info")
                .param("numeroDocumento", "23445322")
                .param("tipoDocumento", "C")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.primerNombre").value("Juan"))
                .andExpect(jsonPath("$.segundoNombre").value("Carlos"))
                .andExpect(jsonPath("$.primerApellido").value("Perez"))
                .andExpect(jsonPath("$.segundoApellido").value("Gomez"))
                .andExpect(jsonPath("$.telefono").value("1234567890"))
                .andExpect(jsonPath("$.direccion").value("Calle 123"))
                .andExpect(jsonPath("$.ciudadResidencia").value("Bogotá"));

                
    }


}
