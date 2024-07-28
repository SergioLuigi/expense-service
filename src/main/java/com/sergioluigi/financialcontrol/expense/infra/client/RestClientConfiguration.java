package com.sergioluigi.financialcontrol.expense.infra.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sergioluigi.financialcontrol.expense.configuration.exception.CustomErrorResponse;
import com.sergioluigi.financialcontrol.expense.configuration.exception.ExpenseException;
import com.sergioluigi.financialcontrol.expense.infra.client.category.CategoryClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.io.IOException;

@Configuration
public class RestClientConfiguration {

    @Value("${rest.clients.category-service}")
    private String baseUrl;

    @Bean
    public CategoryClient clientCnfig() throws IOException {
        return getHttpServiceProxyFactory(baseUrl, CategoryClient.class);
    }

    private <T> T getHttpServiceProxyFactory(String providerUrl, Class<T> clazz) throws IOException {
        RestClient restClient = RestClient.builder()
                .defaultStatusHandler(HttpStatusCode::isError, clientErrorHandler())
                .baseUrl(providerUrl).build();
        RestClientAdapter adapter = RestClientAdapter.create(restClient);
        var factory = HttpServiceProxyFactory.builderFor(adapter).build();
        return factory.createClient(clazz);
    }

    private RestClient.ResponseSpec.ErrorHandler clientErrorHandler() throws IOException {
        return (request, response) -> {
            throw new ExpenseException(
                    new CustomErrorResponse((HttpStatus) response.getStatusCode(),
                            new ObjectMapper().readTree(response.getBody()).get("message").asText(),
                            null,
                            request.getURI().getPath()));
        };
    }
}
