package com.napptilus.utils;

import com.napptilus.entitis.Price;

import com.napptilus.service.PriceService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


@Component
@Slf4j
public class LoadDatabase implements CommandLineRunner {
    private final PriceService service;

    @Autowired
    public LoadDatabase(PriceService priceService) {
        this.service = priceService;
    }

    @Override
    public void run(String... args) {

        try {
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

            service.savePrices(data_price);

            List<Price> list_prices = service.getAllPrices();

            list_prices.forEach(price -> log.info(price.toString()));

            log.info("Prices data loaded into the database");
        }catch (DataException e){
            log.error("Error loading prices into the database", e);
        }
    }
}