package listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ServletListener
 *
 */
// 注解注入
// @WebListener
public class ServletListener implements ServletRequestListener, ServletRequestAttributeListener {

	/**
	 * Default constructor.
	 */
	public ServletListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
	 *      通知当前对象，请求已经被消除
	 */
	public void requestDestroyed(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
	 *      通知当前对象请求已经被加载及初始化
	 */
	public void requestInitialized(ServletRequestEvent arg0) {
		System.out.println("-----------------ServletListener监听对象已经被加载-----------------");
	}

	// 向Request对象添加新属性
	@Override
	public void attributeAdded(ServletRequestAttributeEvent arg0) {
		System.out.println("-----------------ServletListener向Request对象添加新属性-----------------");
		System.out.println("name为：" + arg0.getName() + "-----值为" + arg0.getValue());

	}

	// 从request对象中删除属性
	@Override
	public void attributeRemoved(ServletRequestAttributeEvent arg0) {
		// TODO Auto-generated method stub

	}

	// 替换对象中现有属性值
	@Override
	public void attributeReplaced(ServletRequestAttributeEvent arg0) {
		System.out.println("-----------------ServletListener替换对象中现有属性值-----------------");
		String oldValue = String.valueOf(arg0.getValue());// 旧的属性
		String newValue = String.valueOf(arg0.getServletRequest().getAttribute(arg0.getName()));// 新的属性
		System.out.println("name" + arg0.getName() + "------------oldValue:" + oldValue + "::newValue" + newValue);
	}

}
