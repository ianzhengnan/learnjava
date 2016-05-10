package ian.annotation.listener;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

import java.awt.event.ActionListener;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ActionListenerFor{

	//定义一个成员变量用于设置元数据
	//该listener成员变量用于保存监听器实现类
	Class<? extends ActionListener> listener();

}