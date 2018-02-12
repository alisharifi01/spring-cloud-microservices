package com.msa.sample.client;

import com.msa.sample.service.api.SampleService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name = "server-side" , serviceId = "server-side")
public interface SampleServiceClient extends SampleService {

}
