package com.jiuson.consumer.controller;

import com.jiuson.consumer.feign.ProviderFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * SpringBoot web组件的RestTemplate访问微服务接口
 */
@RestController
public class ConsumerController {

    @Value("${server.port}")
    private String port;
    @Value("${spring.application.name}")
    private String consumerName;

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    private Integer requestNum = 0;//来自客户端的总请求数，通过不同的浏览器访问，可以证明ConsumerController是Singleton

    /*
    在SpringCloud中有两种方式调用注册中心的服务：
    1、rest（springboot web组件提供，底层对httpclient的封装），默认整合ribbon负载均衡器，需要使用@LoadBalanced开启，且当通过
    服务id来访问服务的时候必须开启该注解（因为存在服务集群的原因,需要用负载均衡算法找到具体由哪个应用提供服务），这种负载均衡是客户端负载均衡
    跟Nginx服务器端负载均衡是有区别的
    2、fegin（SpringCloud提供，底层对rest的封装）
    订单服务调用会员服务
     */
    @GetMapping("/getServiceFromProviderByServerAliasName")
    public String getServiceFromProviderByServerAliasName(){
        System.out.println("当前线程名称：" + Thread.currentThread().getName());
        String result = "这是consumer service 的getServiceFromProviderByDiscoveryClient方法,本次是第[" + requestNum +
                "]次请求，provider service返回的数据是:";
        //通过服务别名(serviceId)方式需要在RestTemplate开启负载均衡器@LoadBalanced
        String url = "http://provider-service/getProviderService";
        result += restTemplate.getForObject(url, String.class);
        return result;
    }

    @GetMapping("/getServiceFromProviderByServerIp")
    public String getServiceFromProviderByServerIp(){
        System.out.println("当前线程名称：" + Thread.currentThread().getName());
        String result = "这是consumer service 的getServiceFromProviderByDiscoveryClient方法,本次是第[" + requestNum +
                "]次请求，provider service返回的数据是:";
        //通过ip+port方式不需要开启负载均衡器，因为已经指定了服务地址
        String url = "http://127.0.0.1:8020/getProviderService";
        result += restTemplate.getForObject(url, String.class);
        return result;
    }

    @GetMapping("/getServiceFromProviderByDiscoveryClient")
    public String getServiceFromProviderByDiscoveryClient(){
        requestNum++;
        System.out.println("当前线程名称：" + Thread.currentThread().getName());
        String result = "这是consumer service 的getServiceFromProviderByDiscoveryClient方法,本次是第[" + requestNum +
                "]次请求，provider service返回的数据是:";
        //通过DiscoveryClient获取指定名称的服务列表
        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("provider-service");
        //负载均衡算法（轮询）：总请求数对服务实例数取余，就是处理本次请求的实例
        String host = serviceInstanceList.get(requestNum % serviceInstanceList.size()).getHost();
        String serviceId = serviceInstanceList.get(requestNum % serviceInstanceList.size()).getServiceId();
        Integer port = serviceInstanceList.get(requestNum % serviceInstanceList.size()).getPort();
        //在RestTemplate没有开启@LoadBalanced负载均衡器时，这里使用host，而不是serviceId，使用serviceId会报unknown Server host错误
        String url = "http://" + host + ":" + port + "/getProviderService";
        // 如果RestTemplate开启了@LoadBalanced负载均衡器，则这里使用serviceId是可以的
        //String url = "http://" + serviceId + "/getProviderService";
        result += restTemplate.getForObject(url, String.class);
        return result;
    }

    @Autowired
    private ProviderFeignClient providerFeignClient;
    @GetMapping("/getByFeignClient")
    public String getByFeignClient(HttpServletRequest request){

        String result = providerFeignClient.getProviderService();
        return result;
    }
}
