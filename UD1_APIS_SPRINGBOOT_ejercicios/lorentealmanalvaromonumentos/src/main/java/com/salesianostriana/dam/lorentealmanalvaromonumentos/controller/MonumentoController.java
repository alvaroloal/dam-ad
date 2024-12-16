package com.salesianostriana.dam.lorentealmanalvaromonumentos.controller;
import com.salesianostriana.dam.lorentealmanalvaromonumentos.dto.GetMonumentoListDto;
import com.salesianostriana.dam.lorentealmanalvaromonumentos.service.MonumentoService;
import com.salesianostriana.dam.lorentealmanalvaromonumentos.model.Monumento;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/monumentos")
@RequiredArgsConstructor
@Tag(name = "Monumentos", description = "El controlador de productos, para poder realizar todas las operaciones de gestión")
public class MonumentoController {

    @Autowired // creo una instancia del servicio creado
    private MonumentoService monumentoService;

    // obtener todos los monumentos
    @Operation(summary = "Obtiene todos los monumentos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se han encontrado productos",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = GetMonumentoListDto.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            [
                                                {"id": 1, "codPais": "FR", "nombrePais": "Francia", "nombreCiudad": "Paris", "latitud": 33.33323, "longitud": 21.01212, "nombreMonumento": "Torre Eiffel", "descripcion":"De las torres mas famosas del mundo", "fotoUrl": "https://www.empacher.com/fileadmin/EN/products/racing-boats/racing-four/Steuer_unter_Deck__steering_device_integrated_inside_canvas.JPG"},
                                                {"id": 2, "codPais": "ES", "nombrePais": "España", "nombreCiudad": "Sevilla", "latitud": 33.33323, "longitud": 21.01212, "nombreMonumento": "Torre del Oro", "descripcion":"La usaban para transportar el oro que venía en barcos", "fotoUrl": "https://www.empacher.com/fileadmin/EN/products/racing-boats/racing-four/Steuer_unter_Deck__steering_device_integrated_inside_canvas.JPG"},
                                            ]
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado ningún monumento",
                    content = @Content),
    })
    @GetMapping
    public List<Monumento> getAllMonumentos() {
        return monumentoService.getAllMonumentos();
    }


    // obtener por id
    @Operation(summary = "Obtiene todos los monumentos por su id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se han encontrado productos con el id indicado",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = GetMonumentoListDto.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            [
                                                {"id": 1, "codPais": "FR", "nombrePais": "Francia", "nombreCiudad": "Paris", "latitud": 33.33323, "longitud": 21.01212, "nombreMonumento": "Torre Eiffel", "descripcion":"De las torres mas famosas del mundo", "fotoUrl": "https://www.empacher.com/fileadmin/EN/products/racing-boats/racing-four/Steuer_unter_Deck__steering_device_integrated_inside_canvas.JPG"},
                                                {"id": 2, "codPais": "ES", "nombrePais": "España", "nombreCiudad": "Sevilla", "latitud": 33.33323, "longitud": 21.01212, "nombreMonumento": "Torre del Oro", "descripcion":"La usaban para transportar el oro que venía en barcos", "fotoUrl": "https://www.empacher.com/fileadmin/EN/products/racing-boats/racing-four/Steuer_unter_Deck__steering_device_integrated_inside_canvas.JPG"},
                                            ]
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado ningún monumento con ese id",
                    content = @Content),
    })
    @GetMapping("/{id}")
    public ResponseEntity<Monumento> getMonumentoById(@PathVariable Long id) {
        Optional<Monumento> monumento = monumentoService.getMonumentoById(id);
        if (monumento.isPresent()) {
            return ResponseEntity.ok(monumento.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    // crear nuevo monumento
            @Operation(summary = "Crear un monumento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha creado correctamente",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = GetMonumentoListDto.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            [
                                                {"id": 1, "codPais": "FR", "nombrePais": "Francia", "nombreCiudad": "Paris", "latitud": 33.33323, "longitud": 21.01212, "nombreMonumento": "Torre Eiffel", "descripcion":"De las torres mas famosas del mundo", "fotoUrl": "https://www.empacher.com/fileadmin/EN/products/racing-boats/racing-four/Steuer_unter_Deck__steering_device_integrated_inside_canvas.JPG"},
                                                {"id": 2, "codPais": "ES", "nombrePais": "España", "nombreCiudad": "Sevilla", "latitud": 33.33323, "longitud": 21.01212, "nombreMonumento": "Torre del Oro", "descripcion":"La usaban para transportar el oro que venía en barcos", "fotoUrl": "https://www.empacher.com/fileadmin/EN/products/racing-boats/racing-four/Steuer_unter_Deck__steering_device_integrated_inside_canvas.JPG"},
                                            ]
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha creado ningún monumento",
                    content = @Content),
    })
    @PostMapping
    public ResponseEntity<Monumento> createMonumento(@RequestBody Monumento monumento) {
        Monumento nuevoMonumento = monumentoService.createMonumento(monumento);
        return ResponseEntity.status(201).body(nuevoMonumento);
    }


    // actualizar monumento
    @Operation(summary = "Actualizar monumento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se han actualizado el monumento",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = GetMonumentoListDto.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            [
                                                {"id": 1, "codPais": "FR", "nombrePais": "Francia", "nombreCiudad": "Paris", "latitud": 33.33323, "longitud": 21.01212, "nombreMonumento": "Torre Eiffel", "descripcion":"De las torres mas famosas del mundo", "fotoUrl": "https://www.empacher.com/fileadmin/EN/products/racing-boats/racing-four/Steuer_unter_Deck__steering_device_integrated_inside_canvas.JPG"},
                                                {"id": 2, "codPais": "ES", "nombrePais": "España", "nombreCiudad": "Sevilla", "latitud": 33.33323, "longitud": 21.01212, "nombreMonumento": "Torre del Oro", "descripcion":"La usaban para transportar el oro que venía en barcos", "fotoUrl": "https://www.empacher.com/fileadmin/EN/products/racing-boats/racing-four/Steuer_unter_Deck__steering_device_integrated_inside_canvas.JPG"},
                                            ]
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha actualizado el monumento",
                    content = @Content),
    })
    @PutMapping("/{id}")
    public ResponseEntity<Monumento> updateMonumento(@PathVariable Long id, @RequestBody Monumento monumento) {
        if (monumentoService.getMonumentoById(id).isPresent()) {
            Monumento monumentoActualizado = monumentoService.updateMonumento(id, monumento);
            return ResponseEntity.ok(monumentoActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
    // eliminar monumento
    @Operation(summary = "Eliminar un monumento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha eliminado correctamente",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = GetMonumentoListDto.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            [
                                                {"id": 1, "codPais": "FR", "nombrePais": "Francia", "nombreCiudad": "Paris", "latitud": 33.33323, "longitud": 21.01212, "nombreMonumento": "Torre Eiffel", "descripcion":"De las torres mas famosas del mundo", "fotoUrl": "https://www.empacher.com/fileadmin/EN/products/racing-boats/racing-four/Steuer_unter_Deck__steering_device_integrated_inside_canvas.JPG"},
                                                {"id": 2, "codPais": "ES", "nombrePais": "España", "nombreCiudad": "Sevilla", "latitud": 33.33323, "longitud": 21.01212, "nombreMonumento": "Torre del Oro", "descripcion":"La usaban para transportar el oro que venía en barcos", "fotoUrl": "https://www.empacher.com/fileadmin/EN/products/racing-boats/racing-four/Steuer_unter_Deck__steering_device_integrated_inside_canvas.JPG"},
                                            ]
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha eliminado el monumento",
                    content = @Content),
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMonumento(@PathVariable Long id) {
        if (monumentoService.getMonumentoById(id).isPresent()) {
            monumentoService.deleteMonumento(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


