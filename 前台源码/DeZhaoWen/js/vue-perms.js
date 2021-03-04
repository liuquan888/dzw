Vue.directive("perms",{
	inserted:function(el,binding,vnode,oldnode){
		//获取整个系统中拥有的所有权限
		console.log(top.data.perms);
		var perms = top.data.perms;
		var verfiy = binding.value;//当前验证的权限
		perms.forEach(ite=>{
			console.log(typeof ite.pvgVerify+"+"+typeof verfiy)
			console.log(ite.pvgVerify.length+"+"+verfiy.length)
			console.log(ite.pvgVerify+"  "+verfiy+"+"+(ite.pvgVerify==verfiy))+" +"+(typeof verfiy)
		});
		var flag = perms.some(item=>item.pvgVerify==verfiy);
		console.log(flag)
		if(!flag){
			el.remove();
		}
	},
})