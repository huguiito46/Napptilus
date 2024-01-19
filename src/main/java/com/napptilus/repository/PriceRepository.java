package com.napptilus.repository;


import com.napptilus.model.entitis.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    @Query("SELECT p FROM Price p WHERE p.brandId = :brandId AND p.productId = :productId AND :date BETWEEN " +
            "p.startDate AND p.endDate AND p.startDate <= :date ORDER BY p.priority DESC")
    Optional<List<Price>> findPricesByDateAndProductIdAndBrandIdQuery(
            @Param("date") LocalDateTime date,
            @Param("productId") Long productId,
            @Param("brandId") Long brandId);

}
