package control.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import eb.eventbus.ThreadMode;

/**
 * ***********************文件信息*****************************
 * 模块名：EBEventBus
 * 文件名：Subcriber.java
 * 创建者：yangll
 * 创建日期：2015-2-9
 * 功能描述：事件接收函数的注解类,运用在函数上
 **********************************************************
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Subcriber {
   /**
	* 事件的tag,类似于BroadcastReceiver中的Action,事件的标识符 
	* @return
	*/
	String tag() default TagType.DEFAULT_TAG;
	/**
	 * 所在的线程模型 
	 * @return
	 */
	ThreadMode threadMode() default ThreadMode.PostThread;
}
