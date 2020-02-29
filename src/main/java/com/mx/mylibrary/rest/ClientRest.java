package com.mx.mylibrary.rest;

import com.mx.mylibrary.entity.Client;
import com.mx.mylibrary.service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController("apiClient")
@RequestMapping("/api/v1/")
@Api(value = "/api/v1/clients",
     description = "API RESTFul (Representational State Transfer) :: Clients",
     produces = "application/json,application/json;charset=UTF-8",
     consumes = "application/json,application/json;charset=UTF-8")
public class ClientRest {

    @Autowired
    @Qualifier("clientService")
    private ClientService clientService;

    @GetMapping(name = "findAll",
                path = "clients",
                produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "CRUD (Create, Read, Update and Delete) :: Búsqueda de Clientes", response = List.class)
    private ResponseEntity<List<Client>> findAll() {
        return ResponseEntity.ok(clientService.listAll());
    }

    @PostMapping(name = "save",
                 path = "clients",
                 produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE},
                 consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "CRUD (Create, Read, Update and Delete) :: Guardar Cliente", response = Client.class)
    private ResponseEntity<Client> save(@RequestBody Client client) {
        if(client == null || !(client instanceof Client)) {
            throw new RuntimeException("El parametro cliente no es valido, intente nuevamente");
        } else {
            return ResponseEntity.ok(clientService.save(client));
        }
    }

    @PutMapping(name = "update",
                path = "clients",
                produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE},
                consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "CRUD (Create, Read, Update and Delete) :: Actualizar Cliente", response = Client.class)
    private ResponseEntity<Client> update(@RequestBody Client client) {
        if(client == null || !(client instanceof Client)) {
            throw new RuntimeException("El parametro cliente no es valido, intente nuevamente");
        } else {
            return ResponseEntity.ok(clientService.update(client));
        }
    }

    @DeleteMapping(name = "delete",
                   path = "clients",
                   produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE},
                   consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "CRUD (Create, Read, Update and Delete) :: Eliminar Cliente", response = Map.class)
    private ResponseEntity<Map<String,Object>> delete(@RequestBody Client client) {
        if(client == null || !(client instanceof Client)) {
            throw new RuntimeException("El parametro recibido no es valido, intente nuevamente");
        } else if (client.getId() == 0) {
            throw new RuntimeException("El parametro recibido no es valido, intente nuevamente");
        } else {
            Map<String,Object> map = new HashMap<>();
            map.put("eliminado", clientService.delete(client.getId()));
            return ResponseEntity.ok(map);
        }
    }
}
