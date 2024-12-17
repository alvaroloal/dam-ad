package com.salesianostriana.dam.monumentos.controller;

import com.salesianostriana.dam.monumentos.dto.CreateMonumentoDto;
import com.salesianostriana.dam.monumentos.dto.GetMonumentoListDto;
import com.salesianostriana.dam.monumentos.model.Monumento;
import com.salesianostriana.dam.monumentos.service.MonumentoService;
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
@RequestMapping("/api/monumento")
@RequiredArgsConstructor
@Tag(
        name = "Monumento",
        description = "Controlador de monumentos, para poder realizar todas" +
                " las operaciones de gestión"
)
public class MonumentoController {

    private final MonumentoService service;


// Método para cargar todos los monumentos (como request param tiene el atributo orden,
// que si se escribe asc se ordenará por nombre en orden ascendente y si se escribe desc se ordenará
// por nombre en orden descendente
    @Operation(summary = "Obtiene todos los monumentos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
            description = "Se han encontrado los monumentos",
            content = {
                    @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = GetMonumentoListDto.class)),
                    examples = {
                            @ExampleObject(
                                    value = """
                                                {
                                                    "count": 2,
                                                    "items": [
                                                        {
                                                            "id": 1,
                                                            "codigoPais": "ES",
                                                            "nombrePais": "España",
                                                            "nombreCiudad": "Úbeda",
                                                            "latitud": 38.00782957506695,
                                                            "longitud": -3.3677859448302137,
                                                            "nombreMonumento": "Plaza Vázquez de Molina",
                                                            "descripcion": "Illo un sitio to wapo, no hay más",
                                                            "photoUrl": "https://www.vandelviraturismo.com/wp-content/uploads/2020/09/plaza-vazquez-molina-en-ubeda-768x512.jpg"
                                                        },
                                                        {
                                                            "id": 2,
                                                            "codigoPais": "ES",
                                                            "nombrePais": "España",
                                                            "nombreCiudad": "Úbeda",
                                                            "latitud": 38.01075927702061,
                                                            "longitud": -3.3676329907672184,
                                                            "nombreMonumento": "Casa Mudejar (Museo de Arqueología)",
                                                            "descripcion": "Illo un sitio to wapo, no hay más",
                                                            "photoUrl": "https://www.spain.info/.content/imagenes/cabeceras-grandes/andalucia/m_arqueologico_casa_mudejar_ubeda_t2300373.jpg"
                                                        }
                                                    ]
                                                }
                                            """
                            )
                    })
            }),
            @ApiResponse(responseCode = "404",
            description = "No se ha encontrado ningún monumento",
            content = @Content)
    })
    @GetMapping
    public GetMonumentoListDto findAll
            (@RequestParam(required = false,
            value = "orden",
            defaultValue = "no")
             String orden) {

       return GetMonumentoListDto.of(service.findAll(orden));
    }

    @Operation(summary = "Obtiene un producto por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
            description = "Se ha encontrado el producto",
            content = {
                    @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Monumento.class),
                    examples = {
                            @ExampleObject(
                                    value = """
                                                {
                                                     "id": 1,
                                                     "codigoPais": "ES",
                                                     "nombrePais": "España",
                                                     "nombreCiudad": "Úbeda",
                                                     "latitud": 38.00782957506695,
                                                     "longitud": -3.3677859448302137,
                                                     "nombreMonumento": "Plaza Vázquez de Molina",
                                                     "descripcion": "Illo un sitio to wapo, no hay más",
                                                     "photoUrl": "https://www.vandelviraturismo.com/wp-content/uploads/2020/09/plaza-vazquez-molina-en-ubeda-768x512.jpg"
                                                }
                                            """
                            )
                    })
            }),
            @ApiResponse(responseCode = "404",
            description = "No se ha encontrado el monumento deseado",
            content = @Content)
    })
    @GetMapping("/{id}")
    public Monumento findById(@PathVariable Long id) {

        return service.findById(id);
    }

    @Operation(summary = "Crear un monumento nuevo")
    @ApiResponse(responseCode = "201",
    description = "Se ha creado un monumento nuevo",
    content = {
            @Content(mediaType = "application/json",
            schema = @Schema(implementation = Monumento.class),
            examples = {
                    @ExampleObject(
                        value = """
                                    {
                                         "id": 1,
                                         "codigoPais": "LT",
                                         "nombrePais": "Lituania",
                                         "nombreCiudad": "Vilna",
                                         "latitud": 1.23112,
                                         "longitud": 12.1212132,
                                         "nombreMonumento": "Tres Cruces",
                                         "descripcion": "Las Tres Cruces es un monumento en Vilna, Lituania, diseñado por el arquitecto y escultor polaco-lituano Antoni Wiwulski en 1916. Fue demolido en 1950 por orden de las autoridades de la Unión Soviética. Un nuevo monumento diseñado por Henrikas Silgalis fue erigido en su lugar en 1989.​",
                                         "photoUrl": "data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/4QAqRXhpZgAASUkqAAgAAAABADEBAgAHAAAAGgAAAAAAAABHb29nbGUAAP/bAIQAAwICDQ0KCwoLCgoKDQ0KCgoLCgsKCgoKCgoLCgoICgoKCgoKCgoICAoKCgoICggKCgoKCgoICgsNCggNCAgKCAEDBAQGBQYKBgYKDQ0KDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0NDQ0N/8AAEQgAoADVAwERAAIRAQMRAf/EAB0AAAICAwEBAQAAAAAAAAAAAAUGBAcCAwgBCQD/xABEEAACAQIEAwUFBgQFAwIHAAABAhEDIQAEEjEFBkEHEyJRYTJxgZGhCCNCscHwFFLR4RYzYnLxFUOCosIXJERzdJKT/8QAGgEAAwEBAQEAAAAAAAAAAAAAAQIDAAQFBv/EAC8RAAICAgIBAwIFAgcAAAAAAAABAhEDIRIxQQQTUSJhMnGRobHB8QUUFTOB0fD/2gAMAwEAAhEDEQA/AOieaezQd5qIAP8A6SOo/WMdSl5RwyjToROZuycoy1AZ2ggwYPQ9MdMcvhk2iBzZ2bswV1EmL26+Z9+OuM6EasRs3lAE0skwfcVPmJ3Hpi6lZJo08M5fqM6qvmCIsSDH5dY+WC5JdmSbLW4Dxk5epoqb2GwBA8wTePpAxxS2tF0SuIcSNfvFtUeaZRySWUEmQDaQPIg2PpiUbh30M9lX8T5ifL1moEgzNpk3tB67mYj547Ix5Ci7U5ccVe9IGosobYFlFxpUdBf2oxXmuiagEeO88PQr06VNrOVqQGiEhgwPSWIm1rbA4VQUlYzk06D3C+U++rvXSopSFOg3qErMqFjcESDuREdcK5VqhqTdhXlfia0++jUyvJiIZWPtDr6m8Ym05bHFPMVFqZhdLABdpTxVB62jwnwsCR8ZtRdCtWx15b5QM1KhABcaQBAAA3sPOB8sRcgqJvGXKKYBg+gi2/8ATAuw0SOHcDZqTGIUEG/v8/LGugcfIs8Re8A29Pfii2GKJJrYA6NCoLyb4IbFDi2U3K/XFkJJWZ8F5VZhJt19YwzkiZKzPLUGw2F8C0xQLXyRk9cYxAzeV9MYx5R4QTvMC+EbClZE/wClkmAMayqjQ48L5eaLjy88SchjuDj3Dw1SSpEm46TtPxx4sHobJ2KvMfNOXpaqLkk7g+ELHlqJ3PT1xdJsnryAf8TKEFRB4SdmEG3kZgn0E+fpilSNaEfiXC6NUM4VidR1RcRG5FoM2iPj52i5rsRpMgcsZYUi90ImUDe0D1gm4O0QenqcW5X0BIaOJ5ilmhTbSNQ8JeBMj8L9Y8tj1FrY5+co9oerBPMfZJUor/E5dmqKB94FMsi3OoD8QWCxFzF4scMsyemO8TStFUc6ZPWDVVVZ5BVr6gd7RtPp546YkWht7P8AjOvLFGVdYDJ7BJM9ZJ8/2ek5OtjxjehZzXZs1RnWqgLICy1VMMt5jSdpFmRgfMeeKwyV0F42u0Z8o1HptpJCk3DKkhxtYSNJA3tfGm09iosDPcqUe479X0O3tkSQTYaoLWO5iAPzM02mMUzwCqz1x4hKsVkXkk76Zsdt7HHSxVtlzJzGikKSS25PQydhHkN8cnFjhrN8UBOkARO9tom39cToZAjinGIUoxO/hEfh6f8AOKJCN6FhKIw1gVkHiWZGwwVY4LqZnD0YzyxHUWwxhry/FFJUQFG04kTaM81ldRIQSo3I/T0xrok0A+I8BP8AKB5DqcU5mI9blqwMR+eNyCjTRygHtWHl5/vywjl8FVo2ZTMIGhUg+c4XYxYPBsgmmXInoAbj37b4QTR0xzjWDqxp+R2HUdJFjjyMeuzqyrycj9oXB9ctpYFbEeV7Eenp6749XCzjmgJwbIkLPeOQpClWJIuZiJsfL3dMdLaJpDXwVqtJvDpdXYBltqjcgbefw+ImTplEqDdTg6V50EQJ8GzA+6RqkkXB6+mOdNwf2HqwPT5eqZZzKsJvMRHwNwfLBnOMkHi1sdcl2yGnCMszENuLiPEuxF/zxH229pFVlrsHc7cJpVxqpqtNx7YUaQ5gaWUbAggmYv67kwyOJpVLfk1cocrKCj/5R2qaY0tYjUBHgc9YMSNr4M8jkqGxpWOvHuAUlVaoIeppMk2MRqBN4ZiN5E29cSRaTSKwyvCKTFqg8Mh/B5MRcwPZveAYItYbdcZN6Zx0hU4eah1UhBAHXqfT3/Qb46VS2wIg8I5Oaj3tVgVMEiIsxaBBBMxO9tsNyTMluyXwThf43JFxpG8mZ28vXAYaGrhudBBXTF7Gb/3xNjAHO0yTJM3xkJRjWpzGAzIC8SyJw8WhjGlkI3w3JGCYygAA8/ywtsFjLyhyS1ZyAIQbtF9vLf0+uElKhasdm4OqKKKEAk+5iF3MHzNoNx5CcSbDxSN9blumAamw0/iMkHrHr0xrNxRV3Gc1DHyF8WXRNCZneIg4qkFs1cK4npYTf3/vfAkqHW0PT8apjzM+uJ0LxL0yHaQMvRqsF1kvFTVMbG4kWbqPfOPMWPkXeR+SnOK8QFXVVRyJJta3p/fHfCLj2c8nYr8P5xVKjB01TY7QT0Pv9fhi/GxE6LK5R4mtZVUAFtZa4+hvJ9/piE7S0VWxz/8Agp4C6sUYSTHv2v1GOR5G9M6liRI4JmNSnL1FNSCQKjpcqRpiY6G4IsNPzQsKvEuz/u6jAoWABi0Aj0K7EWthuT6sjwS2kJvGqzqyQWUA3H49NouLEbgmDt62tiipdkJt2beHcQbWwnRqCtpJkk2AN9j+LyjyxWUIImmwVnuNVlYBwxOrRAkzPs6Y6HafXpMYMYx7QXJ+Rt4VWpim2mVYDSwNzMzf4WJt/UU7+w1o0LwAjx01PiEnr9ff54LYKBfEOGliFLX/AJbx+gn34ZNIYcs72aN3VO4BMkyIIiw3i5F8J7qsaiHR5OKDxkbSCL29fLB5oFAWry6PPBsVqyMOGDYfTGs1GH/SwT4jHvxrMlRjxfJKAIIA62ufccFGETjvFtNUqpsAL/Cf1xZRsC62HeWO0NqSsUMFtz1P9MTcbFtplwcvtRenTqO5asbzYaQTJMn5e7HNK10VVAfn7KvqVVMqb72xSNE5pvop/mauyMVZTB2PT9+mOmOwREyuCo1E2k9cVGpEZeZlid/LAoJOp1Ge4aMZJBOmeLcMbUUIIDGJi1z5evz/AF8mMqY0o0IfG+zwoW0FluZnY/K2O2OSyLiVpzJyw5JvpgjaSfX346oyRzyix17J6dSnVJDiQuqYmVjcT+K1xvfbfEcjTLQs6CqdqCJSbXLNsFU6RB3Jm0+UY8723Z2e6VvlOftFYMAk6pBM6ihgFLGIj0g+mK+y6FWX5OneTuZ8vmKYQQHbxBSBMxsGgwYmxM+/HDOMos6E0+it+0LsuuX9oqT4dMW3j3fT9GhOwNJ9lbVuAVDcUfFYAxYjYqDIhonf9cVs5uL+AnmeUQy6SxpupcjVvIFlDXkzYHYgj3l4yphcHQu8oZLSai1gF3ZnYCALySZhV0ySTaBfa1pzVaJpbLI4TlFDJTDCWBKDUAXUAaioPtKARqIkDUJiRjkspTM24XTTvaroqimr1GYA2VAahOn8RABNt4w3JhirEXlb7Q2RztYUMvXqVKjBmRKmVzdGyoXbxVqFNCVUEka56QdsTUk2O40FuIq03n+2OtEyG6WNsMhWLeZqlXBifT99cOkTboGcb4qJmPhGHUQNipxbiBve+3uxRIyEyrTJa5JHni/QzHbgfLGqmb6TAKgjf4453LYrVkbjeYqUrMQQRupMgev+nBpMm7QR4bziSqoakgDwsbHbYX2/fXCuIOTBPOdRqgbSYgTbb6flh49jRZSfHOKt/lubD9jHZGK7Ec2FeS6SEmbiN5+nUfr7sJPRWErGvO8UEjQgAj+b+wxMc7YzWZVhJHXY48Q6JyTFXmNVPT5fqfP1xXH2SZVnNmVjbxeYif8Ag+7HbFkZAbLZx1A0G0HfcYcnyA/MPGWcBVJZosP3YYaKQHKxSqPVJCtqWDvBPusNwdrTi/0ibLi7Leayj/eOaYEffLJAIupBgeING4mPhPHlxqR1Rm0Xx2NfaC/ic22SqRmCZZa1OJUBQDrW33UgksNibgyMedlwOK5HRDLydFg88cs6FZ0AFxIHtfCOnyxCEvDOgpTmXJ1NUm8mQevuPrH0x0I5pXeyqvtWcMrjhbvRytfNsXTvKVBQzCmqu5crIZ6auqBgiuwkHQQHKynfgrBaOF+SO0Y1ly1VKp7zKIlLLVJ05jKUlNRlpIwutL7xgBcFB3ctTUIvP0ULu4jx7jmYZs9TyWeag9NdeYy+Z7jLvTp01o1Kv8KtUFhCMagFOGYPpUAhQaZhU4FzNXy1Tv8AJpmHrBSqplaIr12RoDhKRVgwC+NrWRSbRgL7GOiOx7t1rvw6tmM3SzT1f41ssi5mimVemRlqNXS6qinTJZxpVixYjUoHhqsjQjijHl/toqoMyaypVLGmcsipoWmSrCqKjSS1IEU2RYNQlqgNQAoUb3mDgM/Z/wA5tmssldkVX1VaVQD2ddGq9BmUEsVR9HeqpZiquAWJBJ7ITtEJKmMrcGkyALX23gTt9fLFbEoSuIcos1RtciZvFsVUhaYt8Tyy0iIhv90GIj4YdC34PW5+WIDAmDvYD/jG4gsXePcYcUy7MSNpCmD6EkDy9cNFeAFdPzMWMnodhv8A2x0cKJSew/luenkBRC+oPx+OFcDKQVy/B0rNrKQPUCPWNsblxKfi2Z8W4JSQALJP8uwjpt09P641tlFoROK8WfVAsPKMXSIub8H0TqcpVggf7tlI1aVqHUB7mA+hYx5Y+Z5Lo73FoV+I51AdLhhNvj9cWgm+hLBOeyNAqbNq8/T3f846UJoU+L8stp1AWi0eWKKQrVoQc5kipJW3qBi0X4Odpoj5Pmlg33kFQeoFvUdcHiFS+RndUddtaEG4Nwenui8Ejy9MKUE/LcDelmUrUNQIiND93UEASRp21XJ6mY64d/UqZNKnaO2OTu2ulVo0zmKtOnVK6XSpNNiwABPVQDc3IkkiLRjxsmBp6R6Mcia2bON8G7095T+8QQV0HUu0bgkiPLpgJ12GS5bRFyfCnj2TvNx9P774OhEmuj5ffad4XQy/Hc/UVUpd/mAIRQqKaWXy61iQLBnzBq1ajwNT1CWvfHLKrOgYfs2dvVelmcxwwVGWjUyefqtRqISrKOHZjMLXyzGDSJqIqtpPdvclWYq6FMwZ+yzxYDjORgAamzCWt/8AR5hot/twIswe5y+042frrl3qUlKKa4y1Pxd3AVNVSoQW1gVYCkoCGJFO04zdmE7J8h/x/EkyNTN1qFAZOrmalKgQlSs9OvRpaGqaSyUytYF1BkgWEksrRViSdHWPZ52ZUMplf4XKU+5pIzFU1VavifxM2uo7vcmSCYHQCIx3QiokG77ICc7mjUuoI2mDFvTF+Nok5qPYeo9q9NiSVXVMzpBG2mLdB5RHlhPba8hU0yt+0blig8slUUwRMT19B0GOmEmhWl2UtxXkNhDJBE2IMn3x5fDHWpryRSphnJUZTu3YsIuG29wj6Yk+9DAzimYy2WUMFLNfc6r9ALb4ZcpCy+WSuBv3wNaoBSTcAjxN/tG3lc/XGbrQq2OXDeYERIUah5Ej4eoB6/2xPi2GxG4rzzSDlmKCJtP6eXri8YMHL5FDiPaLQLEs0n02/LFVCQjkjrql28uyKlJ3VVB9phf36RFxaOnmbY8l+mS7Op5gVmOfHYy0H3Ww6xpCe4aqfNqkgTfD0FTTHvl/mA6HSQxgQLEi/wAxb/jEpKiyYpcw8IUtAEH6T1w6FEXm3lbSJFx+74tGRGUfKIHKfERTN5gjbpEgnDNCxYVqUnOYWrSGpVgkzc9Tbyiwwtjkrn3mNK1UP7NgBB/Cu1oEfDefnkgNlj9k/NFagr1aYeuvdmKCCWqNIVEuVCktHjdlRRLMyqrFZ+zDJJRbS+76X3/tv4VlFNwVpX9l5L/7PeaWqqy1qL5Z7O1N2RiEYSrh6bPScWIYI7FSpBiRPD6rBHG/okpL5V1+6T/Yvhyua+pNP4df0bX7nxn+1FxXvM+1YGRUzHEKwPmK2ZWov02x5zOo705MoU6PJIzS0qRrf4adWraE71qS5WtVSkamnWaas7sqElVLsQssZvWhL2cnfZdzx/63wv8A/JYf/tlsxS+uqMSj2F9HUX2keyPK5Dhlb+CytHKd5nKVWoaK6CzVCwIm5RBMJSQrTQGEVQcUnFJATOb/ALPnHO749kLCK1PO5ZvTXQOZU+vjyyrFvbmfDBSD2CfR9DcyO6hwgckezGkWkRq1SYJvPn7sdJEWuMZShXpw6d08mY06SVFpECJMX2v1i9IzaFasQs92LjUCtYICbtrU6bdVFyOn16Yv7/ySeJETP9kz7KTVAjxhbAncXtHWbTO2CsyDwINTgr0GhQjNF2YDSoi8za07dTiqlZqoUOZe7KsA66r+IKPh4bD64rEVlT5TlQiujvUWoACSCoifRW1Rv1m95FsdTeuiLWyyDlUNMEkQAICgD3WAAHlAxyjeCnecOZShZaaOWJMAyfSRbbzvGO6Eb7JSdATL9lTVm7ytVKLCkoEKkncjUWIKzb2fXD+6o9ITg3tsdeMcmUHK6qNIwoA6AegAIt8/h1kpv5KOKY0cvc0MdgY6kCfn0xSeNC2WDwDOBiA1p2J6nyxwSVDLY5Z3haU11fiKm4gR9L/A2xOzo4qOxAoc+9zUPduVJsWIB1XnqCIxVY77Ft+Bi5e7R9bhaoDtNnEySdgYtpO0wCMLLHXQyl8jfnM+j0mDqpYf6goFrb7+cDyxJJoo2ineZuAgqGV4YGRHl5zt8MXiznkkgdwXmGpTdUDbHqJDD19IxVxTViJtGjjOXZtVRREEnR0iTdd7WuOhwVXQBo7O+1U6NMx0O4kf26HEp4h1Oh+pds7LTqMGKinTqP6jSjN8jF8ceWFRLRnbo+c/a4D31Jf5aCn5u4/9ox4z7PQ8HalLjrjkvSD4f8PlSOkNlCPnf347aXAg2+Ry12Ncb7riPD6k6YzuVUGJg1KyUAY6iXE3xyY/xL8ysumdvfaq40z8IruzhtNfJiFk+1maVIEzcGXvEgDrYnHb6hLjo58cnezjHlXi/d8T4TW6LxTKK94+7q1P4d79BoqtPui0yPPi9nU1Z9fOaOAUhTVKysoBJAUQJMAy3WYE7QOuLxbZFpLRX3GeSKABKVWW3skAievrtiqZNikOMJT8I0sINjefOQbAeUj9MOotgbK+5w7cAv3aFUG2keEGfQfrjqx4PLJPJXRU3MnPbMJZ4BNoMz8tvpjtjjJOYtVc1qIkwOpAkj9+uLJJCOTB/GOLqCAmpgNz1Pqb/liijYrZAPOjGw0rHUwcH2zchky7g6W71NhIAkN5hTAv+4xJpjG/iOZuD0i398KEWM9lGJm+HTQA5yxxICkgc6TcEed4v69ZxebtaFQ35bnSkgJ1A6eh6/D6Y53jbDZF4723u1HRo0rJEjr6bG3X4dMBYDcinObe0+nMAtOwkiPpE+6BGO7HgYspjPyHz0WI0i9hP7OFyY67HUrLYOZqGBJgjzuekTuN7RjhaSHtjPz1yOpoUhQJZ2Ex/LYTbdgPdffEoy3sZxErkrkKq9Z9eo6DoJGwfa4N+hEASAMWnkVaBxvwXRy92S6w1NQCNDX0m5FyBIA36Xgg+eOR5Nj+3opnjPZlWpVDCeGQJF7+VuvmPXHUsiaOdwaAHO2YqUSKRCqr0S7GdTFJdGWPwCFMm5abFYM+V6rM74ro68GNds5P4iHc6qjFjpCgm5CglgCYBJBY3JJ9eg8ytnbLo6m7WuNvS5Q4VTpuyDMZfJUammPvKLZGo9Sm0gyjEJOxtvi8nUSaX1HNmWldLqdLJUp1EcRKVKdRalNgGBUlXVWhgVJEEMCQeVSdljsjnVHq8uLmKjEtUocOrNYCXatlmYkAAA6iTYADoBjulLljV90jjSqWjl3jfL5qKoDMhDo6ssalZGFRWEgiQygyQR6HHD5Ow+jX2ePtI0+K0KqVPuM5lii5qkCRQcVCwpZjLlyxFKsUYdw9RqlBlKE1l7uvWvBkJRoZ+e+TasErBgSfEA220AiZ88dMWr2SaZQnOnLlUAnvFBI9kOfkSQYPuJx6EGjkmmitf8PAf5ioxmbSSf8AczXb5CMdKl8EuxZ43wryMfyrYD6Y6YtLs1GHC+UqpjWQgmQAZn4XMe+PjgymvBkmTM5yhRMzUY+4hQfoTHnhebG4oFVuXMvTIYEXtBOqemxH1wecmCkgPxTk1YJRlUm+gl1P5QD64ZT+QOIxcvcMISSeg/ESJi+7H/nEmOj9mkM4ASXz1yA5R6mWR5BH3c3J3ldy0jcD0wMeSuybRTVThmcVtbZaqCP5l0H46oJteR+on0VPHXZH6l4PamXrMGNRO78NgBAi3Tcn1N/U4PKK6G2+xP4hyswUuRMER5wTcx1gef6YvHMuibj5LJ7KOIhDeIG0mx+PQ4hldl4lpZ7taCsGlfDHh/mEXki/uGOH27H5UWZyt2litTR1Kh4OlAIgNv1c1DbyQC94kjmnj4l4yss7hPNv8IClUIGeKkkENERNruLzpM7z1xzuNlE6H/ljj1Moa+XqsCAdasxjWwmUX8I6W84i9ouNaZROw1y1w4VdTVbhpmF2NyN59ozMfocTnKloPZxD9q3OKM7nqaSFpUqeWQyJlqSl9titau6ecpjzZytl4Kkc2vkhjGtDX2h9q1arwnK8Nq0U05R6ZoV0kTQp0Gy60qgMqXEyKwNMsIU02INRxKTqhkkhcHDTpkeW3/MYmE6GzvbEG4RQ4YmWYkUMvTq1nYABqL02+6VdQYHQLu6mP+3i3PVE+CK8XJRiJQL/AGZuJd3xmvRKahXy4ffd6DgIoHXUj1W3A8HxF8XZzZI+TsjmLnipThDSeNPtHcTtYmTE/oJ3PoRxp+Tnc6ETmPPq43E7ny+Fh8ZA+OOmKolJ2K+a4Qky0Sbjr8fXFU2TSETjnEaasbMYtN5J6x5R546Y3QOjTU5HdgpEgt4vG5Ogb+yohiRt4hc9MHmkET+aeXHpEg1NYO2lWUn3xqJE/hBE+d8WjJMRpkTKZCsJdKbeBQTrME/7QRA9xIt54LcTKwVzVxasVvRqE2kzCj02904aEY/IG38E7krj5SnDsxMkBdwAYgAteRcAAxHuETnH4GixiSuDcys9DiY5ePLGbp67sQJtDX/sY6445WBDbznwOhWVIbuwvhLNeZIEk7mIteST85qTRTRArdk1BKS1VV6wiG2YKxkSQZIkxtYX3kYb3GzUU1zN2Y02BldBkmFsJ8oM9L+87Y6I5WheKZVPFuyUT4azLfYgdPLHXHL8om4BThXZIrqfvNTQAJ2HmY3P72wXkDwCnKuUzFCoFSkGGylpG25Vuk7zPTAbT7Ck0Wdk+aNOpszRL6isVFd20kSSsuT53ExbrAjmlD4KX8l0dmfCGqHvFQU1IkAMY/lE9J3nYdYxxZHRaCGjnH7TOT4Ywy1WnmK9UUkqlMvTptCuzATUq1aVOToJ0ayyqQSo1pq8zJK2dUUfPztL7QBXrZg6KivWzLZgk6SoD1mzOk+KQVEKIBFt/PkLClQp3+OHOfsnZtvuyP8ATt8DP0wh0E3KLb5YBhxrPbGMaK9TGMAOE53ueJ5POEQtKqC7fyI6mgzHeypUqsbHbbDxdMSUbR9DOUOeMvnaJejXpZjSQrlGp1CD1UlWMXt4tLTuJx2KXwc9fJPbk+n1pUvELCLk/oY2j6Yqps3BHMXa1wcLmHRTpIJgFjINoAIJgT6/XHo43aOSaJ/AuLpUPc5zLAL7FOoGhpjxEhCpIJE6jtJPQwXa2mKCuduJigdCLC6QKei407AdZ9TM+uCtgEmnxyoUIKohOzEkn3joD77jFUggdeLVlOkPJ3J3+uHpC7JOX4fXa7XX1iMa0g0yXU5bpCCad95ki/WMbkxWiTmsis2URHmP6YU1j7xzsuqIFKVClgSXBRpvKwfaA2nrE2xyLOnoemiDxfm7uvu1qmY8RMmfhtE9I+eHSsyNmU7RmKhdYjrBAn3j6Y3D7Dg7jXMzG9z674dRMDauZDgEgA/vr0w4DXmuG6IZWmd7frP9PjgWEO8E5sYKKbAOhIkGxA9D5+s4NJmGPK8Bp1JAOkExDG3nPu3E7n6Ym5NBoaM/zj/BZWo/tLTAdVnTreQqUw0Np7xyqaoMTMGMceWSqykLujljm3m581mauaqgB6r6iqzpQBQiIs3KoiqgJuYnrjx5Ss70q0V7xBj3zmRAMRF5CATM+u0fHC2ZqyVl6uACKoxzb+A/7f0xhgtlHt8MK2Yaqta2CmY0vUwTA3iySDaZUg7Wmw3I8ztOMYA9m3NjZTP5XPIL0aqlomWoN93mKdiJL0WcKDKipocg6Bh4ugNWj6ccN7Q6NTL081RbvKVVBUputNyzK22qmyq6MLhkIV1YEMAQQPQxwc+jklJR7KX7ReFUXcVkYl9JDKyFbxE36nc2G+2PTx45dHJKcRB4Vk20gtdpaLjqLWMi0QB0n34s8bJ8iFxHi9LTodWNSbHcC0yREG+5ER+ZjBmcqI3DOSu89swGUFbCQRBiNWzHZpFh63v7T8EXlRY3C+yym4ALgQALLMHa5BAA2uR1674g8c0BZYvyVPzdnjSZ6YM6Sy+RkW88BQ+Tp5Ff53i1Tu2qHYECZ6mYEevnti6hZNy0Jx50rTafnH54f2yPNnbvNfPb1iA9WV2kIth7h1+GPn4wo9J2c79qPBH16lU1FmzJ5b+ICSD8I9cd2OVEGVWO1JKT+OUP8p2H9MdvHktEvcV0Hcl260j/ANwfPC+2xvdj5DeV7UKbfjX5jC8WOpxfk2Vuf021g4XiHkiRw3nC9jOHejJlhcD5hkC/XYYgx7B/bPzxQqZMUA4qVRWpuqrVaaWnVqaoqMA6lC9IU6gIDVFcLqpqy+X6mcek9nTii7sqXKY8w6xTUEs7dNbn/wBZX8hjGN6jGMeZoeH/AMcYwZy3s/DE2YZiLYZGNZwxjXXPhPu/vjGEWrl4JHkSPkYxjHWn2QeaAOHPlmrCVzVbu00ae5WoErETJ71alR6lbWApDO6EHTqPpenZxZi6MzyeX/AGn8Uf3/SMel71aOT2myHxXktgkLSWY3iDPvkkWtP7A9+/IfaaKYzqPSqs1TLNHUldSyehImR7/ccdePIiU42M9HMOVU0Upy0QCoF/ITAB6gRJi07n2vTTwP8A3W/+D5/10fVJX6dRb+5Cq080p+8bT+G51R5mFIHwbpaN8e7FeikvpV/r/U+QlL/Eoyqbrx4f8a/UrPtB4Cz1huVN2qDYn8UwfCxPSRPScfNZow5tx68I+79HOftRjPcktvqwNwvK0x3i/e1FE6VJAACwSSPaI3IsSDtMk4WNHS7BWbyVJmJQJTEnwle8i8bgHSTuVJJEgYrxRLkW3k+UgzFe97iJ8b62Q+401N+twBH8uPlU6PcaBmb5VYSRme9NwFCkAxsSWA+XrPnisZonVCjzB2RmupL5egTqC/g1QbFmIgwIuf64ssldMDimasp9jPhrAd41UP8AiFKoVSf9M6rep+Qwk8spf3a/hl4prz/Ulr9izhwsGzI6givcARPSCPhsT6Qsc0ovv9W3/LNKHLv+F/0V72gdlHDaIZcvn6hqQYSkGzJ1j8Lsand04nZqiN1Aa+N/qCT3sk/S8utMrvgnAaqme+Y/AD9Sfr88cuX/ABCUvwpL92Wh6WK7bGVMsxEM7MPIsdPndRAPvInHnTySn+J2dail0TstkQIAAGJjBeiMYwl8NqnSD5yfmST+eMYmUm3P73xjHuZTw/DCtmDNJfDgBQx01sP30wQmKC2HFPNGAYUczl/E3vn53/XGMecN4hUptqpValI9SjsgMTGoA6agEmA4IEm2Cm10BpPsuLk77W/EKGlXNDOUxMrWpmnVIiwSvRKKl92ehWkdBvinuSF4IuLlj7bOVe2YpVsoxi5UVqJY2gVKUuFHV6lGmo3JicVjkXkSUX4LLyPPqZinro6MyjfiplaiT5FlLLq8xv6Y9jDhjJKXOKX5o8bN6mUJcVCTf5P+WQqPKtQ+zTKAmYCk9Z21AW6W/LHfHLhhq+RwShny+OP/AL8zdwfgCmroqGrVcTNPwj0gzPxEzis/VtxrGkv3IY/QVLlkcpCb2m8Eyy5eutEhGkOiM8uHBVWphhMyNRIqaQhIIeJVuBTnez2FCKWkcycS5Zqjx1ctWVDPd1FIanUgmTqUkdCIsbTGOj3UvIKvtEd6tYgf/JVm3+8ZcxUL3kXUEAKLAesyZs3vL5JOP2Ln4xy5ngSaSB9IlkUhDbyvpY+UkE48aM4+T03a6I9bnTP6B3nD8yyKQp+6Zyp3IIALepgQDiyeN+SVv4YI4p2h0qQnMUKmVDfiqpUogkdB3gGo3tpmfLAm4RVuSGj9Wkn+hWXMXbesxk0rOZ/zK4CUuvspatUjYh1pDqGbHFL1evpR1RxfImcd5jr5gFa9ZnXrSHgowdwaa2qD/wC4XPrjilOUu2XSS6I2XyMCwwgxIpU74xiXQpeeMYmKL4Jjbm2IRj5Kx+QOCYV+GUPCo/0j8hgGJOnf4/rhGY8qtNlBY+SgsfkOmAGhky3C3j/Kq/8A8qh/JcGhg6KZAAYFTAswKnb1AxjGCDBTFZkEw6ALnEcsdZ/fp+mAzEGtS29+AY/OPhjGI9anjGNfC8y9Kp31CpVoVLfe0aj0nIU6grNTKl6c702lDeVMkY3Ri7+SftrcQogJmBSz62Gt1XL5kXknXSXuasL4VU0EY7tW3mscjX3JygmMvCe3nL5gg63o1CQe6raadTVvCsGZKptP3dRm6nTcY9jB6jHLV0/hnnzxSjvwR+OcdUuKhWWFtgyn3gkgn3/PHqPG2jm5IZci1M0kqZdWp1WUCrTLRSdlYwyAlvE40l1JAkGAARjl4bqQ6flBuh9o6qAEzOUoZor4Veog1hQT4SRMidjAPnO+Ffo4S2mH3mvAGzH2iu5XVmKTZYXjWtnYAnTTtqqOQCQiBmgEgQpjky4seNcnJHRCcpuuLKl5x+2Fm31JkgcvTMjvaqpUq9Rqp0zqp07wyNVFQxZqSmY8ieW/wo7I467KU4hWqVqhrZirUzFQ71K1RqjibwuoxTSbimgVB0UYklfZUl0crgsSTo3ihgEiTTpY1hTo293h0XJVCjbBoxJy1LGMZ8XX7twLkrAAubwNh78YxH4NyhUYTAQWu5j5D9GKnCmDP+G6CXqVA5kCCwRZmIAFze0HVPywNDBCvx+ikIrU1uIUFR1iw39LYykjHmS7UU79qJdQop6hU70QXDQ9Mr00qyPquLkHTC6mvQRmqdoWXCw1ejAiQXU77AiZxLkHQsZvnfIeKcxSpENB0VB1mPBcdNwD8MFSQraMsvn6DtopZzLVWv4O8UPaBtJk3FoFzigpD49wNgQSpE9QNQsZuVkDfrgmAdbLyLYxjXUpdcBmIb08LZJyNHd4Fg5M8NHGBbMX4cCIIBHkcAKbQQ4HxF6TKR96gIJoVHqd2Rawam61Ke0LpbSJujbY6sXqcuPUZa+Hv+ev4+wksMMm2t/odGcvfaN4ecu3f5dMu9MFzSq6grwA0Zatl1BqXOlKTBa7EMFoOCoan+Zb7ewezXgqzmv7XfDhVb7iqwMMF7vx0wyq2h2JK1IJJR0ZgUInaWqvUzXRvYRVucy71Khq1qlStUaZq1WLvBOrSCxOimCTppJpRdlVRbHl1bt9nYbWykYtQp+7jAoxIp0MIyMuyQuW9MAU3mkAJJAHUkxgmJfDMhrvTHeCYlSNM+8kA/CThkXXQWfgIX/NrUqXpOo/XTB62DYNjEfPc45Gisl2rNEhVvq+UKoPmykW3uJ1gYk5rt4qlGVMrSpAkaYOqwINwVAJMFbKCCZEabpyQtifn+d8zU9qq4HoSt+kBb+vteXnheQLIFPLk+07G+51Enqb9ZJnf4YXkEzNOIbVHq1x9ZEHy+owprJb8TXqiN7hufgwBA2iItbG2PyAvE6YY6u7RWmzaLx5DxbXI9fXrt9CSkDa3Bp8rbSIEeQsfz9MAjZBfgW3s/FT7+p8+uGUg2OfKnOmYo+xWLKAfu6hNRLxMBj4Ta0bRthlIZSHzg3bOpEZjLayTJdCAQNrTLD3AjeBECX5IbmFKnO+UZZD1qRj2WTX8NyWP/mMLyRuSJmVyyOPuq1KrYWDBKl7wabkaT/pLEj1jDC0vB5meFlfaVl8iRYj0bYj1BOMK0aUynlgAM0y+MYzXL4IUYPlPTCtFwDxDsvy9U6npKT5iVn36SJ+Mx6YTm46TCGlQYujMj1xhwGOUplj4QW9wt8/ZHxIwAMi8f44lGDVZV3MSGYR6LbfprwhNxEPPdrrFiKNNmExtYn/AHDa34dVpuZmDRqQOzfMFeqoViKcTGn2rgiWZblomPGfTSCQQ5JGtIk8Lesi92lZ0De0VJBPkCygE7nqbWNpwnNG5GinwST4pa8mSZmZ6m5+fXc3wryUbkEEyqrACz5SAAJg/i29OtvXCcmxjKpVPUAW2BG3Sbb9Y/O04DZoNWbEn0AB+G8Ses2+gwQcjMMFFyF9T8gBbzsPdjVYLNJqE2vc7zsI3EH67xOCAzGoAWEmesCZ9RPrF7nGDbIwUSZt6Em23QnrG8HGYLZlXURAgegt6bgiPiL26YUBD/h/QyPMW26X/SPrhugkyllfgfIwfl+QG2+FARqtI+oHnHx9ZB67ddsOqMYU8sfd67+l4/Ofj1GdAo3CleVN/ebfPbznphQhLh/MdZGBp1nFtgxII9zEgiAAJFvnhk6NbDR7V6sy9GiwsDpBpsfOXUwfOWDRHvluY132EOB9qCNq71WowZX/ALoI63AQhhe2k2K3J1QbQNDnwnMJUBak9OrtIVwGE6j4lfQymxkRIIODoZJEmvQj2gV/3Ar8picBlTdk6NvjjlkyiQHzFBUTvK9ZaSm8MVQgbwV8b/IA47EKLfE+0XLpHdq1cnYqJABMag9TVa2wAa/s4ItoBZ/natUQrC0lMzu9QjoJJ0rbcBf/AC80cqJuQCqcEDNqaajQBqqEvEbQGMAXJAAsSf5sI5sXkTstk4EbA+lhHkOkdRF/heTkCmSadAD6+Qn12n87jCXY1IjgHoAPgTPxmZ8zFo6bYfQNElKBAgkecgFb+m/9vPCtoN0eUqsepiBYQOnmNhBj3kAzgm5EeqIE/Mi5G/qZM9b/AAwUCrPDUP8ALE9T4Z69R4hHWb+hwTcT8qg2sbxNisiRHuHXbGNRpFKLixF9o38pBtaw2uLCQcMajW3zPrG3SbiT8dsYZI006HlJ9LWgRcA7zcgm595wbM0TVy0R18h0G9zN7egEesYSwcT8VGxi39N/39cLtimxupkDpafn0v8AC3pgbAeER1G2+x9b/S/9sazGutlrnfzHkel7Rfr/AFwyZjSaHmLe8AzuADa2/h3jyvhrMYnJ9J9L32+Mz0N/yxrMYLlj5g28tJ+YN/jhWwGLUxeQR16D0+v5npgAIWbynkSJO8kESPMGR6QfPbqeVGuhp5d7ZMzRVUbTmUAFqikVdMQIqqV1Ra9TUx6m8hXkHWRoasn295Uz3mXq0j5Lob5kaL+h1EeeN+ZZZon/2Q=="
                                     }
                                """
                    )
            })
    })
    @PostMapping
    public ResponseEntity<Monumento> save(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Monumento a crear",
                    required = true,
                    content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = CreateMonumentoDto.class),
                    examples = @ExampleObject(
                            value = """
                                        {
                                            "codigoPais" : "LT",
                                            "nombrePais" : "Lituania",
                                            "nombreCiudad" : "Vilna",
                                            "latitud" : 1.23112,
                                            "longitud" : 12.1212132,
                                            "nombreMonumento" : "Tres Cruces",
                                            "descripcion" : "Las Tres Cruces es un monumento en Vilna, Lituania, diseñado por el arquitecto y escultor polaco-lituano Antoni Wiwulski en 1916. Fue demolido en 1950 por orden de las autoridades de la Unión Soviética. Un nuevo monumento diseñado por Henrikas Silgalis fue erigido en su lugar en 1989.​",
                                            "photoUrl" : "data:image/jpeg;base64,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"
                                        }
                                    """
                    ))
            )
            @RequestBody CreateMonumentoDto monumento) {

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(monumento.toMonumento()));

    }

    @Operation(summary = "Editar un monumento guardado en la base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
            description = "Se ha editado el monumento correctamente",
            content = @Content(mediaType = "application/json",
            examples = @ExampleObject(value =
                    """
                       {
                            "id": 1,
                            "codigoPais": "RO",
                            "nombrePais": "Rumanía",
                            "nombreCiudad": "Bucarest",
                            "latitud": 1.23112,
                            "longitud": 12.1212132,
                            "nombreMonumento": "Plaza de la Revolución",
                            "descripcion": "La Plaza de la Revolución de Bucarest es mucho más que un bello espacio al aire libre de Bucarest. En diciembre de 1989 el régimen del dictador Ceaușescu se extinguía bruscamente tras la masacre de población civil en las protestas de la ciudad de Timisoara.​",
                            "photoUrl": "https://www.larumania.es/wp-content/uploads/2016/10/memorial_plaza_revolucion_bucarest.jpg"
                       }
                    """))),
            @ApiResponse(responseCode = "404",
            description = "No se ha encontrado ningún monumento",
            content = @Content)
    })
    @PutMapping("/{id}")
    public Monumento edit(@PathVariable Long id,
                          @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                  description = "Monumento a para editar",
                                  required = true,
                                  content = @Content(mediaType = "application/json",
                                          schema = @Schema(implementation = CreateMonumentoDto.class),
                                          examples = @ExampleObject(
                                                  value =
                                        """
                                            {
                                        
                                                 "codigoPais": "RO",
                                                 "nombrePais": "Rumanía",
                                                 "nombreCiudad": "Bucarest",
                                                 "latitud": 1.23112,
                                                 "longitud": 12.1212132,
                                                 "nombreMonumento": "Plaza de la Revolución",
                                                 "descripcion": "La Plaza de la Revolución de Bucarest es mucho más que un bello espacio al aire libre de Bucarest. En diciembre de 1989 el régimen del dictador Ceaușescu se extinguía bruscamente tras la masacre de población civil en las protestas de la ciudad de Timisoara.​",
                                                 "photoUrl": "https://www.larumania.es/wp-content/uploads/2016/10/memorial_plaza_revolucion_bucarest.jpg"
                                            }
                                        """
                                          ))
                          )
                          @RequestBody CreateMonumentoDto monumento) {

        return service.edit(id, monumento.toMonumento());
    }

    @Operation(summary = "Eliminar un monumento")
    @ApiResponse(
            responseCode = "204",
            description = "Se ha eliminado el monumento",
            content = @Content
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        service.delete(service.findById(id));

        return ResponseEntity.noContent().build();
    }


}
