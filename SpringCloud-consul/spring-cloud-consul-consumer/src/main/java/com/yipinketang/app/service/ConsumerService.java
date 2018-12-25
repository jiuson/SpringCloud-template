package com.yipinketang.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/consul-consumer")
public class ConsumerService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/hello")
    public Object getServiceFromProducer(@RequestParam(name = "name", required = false) String name){

        List<String> services = discoveryClient.getServices();
        System.out.println(services);
        String url = "http://producer/consul-producer/hello";
        return restTemplate.getForObject(url, String.class, name);
    }

    /**
     * 轮询一个服务
     * @return
     */
    @GetMapping("/hello-balancer")
    public Object getServiceFromProducerByLoadBalancer(){
        String serviceId = loadBalancerClient.choose("producer").getServiceId();
        String host = loadBalancerClient.choose("producer").getHost();
        String instanceId = loadBalancerClient.choose("producer").getInstanceId();
        Map<String, String> metadata = loadBalancerClient.choose("producer").getMetadata();
        int port = loadBalancerClient.choose("producer").getPort();
        String scheme = loadBalancerClient.choose("producer").getScheme();
        String uri = loadBalancerClient.choose("producer").getUri().toString();
        boolean secure = loadBalancerClient.choose("producer").isSecure();
        return "The service info is: [serviceId: " + serviceId + "\n host: " + host + "\n instanceId: " + instanceId + "\n metadata: " + metadata
                + "\n port: " + port + "\n scheme: " + scheme + "\n uri: " + uri + "\n secure: " + secure;
    }

    /**
     * discoverClient getInstances
     * @param instanceName
     * @return
     */
    @GetMapping("/get-instance")
    public Object getInstance(@RequestParam("instanceName") String instanceName){
        return discoveryClient.getInstances(instanceName == null ? "producer" : instanceName);
    }

    /**
     * discoverClient getServices
     * @return
     */
    @GetMapping("/get-services")
    public Object getServices(){
        return discoveryClient.getServices();
    }
}
