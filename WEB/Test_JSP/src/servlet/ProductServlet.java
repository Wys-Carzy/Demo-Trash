package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import entity.*;
import services.ProductServices;
/**
 * ��ƷServlet��
 * @author Wys
 *
 */
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 5223550490384111636L;
	
	HttpSession session;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String param = request.getParameter("param");
		
		session = request.getSession();	// ʵ��session����
		String URL = null;
		if ( "show".equals(param) ) {								// չʾ������Ʒ
			Map<String, Product> good = showGoods();
			session.setAttribute("goods", good);
			URL = "home.jsp";
		}else if( "buy".equals(param) ){							//��ӵ����ﳵ
			Object name = session.getAttribute("user");
				if(name==null){
					URL = "Login.jsp";
				}else{
					String ID = request.getParameter("id");
					int x = 0 ;
					if(request.getParameter("admin")!=null){
						x = Integer.parseInt(request.getParameter("admin"));
					}else{
						x = 1;
					}
					boolean pro = Buy(ID , x , name);
					URL = "ProductServlet?param=Shop";
				}
		}else if("Shop".equals(param)){								//��ʾ���ﳵ
			String table = "Shopping" ;
			Object name = session.getAttribute("user");
			if(name==null){
				URL = "Login.jsp";
			}else{
	    		Map<String, Shopping> shop = Shop(name , table);
				session.setAttribute("shop", shop);
	    		URL = "shop.jsp";
			}
		}else if("tobuy".equals(param)){							//�ύ����
			Object name = session.getAttribute("user");
			if(name==null){
				URL = "Login.jsp";
			}else{
				String ID = request.getParameter("id");
				int x = 0 ;
				if(request.getParameter("num")!=null && Integer.parseInt(request.getParameter("num"))>0){
					x = Integer.parseInt(request.getParameter("num"));
				}else{
					x = 1;
				}
				boolean flag = toBuy(ID , x , name);
				URL = "ProductServlet?param=Indent";
			}
		}else if("del".equals(param)){								//�ӹ��ﳵɾ��
			Object name = session.getAttribute("user");
			if(name==null){
				URL = "Login.jsp";
			}else{
				String ID = request.getParameter("id");
				String table = "Shopping";
				boolean flag = del(ID , name , table);
				URL = "ProductServlet?param=Shop";
			}
		}else if("Indent".equals(param)){							//��ʾ����
			String table = "Indent";
			Object name = session.getAttribute("user");
			if(name==null){
				URL = "Login.jsp";
			}else{
	    		Map<String, Shopping> lndent = Shop(name , table);
				session.setAttribute("lndent", lndent);
				URL = "Indent.jsp";
	    	}
		}else if("todel".equals(param)){							//ɾ��
			Object name = session.getAttribute("user");
			if(name==null){
				URL = "Login.jsp";
			}else{
				String ID = request.getParameter("id");
				String table = "Indent";
				boolean flag = del(ID , name , table);
				URL = "ProductServlet?param=Indent";
			}
		}else if("collect".equals(param)){							//����ղ�
			Object name = session.getAttribute("user");
			if(name==null){
				response.setContentType("text/html");
				out.print(name);
				out.flush();
				out.close();
			}else{
				String ID = request.getParameter("id");
				boolean flag = collect(ID , name);
				if(flag==false){
					response.setContentType("text/html");
					out.print(flag);
					out.flush();
					out.close();
				}else{
					response.setContentType("text/html");
					out.print(flag);
					out.flush();
					out.close();
				}
			}
		}else if("showCollect".equals(param)){						//��ʾ�ղ�
			Object name = session.getAttribute("user");
			if(name==null){
				URL = "Login.jsp";
			}else{
	    			Map<String, Shopping> shop = showCollect(name);
					session.setAttribute("showCollect", shop);
	    		}
				URL = "collect.jsp";
		}else if("delCollect".equals(param)){
			Object name = session.getAttribute("user");
			if(name==null){
				URL = "Login.jsp";
			}else{
					String ID = request.getParameter("id");
					String table = "Collect";
					boolean flag = del(ID , name , table);
					URL = "ProductServlet?param=showCollect";
				}
		}else if("update".equals(param)){							//�޸Ĺ��ﳵ����
			Object name = session.getAttribute("user");
			if(name==null){
				URL = "Login.jsp";
			}else{
					String ID = request.getParameter("id");
					int num = Integer.parseInt(request.getParameter("num"));
						if(num>0){
							boolean flag = update(ID , name , num);
							response.setContentType("text/html");
							out.println("<font color='#FF8080'>�޸ĳɹ���</font>");
							out.flush();
							out.close();
						}else{
							response.setContentType("text/html");
							out.println("<font color='#FF0000'>��ȷ�������������Ϊ������</font>");
							out.flush();
							out.close();
						}
				}
			
		}
		request.getRequestDispatcher(URL).forward(request, response);
	}
	
	/**
	 * �޸Ĺ��ﳵ����
	 */
	public boolean update(String iD, Object name, int num) {
		ProductServices ps = new ProductServices();
		boolean flag = ps.update(iD , name ,num);
		return flag;
	}

	/**
	 * ��ѯ�ղؼ�
	 */
	public Map<String, Shopping> showCollect(Object name) {
		ProductServices ps = new ProductServices();
		Map<String, Shopping> goodsMap = ps.showCollect(name);
		return goodsMap;
	}
	/**
	 * �����ղ�
	 */
	public boolean collect(String id, Object name) {
		ProductServices ps = new ProductServices();
		boolean map = ps.collect(id , name);
		return map;
	}

	/**
	 * ɾ����Ʒ
	 */
	public boolean del(String id, Object name, String table) {
		ProductServices ps = new ProductServices();
		boolean map = ps.del(id , name ,table);
		return map;
	}
	/**
	 * �ύ����
	 */
	public boolean toBuy(String id, int x, Object name) {
		ProductServices ps = new ProductServices();
		boolean map = ps.buyGoods(id , x , name);
		return map;
	}
	/**
	 * ��ѯ������Ʒ
	 */
	public Map<String, Product> showGoods() {
		ProductServices ps = new ProductServices();
		Map<String, Product> goodsMap = ps.showAllGoods();
		return goodsMap;
	}
	/**
	 * �����Ʒ�����ﳵ
	 */
	public boolean Buy(String ID , int num , Object s){
		ProductServices ps = new ProductServices();
		boolean pro = ps.addCart(ID,num , s);
		return pro;
	}
	/**
	 * ��ѯ���ﳵ�Լ�����
	 */
	public Map<String, Shopping> Shop(Object name , String table ){
		ProductServices ps = new ProductServices();
		Map<String, Shopping> pro = ps.selectShop(name , table);
		return pro;
	}
}
