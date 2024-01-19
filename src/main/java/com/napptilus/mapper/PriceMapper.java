package com.napptilus.mapper;



import com.napptilus.model.dto.PriceDTO;
import com.napptilus.model.entitis.Price;
import org.mapstruct.Mapper;


@Mapper
public interface PriceMapper {

    PriceDTO priceToPriceDTO(Price price);

}
