package control.baseevent;
/**
 * ***********************文件信息*****************************
 * 模块名：EBEventBus
 * 文件名：RequestEvent.java
 * 创建者：yangll
 * 创建日期：2015-1-6
 * 功能描述：请求事件基类 （网络层使用）
 **********************************************************
 */
public abstract class RequestEvent {
	  public long acvtime;   // 激活时间
	  public long delaytime; // 最大超时时间 单位毫秒
	  public Object inparam; // 输入参数
	  
	  public int nettype; // 使用的网络类型
	  /**
	   * 发送协议
	   * protocolstr 与 data 是 互斥存在
	   * 如果 同时存在，网络层只发送 protocolstr 
	   */
	  public String protocolStr;// 协议str
	  /**
	   * 发送二进制数据
	   */
	  public byte[] data;
}
