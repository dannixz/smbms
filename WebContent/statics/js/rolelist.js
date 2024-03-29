var providerObj;

//供应商管理页面上点击删除按钮弹出删除框(providerlist.jsp)
function deleteProvider(obj){
	
	$.ajax({
		type:"GET",
		url:path+"/user/roledel",
		data:{roleid:obj.attr("roleid")},
		dataType:"json",
		success:function(data){
			if(data.delResult == "true"){//删除成功：移除删除行
				cancleBtn();
				obj.parents("tr").remove();
				window.location.href=path+"/user/rolelist";
			}else if(data.delResult == "false"){//删除失败
				alert("对不起，删除供应商【"+obj.attr("proname")+"】失败");
//				changeDLGContent("对不起，删除角色【"+obj.attr("rolename")+"】失败");
			}else if(data.delResult == "notexist"){
				alert("对不起，供应商【"+obj.attr("proname")+"】不存在");
//				changeDLGContent("对不起，角色【"+obj.attr("rolename")+"】不存在");
			}else{
				alert("对不起，该角色【"+obj.attr("rolename")+"】下还有【"+data.delResult+"】条订单，不能删除");
//				changeDLGContent("对不起，该角色【"+obj.attr("rolename")+"】下还有【"+data.delResult+"】条订单，不能删除");
			}
		},
		error:function(data){
			//alert("对不起，删除失败");
			changeDLGContent("对不起，删除失败");
		}
	});
}

function openYesOrNoDLG(){
	
	$('.zhezhao').css('display', 'block');
	
	$('#removeProv').fadeIn();
	
}

function cancleBtn(){
	$('.zhezhao').css('display', 'none');
	$('#removeProv').fadeOut();
}
function changeDLGContent(contentStr){
	
	var p = $(".removeMain").find("p");
	
	p.html(contentStr);
	
}
$(function(){
	//查看角色信息
	$(".viewRole").on("click",function(){
		//将被绑定的元素（a）转换成jquery对象，可以使用jquery方法
		var obj = $(this);
		window.location.href=path+"/user/roleShow/"+ obj.attr("roleid");
	});
	
	//修改角色信息
	$(".modifyRole").on("click",function(){
		var obj = $(this);
		window.location.href=path+"/user/updaterole/"+ obj.attr("roleid");
	});

	$('#no').click(function () {
		cancleBtn();
	});
	
	$('#yes').click(function () {
		deleteProvider(providerObj);
	});

	$(".deleteRole").on("click",function(){
		providerObj = $(this);
		
		if (confirm("你确定要删除角色【"+providerObj.attr("rolename")+"】吗？")) {
			deleteProvider(providerObj);
		}
	});
	
/*	$(".deleteProvider").on("click",function(){
		var obj = $(this);
		if(confirm("你确定要删除供应商【"+obj.attr("proname")+"】吗？")){
			$.ajax({
				type:"GET",
				url:path+"/jsp/provider.do",
				data:{method:"delprovider",proid:obj.attr("proid")},
				dataType:"json",
				success:function(data){
					if(data.delResult == "true"){//删除成功：移除删除行
						alert("删除成功");
						obj.parents("tr").remove();
					}else if(data.delResult == "false"){//删除失败
						alert("对不起，删除供应商【"+obj.attr("proname")+"】失败");
					}else if(data.delResult == "notexist"){
						alert("对不起，供应商【"+obj.attr("proname")+"】不存在");
					}else{
						alert("对不起，该供应商【"+obj.attr("proname")+"】下有【"+data.delResult+"】条订单，不能删除");
					}
				},
				error:function(data){
					alert("对不起，删除失败");
				}
			});
		}
	});*/
});