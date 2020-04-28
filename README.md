# StudySpringCloud
To learn about spring cloud creation

##80端口被占用

netstat -ano,列出所有端口的情况

netstat -aon|findstr "80" 找到端口对应的pid(4)

tasklist|findstr "4"  根据pid发现哪个进程占用

taskkill /f /t /im System.exe。杀死对应的进程,如果是系统占用可以去服务管理(services.msc)停止服务.


控制层返回后结果统一,格式统一.防止出现不匹配错误.

##问题

com.netflix.hystrix.exception.HystrixRuntimeException: PaymentHystrixService#paymentInfo_OK(Integer) failed and no fallback available.
com.netflix.client.ClientException: Load balancer does not have available server for client: CLOUD-PROVIDER-HYSTRIX-PAYMENT

解决方法:
- 没有引入Eureka依赖
- 服务名称不对
- 消费端eureka配置错误

    \#true 表示往注册中心注册自己
    
    register-with-eureka: true
    
    \#true 表示去检索eureka服务
    
    fetch-registry: true

