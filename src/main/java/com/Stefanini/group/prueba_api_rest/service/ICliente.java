package com.Stefanini.group.prueba_api_rest.service;

import com.Stefanini.group.prueba_api_rest.Entity.Cliente;

public interface ICliente {

    Cliente consultarInfo(String numeroDocumento, String tipoDocumento);

}
