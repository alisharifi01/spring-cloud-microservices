package com.msa.sample.service.impl;

import org.springframework.web.bind.annotation.RestController;
import com.msa.sample.service.api.SampleService;

@RestController
public class SampleServiceImpl implements SampleService {

    public String hello() {
        return "hello";
    }
}
