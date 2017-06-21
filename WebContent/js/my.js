
$(document).ready(function(){
	$("#add_hotel").click(function(){
		var num_test = /^[0-9]*$/;
		var price_test = /^[0-9]*\.?[0-9]*$/;
		var num = $("#num").val();
		var name = $("#name").val();
		var address = $("#address").val();
		var price = $("#price").val();
		var star = $("#star").val();
		
		/*
		if(num.length == 0){
			alert("编号不能为空");
			return ;
		}

		else if( !(num_test.test(num))){
			alert("酒店编号不符合格式");
			return ;
		}
		else
			num = Number(num);
		
		if(price.length == 0){
			alert("酒店价格不能为空");
			return ;
		}
			
		else if( !(price_test.test(price))){
			alert("酒店价格不符合格式");
			return ;
		}
			
		else
			price = parseFloat(price);
		
		if(star.length == 0){
			alert("酒店星级不能为空");
			return ;
		}
			
		else if( !(num_test.test(star))){
			alert("酒店星级不符合格式");
			return ;
		}
			
		else
			star = Number(star);*/
		var string="";
		if(num.length == 0){
			string+="编号不能为空\n";
		}
		if( !(num_test.test(num))){
			string+="酒店编号不符合格式\n";
		}
		else
			num = Number(num);
		
		if(price.length == 0){
			string+="酒店价格不能为空\n";
		}
			
		if( !(price_test.test(price))){
			string+="酒店价格不符合格式\n";
		}
		else
			price = parseFloat(price);
		
		if(star.length == 0){
			string+="酒店星级不能为空\n";
		}
			
		if( !(num_test.test(star))){
			string+="酒店星级不符合格式\n";
		}
		else
			star = Number(star);
		
		/*
		if(num <=0 || num > 999999)
			alert("酒店编号不符合格式");
		else if(name.length <= 1 || name.length > 20 )
			alert("酒店名称不符合格式");
		else if(address.length < 5 || name.length > 50 )
			alert("酒店地址不符合格式");
		else if(price <= 0 || price > 999999 )
			alert("酒店价格不符合格式");
		else if(star <= 0 || star > 5 )
			alert("酒店星级不符合格式");
		else{
			alert("提交成功");
		}*/
		if(num <=0 || num > 999999)
			string+="酒店编号不符合格式\n";
		if(name.length <= 1 || name.length > 20 )
			string+="酒店名称不符合格式\n";
		if(address.length < 5 || name.length > 50 )
			string+="酒店地址不符合格式\n";
		if(price <= 0 || price > 999999 )
			string+="酒店价格不符合格式\n";
		if(star <= 0 || star > 5 )
			string+="酒店星级不符合格式\n";
		if(string.length==1){
			string="提交成功";
		}
		
		if(string.length == 0){
			this.commit();
		}else{
			alert(string);
		}
	});
	
	
	$("#change_password").click(function(){
		var password = $("#password").val();
		var r = /^[1-9][0-9]*$/;　　//整数 
		var big = /[A-Z]/;	//大写字母
		if(password.length < 8){
			alert("密码长度不能少于8位");
		}else if(password.length > 20){
			alert("密码长度不能多于20位");
		}else if(r.test(password)){
			alert("密码不能全为整数");
		}else if(!big.test(password)){
			alert("密码至少要有一个大写字母");
			
		}else{
			alert("添加成功");
		}
		this.commit();
		
		
	});
	
})