package com.napptilus.service.impl;

import com.napptilus.model.dto.PriceDTO;
import com.napptilus.model.entitis.Price;
import com.napptilus.mapper.PriceMapper;
import com.napptilus.repository.PriceRepository;
import com.napptilus.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PriceServiceImpl implements PriceService {
    @Autowired
    private PriceRepository repository;

    private PriceMapper mapper;
    @Override
    public Optional<List<PriceDTO>> findPricesByDateAndProductIdAndBrandIdQuery(LocalDateTime date, Long productId, Long brandId) {

        Optional<List<Price>> optPrices = repository
                .findPricesByDateAndProductIdAndBrandIdQuery(date, productId, brandId);

        return optPrices.map(prices ->
                prices.stream()
                        .map(PriceDTO::new)
                        .collect(Collectors.toList())

        );
    }
}

