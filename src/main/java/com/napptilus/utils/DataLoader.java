package com.napptilus.utils;

import com.napptilus.entitis.Price;
import com.napptilus.repository.PriceRepository;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


@Component
public class DataLoader implements CommandLineRunner {

    private final PriceRepository repository;

    public DataLoader(PriceRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        // Datos de ejemplo
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
                        .build()


        );

        // Guardar los datos de ejemplo en la base de datos
        repository.saveAll(data_price);
    }

}