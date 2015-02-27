package control.annotation;
/**
 * ***********************文件信息*****************************
 * 模块名：EBEventBus
 * 文件名：TagType.java
 * 创建者：yangll
 * 创建日期：2015-2-9
 * 功能描述： 
 *          该类是描述一个函数唯一性的对象，参数类型、tag两个条件保证了对象的唯一性.
 *          通过该类的对象来查找注册了相应类型和tag的所有订阅者, 
 *          并且在接到消息时调用所有订阅者对应的函数.
 **********************************************************
 */
public class TagType {
   
	/**
	* 默认的tag
	*/
	public static final String DEFAULT_TAG = "default_tag";

	/**
	 * 参数类型
	 */
	Class<?> paramClass;
	/**
	 * 函数的tag
	 */
	public String tag = DEFAULT_TAG;

	/**
	 * @param aClass
	 */
	public TagType(Class<?> aClass) {
		this(aClass, DEFAULT_TAG);
	}

	public TagType(Class<?> aClass, String aTag) {
		paramClass = aClass;
		tag = aTag;
	}
	
	@Override
	public String toString() {
		return "EventType [paramClass=" + paramClass.getName() + ", tag=" + tag + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((paramClass == null) ? 0 : paramClass.hashCode());
		result = prime * result + ((tag == null) ? 0 : tag.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TagType other = (TagType) obj;
		if (paramClass == null) {
			if (other.paramClass != null)
				return false;
		} else if (!paramClass.equals(other.paramClass))
			return false;
		if (tag == null) {
			if (other.tag != null)
				return false;
		} else if (!tag.equals(other.tag))
			return false;
		return true;
	}
}
