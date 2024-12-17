package com.salesianostriana.dam.monumentos.dto;

import com.salesianostriana.dam.monumentos.model.Monumento;

import java.util.List;

public record GetMonumentoListDto(
        Long count,
        List<Monumento> items
) {

    public static GetMonumentoListDto of (List<Monumento> monumentos){

        return new GetMonumentoListDto(
                (long) monumentos.size(),
                monumentos
        );
    }
}
