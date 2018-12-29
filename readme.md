# AIDL 简介
## 概念
Android提供的一种进程间通信的机制
## AIDL支持的数据类型
四种:
* Java的基本数据类型
* List和Map
  * 元素必须是AIDL支持的数据类型
  * Server端具体的类里必须是ArrayList或者HashMap
* 其他AIDL生成的接口
* 实现Parcelable的类
  
## AIDL如何编写
三部分:
1. 创建AIDL
   1. 创建要操作的实体类,实现Parcelable接口,以便于序列化
   2. 新建aidl文件夹在里面创建
      1. 业务接口aidl文件
      2. 实体类的映射aidl文件
   3. As Make project,生成Binder的java文件
2. Server
   1. 创建Service类,在类中创建Binder对象,实现对应的方法,注册service为远程服务
   2. 在onBind()中返回
3. client
   1. 实现ServiceConnection接口,在其中拿到AIDL类
   2. bindService()
   3. 调用AIDL类中定义好的操作请求

# AIDL内部实现

* IBinder:IBinder是一个接口,代表一种跨进程通信的能力.只要实现了这个接口,这个对象就能跨进程传输.
* IInterface:代表的就是Server进程对象具备什么样的能力(能提供哪些方法,其实对应的就是AIDL文件中定义的接口)
* Binder:java层的Binder类,代表的其实就是Binder本地对象.BinderProxy类是Binder类的一个内部类,他代表远程进程的Binder对象的本地代理;这个两个类都继承自IBinder,因而都具有跨进程传输的能力;实际上,在跨进程的时候,Binder驱动会自动完成这两个对象的转换.
* Stub:AIDL的时候,编译工具会给我们生成一个名为Stub的静态内部类;这个类继承了Binder,说明它是一个Binder本地对象,它实现了IInterface接口,表明它具有Server承诺给Client的能力;Stub是一个抽象类,具体的IInterface的相关实现需要开发者自己实现.