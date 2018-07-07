<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>电影系统</title>  
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/pintuer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/admin.css">
    <script src="${pageContext.request.contextPath }/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath }/js/pintuer.js"></script> 
	
	<script type="text/javascript">
		function logout() {
            if(window.confirm('您确定要退出吗？')) {
                 top.location.href='${pageContext.request.contextPath }/index.jsp';
            }
        } 
	</script>
	
	<script type="text/javascript">  
    //获取系统时间，将时间以指定格式显示到页面。  
    function systemTime()  
    {  
        //获取系统时间。  
        var dateTime=new Date();  
        var hh=dateTime.getHours();  
        var mm=dateTime.getMinutes();  
        var ss=dateTime.getSeconds();  
         var welcomeStr = "";
			if (hh > 0 && hh < 12 )
 			{welcomeStr = "上午好";  }
			else
			{
			welcomeStr = "下午好";
			}
           
        //分秒时间是一位数字，在数字前补0。  
        mm = extra(mm);  
        ss = extra(ss);  
          
        //将时间显示到ID为time的位置，时间格式形如：19:18:02  
        document.getElementById("time").innerHTML=hh+":"+mm+":"+ss+"   :"+welcomeStr ;  
          
        //每隔1000ms执行方法systemTime()。  
        setTimeout("systemTime()",1000);  
    }  
      
    //补位函数。  
    function extra(x)  
    {  
        //如果传入数字小于10，数字前补一位0。  
        if(x < 10)  
        {  
            return "0" + x;  
        }  
        else  
        {  
            return x;  
        }  
    }  
</script> 
	
	</head>

	<body style="background-color: #f2f9fd;" onload="systemTime()">
		<div class="header bg-main" >
			<div class="logo margin-big-left fadein-top">
				<h4>
					<img src="./images/y.jpg" class="radius-circle rotate-hover"
						height="50" alt="" />
					管理员：<b>${a}
				</h4>
			</div>
			<div class="head-l">
				
				<a class="button button-little bg-red" ><span
					class="icon-power-off" onclick="logout();">&nbsp;&nbsp;退出登录</span> </a>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					
			</div>
			
			<div style="padding-top: 25px;">
				<div id="time"></div>
			</div>
		</div>
		
		
		
		
		<div class="leftnav">
			<div class="leftnav-title">
				<strong><span class="icon-list"></span>菜单列表</strong>
			</div>
			<h2>
				<span class="icon-user"></span>基本操作
			</h2>
			<ul style="display: block">
				<li>
				<!--..跳转到上一级目录	.代表当前路径 -->	
					<a href="./fsortServlet?code=1" target="right" ><span
						class="icon-caret-right"></span>电影类别管理</a>
				</li>
				<li>
					<a href="./fimlServlet?code=1" target="right"><span
						class="icon-caret-right"></span>电影信息管理</a>
				</li>
				<li>
					<a href="./hallServlet?code=1" target="right"><span
						class="icon-caret-right"></span>放映大厅管理</a>
				</li>
				<li>
					<a href="./empServlet?code=1" target="right"><span
						class="icon-caret-right"></span>员工信息管理</a>
				</li>
				<li>
					<a href="./broadServlet?code=1" target="right"><span
						class="icon-caret-right"></span>放映信息管理</a>
				</li>
				<li>
					<a href="./salaServlet?code=1" target="right"><span
						class="icon-caret-right"></span>售票信息管理</a>
				</li>
				<li>
					<a href="./profit?code=1" target="right"><span
						class="icon-caret-right"></span>&nbsp;&nbsp;&nbsp;收益管理</a>
				</li>
				<li>
					<a href="./profit?code=3" target="right"><span
						class="icon-caret-right"></span>&nbsp;总收入明细</a>
				</li>
				
			</ul>
			
		</div>
		<script type="text/javascript">
$(function() {
	$(".leftnav h2").click(function() {
		$(this).next().slideToggle(200);
		$(this).toggleClass("on");
	})
	$(".leftnav ul li a").click(function() {
		$("#a_leader_txt").text($(this).text());
		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
	})
});
</script>
		<ul class="bread">
			<li>
				<a href="${pageContext.request.contextPath }/images/bizhi.jpg" target="right" class="icon-home">
					首页</a>
			</li>
			<li>
				<a href="##" id="a_leader_txt">网站信息</a>
			</li>
			<li>
				<b>当前语言：</b><span style="color: red;">中文</php></li>
		</ul>
		<div class="admin">
			<iframe scrolling="auto" rameborder="0" src="${pageContext.request.contextPath }/images/_TT~9VHJ1JI(E49MVZ6{4$6.png" name="right"
			 	width="100%" height="100%"></iframe>
		</div></body>
</html>
