package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class MainController {

    @GetMapping("/hello")
    public String sayHello() {
        return "HOLA MUNDO";
    }

    @GetMapping("/producto/123")
    public Producto getProducto() {
        return new Producto(123L, "Un producto molon");
    }
    

    record Producto(long id, String nombre){}
    
    
}
