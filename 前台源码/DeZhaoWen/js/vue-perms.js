Vue.directive("perms",{
	inserted:function(el,binding,vnode,oldnode){
		//获取整个系统中拥有的所有权限
		console.log(top.data.perms);
		var perms = top.data.perms;
		var verfiy = binding.value;//当前验证的权限
		perms.forEach(ite=>console.log(ite.pvgVerify+"+"+verfiy))
		var flag = perms.some(item=>item.pvgVerify==verfiy);
		if(!flag){
			el.remove();
		}
	},
})