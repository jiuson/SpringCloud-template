# 基于Springcloud2.0构建分布式服务
<p>这是一个maven的聚合项目</p>
<h2>1、springcloud2.0-yipinketang-parent作为一个pom项目，为其他module提供公共的依赖信息</h2>
<ul>
  <li>spring-boot-starter-web依赖 提供SpringBoot-webmvc组件</li> 
  <li>spring-cloud-starter-netflix-eureka-server依赖 提供SpringCloud-Eureka Server组件</li> 
  <li>spring-cloud-netflix-eureka-client依赖 提供SpringCloud-Eureka Client组件</li> 
  <li>spring-cloud-starter-netflix-hystrix依赖 提供SpringCloud-Eureka hystrix组件，实现服务熔断，防止服务雪崩，通过在接口上使用@HystrixCommand注解，可以对接口进行线程池级别的隔离</li> 
  <li>spring-cloud-starter-openfeign依赖 提供SpringCloud-openfeign微服务调用组件</li> 
</ul>
<h2>2、springcloud2.0-yipinketang-eureka-server是Eureka注册中心服务</h2>
<ul>
<li>注册中心搭建步骤：https://blog.csdn.net/u011063151/article/details/84061620</li>
</ul>
<h2>3、springcloud2.0-yipinketang-eureka-client是Eureka客户端服务</h2>
<ul>
<li>Eureka客户端搭建步骤：https://blog.csdn.net/u011063151/article/details/84068307</li>
<li>Eureka客户端注册到Eureka注册中心</li>
</ul>
<h2>4、微服务调用 RestTemplate和FeignClient</h2>
<ul>这一节主要搭建了两个微服务模块：</br>
  <li>服务的提供方：springcloud2.0-yipinketang-provider-service</li>
  <li>服务的调用方：springcloud2.0-yipinketang-consumer-service</li>
 </ul>
<ul>在SpringCloud微服务框架中，一般会采用两种比较常见的方式调用服务接口：
  <li>1、SpringBoot-web组件提供的RestTemplate </br> RestTemplate自带负载均衡能力，但要使用@LoadBalanced注解开启负载均衡</li> 
  <li>2、FeignClient </br> feign 自带负载均衡能力，断路器、服务降级、线程池隔离功能 (@FeignClient、@HystrixCommand)</li>
</ul>
  
  
  
  
  
  
  
  
  
  
  
  
  
  
 </br> </br> </br> </br> </br> </br> </br> 
<p>未完待续......</p>
