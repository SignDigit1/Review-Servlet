package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class HttpFilter
 */
// 注解注册
// @WebFilter("/*")
public class HttpFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public HttpFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 通过过滤器设置编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		// 只允许contentType为application/json，即为json数据
		if ("application/json".equals(request.getContentType())) {
			System.out.println("**************通过过滤**************");
			// 把请求传回过滤链
			chain.doFilter(request, response);
		} else {
			System.out.println("**************contenttype类型不对，不通过**************");
			return;
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// 获取初始化参数
		String site = fConfig.getInitParameter("Site");
		// 输出初始化参数
		System.out.println(site);
	}

}
