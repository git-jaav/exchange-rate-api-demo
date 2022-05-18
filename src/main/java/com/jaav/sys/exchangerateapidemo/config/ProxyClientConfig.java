package com.jaav.sys.exchangerateapidemo.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jaav.sys.exchangerateapidemo.client.ApisNetSunatClient;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class ProxyClientConfig {


    //@Autowired
    //ApplicationProperties applicationProperties;

    @Value("${application.http-client.sunat-net.url}")
    private String baseUrlSunaNet;

    @Bean
    @Autowired
    public Retrofit retrofit(OkHttpClient client, Gson gson, String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addConverterFactory(GsonConverterFactory.create())
                //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit;
    }

    @Bean
    public OkHttpClient client() {
        final OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();

        final OkHttpClient builtClient = okHttpClientBuilder.build();

        return builtClient;
    }

    @Bean
    public Gson gson() {
        return new GsonBuilder().setLenient().create();
    }


    @Bean
    public String baseUrlSunatNet() {
        return baseUrlSunaNet;
    }

    // Create a Bean  and add it to SpringContext.
    @Bean
    public ApisNetSunatClient ApisNetSunatClient() {
        return retrofit(client(),gson(), baseUrlSunatNet())
                .create(ApisNetSunatClient.class);
    }

    /*
    // Create Retrofit instance of svcInvestment
    private Retrofit createHttpClient(String baseUrl,String connectionTimeout,String readTimeout,
                                      ObjectMapper objectMapper) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .connectTimeout(Integer.parseInt(connectionTimeout), TimeUnit.MILLISECONDS)
                .readTimeout(Integer.parseInt(readTimeout),TimeUnit.MILLISECONDS);
        return new Retrofit.Builder()
                .baseUrl("http://localhost/api/business/miniencuesta/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

    }*/

}
