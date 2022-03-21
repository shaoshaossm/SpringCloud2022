package com.ssm.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shaoshao
 * @version 1.0
 * @date 2022/3/21 11:59
 */
@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes=  routeLocatorBuilder.routes();
        routes.route("path_route_ssm",r->r.path("/guonei").uri("http://news.baidu.com/guonei"));
        return routes.build();

    }

}
