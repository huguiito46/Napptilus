package com.napptilus.service;


import com.napptilus.entitis.Price;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public interface PriceService {

    void savePrices(List<Price> prices);

    List<Price> getAllPrices();

    Optional<List<Price>> findPricesByDateAndProductIdAndBrandIdQuery(LocalDateTime date, Long productId, Long brandId);

}
