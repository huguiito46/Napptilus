package com.napptilus.controller;


import com.napptilus.dto.PriceDTO;
import com.napptilus.entitis.Price;
import com.napptilus.service.PriceService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/napptilus/price")
@Slf4j
public class PriceController {

    @Autowired
    private PriceService service;


    /** Endpoint REST para buscar un precio basado en la fecha, el ID del producto y el ID de la cadena.
     * Este endpoint acepta parámetros de consulta para la fecha, el ID del producto y el ID de la cadena.
     * Realiza una búsqueda en la base de datos para recuperar el precio aplicable en la fecha proporcionada
     * para el producto y cadena dados. El resultado se devuelve como una respuesta HTTP.
     *
     * @param date      La fecha para la cual se debe buscar el precio.
     * @param productId El identificador del producto.
     * @param brandId   El identificador de la cadena.
     * @return Una respuesta HTTP que contiene el precio aplicable en la fecha especificada para el producto y cadena dados.
     *         Si no se encuentra un precio coincidente, se devuelve un código de estado 404 (No encontrado).
     *         Si se encuentra un precio, se devuelve un código de estado 200 (Éxito) junto con el precio.
     */

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK - Successful retrieval of data"),
            @ApiResponse(responseCode = "400", description = "Bad Request - Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Not Found - Customer not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error - Something went wrong on the server side")})
    @GetMapping("/query/search")
    public ResponseEntity<?> searchPrice(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
                                             @RequestParam("productId") Long productId,
                                             @RequestParam("brandId") Long brandId) {

        log.info("Received search request for date: {}, productId: {}, brandId: {}", date, productId, brandId);

        Optional<List<Price>> opt_price = service
                .findPricesByDateAndProductIdAndBrandIdQuery
                        (date, productId, brandId);

        if (opt_price.isPresent() && !opt_price.get().isEmpty()) {

            PriceDTO priceDTO = new PriceDTO(opt_price.get().get(0));
            log.info("OK - Returning price for the request: {}", priceDTO);
            return new ResponseEntity<>(priceDTO, HttpStatus.OK);

        } else {
            log.warn("No price found for the request");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @GetMapping("/all")
    public List<Price> getAllPrices() {
        return service.getAllPrices();
    }


}
