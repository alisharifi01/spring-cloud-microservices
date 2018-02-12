package com.msa.sample.service.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface SampleService {

    @RequestMapping(value = "/hello" , method = RequestMethod.GET)
    String hello();
}
