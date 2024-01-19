package com.napptilus.controller;


import com.napptilus.model.dto.PriceDTO;
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

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK - Successful price found"),
            @ApiResponse(responseCode = "400", description = "Bad Request - Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Not Found - Price not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error - Something went wrong on the server side")})
    @GetMapping("/query/search")
    public ResponseEntity<PriceDTO> searchPrice(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime date,
                                             @RequestParam("productId") Long productId,
                                             @RequestParam("brandId") Long brandId) {

        log.info("Received search request for date: {}, productId: {}, brandId: {}", date, productId, brandId);

        Optional<List<PriceDTO>> opt_price = service
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

}
