#  Netty网络基础架构系统

采用Netty信息加载实现长连接实时通讯系统，客户端可以是任何场景，支持实时http通讯、webSocket通讯、tcp协议通讯、和udp协议通讯、广播协议等。支持http协议，rpc协议。采用自定义网络数据包结构，实现自定义网络栈。

1：支持分布式zookeeper进行服务节点配置。\
2：采用自定义注解形式实现netty私有消息协议栈。\
3：支持远程RPC调用。\
4：支持redis。\
5：支持db分离。\
6: 支持同步和异步消息处理\
7: 支持kafka消息队列提供/消费 模式来实现分布式消息队列\
8: 支持数据加密传输，保障数据安全。\
9: 支持分布式事务3pc提交，异常回滚。

## 主要使用业务场景

1:游戏服务器\
2:实时通讯系统\
3:金融数据处理系统\
4:对网络实时性要求较高的系统\
5:常见互联网系统

## 通信模式


### TCP 通信模式

tcp通讯，采用netty实现tcp通讯，项目中可以利用 com\twjitm\core\start\GameService ,将启动模式改为tcp服务器启动模式
可以利用test中的\test\java\com\twjitm\ClientServiceTest 可以模拟客户端进行连接，需要将端口和地址改为tcp服务器进行连接。
tcp消息处理采用消息队列，将所有到来的消息放到队列中，通过线程池化技术来处理消息。

### UDP 通信模式
UDP自定义网络协议栈和tcp自定义网络协议栈格式差不多，不同的是udp不需要建立连接，也就是无状态的通信模式。在消息处理模块采用
tcp连接的时候利用保存的session来确定是哪个客户端发出的消息。

### HTTP 通信模式
HTTP协议同样采用自定义网络协议栈实现，和tcp，udp协议差不多，只不过数据包不一样，http是建立在tcp的应用层上的协议。采用同步处理方式，当消息到来的时候及时作出处理。


### RPC 通信模式
RPC模块分为同步调用和异步调用，远程服务器调用，利用netty实现轻量级rpc服务器框架，通过自定义线程让步策略，结合动态代理等实现rpc服务器通讯模块。利用xml文档配置rpc服务器基本信息，以达到动态的水平扩展服务器。

## 分布式

### zookeeper 服务

通过整合zookeeper，动态地注册服务，发现服务，整合rpc逻辑，实现分布式服务发现和注册。

### kafka服务

通过整合kafka服务。实现分布式服务器消息队列，解耦系统中的逻辑。


## 其他
### spring容器的使用

本项目利用spring来统一管理一些bean，利用服务器启动的时候，统一将容器初始化提交给spring，利用spring提供的注解，轻松获得注入到spring容器中的bean对象，提高代码的可读性。

### 事件更新器
通过线程管理，服务器事件更新采用独立模式来更新服务器事件，采用队列模式来使得事件串行执行。

