package com.napptilus.mapper;



import com.napptilus.dto.PriceDTO;
import com.napptilus.entitis.Price;
import org.mapstruct.Mapper;


@Mapper
public interface PriceMapper {

    PriceDTO priceToPriceDTO(Price price);

}
