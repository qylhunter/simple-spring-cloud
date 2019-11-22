
#simple-spring-cloud

##背景
搭建简单快速入门spring cloud项目

##1、使用技术
```
eureka、zuul、zipkin、spring security、feign、hystrix

环境：jdk1.8、spring cloud Greenwich.SR3
```
##2、功能模块
```
eureka-server：注册中心
service-hi; service-hello：业务模块
zuul：智能网关
zipkin：日志链路追踪

```
##3、实现功能
```
1、注册中心及服务管理（注册中心登录、注册设置验证）；
2、服务注册、服务发现（注册服务时需要验证验证）；
3、zipkin日志链路追踪；
4、feign远程调用接口；
5、zuul过滤；
6、统一接口调用：使用zuul路由；
7、接口熔断处理；
8、业务网关service-hi/hello的接口接入验证设置；
```
##4、使用
```
以下为范例中的配置(自定义配置，根据自定义配置的修改)
1、eureka server查看注册的服务：http://localhost:18000/
2、zipkin 查看日志链路：http://localhost:18003/zipkin/
3、接口测试（路由、feign）
hi:
http://localhost:18001/service-hi/hi
hello:
http://localhost:18001/hello/hello


```


