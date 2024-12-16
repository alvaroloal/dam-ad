package com.salesianostriana.dam.lorentealmanalvaromonumentos.dto;



import com.salesianostriana.dam.lorentealmanalvaromonumentos.model.Monumento;

import java.util.List;

public record GetMonumentoListDto(
        Long count,
        List<Monumento> items
) {

    public static GetMonumentoListDto of (List<Monumento> items) {
        return new GetMonumentoListDto()(
                (long) items.size(),
                items;
        );
    }

    public List<Monumento> to() {
        return items;
    }


}




