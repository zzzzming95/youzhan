<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<c:import url="header.jsp"></c:import>  
<%String path = request.getContextPath(); %>


<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<form class="form-search" action="<%=path%>/hotel/search" >
				<input class="input-medium search-query" type="text" name="search" /> <button type="submit" class="btn">查找</button>
			</form>
		</div>
	</div>
</div>  

<a href="/user">用户</a>



</body>


<script type="text/javascript" src="<%=path%>/javascript/bootstrap.min.js"></script>
</html>