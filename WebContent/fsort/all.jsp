<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>登录</title>  
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/pintuer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/admin.css">
    <script src="${pageContext.request.contextPath }/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath }/js/pintuer.js"></script> 
    <style type="text/css">
       *{
        font-size: 12px;
       }
    </style>

  </head>
  
  <body>

  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 操作信息管理</strong></div>
    <div class="padding border-bottom">
      <ul class="search">
        <li>
          
          <%--<button type="submit" class="button border-red"><span class="icon-trash-o"></span> 批量删除</button>
        --%></li>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        
        <th>编号</th>       
        <th>电影类别</th>
        <th>电影备注</th>
        <th align="center">操作</th>       
      </tr>
      <c:forEach var="fsort" items="${FsortEntity}">
      	<tr>
      	
      		<td>
      			${fsort.sid}
      		</td>
      		<td>
      			${fsort.sname}
      		</td>
      		<td>
      			${fsort.sremark}
      		</td>
      		
      		<td>
      			<div class="button-group">
						<a class="button border-red" href="./fsortServlet?code=2&sid=${fsort.sid}" onclick="return del(1)">
			<span class="icon-trash-o">
					</span> 修改</a> 
				</div>
			</td>
			
      	</tr>
      </c:forEach>     
       <tr>
       		<td colspan="4" align="center">
				<a href="./fsort/add.jsp"><button type="button"  class="button border-green" id="checkall"><span class="icon-check"></span>增加</button></a>
			</td>
       </tr>
    </table>
  </div>


</body></html>
