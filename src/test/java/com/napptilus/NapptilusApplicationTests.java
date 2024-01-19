package com.napptilus;

import com.napptilus.controller.PriceController;
import com.napptilus.model.dto.PriceDTO;
import com.napptilus.service.PriceService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@Nested
@ExtendWith(MockitoExtension.class)
class NapptilusApplicationTests {

	@InjectMocks
	private PriceController controller;
	@Mock
	private PriceService service;
	@Autowired
	private MockMvc mockMvc;

	/** SWAGGER TEST 1
	 * {
	 * "id": 1,
	 * "brandId": 1,
	 * "startDate": "2020-06-14T00:00:00.00",
	 * "endDate": "2020-12-31T23:59:59.00",
	 * "priceList": 1,
	 * "productId": 35455,
	 * "priority": 0,
	 * "price": 35.5,
	 * "curr": "EUR"
	 * }
	 */
	@Test
	@DisplayName("Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1")
	void testSearchPriceTest1() {

		Long productId = 35455L;
		Long brandId = 1L;
		LocalDateTime startDate = LocalDateTime.parse("2020-06-14T10:00:00");

		PriceDTO priceDTO = new PriceDTO();
		priceDTO.setId(1L);
		priceDTO.setBrandId(brandId);
		priceDTO.setStartDate(LocalDateTime.parse("2020-06-14T00:00:00.00"));
		priceDTO.setEndDate(LocalDateTime.parse("2020-12-31T23:59:59.00"));
		priceDTO.setPriceList(1L);
		priceDTO.setProductId(35455L);
		priceDTO.setPriority(0L);
		priceDTO.setPrice(BigDecimal.valueOf(35.50));
		priceDTO.setCurr("EUR");

		when(service.findPricesByDateAndProductIdAndBrandIdQuery(startDate, productId, brandId))
				.thenReturn(Optional.of(Collections.singletonList(priceDTO)));

		ResponseEntity<PriceDTO> responseDTO = controller.searchPrice(startDate, productId, brandId);
		assertAll("responseDTO",
				() -> assertThat(responseDTO.getStatusCode()).isEqualTo(HttpStatus.OK),
				() -> assertThat(responseDTO.getBody()).isNotNull(),
				() -> assertThat(responseDTO.getBody()).isEqualTo(priceDTO)
		);

		verify(service, times(1)).findPricesByDateAndProductIdAndBrandIdQuery(startDate, productId, brandId);
	}

	/**
	 * SWAGGER TEST 2
	 * {
	 * "id": 2,
	 * "brandId": 1,
	 * "startDate": "2020-06-14T15:00:00.00",
	 * "endDate": "2020-06-14T18:30:00.00",
	 * "priceList": 2,
	 * "productId": 35455,
	 * "priority": 1,
	 * "price": 25.45,
	 * "curr": "EUR"
	 * }
	 */
	@Test
	@DisplayName("Test 2: petición a las 16:00 del día 14 del producto 35455 para la marca 1")
	void testSearchPriceTest2() {

		Long productId = 35455L;
		Long brandId = 1L;
		LocalDateTime startDate = LocalDateTime.parse("2020-06-14T16:00:00");

		PriceDTO priceDTO = new PriceDTO();
		priceDTO.setId(2L);
		priceDTO.setBrandId(brandId);
		priceDTO.setStartDate(LocalDateTime.parse("2020-06-14T15:00:00.00"));
		priceDTO.setEndDate(LocalDateTime.parse("2020-06-14T18:30:00.00"));
		priceDTO.setPriceList(2L);
		priceDTO.setProductId(35455L);
		priceDTO.setPriority(1L);
		priceDTO.setPrice(BigDecimal.valueOf(25.50));
		priceDTO.setCurr("EUR");

		when(service.findPricesByDateAndProductIdAndBrandIdQuery(startDate, productId, brandId))
				.thenReturn(Optional.of(Collections.singletonList(priceDTO)));

		ResponseEntity<PriceDTO> responseDTO = controller.searchPrice(startDate, productId, brandId);
		assertAll("responseDTO",
				() -> assertThat(responseDTO.getStatusCode()).isEqualTo(HttpStatus.OK),
				() -> assertThat(responseDTO.getBody()).isNotNull(),
				() -> assertThat(responseDTO.getBody()).isEqualTo(priceDTO)
		);

		verify(service, times(1)).findPricesByDateAndProductIdAndBrandIdQuery(startDate, productId, brandId);

	}


	/**
	 * SWAGGER TEST 3
	 *{
	 *   "id": 1,
	 *   "brandId": 1,
	 *   "startDate": "2020-06-14T00:00:00",
	 *   "endDate": "2020-12-31T23:59:59",
	 *   "priceList": 1,
	 *   "productId": 35455,
	 *   "priority": 0,
	 *   "price": 35.5,
	 *   "curr": "EUR"
	 * }
	 */
	@Test
	@DisplayName("Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1")
	void testSearchPriceTest3() {

		Long productId = 35455L;
		Long brandId = 1L;
		LocalDateTime startDate = LocalDateTime.parse("2020-06-14T21:00:00");

		PriceDTO priceDTO = new PriceDTO();
		priceDTO.setId(1L);
		priceDTO.setBrandId(brandId);
		priceDTO.setStartDate(LocalDateTime.parse("2020-06-14T00:00:00"));
		priceDTO.setEndDate(LocalDateTime.parse("2020-12-31T23:59:59"));
		priceDTO.setPriceList(1L);
		priceDTO.setProductId(35455L);
		priceDTO.setPriority(0L);
		priceDTO.setPrice(BigDecimal.valueOf(35.5));
		priceDTO.setCurr("EUR");

		when(service.findPricesByDateAndProductIdAndBrandIdQuery(startDate, productId, brandId))
				.thenReturn(Optional.of(Collections.singletonList(priceDTO)));

		ResponseEntity<PriceDTO> responseDTO = controller.searchPrice(startDate, productId, brandId);
		assertAll("responseDTO",
				() -> assertThat(responseDTO.getStatusCode()).isEqualTo(HttpStatus.OK),
				() -> assertThat(responseDTO.getBody()).isNotNull(),
				() -> assertThat(responseDTO.getBody()).isEqualTo(priceDTO)
		);


		verify(service, times(1)).findPricesByDateAndProductIdAndBrandIdQuery(startDate, productId, brandId);
	}


	/** SWAGGER TEST 4
	 * {
	 *   "id": 3,
	 *   "brandId": 1,
	 *   "startDate": "2020-06-15T00:00:00",
	 *   "endDate": "2020-06-15T11:00:00",
	 *   "priceList": 3,
	 *   "productId": 35455,
	 *   "priority": 1,
	 *   "price": 30.5,
	 *   "curr": "EUR"
	 * }
	 */
	@Test
	@DisplayName("Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1")
	void testSearchPriceTest4() {

		Long productId = 35455L;
		Long brandId = 1L;
		LocalDateTime startDate = LocalDateTime.parse("2020-06-15T10:00:00");

		PriceDTO priceDTO = new PriceDTO();
		priceDTO.setId(3L);
		priceDTO.setBrandId(brandId);
		priceDTO.setStartDate(LocalDateTime.parse("2020-06-15T00:00:00"));
		priceDTO.setEndDate(LocalDateTime.parse("2020-06-15T11:00:00"));
		priceDTO.setPriceList(3L);
		priceDTO.setProductId(35455L);
		priceDTO.setPriority(1L);
		priceDTO.setPrice(BigDecimal.valueOf(30.5));
		priceDTO.setCurr("EUR");

		when(service.findPricesByDateAndProductIdAndBrandIdQuery(startDate, productId, brandId))
				.thenReturn(Optional.of(Collections.singletonList(priceDTO)));

		ResponseEntity<PriceDTO> responseDTO = controller.searchPrice(startDate, productId, brandId);
		assertAll("responseDTO",
				() -> assertThat(responseDTO.getStatusCode()).isEqualTo(HttpStatus.OK),
				() -> assertThat(responseDTO.getBody()).isNotNull(),
				() -> assertThat(responseDTO.getBody()).isEqualTo(priceDTO)
		);
		verify(service, times(1)).findPricesByDateAndProductIdAndBrandIdQuery(startDate, productId, brandId);
	}


	/** SWAGGER TEST 5
	 * {
	 *   "id": 4,
	 *   "brandId": 1,
	 *   "startDate": "2020-06-15T16:00:00",
	 *   "endDate": "2020-12-31T23:59:59",
	 *   "priceList": 4,
	 *   "productId": 35455,
	 *   "priority": 1,
	 *   "price": 38.95,
	 *   "curr": "EUR"
	 * }
	 */
	@Test
	@DisplayName("Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1")
	void testSearchPriceTest5() {
		Long productId = 35455L;
		Long brandId = 1L;
		LocalDateTime startDate = LocalDateTime.parse("2020-06-16T10:00:00");

		PriceDTO priceDTO = new PriceDTO();
		priceDTO.setId(4L);
		priceDTO.setBrandId(brandId);
		priceDTO.setStartDate(LocalDateTime.parse("2020-06-15T16:00:00"));
		priceDTO.setEndDate(LocalDateTime.parse("2020-12-31T23:59:59"));
		priceDTO.setPriceList(4L);
		priceDTO.setProductId(35455L);
		priceDTO.setPriority(1L);
		priceDTO.setPrice(BigDecimal.valueOf(38.95));
		priceDTO.setCurr("EUR");

		when(service.findPricesByDateAndProductIdAndBrandIdQuery(startDate, productId, brandId))
				.thenReturn(Optional.of(Collections.singletonList(priceDTO)));

		ResponseEntity<PriceDTO> responseDTO = controller.searchPrice(startDate, productId, brandId);
		assertAll("responseDTO",
				() -> assertThat(responseDTO.getStatusCode()).isEqualTo(HttpStatus.OK),
				() -> assertThat(responseDTO.getBody()).isNotNull(),
				() -> assertThat(responseDTO.getBody()).isEqualTo(priceDTO)
		);

		verify(service, times(1)).findPricesByDateAndProductIdAndBrandIdQuery(startDate, productId, brandId);
	}
}









