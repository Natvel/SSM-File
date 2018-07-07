<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <div class="panel-head"><strong class="icon-reorder"> 下架电影信息</strong></div>
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
        <th>电影名称</th>
        <th>主演</th>
        <th>上映时间</th>
        <th>简介</th>
        <th align="center">操作</th>       
      </tr>
      	<c:forEach items="${fimllist}" var="fimllist">
      	<tr>
      
      		<td>
      		${fimllist.fid}
      		</td>
      		<td>
      			${fimllist.fsort.sname}
      		</td>
      		<td>
      			${fimllist.fname}
      		</td>
      		<td>
      			${fimllist.fauto}
      		</td>
      		<td>
      			${fimllist.ontime}
      		</td>
      		<td>
      			${fimllist.fremark}
      		</td>
      		
			<td colspan="7" align="center">
				<a href="./fimlServlet?code=8&fid=${fimllist.fid}"><button type="button"  class="button border-green" id="checkall"><span class="icon-check"></span>上架</button></a>
				
			</td>
      	</tr>
      	</c:forEach>
       <tr>
       		<td colspan="7">
       			<a href="./fimlServlet?code=1"><button type="button"  class="button border-green" id="checkall"><span class="icon-check"></span> 返回查询菜单</button></a>
       		</td>
       </tr>
    </table>
  </div>


</body></html>
