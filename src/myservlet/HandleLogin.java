package myservlet;
import mybean.*;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HandleLogin extends HttpServlet {
private static final long serialVersionUID = 1L;
 
 public HandleLogin() {
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
 Statement sql; 
 ResultSet rs;
 Login loginBean=new Login();
 String backNews="";
 //创建了生命周期为 session 的 bean 对象loginBean
 HttpSession session =request.getSession(true); 
 session.setAttribute("login",loginBean);

 String loginname=request.getParameter("loginname").trim();
 String password=request.getParameter("password").trim();
 boolean ok=loginBean.isSuccess();
 if(loginname==""||password=="")
 {
	 backNews="请输入账号和密码！";
	 loginBean.setBackNews(backNews);
 }
 else if(ok==true&&loginname.equals(loginBean.getLoginame())){
 backNews=loginname+"已经登录了";
 loginBean.setBackNews(backNews);
 }
 else{
 String uri="jdbc:mysql://127.0.0.1:3306/test";
 boolean boo=(loginname.length()>0)&&(password.length()>0);	 
 try{ 
 //2.建立了与指定数据库test连接的con对象
 con=DriverManager.getConnection(uri,"root","664859");
 String condition="select * from user where logname = '"+loginname+"' and password ='"+password+"'";
 
 //3.创建了数据库操作对象 sql
 sql=con.createStatement(); 
 if(boo){

 //4.创建了结果集对象 rs
 rs=sql.executeQuery(condition);
 boolean m=rs.next();//////////////////////////////
 if(m==true) {
 backNews="登录成功";
 
 loginBean.setBackNews(backNews);
 loginBean.setSuccess(true);
 loginBean.setLoginame(loginname);
 rs.close();
 }
 else{
 backNews="您输入的用户名不存在，或密码不般配";
 loginBean.setBackNews(backNews); 
 loginBean.setSuccess(false); 
 loginBean.setLoginame(loginname);
 loginBean.setPassword(password);
 }
 }
 //5.释放资源
 sql.close();
 con.close();
 }
 catch(SQLException exp){
 backNews=""+exp;
 loginBean.setBackNews(backNews); 
 loginBean.setSuccess(false); 
 }
 }
 //转发操作
 RequestDispatcher dispatcher=request.getRequestDispatcher("showLoginMess.jsp");//转发
 dispatcher.forward(request,response);
}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request, response);
}
}