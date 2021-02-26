var menuApi = {
	findPerms : function(roleId,callback){
		$.ajax({
			url:"http://127.0.0.1:8080/privilegeRole/findPerms",
			dataType:"json",
			data:{
				roleId:roleId
			},
			success:function(result){
				callback(result);
			},error:function(error){
				console.log(error);
			}
		});
	}
}