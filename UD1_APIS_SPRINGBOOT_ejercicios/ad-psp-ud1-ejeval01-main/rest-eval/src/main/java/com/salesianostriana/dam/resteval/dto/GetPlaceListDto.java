package com.salesianostriana.dam.resteval.dto;

import com.salesianostriana.dam.resteval.Place;

import java.util.List;

public record GetPlaceListDto(
        Long count,
        List<GetPlaceDto> items
) {

    public static GetPlaceListDto of (List<Place> places) {

        return  new GetPlaceListDto(
                (long) places.size(),
                places.stream().map(GetPlaceDto::of).toList()
        );
    }
}
