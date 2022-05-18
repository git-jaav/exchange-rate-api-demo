package com.jaav.sys.exchangerateapidemo.model;


import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ExchangeRateSunatResponse {

    private BigDecimal compra;
    private BigDecimal venta;
    private String origen;
    private String moneda;
    private String fecha;

}
