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
    
##mbeanExporter重复加载报错 Error creating bean with name 'jmxMBeanExporter' defined in class path resource

解决方法

    - 1.spring.application.admin.enabled=false
    - 2.程序 编辑配置 enable JMX agent 去掉勾选
    
   
##基于Feign使用Hystrix

解决方法
    
    注释掉@HystrixCommand和@DefaultProperties(defaultFallback = "payment_Global_FallBackMethod"),两种方式不能兼容.


##HystrixCommand服务熔断

    当满足一定的阈值的时候(默认10秒内超过20个请求次数)
    当失败率达到一定的时候(默认10秒内超过50%个请求失败)
    到达以上阈值的时候,所有请求都不会进行转发
    一段时间之后(默认5秒),这个时候断路器是半开状态,会让其中一个请求进行转发.
    如果成功,断路器会关闭,若失败,继续开启.重复4和5.
