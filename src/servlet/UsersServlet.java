package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import service.UserService;
import utils.ServletUtils;

/**
 * Servlet implementation class UsersServlet
 */
@WebServlet("/servlet/UsersServlet")
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsersServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		JSONObject ajaxPostJsonParam = ServletUtils.getAjaxPostJsonParam(request);
		request.setAttribute("testListener", "第一次");
		request.setAttribute("testListener", "不是第一次");

		System.out.println("####################  ajaxPostJsonParam:" + ajaxPostJsonParam.toString());
		Object values = ajaxPostJsonParam.get("id");
		System.out.println("####################  id:" + String.valueOf(values));
		UserService userService = new UserService();
		String usersByJsonString = userService.getUsersByJsonString(String.valueOf(values));

		response.getWriter().print(usersByJsonString);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
