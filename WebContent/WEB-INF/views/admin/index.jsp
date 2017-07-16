<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<c:import url="header.jsp"></c:import>  
<%String path = request.getContextPath(); %>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-4">
					<ul class="nav nav-tabs nav-stacked">
						<li class="active">
							<a href="#">Home</a>
						</li>
						<li>
							<a href="#">Profile</a>
						</li>
						<li class="disabled">
							<a href="#">Messages</a>
						</li>
						<li class="dropdown pull-right">
							 <a href="#" data-toggle="dropdown" class="dropdown-toggle">Dropdown<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li>
									<a href="#">Action</a>
								</li>
								<li>
									<a href="#">Another action</a>
								</li>
								<li>
									<a href="#">Something else here</a>
								</li>
								<li class="divider">
								</li>
								<li>
									<a href="#">Separated link</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
				<div class="col-md-8">
				</div>
			</div>
		</div>
	</div>
</div>





</body>


<script type="text/javascript" src="<%=path%>/javascript/bootstrap.min.js"></script>
</html>