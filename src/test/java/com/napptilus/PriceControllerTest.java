package com.napptilus;

import com.napptilus.controller.PriceController;
import com.napptilus.dto.PriceDTO;
import com.napptilus.entitis.Price;
import com.napptilus.service.PriceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.ReflectionTestUtils.getField;


@ExtendWith(MockitoExtension.class)
public class PriceControllerTest {

    @InjectMocks
    private PriceController controller;

    @Mock
    private PriceService service;

    @Autowired
    private MockMvc mockMvc;


    @BeforeEach
    void setUp() {
        MockitoAnnotations
                .openMocks(this);
    }

    @Test
    @DisplayName("Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1")
    void testSearchPriceTest1() {

        Long productId = 35455L;
        Long brandId = 1L;
        LocalDateTime date = LocalDateTime.of(2020, 6, 14, 10, 0, 0);

        List<Price> prices = createTestListPrices();

        when(service.findPricesByDateAndProductIdAndBrandIdQuery(date, productId, brandId))
                .thenReturn(Optional.of(prices));

        ResponseEntity<?> response = controller.searchPrice(date, productId, brandId);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        assertThat(response.getBody()).isInstanceOf(PriceDTO.class);
        PriceDTO responseBodyDTO  = (PriceDTO) response.getBody();

        assertThat(responseBodyDTO).isNotNull();

        assertThat(responseBodyDTO.getPrice()).isEqualTo(prices.get(0).getPrice());

        assertThat(responseBodyDTO.getBrandId()).isEqualTo(prices.get(0).getBrandId());


        printTestResults(responseBodyDTO, date, productId, brandId);
    }


    @Test
    @DisplayName("Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1")
    void testSearchPriceTest2() {

        Long productId = 35455L;
        Long brandId = 1L;
        LocalDateTime date = LocalDateTime.of(2020, 6, 14, 16, 0, 0);

        List<Price> prices = createTestListPrices();

        when(service.findPricesByDateAndProductIdAndBrandIdQuery(date, productId, brandId))
                .thenReturn(Optional.of(prices));

        ResponseEntity<?> response = controller.searchPrice(date, productId, brandId);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isInstanceOf(PriceDTO.class);
        PriceDTO responseBodyDTO = (PriceDTO) response.getBody();

        assertThat(responseBodyDTO).isNotNull();
        assertThat(responseBodyDTO.getPrice()).isEqualTo(prices.get(0).getPrice());
        assertThat(responseBodyDTO.getBrandId()).isEqualTo(prices.get(0).getBrandId());

        printTestResults(responseBodyDTO, date, productId, brandId);
    }

    /** A PARTIR DE AQUÍ REVISAR EL TEST 3,4,Y 5 DE TODAS FORMAS SE DOCUMENTA TODO CON SWAGGER
     */

    @Test
    @DisplayName("Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1")
    void testSearchPriceTest3() {

        Long productId = 35455L;
        Long brandId = 1L;
        LocalDateTime date = LocalDateTime.of(2020, 6, 14, 21, 0, 0);

        List<Price> prices = createTestListPrices();

        when(service.findPricesByDateAndProductIdAndBrandIdQuery(date, productId, brandId))
                .thenReturn(Optional.of(prices));

        ResponseEntity<?> response = controller.searchPrice(date, productId, brandId);


        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isInstanceOf(PriceDTO.class);
        PriceDTO responseBodyDTO = (PriceDTO) response.getBody();

        assertThat(responseBodyDTO).isNotNull();
        assertThat(responseBodyDTO.getPrice()).isEqualTo(prices.get(0).getPrice());
        assertThat(responseBodyDTO.getBrandId()).isEqualTo(prices.get(0).getBrandId());

        printTestResults(responseBodyDTO, date, productId, brandId);
    }

    @Test
    @DisplayName("Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1")
    void testSearchPriceTest4() {
        Long productId = 35455L;
        Long brandId = 1L;
        LocalDateTime date = LocalDateTime.of(2020, 6, 15, 10, 0, 0);

        List<Price> prices = createTestListPrices();

        when(service.findPricesByDateAndProductIdAndBrandIdQuery(date, productId, brandId))
                .thenReturn(Optional.of(prices));

        ResponseEntity<?> response = controller.searchPrice(date, productId, brandId);


        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isInstanceOf(PriceDTO.class);
        PriceDTO responseBodyDTO = (PriceDTO) response.getBody();

        assertThat(responseBodyDTO).isNotNull();
        assertThat(responseBodyDTO.getPrice()).isEqualTo(prices.get(0).getPrice());
        assertThat(responseBodyDTO.getBrandId()).isEqualTo(prices.get(0).getBrandId());

        printTestResults(responseBodyDTO, date, productId, brandId);
    }


    @Test
    @DisplayName("Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1")
    void testSearchPriceTest5() {
        Long productId = 35455L;
        Long brandId = 1L;
        LocalDateTime date = LocalDateTime.of(2020, 6, 16, 21, 0, 0);

        List<Price> prices = createTestListPrices();

        when(service.findPricesByDateAndProductIdAndBrandIdQuery(date, productId, brandId))
                .thenReturn(Optional.of(prices));

        ResponseEntity<?> response = controller.searchPrice(date, productId, brandId);


        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isInstanceOf(PriceDTO.class);
        PriceDTO responseBodyDTO = (PriceDTO) response.getBody();

        assertThat(responseBodyDTO).isNotNull();
        assertThat(responseBodyDTO.getPrice()).isEqualTo(prices.get(0).getPrice());
        assertThat(responseBodyDTO.getBrandId()).isEqualTo(prices.get(0).getBrandId());

        printTestResults(responseBodyDTO, date, productId, brandId);
    }



    private void printTestResults(PriceDTO responseBodyDTO,
                                  LocalDateTime date,
                                  Long productId,
                                  Long brandId) {
        // Imprimir resultados
        System.out.println("=== Resultados del Test ===");
        Stream.of("brandId", "startDate", "endDate", "priceList", "productId", "priority", "price", "curr")
                .forEach(field -> System.out.println(field + ": " + getField(responseBodyDTO, field)));

        // Imprimir detalles de la prueba
        Stream.of("Date: " + date,
                        "ID del Producto: " + productId,
                        "ID de la Marca: " + brandId)
                .forEach(System.out::println);
    }

    private List<Price> createTestListPrices() {
        return Arrays.asList(

                Price.builder()
                        .brandId(1L)
                        .startDate(LocalDateTime.parse("2020-06-14T00:00:00.00"))
                        .endDate(LocalDateTime.parse("2020-12-31T23:59:59.59"))
                        .priceList(1L)
                        .productId(35455L)
                        .priority(0L)
                        .price(new BigDecimal("35.50"))
                        .curr("EUR")
                        .build(),


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





    }



































    private void assertResponse(ResponseEntity<?> response,
                                Price price,
                                LocalDateTime date, Long productId, Long brandId) {


        assertThat(response.getStatusCode())
                .as("El código de estado de la respuesta debe ser OK (200)")
                .isEqualTo(HttpStatus.OK);

        assertThat(response.getBody())
                .as("El cuerpo de la respuesta debe ser una instancia de PriceDTO")
                .isInstanceOf(PriceDTO.class);

        PriceDTO responseBodyDTO = (PriceDTO) response.getBody();

        assertThat(responseBodyDTO)
                .as("El objeto PriceDTO obtenido del cuerpo de la respuesta no debe ser nulo")
                .isNotNull();

        assertThat(responseBodyDTO.getPrice())
                .as("El precio en PriceDTO debe ser igual al precio en el objeto Price de la lista")
                .isEqualTo(price.getPrice());

        assertThat(responseBodyDTO.getBrandId())
                .as("El brandId en PriceDTO debe ser igual al brandId en el objeto Price de la lista")
                .isEqualTo(price.getBrandId());

        System.out.println("=== Resultados del Test ===");
        Stream.of("brandId", "startDate", "endDate", "priceList", "productId", "priority", "price", "curr")
                .forEach(field -> System.out.println(field + ": " + getField(responseBodyDTO, field)));

        Stream.of("Fecha de la Prueba: " + date,
                        "ID del Producto: " + productId,
                        "ID de la Marca: " + brandId)
                .forEach(System.out::println);
    }

}

