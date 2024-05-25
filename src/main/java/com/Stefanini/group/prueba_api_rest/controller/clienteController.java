package com.Stefanini.group.prueba_api_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Stefanini.group.prueba_api_rest.Entity.Cliente;
import com.Stefanini.group.prueba_api_rest.service.ICliente;

@RestController
@RequestMapping("/api")
public class clienteController implements ErrorController{

    @Autowired
    private ICliente clienteService;


    @GetMapping("/")
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("API en funcionamiento");
    }

      @GetMapping("/info")
    public ResponseEntity<?> getClienteInfo(@RequestParam String tipoDocumento, @RequestParam String numeroDocumento) {
        if (tipoDocumento == null || numeroDocumento == null || tipoDocumento.isEmpty() || numeroDocumento.isEmpty()) {
            return new ResponseEntity<>("Tipo y número de documento son obligatorios.", HttpStatus.BAD_REQUEST);
        }

        if (!tipoDocumento.equals("C") && !tipoDocumento.equals("P")) {
            return new ResponseEntity<>("Tipo de documento no válido. Los valores permitidos son 'C' (Cédula) y 'P' (Pasaporte).", HttpStatus.BAD_REQUEST);
        }

        //respuesta correcta
       

        if (tipoDocumento.equals("C") && numeroDocumento.equals("23445322")) {
            Cliente clientInfo =  clienteService.consultarInfo(numeroDocumento, tipoDocumento);
            return new ResponseEntity<>(clientInfo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cliente no encontrado.", HttpStatus.NOT_FOUND);
        }
    }
    

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
