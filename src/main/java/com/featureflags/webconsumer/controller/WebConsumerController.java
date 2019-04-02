package com.featureflags.webconsumer.controller;


import com.featureflags.webconsumer.dataservice.FFConsumerService;
import com.featureflags.webconsumer.model.Flag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class WebConsumerController {

    @Autowired
    FFConsumerService FFConsumerService;

    @ResponseBody
    @GetMapping(value = "/featureflags", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Flag> getAllFeatureFlags() {
        return FFConsumerService.getAllFeatureFlags().getBody();
    }

    @ResponseBody
    @PostMapping(value = "/featureflags", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Flag> createFlag(@RequestBody Flag flag) {
        return FFConsumerService.save(flag).getBody();
    }
}
