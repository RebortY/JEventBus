package control;

import control.annotation.TagType;
import eb.eventbus.EventBus;

/**
 * ***********************文件信息*****************************
 * 模块名：EBNetwork
 * 文件名：EBNetcore.java
 * 创建者：yangll
 * 创建日期：2015-1-6
 * 功能描述：网络处理对外接口  可同时并发 1000 个事件
 **********************************************************
 */
public class EBEventBus {

	EventBus buscontrol = null;
	/**
	 * 是否开启穿父类  
	 * @param inheritance  
	 * true  父类，子类都会接收到事件传递
	 * false 父类接收不到事件传递
	 */
	private EBEventBus(boolean inheritance) {
		//创建一个不开启父类缓存的事件总线 , 目前 Async 方式使用的时 无界线程池。
		buscontrol = EventBus.builder().eventInheritance(inheritance).build();
	}

	/**
	 * 创建新的事件总线 
	 *@param inheritance  
	 *       true  父类，子类都会接收到事件传递
	 *       false 父类接收不到事件传递
	 * 
	 * @param 事件传递唯一标示 ( 可以为 null  为 null时 使用默认tag)
	 * 
	 * @return EBEventBus
	 */
	public static EBEventBus createEventBus(boolean inheritance) {
		return new EBEventBus(inheritance);
	}

	/**
	 * 注册订阅者
	 * @param subscriber
	 */
	public void register(Object subscriber) {
		buscontrol.register(subscriber);
	}
	
	/**
	 * 注册订阅者并给与优先级
	 * @param subscriber
	 * @param priority   优先级 0 最高 从 0 到 正无穷优先级一次递减。 默认不要设置 0 
	 */
	public void register(Object subscriber, int priority) {
		buscontrol.register(subscriber, priority);
	}
	
	/**
	 * 注销订阅者
	 * @param subscriber
	 */
	public void unregister(Object subscriber){
		buscontrol.unregister(subscriber);
	}
	
	/**
	 * 注册订阅者并缓存
	 * @param subscriber
	 */
	public void registerSticky(Object subscriber) {
		buscontrol.registerSticky(subscriber);
	}
	
	/**
	 * 注册订阅者设置优先级 并 缓存
	 * @param subscriber
	 * @param priority  优先级 0 最高 从 0 到 正无穷优先级一次递减。 默认不要设置 0
	 */
	public void registerSticky(Object subscriber, int priority) {
		buscontrol.registerSticky(subscriber, priority);
	}
	
	/**
	 * 获取最新的缓存事件
	 * @param eventType
	 * @return
	 */
	public <T> T getStickyEvent(Class<T> eventType){
		return buscontrol.getStickyEvent(eventType);
	}
	
	/**
	 * 删除缓存事件
	 * @param event
	 * @return true 删除成功   false 已经被删除了
	 */
	public boolean removeStickyEvent(Object event){
		return buscontrol.removeStickyEvent(event);
	}
	
	/**
	 * 删除缓存事件并返回最近的一次事件类型
	 * @param eventType
	 * @return
	 */
	public <T> T removeStickyEvent(Class<T> eventType){
		return buscontrol.removeStickyEvent(eventType);
	}
	
	/**
	 * 删除所有缓存事件
	 */
	public void removeAllStickyEvents(){
		 buscontrol.removeAllStickyEvents();
	}
	
	/**
	 * 向事件总线中发送事件
	 * @param event
	 */
	public void post(Object event){
//		buscontrol.post(event); 注销原有的post方法
		buscontrol.post(event, TagType.DEFAULT_TAG);
	}
	
	public void post(Object event , String tag){
		tag = tag == null ? TagType.DEFAULT_TAG : tag;
		buscontrol.post(event, tag);
	}
	
	/**
	 * 想事件总线中发送需要缓存的事件
	 * @param event
	 */
	public void postSticky(Object event){
		buscontrol.postSticky(event);
	}

}
