package com.napptilus.service.impl;

import com.napptilus.entitis.Price;
import com.napptilus.repository.PriceRepository;
import com.napptilus.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceRepository repository;

    @Override
    public void savePrices(List<Price> prices) {
        repository.saveAll(prices);
    }

    @Override
    public List<Price> getAllPrices() {
       return repository.findAll();
    }

    @Override
    public Optional<List<Price>> findPricesByDateAndProductIdAndBrandIdQuery(LocalDateTime date, Long productId, Long brandId) {
        return repository.findPricesByDateAndProductIdAndBrandIdQuery(date, productId, brandId);
    }
}
