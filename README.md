## beer.zeer:echo:1 

### 发布了 看看做了哪些改动吧 

```
1/ jdbc   <-  mybatis (性能和使用便捷程度配置文件分离)   
2/ Logger ->  TEST    (供给TEST环境下使用)  
3/ IOC        x       (官方没有搞懂持久化作为Bean)   
4/ pom        war     (可以直接使用mvn package -f pom.xml)  
5/ package    beer.zeer -> beer.zeer.echo  
```

### 使用 

```shell
# 确保 mvn 和 java 命令可用
set JAVA_HONE=${javahome}
mvn package -f pom.xml
```

### 用的不爽 | 好的想法 

[issuer](https://github.com/ZeerBeer/echo-ssm/issues)
