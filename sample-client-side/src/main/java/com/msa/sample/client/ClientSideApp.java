package com.msa.sample.client;

import com.msa.sample.service.api.SampleService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@EnableEurekaClient
@EnableHystrixDashboard
@EnableFeignClients
@EnableCircuitBreaker
@SpringBootApplication
public class ClientSideApp {

    private @Autowired SampleServiceClient sampleServiceClient;

    @HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping(value = "/hello")
    public String available() throws Exception {
        return sampleServiceClient.hello();
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public String fallback() {
        return "exception in calling service ...";
    }

    public static void main(String[] args) {
        SpringApplication.run(ClientSideApp.class, args);
    }
}
