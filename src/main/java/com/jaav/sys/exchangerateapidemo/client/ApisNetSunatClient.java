package com.jaav.sys.exchangerateapidemo.client;


import com.jaav.sys.exchangerateapidemo.model.ExchangeRateSunatResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface ApisNetSunatClient {


    /**
     * obtener el tipo de cambio para los dias del Mes y agno:
     * Ejemplo: //{BASE_URL}/tipo-cambio-sunat?month=7&year=2021
     * @param enteCodigo
     * @param year
     * @return
     */
    @GET("tipo-cambio-sunat")
    Call<List<ExchangeRateSunatResponse>> getExchangeRateSunatByMonthAndYear(
            @Query("month") Integer enteCodigo,
            @Query("year") Integer year);


    @GET("tipo-cambio-sunat")
    Call<ExchangeRateSunatResponse> getExchangeRateSunatByDate(
            @Query("fecha") String fecha);

}
