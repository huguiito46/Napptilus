package com.napptilus;

import com.napptilus.controller.PriceController;
import com.napptilus.dto.PriceDTO;
import com.napptilus.entitis.Price;
import com.napptilus.service.PriceService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


/**
 *
 *Desarrollar unos test al endpoint rest que validen las siguientes peticiones al servicio
 * con los datos del ejemplo:
 * ○ Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1
 *
 *
 *
 *
 */

@ExtendWith(MockitoExtension.class)
@Slf4j
public class PriceControllerTest {

    @InjectMocks
    private PriceController controller;

    @Mock
    private PriceService service;


    @BeforeEach
    void setUp() {
        MockitoAnnotations
                .openMocks(this);
    }

    @Test
    @DisplayName("Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1")
    void testSearchPrice() {
        // Datos de prueba
        Long productId = 35455L;
        Long brandId = 1L;
        LocalDateTime date = LocalDateTime.of(2020, 6, 14, 10, 0, 0);



        // Construir los objetos Price y agregarlos a una lista
        log.info("Insert prices in the database...");
        List<Price> prices = Arrays.asList(
                // Primer rango de precios
                Price.builder()
                        .brandId(1L)
                        .startDate(LocalDateTime.parse("2020-06-14T00:00:00.00"))
                        .endDate(LocalDateTime.parse("2020-12-31T23:59:59.59"))
                        .priceList(0L)
                        .productId(35455L)
                        .priority(0L)
                        .price(new BigDecimal("35.50"))
                        .curr("EUR")
                        .build(),

                // Segundo rango de precios
                Price.builder()
                        .brandId(1L)
                        .startDate(LocalDateTime.parse("2020-06-14T15:00:00.00"))
                        .endDate(LocalDateTime.parse("2020-06-14T18:30:00.00"))
                        .priceList(1L)
                        .productId(35455L)
                        .priority(1L)
                        .price(new BigDecimal("25.45"))
                        .curr("EUR")
                        .build(),

                // Tercer rango de precios
                Price.builder()
                        .brandId(1L)
                        .startDate(LocalDateTime.parse("2020-06-15T00:00:00.00"))
                        .endDate(LocalDateTime.parse("2020-06-15T11:00:00.00"))
                        .priceList(1L)
                        .productId(35455L)
                        .priority(1L)
                        .price(new BigDecimal("30.50"))
                        .curr("EUR")
                        .build(),

                // Cuarto rango de precios
                Price.builder()
                        .brandId(1L)
                        .startDate(LocalDateTime.parse("2020-06-15T16:00:00.00"))
                        .endDate(LocalDateTime.parse("2020-12-31T23:59:59.59"))
                        .priceList(1L)
                        .productId(35455L)
                        .priority(1L)
                        .price(new BigDecimal("38.95"))
                        .curr("EUR")
                        .build()
        );

        // Configurar el servicio mock para devolver la lista de precios
        Mockito.when(service.findPricesByDateAndProductIdAndBrandIdQuery(date, productId, brandId))
                .thenReturn(Optional.of(prices));

        // Llamar al método del controlador
        ResponseEntity<?> response = controller.searchPrice(date, productId, brandId);

        // Verificar el código de estado de la respuesta
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        // Verificar que el cuerpo de la respuesta sea un PriceDTO
        assertThat(response.getBody()).isInstanceOf(PriceDTO.class);
        PriceDTO priceDTO = (PriceDTO) response.getBody();

        // Verificar que el PriceDTO tiene el precio esperado
        assert priceDTO != null;
        assertThat(priceDTO.getPrice())
                .isEqualTo(prices.get(0).getPrice());
    }
}

