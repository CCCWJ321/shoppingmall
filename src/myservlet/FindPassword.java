package myservlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mybean.Login;

/**
 * Servlet implementation class FindPassword
 */
@WebServlet("/FindPassword")
public class FindPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindPassword() {
        super();
        // TODO Auto-generated constructor stub
       
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		 try { 
        	 Class.forName("com.mysql.jdbc.Driver");
        	 }
        	 catch(Exception e){} 
        	
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		 response.setCharacterEncoding("UTF-8");
		 
		 Connection con; 
		 Statement sql; 
		 ResultSet rs;
		 Login loginBean=new Login();
		 String backNews="";
		 //创建了生命周期为 session 的 bean 对象loginBean
		 HttpSession session =request.getSession(true); 
		 session.setAttribute("findpassword",loginBean);
		 
		 String loginname=request.getParameter("loginname").trim();
		 String email=request.getParameter("email").trim();
		 if(loginname=="")
		 {
			 backNews="请输入账号！";
			 loginBean.setBackNews(backNews);
		 }
		 else{
			 String uri="jdbc:mysql://127.0.0.1:3306/test";
			 boolean boo=(loginname.length()>0);	 
			 try{ 
			 //2.建立了与指定数据库test连接的con对象
			 con=DriverManager.getConnection(uri,"root","664859");
			 String condition="select password from user where logname = '"+loginname+"' and email ='"+email+"'";
			 
			 //3.创建了数据库操作对象 sql
			 sql=con.createStatement(); 
			 if(boo){

			 //4.创建了结果集对象 rs
			 rs=sql.executeQuery(condition);
			
			 boolean m=rs.next();//////////////////////////////
			 String password=rs.getString(1);
			 if(m==true) {
			 backNews="您的密码是:";
			 
			 loginBean.setBackNews(backNews);
			 loginBean.setPassword(password);
			 rs.close();
			 }
			 else{
			 backNews="您输入的用户名不存在";
			 loginBean.setBackNews(backNews); 
			 loginBean.setLoginame(loginname);
			 }
			 }
			 //5.释放资源
			 sql.close();
			 con.close();
			 }
			 catch(SQLException exp){
			 backNews="你输入的用户名与邮箱不匹配或用户名不存在"+exp;
			 loginBean.setBackNews(backNews); 
			 loginBean.setSuccess(false); 
			 }
			 }
			 //转发操作
			 RequestDispatcher dispatcher=request.getRequestDispatcher("showPassword.jsp");//转发
			 dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
