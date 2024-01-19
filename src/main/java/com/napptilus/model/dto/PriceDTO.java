package com.napptilus.model.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.napptilus.model.entitis.Price;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PriceDTO {

    private Long id;
    private Long brandId;

    private LocalDateTime startDate;

    private LocalDateTime endDate;
    private Long priceList;
    private Long productId;
    private Long priority;
    private BigDecimal price;
    private String curr;

    public PriceDTO(Price price) {

        this.id = price.getId();
        this.brandId = price.getBrandId();
        this.startDate = price.getStartDate();
        this.endDate = price.getEndDate();
        this.priceList = price.getPriceList();
        this.productId = price.getProductId();
        this.priority = price.getPriority();
        this.price = price.getPrice();
        this.curr = price.getCurr();

    }

    public PriceDTO(PriceDTO priceDTO) {


        this.id = priceDTO.getId();
        this.brandId = priceDTO.getBrandId();
        this.startDate = priceDTO.getStartDate();
        this.endDate = priceDTO.getEndDate();
        this.priceList = priceDTO.getPriceList();
        this.productId = priceDTO.getProductId();
        this.priority = priceDTO.getPriority();
        this.price = priceDTO.getPrice();
        this.curr = priceDTO.getCurr();

    }


}
