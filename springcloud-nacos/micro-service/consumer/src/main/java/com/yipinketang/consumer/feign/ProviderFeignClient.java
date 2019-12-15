package com.yipinketang.consumer.feign;

import com.yipinketang.consumer.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * description: ProviderFeignClient <br>
 * date: 2019/12/15 17:43 <br>
 * author: jiuson <br>
 * version: 1.0 <br>
 */

@Component
@FeignClient(value = "provider-service", configuration = FeignConfiguration.class)
public interface ProviderFeignClient {

    @PostMapping("/getProviderService")
    String getProviderService();

    @GetMapping("/getPort")
    String getProviderServicePort();
}
