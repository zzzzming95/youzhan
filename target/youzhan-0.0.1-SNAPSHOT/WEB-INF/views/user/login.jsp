<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<c:import url="header.jsp"></c:import>  
<%String path = request.getContextPath(); %>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<form role="form" action="<%=path%>/user/loginData" method="POST">
				<div class="form-group">
					 
					<label for="exampleInputEmail1">
						用户名
					</label>
					<input type=text class="form-control" name="username" id="exampleInputEmail1" />
				</div>
				<div class="form-group">
					 
					<label for="exampleInputPassword1">
						密码
					</label>
					<input type="password" class="form-control" name="password" id="exampleInputPassword1" />
				</div>
				
				<div class="checkbox">
					 
					<label>
						<input type="checkbox" /> Check me out
					</label>
				</div> 
				<button type="submit" class="btn btn-default">
					登陆
				</button>
			</form>
		</div>
	</div>
</div>


</body>


<script type="text/javascript" src="<%=path%>/javascript/bootstrap.min.js"></script>
</html>