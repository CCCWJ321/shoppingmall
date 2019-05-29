package myservlet; 
import mybean.*;
import java.sql.*; 
import java.io.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 

public class HandleRegister extends HttpServlet { 
 private static final long serialVersionUID = 1L; 
 
 public HandleRegister() { 
 super(); 
 
 } 
 
 public void init(ServletConfig config) throws ServletException { 
 super.init(config); 
 //1.加载 JDBC 数据库驱动程序 
 try { 
 Class.forName("com.mysql.jdbc.Driver"); 
 } 
 catch(Exception e){} 
 } 
 
 
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 

 request.setCharacterEncoding("UTF-8"); 
 response.setContentType("text/html;charset=UTF-8"); 
 response.setCharacterEncoding("UTF-8"); 
 
 Connection con; 
 PreparedStatement sql; 
 Register reg=new Register(); 
 request.setAttribute("register",reg); 
 
 String loginname=request.getParameter("loginname").trim(); 
 String password=request.getParameter("password").trim();
 String email=request.getParameter("email").trim(); 
 if(loginname==null) 
	 loginname=""; 
 if(password==null) 
 password=""; 
 boolean isT=true; 
 boolean boo=loginname.length()>0&&password.length()>0&&isT; 
 String backNews=""; 
 try{ 
 String uri="jdbc:mysql://127.0.0.1:3306/test?";
 String user="root";
 String spassword="664859"; //characterEncoding=utf-8"; 
 //2.建立与指定数据库 test 的连接对象 con 
 con=DriverManager.getConnection(uri,user,spassword); 
 String insertCondition="INSERT INTO user VALUES (?,?,?)"; 
 //3.利用 con 对象调用 prepareStatement 方法生成用于执行 SQL 语句的对象 
sql=con.prepareStatement(insertCondition); 
 if(boo){ 
 sql.setString(1, loginname);//利用 sql 对象调用 set 方法设置？所代表的具体值 
 sql.setString(2,password); 
 sql.setString(3, email); 
 //4.数据库操作对象sql调用executeUpdate()方法并返回成功的记录条数 
 int m=sql.executeUpdate(); 
 if(m!=0){ 
 backNews="注册成功"; 
 reg.setBackNews(backNews); 
 reg.setLogname(loginname); 
 reg.setPassword(password); 
 reg.setEmail(email); 
 
 } 
 } 
 else{ 
 backNews="信息填写不完整或名字中有非法字符"; 
 reg.setBackNews(backNews); 
 } 
 //5.释放资源 
 sql.close(); 
 con.close(); 
 } 
 catch(SQLException exp){ 
 backNews="该名字已被使用，请您更换名字"+exp; 
 reg.setBackNews(backNews); 
 } 
 RequestDispatcher dispatcher= request.getRequestDispatcher("show.jsp");// 转发 
 dispatcher.forward(request,response); 
 } 
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, 
IOException { 
 doGet(request,response); 
 } 
}