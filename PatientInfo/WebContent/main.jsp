<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>病人挂号信息系统</title>
<%
	// 权限验证
	if(session.getAttribute("currentUser")==null){
		response.sendRedirect("index.jsp");
		return;
	}
%>
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$(function(){
		// 数据
		var treeData=[{
			text:"病人挂号信息系统",
			iconCls:"icon-menu",
			children:[{
				text:"用户信息管理",
				iconCls:"icon-user",
				attributes:{
					url:"patientInfoManage.jsp"
				}
			},{
				text:"挂号系统管理",
				iconCls:"icon-manage",
				attributes:{
					url:"guahaoManage.jsp"
				}
			},{
				text:"挂号报表统计",
				iconCls:"icon-chart",
				attributes:{
					url:"chart.jsp"
				}
			}]
		}];
		
		// 实例化树菜单
		$("#tree").tree({
			data:treeData,
			lines:true,
			onClick:function(node){
				if(node.attributes){
					openTab(node.text,node.attributes.url,node.iconCls);
				}
			}
		});
		
		// 新增Tab
		function openTab(text,url,iconCls){
			if($("#tabs").tabs('exists',text)){
				$("#tabs").tabs('select',text);
			}else{
				var content="<iframe frameborder='0' scrolling='auto' style='width:100%;height:100%' src="+url+"></iframe>";
				$("#tabs").tabs('add',{
					title:text,
					closable:true,
					content:content,
					iconCls:iconCls,
				});
			}
		}
	});
</script>
</head>
<body class="easyui-layout">
	<div align="top" style="height: 85px;background-color: #E0EDFF">
		<div align="left" style="float: left; height:80px"><img src="images/logo_1.png"></div>
		<div style="padding-top: 50px;padding-right: 20px; float:right">当前用户：&nbsp;<font color="red" >${currentUser.userName}</font><a href="login!logout" style="margin-left:20px;text-decoration:none">注销登录</a></div>
		
	</div>
	<div align="center">
		<div class="easyui-tabs"  style="border:false" id="tabs">
			<div title="首页" >
				<div align="center" style="padding-top: 100px;"><font color="red" size="10">欢迎使用病人挂号信息系统</font></div>
			</div>
		</div>
	</div>
	<div align="left" style="width: 150px;" title="导航菜单">
		<ul id="tree"></ul>
	</div>
	<div region="south" style="height: 25px;" align="center">版权所有<a href="http://www.java1234.com">www.java1234.com</a></div>
</body>
</html>