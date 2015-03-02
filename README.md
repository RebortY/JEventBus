# JEventBus
基于EventBus增加tag, threadMode支持，去掉了繁琐的onEvent的方法开头，采用注解

#https://github.com/greenrobot/EventBus 原项目地址
优势和好处，就不在这里赘述，可以看一下原项目的介绍。
在原项目的基础上，做了一些修改
1. 不需要使用 onEvent开头的方法来进行线程的区分
2. 增加了tag 可以使区分相同事件的情况下，不同的事件处理
3. 保留了所有的EventBus的特性 



使用方法：

EBEventBus  bus = EBEventBus.createEventBus(true); //参数标示，是否向父类传递 true向父类传递，false 不传递
bus.register(this);  //注册可以是任意对象
  
  //以描述代替固定的方法名字 
  @Subcriber(tag = "helloTag" , threadMode = ThreadMode.MainThread)
	public void mainThreadtest(Event event){
		//TODO  do something 
	}
	//发送事件有两种方法
	bus.post( new Event(), "hello");
	bus.post( new Event() );
	
存在的问题，对于stickEvent 还没有做很好的支持。
有兴趣的朋友，可以fork 一份修改。

目前已经使用到企业级应用中。
   
