package com.jiuson.consumer.feign;

import com.jiuson.consumer.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@FeignClient(value = "provider-service", configuration = FeignConfiguration.class)
public interface ProviderFeignClient{

    @PostMapping("/getProviderService")
    String getProviderService();

    @GetMapping("/getPort")
    String getProvideServicePort();

}
