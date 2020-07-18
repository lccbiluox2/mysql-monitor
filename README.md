# mysql-monitor
MYSQL 监控工具，优化工具，各种工具为一体的java spring boot 项目



# 2. 代码架构

![image-20200718131717024](doc/images/image-20200718131717024.png)

# 3. 后端服务

后端服务的主类是`com.neo.MySQLMointorApplication`

## 3.1 后端服务的数据库

```shell
spring.datasource.driverClassName = com.mysql.jdbc.Driver
spring.datasource.url = jdbc:mysql://localhost:3306/mysql_monitor?useUnicode=true&characterEncoding=utf-8&useSSL=true
spring.datasource.username = root
spring.datasource.password = 12345678
```

这个根据自己的需要进行修改。

SQL运行的脚本在`doc/sql/mysql_monitor.sql`请先执行建表操作，然后运行主类。

# 4.前端服务

前端主页面：`web-provider/html/database/database-list.html`

因为是前后端分离，采用最原始的html+jquery+ajax操作后端并且显示，解决了跨域的问题。直接打开页面即可。

## 4.1 配置

前端的配置文件如下：`web-provider/js/constant.js`

```shell
//定义几个全局变量
var AppUrl = "http://localhost:8090";//整个页面的请求页面

```

主要配置后端请求的地址。

# 5.效果如下

## 5.1 数据库列表页面

![image-20200718132426182](doc/images/image-20200718132426182.png)

## 5.2 数据库详情页面

![image-20200718132451189](doc/images/image-20200718132451189.png)

## 5.3 表列表页面

![image-20200718132514464](doc/images/image-20200718132514464.png)

## 5.4 表详情页面

![image-20200718132536443](doc/images/image-20200718132536443.png)



后面还会开发更多功能。。。等待中。。