package mybean;
public class Login {
private String loginname,password,backNews="";
private boolean success=false; 
public Login() {
}
public String getLoginame() {
return loginname;
}
public void setLoginame(String loginname) {
this.loginname = loginname;
}
public String getPassword() {
return password;
}
public void setPassword(String password) {
this.password = password;
}
public String getBackNews() {
return backNews;
}
public void setBackNews(String backNews) {
this.backNews = backNews;
}
public boolean isSuccess() {
return success;
}
public void setSuccess(boolean success) {
this.success = success;
}
}