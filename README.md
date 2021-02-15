## intro

> 从一开始, 就是Boot.   

大学一直在用boot来连接所有事物, jpa security web来开始项目. 

很奇怪的是, boot遇到的错误比较少, 不清楚背后的原理, 所有目标专注到了业务上.

现在, 开始关注server 性能 事件驱动 协程.

可能再也没有接触到spring机会了, 直到看到了毕设, 开始构思架构. 当模型浮现在脑海中, 突然看到**ssm限定**.

## usage

为了更多的了解ssm 

有了回声项目 很容易上手 

### 功能

访问 http://localhost/ping 响应 pong

访问 http://localhost/ping/ioc 响应 pong

访问 http://localhost/ping/db 响应 pong

### 使用

1. 创建maven
2. 添加mvc依赖
3. 创建web
4. 添加mybatis依赖
5. 访问

## ssm 

最近几天试了下[纯ssm](https://baike.baidu.com/item/SSM/18801167), 分为两块来说 ss m, 我认为**ss和m也应该是组合关系, 而不应该是依赖**.

换句话所, mybatis不应该使用ioc来管理.


### m

m即mybatis, 持久层框架, 不是orm, 思想比较好, xml来生成sql语句, 框架来执行, sql是领域语言, 本就不应该与java同框. 

这种半自动反而要比orm性能高, 灵活. 

我认为**简单sql注解, 复杂sql用xml**.

### ss

ss即spring + springmvc, springmvc包括spring, mvc也是最应该使用ioc来管理的bean. 

前后端分离后, ss完全不需要配置文件, spring作为一个servlet把server的request拿到给了mvc即可. 

我认为**web应该由onSetup来触发**.

## 最后

相比起boot, ssm更清亮, 更容易理解, 更容易排错. 

看起来, 有点像springboot.

吐槽 & 吃瓜 & 交流 see -> [issue](https://github.com/ZeerBeer/echo-ssm/issues)