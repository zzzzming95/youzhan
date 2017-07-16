<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%String path = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
</head>
<body>
<h1>登陆成功，即将跳转到用户中心</h1>
<p>session:${sessionScope.sessionUser}</p> 
${sessionScope.sessionUser}
<a href="<%=path%>/admin/index">点击跳转</a>
</body>
</html>