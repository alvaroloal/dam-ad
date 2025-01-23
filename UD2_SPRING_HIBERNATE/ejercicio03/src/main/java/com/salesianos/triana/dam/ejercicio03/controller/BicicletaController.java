package com.salesianos.triana.dam.ejercicio03.controller;

import com.salesianos.triana.dam.ejercicio03.dto.EditBici;
import com.salesianos.triana.dam.ejercicio03.dto.GetBiciDto;
import com.salesianos.triana.dam.ejercicio03.dto.GetBiciMarca;
import com.salesianos.triana.dam.ejercicio03.dto.GetEstacionDto;
import com.salesianos.triana.dam.ejercicio03.model.Bicicleta;
import com.salesianos.triana.dam.ejercicio03.model.Estacion;
import com.salesianos.triana.dam.ejercicio03.service.BicicletaService;
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
@RequestMapping("/bicicleta/")
@RequiredArgsConstructor
@Tag(name = "Bicicleta", description = "Controlador de bicicletas, para poder realizar todas las operaciones de gestión sobre las bicicletas")
public class BicicletaController {

    private final BicicletaService bicicletaService;

    @Operation(summary = "Obtiene todas las bicicletas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se han encontrado bicicletas",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = GetEstacionDto.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            [
                                                  {
                                                      "id": 1,
                                                      "marca": "Ghost",
                                                      "modelo": "TTR29",
                                                      "estado": "Disponible",
                                                      "estacion": {
                                                          "id": 1,
                                                          "nombre": "Estación Central"
                                                      }
                                                  },
                                                  {
                                                      "id": 2,
                                                      "marca": "Specialized",
                                                      "modelo": "Chisel",
                                                      "estado": "Disponible",
                                                      "estacion": {
                                                          "id": 2,
                                                          "nombre": "Estación Norte"
                                                      }
                                                  }
                                            ]
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado ninguna bicicleta",
                    content = @Content),
    })
    @GetMapping
    public List<GetBiciDto> getAll() {
        return bicicletaService.findAll()
                .stream()
                .map(GetBiciDto::of)
                .toList();
    }

    @Operation(summary = "Obtiene una bicicleta por su id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha encontrado la bicicleta",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = GetEstacionDto.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            {
                                                      "id": 1,
                                                      "marca": "Trek",
                                                      "modelo": "RS33",
                                                      "estado": "Disponible",
                                                      "estacion": {
                                                          "id": 1,
                                                          "nombre": "Estación Central"
                                                      }
                                                  }
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado la bicicleta",
                    content = @Content),
    })
    @GetMapping("/{id}")
    public GetBiciDto getById(@PathVariable Long id) {

        return GetBiciDto.of(bicicletaService.findById(id));

    }

    @Operation(summary = "Crea una bicicleta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha creado la bicicleta",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = GetEstacionDto.class)),
                            examples = {@ExampleObject(
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha creado la bicicleta",
                    content = @Content),
    })
    @PostMapping
    public ResponseEntity<Bicicleta> create(@RequestBody EditBici nuevo) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        bicicletaService.save(nuevo));
    }

    @Operation(summary = "Edita una bicicleta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha editado la bicicleta",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Estacion.class)),
                            examples = {@ExampleObject(

                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado ninguna bicicleta",
                    content = @Content),
    })
    @PutMapping("/{id}")
    public Bicicleta edit(@RequestBody EditBici aEditar,
                          @PathVariable Long id) {
        return bicicletaService.edit(aEditar, id);
    }

    @Operation(summary = "Borra una bicicleta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha eliminado la bicicleta",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Estacion.class)),
                            examples = {@ExampleObject(

                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha podido borrar la bicicleta",
                    content = @Content),
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        bicicletaService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @Operation(summary = "Buscar una bicicleta por su marca")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha encontrado la bicicleta",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = GetEstacionDto.class)),
                            examples = {@ExampleObject(
                                    value = """
                                            {
                                                      "id": 1,
                                                      "marca": "Trek",
                                                      "modelo": "RS33",
                                                      "estado": "Disponible",
                                                      "estacion": {
                                                          "id": 1,
                                                          "nombre": "Estación Central"
                                                      }
                                                  }
                                            """
                            )}
                    )}),
            @ApiResponse(responseCode = "404",
                    description = "No se ha encontrado la bicicleta con esa marca",
                    content = @Content),
    })
    @GetMapping("/marca/{marca}")
    public List<GetBiciMarca> findByMarca(@PathVariable String marca) {
        return bicicletaService.findByMarca(marca)
                .stream()
                .map(GetBiciMarca::fromBicicleta)
                .toList();
    }

}
