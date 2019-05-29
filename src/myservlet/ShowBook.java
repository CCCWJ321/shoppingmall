package myservlet;

import mybean.BookInf;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import java.util.*;
import java.awt.*;
import java.sql.*; 
import java.io.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 

/**
 * Servlet implementation class AddCart
 */
@WebServlet("/AddCart")
public class ShowBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowBook() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	//加载 JDBC 数据库驱动程序
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
		 //PreparedStatement sql; 
		 //ResultSet rs;
		 String url="jdbc:mysql://127.0.0.1:3306/test";
		 String user="root";
		 String password="664859";
		 
		 BookInf bookbean=new BookInf(); 
		 request.setAttribute("book",bookbean);
		 
		 try {
		 
		 con=DriverManager.getConnection(url, user,password);
		 
		 //String condition="select * from book";
		 //sql=(PreparedStatement)con.prepareStatement(condition);
		 /*rs = sql.executeQuery();
		 String a="";
		 while (rs.next()) {
             // 将查询出的内容添加到list中，其中userName为数据库中的字段名称
             a=rs.getString("userName");
         }*/
		// bookbean.setName(rs.getString(1));
		// bookbean.setAuthor(rs.getString(2));
		// sql.close();
		 con.close();
		 
		 }
		 
		 catch(SQLException exp){
			 
		 }
		 RequestDispatcher dispatcher=request.getRequestDispatcher("showBook.jsp");//转发
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
