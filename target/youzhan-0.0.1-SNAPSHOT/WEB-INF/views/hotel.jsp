<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<c:import url="header.jsp"></c:import>  
<%
String path = request.getContextPath(); 
String searchInfo = request.getParameter("search");
%>
<ul>
<input id="search" type="hidden" value="<%=searchInfo %>" />
<c:forEach items="${searchList}" var="hotel">
	<li class="hotel_list">
		<p class="hotel_name">${hotel.name}</p>
		<br />
        <p class="hotel_address">${hotel.address}</p>
        <br />
        <p class="hotel_feature">${hotel.feature}</p>
        <button class="detail btn btn-default" type="button" >查看更多</button>
         <ul class="detaillist">
         </ul>
	</li>
    <br /><br /><br />
</c:forEach>
</ul>
</body>

<script type="text/javascript">
$(".detail").click(function(){
	
	var hotelName = $(this).parent().find(".hotel_name").text();
	var city = $("#search").val();
	var hotel = {
			hotelName : hotelName,
			city : city
	};
	var detaillist = $(this).parent().find(".detaillist");
	
	$.post("<%=path %>/hotel/getdetail",hotel,function(result){
		var detail = eval(result);

		var htm = "";
		
		for(var i=0;i < detail.length;i++){
			htm += "<li>";
    		//for(var key in detail[i]){
        		//alert(key+':'+json[i][key]);
        	htm += "<span>"+detail[i]['source']+"&nbsp;&nbsp;&nbsp;&nbsp;</span>";
    		htm += "<a>"+detail[i]['url']+"</a>&nbsp;&nbsp;&nbsp;&nbsp;";
    		htm += "<span>"+detail[i]['price']+"起</span>";
    		//}
    		
    		htm += "</li>";
		}
		detaillist.html(htm);
		
	  });
	
		
	
	/*	
	var persons = [
	    {name: "tina", age: 14},
	    {name: "timo", age: 15},
	    {name: "lily", age: 16},
	    {name: "lucy", age: 16}
	]
	for(var i=0,l=persons.length;i<l;i++){
	    for(var key in persons[i]){
	        alert(key+':'+persons[i][key]);
	    }
	}
	*/
});



</script>
</html>