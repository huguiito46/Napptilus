CREATE TABLE PRICES (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    BRAND_ID INT,
    START_DATE TIMESTAMP,
    END_DATE TIMESTAMP,
    PRICE_LIST INT,
    PRODUCT_ID INT,
    PRIORITY INT,
    PRICE DECIMAL(10, 2), -- Ajusta la precisión y escala según tus necesidades
    CURR VARCHAR(255) -- Ajusta la longitud según tus necesidades
);