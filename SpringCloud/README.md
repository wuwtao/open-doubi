#### Spring Cloud 介绍
Spring Cloud是一个基于Spring Boot实现的云原生应用开发工具，使得以往频繁操作的组件可以达到开箱即用的特性。
SpringBoot旨在简化创建产品级的 Spring 应用和服务，简化了配置文件，使用嵌入式web服务器，含有诸多开箱即用微服务功能
Spring Cloud是一套完整的微服务解决方案，它将现在非常流行的一些技术整合到一起，实现了微服务中诸如：配置管理，服务发现，智能路由，负载均衡，熔断器，控制总线，集群状态等等功能。

#### Spring Cloud 子项目介绍
1. Spring Cloud Config：配置管理开发工具包，可以让你把配置放到远程服务器，目前支持本地存储、Git以及Subversion。
2. Spring Cloud Bus：事件、消息总线，用于在集群（例如，配置变化事件）中传播状态变化，可与Spring Cloud Config联合实现热部署。
3. Spring Cloud Netflix：针对多种Netflix组件提供的开发工具包，其中包括Eureka、Hystrix、Zuul、Archaius等。
   - Netflix Eureka：云端负载均衡，一个基于 REST 的服务，用于定位服务，以实现云端的负载均衡和中间层服务器的故障转移。
   - Netflix Hystrix：容错管理工具，旨在通过控制服务和第三方库的节点,从而对延迟和故障提供更强大的容错能力。
   - Netflix Zuul：边缘服务工具，是提供动态路由，监控，弹性，安全等的边缘服务。
   - Netflix Archaius：配置管理API，包含一系列配置管理API，提供动态类型化属性、线程安全配置操作、轮询框架、回调机制等功能。
4. Spring Cloud for Cloud Foundry：通过Oauth2协议绑定服务到CloudFoundry，CloudFoundry是VMware推出的开源PaaS云平台。
5. Spring Cloud Sleuth：日志收集工具包，封装了Dapper,Zipkin和HTrace操作。
6. Spring Cloud Data Flow：大数据操作工具，通过命令行方式操作数据流。
7. Spring Cloud Security：安全工具包，为你的应用程序添加安全控制，主要是指OAuth2。
8. Spring Cloud Consul：封装了Consul操作，consul是一个服务发现与配置工具，与Docker容器可以无缝集成。
9. Spring Cloud Zookeeper：操作Zookeeper的工具包，用于使用zookeeper方式的服务注册和发现。
10. Spring Cloud Stream：数据流操作开发包，封装了与Redis,Rabbit、Kafka等发送接收消息。
11. Spring Cloud CLI：基于 Spring Boot CLI，可以让你以命令行方式快速建立云组件。

#### SpringCloud特点
1. 约定优于配置
2. 开箱即用、快速启动
3. 适用于各种环境
4. 轻量级的组件
5. 组件支持丰富，功能齐全

#### Spring Cloud Netflix目录案例

#### SpringCloud alibaba 目录案例

`该页为目录页，持续更新....`

