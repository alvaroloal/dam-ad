package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

//@RestController
public class MainController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hola Mundooo";
    }

    @GetMapping("/producto/123")
    public Producto getProducto() {
        return new Producto(123L, "Iphone 16 PRO");
    }

    @PostMapping("/producto")
    public Producto nuevoProducto(@RequestBody Producto producto){
        return producto;
    }

    record Producto(Long id, String nombre){}


    
}
