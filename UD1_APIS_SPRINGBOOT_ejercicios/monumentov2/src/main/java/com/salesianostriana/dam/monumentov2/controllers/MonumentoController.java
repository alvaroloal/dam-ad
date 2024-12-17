package com.salesianostriana.dam.monumentov2.controllers;

import com.salesianostriana.dam.monumentov2.models.Monumento;
import com.salesianostriana.dam.monumentov2.models.MonumentoRepository;
import com.salesianostriana.dam.monumentov2.services.MonumentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monumentos/")
@RequiredArgsConstructor
@Tag(name = "Monumento", description = "Controlador de monumentos, para poder realizar todas las operaciones de gestión")
public class MonumentoController {

    private final MonumentoRepository monumentoRepository;
    private final MonumentoService monumentoService;

    @Operation(summary = "Obtener todos los monumentos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se han encontrado monumentos",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Monumento.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            [
                                                {
                                                    "id": 2,
                                                    "countryCode": "ES",
                                                    "countryName": "España",
                                                    "cityName": "Sevilla",
                                                    "latitude": 43.3851,
                                                    "longitude": 4.1734,
                                                    "name": "Estatua Gustavo Adolfo Becquer",
                                                    "description": "Se encuentra en la entrada del parque Maria Luisa junto al gran ficus",
                                                    "image": "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bf/Glorieta_de_B%C3%A9cquer_%28Sevilla%29_02.jpg/1280px-Glorieta_de_B%C3%A9cquer_%28Sevilla%29_02.jpg"
                                                },
                                                {
                                                    "id": 2,
                                                    "countryCode": "ES",
                                                    "countryName": "España",
                                                    "cityName": "Sevilla",
                                                    "latitude": 43.3851,
                                                    "longitude": 4.1734,
                                                    "name": "Estatua Gustavo Adolfo Becquer",
                                                    "description": "Se encuentra en la entrada del parque Maria Luisa junto al gran ficus",
                                                    "image": "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bf/Glorieta_de_B%C3%A9cquer_%28Sevilla%29_02.jpg/1280px-Glorieta_de_B%C3%A9cquer_%28Sevilla%29_02.jpg"
                                                }
                                            
                                            ]
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado ningún monumento",
                    content = @Content),
    })
    @GetMapping()
    public ResponseEntity<List<Monumento>> getAllWithParams(
            @RequestParam(required = false, value = "maxLatitude", defaultValue = "") Double latitude,
            @RequestParam(required = false, value = "sort", defaultValue = "no") String sort) {
        List<Monumento> result = monumentoService.query(latitude, sort);


        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Crear un monumento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha creado el monumento correctamente",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Monumento.class)),
                            examples = {@ExampleObject(

                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado ningún monumento",
                    content = @Content),
    })


    @PostMapping
    public ResponseEntity<Monumento> create(
            @RequestBody Monumento monumento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(monumentoService.add(monumento));
    }


    @Operation(summary = "Obtener un monumento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha encontrado el mounmento",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Monumento.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            {
                                                   "id": 2,
                                                    "countryCode": "ES",
                                                    "countryName": "España",
                                                    "cityName": "Sevilla",
                                                    "latitude": 43.3851,
                                                    "longitude": 4.1734,
                                                    "name": "Estatua Gustavo Adolfo Becquer",
                                                    "description": "Se encuentra en la entrada del parque Maria Luisa junto al gran ficus",
                                                    "image": "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bf/Glorieta_de_B%C3%A9cquer_%28Sevilla%29_02.jpg/1280px-Glorieta_de_B%C3%A9cquer_%28Sevilla%29_02.jpg"
                                            }
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado ningún monumento",
                    content = @Content),
    })
    @GetMapping("{id}")
    public Monumento getById(@PathVariable Long id) {
        return monumentoService.get(id);
    }

    @Operation(summary = "Editar un monumento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha editado el monumento",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Monumento.class)),
                            examples = {@ExampleObject(

                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado ningún monumento",
                    content = @Content),
    })
    @PutMapping("{id}")
    public Monumento edit(
            @RequestBody Monumento monumento,
            @PathVariable("id") Long id) {
        return monumentoService.edit(id, monumento);
    }


    @Operation(summary = "Borrar un monumento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha eliminado el monumento",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Monumento.class)),
                            examples = {@ExampleObject(

                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado ningún monumento",
                    content = @Content),
    })
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        monumentoService.delete(id);
        return ResponseEntity.noContent().build();
    }


}

