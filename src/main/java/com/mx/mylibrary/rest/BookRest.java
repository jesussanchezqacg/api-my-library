package com.mx.mylibrary.rest;

import com.mx.mylibrary.entity.Book;
import com.mx.mylibrary.entity.Client;
import com.mx.mylibrary.service.BookService;
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

@RestController("apiBook")
@RequestMapping("/api/v1/")
@Api(value = "/api/v1/books",
     description = "API RESTFul (Representational State Transfer) :: Books",
     produces = "application/json,application/json;charset=UTF-8",
     consumes = "application/json,application/json;charset=UTF-8")
public class BookRest {

    @Autowired
    @Qualifier("bookService")
    private BookService bookService;

    @GetMapping(name = "findAll",
                path = "books",
                produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "CRUD (Create, Read, Update and Delete) :: Búsqueda de Libros", response = List.class)
    private ResponseEntity<List<Book>> findAll() {
        return ResponseEntity.ok(bookService.listAll());
    }

    @PostMapping(name = "save",
                 path = "books",
                 produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE},
                 consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "CRUD (Create, Read, Update and Delete) :: Guardar Libro", response = Client.class)
    private ResponseEntity<Book> save(@RequestBody Book book) {
        if(book == null || !(book instanceof Book)) {
            throw new RuntimeException("El parametro libro no es valido, intente nuevamente");
        } else {
            return ResponseEntity.ok(bookService.save(book));
        }
    }

    @PutMapping(name = "update",
                path = "books",
                produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE},
                consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "CRUD (Create, Read, Update and Delete) :: Actualizar Libro", response = Client.class)
    private ResponseEntity<Book> update(@RequestBody Book book) {
        if(book == null || !(book instanceof Book)) {
            throw new RuntimeException("El parametro libro no es valido, intente nuevamente");
        } else {
            return ResponseEntity.ok(bookService.update(book));
        }
    }

    @DeleteMapping(name = "delete",
                   path = "books",
                   produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE},
                   consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "CRUD (Create, Read, Update and Delete) :: Eliminar Libro", response = Map.class)
    private ResponseEntity<Map<String,Object>> delete(@RequestBody Book book) {
        if(book == null || !(book instanceof Book)) {
            throw new RuntimeException("El parametro recibido no es valido, intente nuevamente");
        } else if (book.getId() == 0) {
            throw new RuntimeException("El parametro recibido no es valido, intente nuevamente");
        } else {
            Map<String,Object> map = new HashMap<>();
            map.put("eliminado", bookService.delete(book.getId()));
            return ResponseEntity.ok(map);
        }
    }
}
