package com.napptilus.controllers;


import com.napptilus.entitis.Price;
import com.napptilus.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/napptilus/price")
public class PriceController {

    @Autowired
    private PriceRepository priceRepository;


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

    @GetMapping("query/search")
    public ResponseEntity<Price> searchPrice(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
                                             @RequestParam("productId") Long productId,
                                             @RequestParam("brandId") Long brandId) {
        List<Price> prices = priceRepository.findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(brandId, productId, date, date);
        if (prices.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(prices.getFirst());
    }

}
