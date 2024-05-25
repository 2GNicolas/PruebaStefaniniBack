package com.Stefanini.group.prueba_api_rest.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties.RSocket.Client;
import org.springframework.stereotype.Service;

import com.Stefanini.group.prueba_api_rest.Entity.Cliente;
import com.Stefanini.group.prueba_api_rest.model.clienteDao;




@Service
public class clienteServicio implements ICliente{

    @Autowired
    private clienteDao clienteDao;

    @Override
    public Cliente consultarInfo(String numeroDocumento, String tipoDocumento) {
        
        return clienteDao.informacion(numeroDocumento,tipoDocumento);
    }

}
