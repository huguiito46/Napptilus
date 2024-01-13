package com.napptilus.utils;

import com.napptilus.entitis.Price;
import com.napptilus.repository.PriceRepository;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


@Component
@Slf4j
public class DataLoader implements CommandLineRunner {

    private final PriceRepository repository;

    public DataLoader(PriceRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {

        // Datos de ejemplo
        log.info("Insert prices in the database...");

        List<Price> data_price = Arrays.asList(

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


        // Guardar los datos de ejemplo en la base de datos
        repository.saveAll(data_price);

        List<Price> list_prices = repository.findAll();

        list_prices.forEach(price -> log.info(price.toString()));

        log.info("Prices data loaded into the database..");
    }

}