package com.example.demo;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController//esta clase es un bean porque esta anotada con RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;


    @GetMapping
    public ResponseEntity<List<Product>> getALL(
            @RequestParam (required = false,
            value = "maxPrice", defaultValue = "-1")double max,
            @RequestParam(required = false, value = "sort", defaultValue = "no")String sortDirection
    ){
        /*
        * 1. Obtener del repositorio la lista de productos
        * 2. Si la lista esta vacia, devuelve 404
        * 3. Si la lista tiene productos devolver error 200 con la lista
        * */

        List<Product> result = productRepository.query(max, sortDirection);
        //List<Product> result = productRepository.getAll();
        if (result.isEmpty()){
            return ResponseEntity.notFound().build();//esto devuelve u nerror 404, a ido a por un prod y no lo encuentra
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public  ResponseEntity<Product>create(
            @RequestBody Product product)

    {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productRepository.add(product));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id){
        return ResponseEntity.of(
                productRepository.get(id)
        );
    }

   @PutMapping("/{id}")
    public ResponseEntity<Product> edit(@RequestBody Product product,
                                        @PathVariable ("id") Long productId){
        return ResponseEntity.of(productRepository.edit(productId, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product>delete(@PathVariable Long id){
        productRepository.delete(id);
        return ResponseEntity.noContent().build();/*metodo build todo lo que acumula en las llamadas anteriores lo devuelve*/
    }

}
