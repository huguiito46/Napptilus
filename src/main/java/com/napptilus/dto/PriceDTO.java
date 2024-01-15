package com.napptilus.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.napptilus.entitis.Price;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString


@JsonInclude(JsonInclude.Include.NON_NULL)
public class PriceDTO {

    private Long id;
    private Long brandId;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SS")
    private LocalDateTime startDate;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SS")
    private LocalDateTime endDate;
    private Long priceList;
    private Long productId;
    private Long priority;
    private BigDecimal price;
    private String curr;

    // Constructor que acepta un objeto Price para facilitar la conversión
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


}
