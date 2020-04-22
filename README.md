# StudySpringCloud
To learn about spring cloud creation

##80端口被占用

netstat -ano,列出所有端口的情况

netstat -aon|findstr "80" 找到端口对应的pid(4)

tasklist|findstr "4"  根据pid发现哪个进程占用

taskkill /f /t /im Tencentdl.exe。杀死对应的进程,如果是系统占用可以去服务管理(services.msc)停止服务.