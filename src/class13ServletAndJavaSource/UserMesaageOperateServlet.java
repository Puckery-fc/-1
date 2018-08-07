package class13ServletAndJavaSource;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Database;
import com.User;

/**
 * Servlet implementation class UserMesaageOperateServlet
 */ 
public class UserMesaageOperateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserMesaageOperateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if(action.equals("login"))
			loginUser(request, response);
		else
			if(action.equals("delete"))
				deleteUser(request, response);
			else
				if(action.equals("update"))
					updateUser(request, response);
				else if(action.equals("register"))
					registerUser(request, response);
				else if(action.equals("select"))
					selectUser(request,response);
				else if(action.equals("fc"))
					tianjia(request,response);
	}
	void selectUser(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException
	{
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
	
		String sql = "select * from tb_user ";
		Database db = new Database();
		ResultSet rs = db.query(sql);	
		ArrayList <User> list = new ArrayList<User>();
		try{
		while(rs.next()){
			User u1Temp = new User();
			u1Temp.userName = rs.getString(1);
			u1Temp.userPassword = rs.getString(2);
			list.add(u1Temp);
			
		}
		rs.close();
		}catch( SQLException e)
		{
			e.printStackTrace();
		}			
		db.close();
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>");
		out.println("<table width='450'border='1'>");
	    out.println("<tr><td align='center'colspan='2'><h2>�����û���Ϣ��</h2></td></tr>");
	    
	    out.println("<tr><td>�û���</td><td>����</td></tr>");
	
		//for(User user:list)
			for(int i=0;i<list.size();i++){
			User u1 = list.get(i);
			
			out.println("<tr><td>"+u1.userName+ "</td><td>"+u1.userPassword+"</td></tr>");
		
			}

			out.println("</table>");
		out.println("</body></html>");
		/*HttpSession session = request.getSession();
		session.setAttribute("userlist", list);
		response.sendRedirect("/2015javawebClassProject/13operateDatabaseServlet/1TotalOperateOfDBServlet/SelectUser.jsp");
		*/
	}
	
	/*void loginUser(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException
	{
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("name");
		String userPwd = request.getParameter("pwd");
		String sql = "select * from tb_user where userName='"+userName+"' and userPwd='"+ userPwd+"'";
		Database db = new Database();
		ResultSet rs = db.query(sql);	
		try{
		if(rs.next())
			{
				HttpSession session = request.getSession();
				session.setAttribute("transmitName", userName);
				String dir = request.getContextPath();
				response.sendRedirect(dir+"/13operateDatabaseServlet/1TotalOperateOfDBServlet/index11.jsp");			
			}
			else
				out.print("���û������ڣ�");
		rs.close();
		}catch( SQLException e)
		{
			e.printStackTrace();
		}			
		db.close();
		
	}
	*/
	void loginUser(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException
	{
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("name");
		String userPwd = request.getParameter("pwd");
		ArrayList<String>list = new ArrayList<String>();
		list.add(userName);
		list.add(userPwd);
		//����ռλ����sql
		String sql = "select * from tb_user where userName=? and userPwd=?";
		//�������ݿ�
		Database db = new Database();
		ResultSet rs = db.queryPreparedStatement(sql,list);	
		//���ݿ�ķ��ؽ���ж�
		try{
		if(rs.next())
			{
				HttpSession session = request.getSession();
				session.setAttribute("transmitName", userName);
				String dir = request.getContextPath();
				response.sendRedirect(dir+"/13operateDatabaseServlet/1TotalOperateOfDBServlet/index11.jsp");			
			}
			else
				out.print("���û������ڣ�");
		rs.close();
		}catch( SQLException e)
		{
			e.printStackTrace();
		}			
		db.close();
		
	}
	
	void deleteUser(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException
	{
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out =response.getWriter();
		String userName = request.getParameter("name");			
		String sql = "delete from tb_user where userName='"+userName+"'";	
		Database  db = new Database();
		Boolean result =  db.insertUpdateDelete(sql);
		if(result)
		{
			out.print("�û�ɾ���ɹ�");
			out.print("<br>");
			out.print("<a href='/2015javawebClassProject/13operateDatabaseServlet/1TotalOperateOfDBServlet/login.jsp'>��ת����¼ҳ��</a>");
		}
		else
		{
			out.print("�û�ɾ��ʧ��");
			out.print("<br>");
			out.print("<a href='/2015javawebClassProject/13operateDatabaseServlet/1TotalOperateOfDBServlet/login.jsp'>��ת����¼ҳ��</a>");	
		}
		db.close();		
	}
	
	void updateUser(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException
	{
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String userNameOld = request.getParameter("nameOld");
		String userNameNew = request.getParameter("nameNew");
		String userPwdNew = request.getParameter("pwdNew");		
		String sql = "update tb_user set userName='"+userNameNew+"',userPwd='"+userPwdNew+"' where userName='"+userNameOld+"'";		
		Database db = new Database();
		boolean result = db.insertUpdateDelete(sql);
		if(result)
		{
			out.print("�޸��û���Ϣ�ɹ�");		
			out.print("<br>");
			out.print("<a href='/2015javawebClassProject/13operateDatabaseServlet/1TotalOperateOfDBServlet/login.jsp'>��ת����¼ҳ��</a>");
		}
		else
		{
			out.print("�޸��û���Ϣʧ��");		
			out.print("<br>");
			out.print("<a href='/2015javawebClassProject/13operateDatabaseServlet/1TotalOperateOfDBServlet/UpdateUser.jsp'>�����޸�ҳ��</a>");
		}
		db.close();			
	}
	
	void registerUser(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException
	{
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("name");
		String userPwd = request.getParameter("pwd");	
		String sql = "insert into tb_user(userName,userPwd) values('"+userName+"','"+userPwd+"')";
		Database db =new Database();
		boolean result = db.insertUpdateDelete(sql);
		if(result)
		{		
			out.print("�û�ע��ɹ�");
			out.print("<br>");
			out.print("<a href='/2015javawebClassProject/13operateDatabaseServlet/1TotalOperateOfDBServlet/login.jsp'>��ת����¼ҳ��</a>");
		}
		else
		{
			out.print("�û�ע��ʧ��");
			out.print("<br>");
			out.print("<a href='/2015javawebClassProject/13operateDatabaseServlet/1TotalOperateOfDBServlet/registerUser.jsp'>����ע��</a>");	
		}		
		db.close();		
	}
	


void tianjia(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException
{
	response.setContentType("text/html");
	response.setCharacterEncoding("UTF-8");
	PrintWriter out = response.getWriter();
	String name = new String(request.getParameter("name").getBytes("ISO-8859-1"),"utf-8");
;
	String price = request.getParameter("price");	
	String shuliang = request.getParameter("shuliang");
	String author = request.getParameter("author");
	String sql = "insert into Table_1(name,price,shuliang,author) values('"+name+"','"+price+"','"+shuliang+"','"+author+"')";
	Database db =new Database();
	boolean result = db.insertUpdateDelete(sql);
	if(result)
	{		
		out.print("������ݳɹ�");
		out.print("<br>");
		out.print("<a href='/2015javawebClassProject/13operateDatabaseServlet/1TotalOperateOfDBServlet/tianjia.jsp'>����</a>");
	}
	else
	{
		out.print("�������ʧ��");
		out.print("<br>");
		out.print("<a href='/2015javawebClassProject/13operateDatabaseServlet/1TotalOperateOfDBServlet/registerUser.jsp'>����</a>");	
	}		
	db.close();		
}


}

