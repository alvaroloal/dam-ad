package com.salesianostriana.dam.lorentealmanalvaromonumentos.controller;


import com.salesianostriana.dam.lorentealmanalvaromonumentos.model.Monumento;
import com.salesianostriana.dam.lorentealmanalvaromonumentos.repository.MonumentoRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/monument")
@RequiredArgsConstructor
public class MonumentoController {

    @Autowired
    private MonumentoRepository monumentoRepository;


    @GetMapping
    public ResponseEntity<List<Monumento>> getALL(
            @RequestParam (required = false,
                    value = "maxLat", defaultValue = "-1")double max,
            @RequestParam(required = false, value = "sort", defaultValue = "no")String sortDirection
    ){

        List<Monumento> result = monumentoRepository.query(max, sortDirection);
        //List<Monumento> result = monumentoRepository.getAll();
        if (result.isEmpty()){
            return ResponseEntity.notFound().build();//esto devuelve un error 404, a ido a por un monumento y no lo encuentra
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public  ResponseEntity<Monumento>create(
            @RequestBody Monumento monumento)

    {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(monumentoRepository.add(monumento));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Monumento> getById(@PathVariable Long id){
        return ResponseEntity.of(
                monumentoRepository.get(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Monumento> edit(@RequestBody Monumento monumento,
                                        @PathVariable ("id") Long monumentoId){
        return ResponseEntity.of(monumentoRepository.edit(monumentoId, monumento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Monumento>delete(@PathVariable Long id){
        monumentoRepository.delete(id);
        return ResponseEntity.noContent().build();/*metodo build todo lo que acumula en las llamadas anteriores lo devuelve*/
    }

}
