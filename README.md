# 基于Springcloud2.0构建分布式服务
<p>这是一个maven的聚合项目</p>
<h2>1、springcloud2.0-parent作为一个pom项目，为其他module提供公共的依赖信息</h2>
<ul>
  <li>spring-boot-starter-web依赖 提供SpringBoot-webmvc组件</li> 
  <li>spring-cloud-starter-netflix-eureka-server依赖 提供SpringCloud-Eureka Server组件</li> 
  <li>spring-cloud-netflix-eureka-client依赖 提供SpringCloud-Eureka Client组件</li> 
  <li>spring-cloud-starter-netflix-hystrix依赖 提供SpringCloud-Eureka hystrix组件，实现服务熔断，防止服务雪崩，通过在接口上使用@HystrixCommand注解，可以对接口进行线程池级别的隔离</li> 
  <li>spring-cloud-starter-openfeign依赖 提供SpringCloud-openfeign微服务调用组件</li> 
</ul>
<h2>2、springcloud2.0-eureka-server是Eureka注册中心服务</h2>
<ul>
<li>注册中心搭建步骤：https://blog.csdn.net/u011063151/article/details/84061620</li>
</ul>
<h2>3、springcloud2.0-eureka-client是Eureka客户端服务</h2>
<ul>
<li>Eureka客户端搭建步骤：https://blog.csdn.net/u011063151/article/details/84068307</li>
<li>Eureka客户端注册到Eureka注册中心</li>
</ul>
<h2>4、微服务调用 RestTemplate和FeignClient</h2>
<ul>这一节主要搭建了两个微服务模块：</br>
  <li>服务的提供方：springcloud2.0-provider-service</li>
  <li>服务的调用方：springcloud2.0-consumer-service</li>
 </ul>
<ul>在SpringCloud微服务框架中，一般会采用两种比较常见的方式调用服务接口：
  <li>1、SpringBoot-web组件提供的RestTemplate </br> RestTemplate自带负载均衡能力，但要使用@LoadBalanced注解开启负载均衡</li> 
  <li>2、FeignClient </br> feign 自带负载均衡能力，断路器、服务降级、线程池隔离功能 (@FeignClient、@HystrixCommand)</li>
</ul>

<h2>5、微服务配置中心——SpringCloud config</h2>
<ul>这一节主要搭建了两个微服务模块：</br>
  <li>http://note.youdao.com/noteshare?id=16c9696422c93daecbf8d6e338d1f9f0</li>
</ul>

<h2>6、微服务配置中心高可用</h2>
<p>配置中心高可用，就是将配置中心作为一个微服务注册到注册中心，并且根据实际需求，启动多个配置中心，然后让客户端从注册中心获取配置中心应用实例，进而获取到配置中心的配置信息，配置中心高可用的优点：</p>
<ul>
  <li>多个配置中心实例集群，有利于更好、更稳定的提供服务，有效的防止单个实例宕机后，整个服务不可用</li>
  <li>更加符合微服务的理念，便于统一管理服务</li>
</ul>

<h2>7、微服务配置中心——及时获取最新配置数据——消息总线</h2>
<ul>
  <li>http://note.youdao.com/noteshare?id=fffdd08fbc86ef903d745d169d94563d</li>
</ul>
  
<h2>8、注册中心——consul</h2>
<ul>
  <li>https://github.com/wjzuo/SpringCloud2.0/tree/master/SpringCloud-consul</li>
  <li>http://note.youdao.com/noteshare?id=5612caf4a11b84159a2777c975212172</li>
</ul>
  
  
  
  
  
  
  
  
  
  
  
  
  
 </br> </br> </br> </br> </br> </br> </br> 
<p>未完待续......</p>
