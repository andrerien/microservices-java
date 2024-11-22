package br.edu.atitus.paradigma.api_gateway_service.configs;

import org.springframework.cloud.gateway.filter.factory.AddRequestHeaderGatewayFilterFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {
	@Bean
	RouteLocator getGatewayRoute(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(route -> route
						.path("/get")
						.filters(f-> f
								.addRequestHeader("Usuario", "André Izolani Rien")
								.addRequestHeader("Teste", "ResponseHeader"))
							.uri("http://httpbin.org"))
				.route(route -> route
						.path("/cambio-service/**")
						.filters(f-> f
								.addRequestHeader("Usuario", "André Izolani Rien"))
						.uri("lb://cambio-service"))
				.route(route -> route
					.path("/produto-service/**")
					.filters(f-> f
							.addRequestHeader("Usuario", "André Izolani Rien"))
					.uri("lb://produto-service"))
				.route(route -> route
						.path("/saudacao-service/**")
						.filters(f-> f
								.addRequestHeader("Usuario", "André Izolani Rien"))
						.uri("lb://saudacao-service"))
					.build();
	}
}
