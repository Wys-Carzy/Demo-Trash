package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import services.UserServices;
/**
 * �û�Servlet��
 * @author Wys
 *
 */
public class UsersServlet extends HttpServlet {

	private static final long serialVersionUID = 1750005275287175407L;

	private HttpSession session;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String param = request.getParameter("param");
		session = request.getSession();	// ʵ��session����
		
		if ("login".equals(param) ) {
			String uname = request.getParameter("username");
			String upwd = request.getParameter("password");
			String time = request.getParameter("time");
			boolean flag;
			if(time==null){
				time = (60*60*24) + "";
				flag = login(uname, upwd, time);
					if(flag == false){
						out.print(flag);
						out.flush();
						out.close();
					}else{
						Cookie cookie = new Cookie("user",uname);
						cookie.setMaxAge(Integer.parseInt(time));
						response.addCookie(cookie);
						session.setAttribute("user", uname);
						out.print(flag);
						out.flush();
						out.close();
					}
			}else{
				flag = login(uname, upwd, time);
					if(flag == false){
						response.setContentType("text/html");
						out.print(flag);
						out.flush();
						out.close();
					}else{
						Cookie cookie = new Cookie("user",uname);
						cookie.setMaxAge(Integer.parseInt(time));
						response.addCookie(cookie);
						session.setAttribute("user", uname);
						out.print(flag);
						out.flush();
						out.close();
					}
			} 
		} else if ("out".equals(param)) {
			Cookie cookie = new Cookie("user",null);
			cookie.setMaxAge(0);
			response.addCookie(cookie);
			session.removeAttribute("user");
			response.sendRedirect("index.jsp");
		} else if ("add".equals(param)) {
			String uname = request.getParameter("username");
			String upwd = request.getParameter("password");
			boolean flag = add(uname, upwd);
			out.print(flag);
			out.flush();
			out.close();
		}else if ("pass".equals(param)){
			String name = request.getParameter("username");
			String pwd = request.getParameter("password");
			String pass = request.getParameter("pass");
			boolean flag = pass(name,pwd,pass);
			out.print(flag);
			out.flush();
			out.close();
		}
	}
	/**
	 * ��¼
	 */
	public boolean login(String uname, String upwd ,String time) {
		UserServices us = new UserServices();
		return us.doLogin(uname, upwd);
	}
	/**
	 * ע��
	 */
	public boolean add(String uname, String upwd) {
		UserServices us = new UserServices();
		return us.doAdd(uname, upwd);
	}
	/**
	 * �޸�����
	 */
	public boolean pass(String name , String password , String pass){
		UserServices us = new UserServices();
		return us.pass(name, password, pass);
	}
}
