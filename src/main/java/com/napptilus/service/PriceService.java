package com.napptilus.service;


import com.napptilus.model.dto.PriceDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public interface PriceService {


    Optional<List<PriceDTO>> findPricesByDateAndProductIdAndBrandIdQuery(LocalDateTime date, Long productId, Long brandId);

}
