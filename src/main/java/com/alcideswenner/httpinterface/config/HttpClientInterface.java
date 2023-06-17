package com.alcideswenner.httpinterface.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import com.alcideswenner.httpinterface.service.TodoClient;

@Configuration
public class HttpClientInterface {

    @Bean
    TodoClient todoClient() {
        WebClient client = WebClient.builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .defaultHeader("Authorization", "token")
                .build();
        var factory = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(client)).build();
        return factory.createClient(TodoClient.class);
    }
}
