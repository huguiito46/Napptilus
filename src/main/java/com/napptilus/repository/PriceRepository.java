package com.napptilus.repository;


import com.napptilus.entitis.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    /**
     * Busca una lista de precios basada en la fecha especificada, el ID del producto y el ID de la cadena.
     * Este método realiza una consulta a la base de datos para recuperar precios que coincidan con los criterios dados.
     * El resultado es una lista de precios para un producto y cadena específicos aplicables en la fecha proporcionada.
     * Los precios se ordenan en orden descendente según su prioridad.
     *
     * @param date      La fecha para la cual se deben recuperar los precios.
     * @param productId El identificador del producto.
     * @param brandId   El identificador de la cadena.
     * @return Una lista de precios aplicables en la fecha especificada para el producto y cadena dados.
     *         La lista está ordenada en orden descendente según la prioridad.
     *         Si no se encuentran precios coincidentes, se devuelve una lista vacía.
     */


    @Query("SELECT p FROM Price p WHERE p.brandId = :brandId AND p.productId = :productId AND :date BETWEEN p.startDate AND p.endDate ORDER BY p.priority DESC")
    List<Price> findPricesByDateAndProductIdAndBrandId(@Param("date") LocalDateTime date, @Param("productId") Long productId, @Param("brandId") Long brandId);


    List<Price> findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
            Long brandId, Long productId, LocalDateTime date, LocalDateTime date2);


}
